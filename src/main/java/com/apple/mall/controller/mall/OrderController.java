package com.apple.mall.controller.mall;

import com.apple.mall.common.Constants;
import com.apple.mall.common.Exception;
import com.apple.mall.common.ServiceResultEnum;
import com.apple.mall.controller.vo.OrderDetailVO;
import com.apple.mall.controller.vo.ShoppingCartItemVO;
import com.apple.mall.controller.vo.UserVO;
import com.apple.mall.entity.Order;
import com.apple.mall.entity.ShopUserComment;
import com.apple.mall.service.GoodsService;
import com.apple.mall.service.OrderService;
import com.apple.mall.service.ShopUserCommentService;
import com.apple.mall.service.ShoppingCartService;
import com.apple.mall.util.PageQueryUtil;
import com.apple.mall.util.Result;
import com.apple.mall.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Resource
    private ShoppingCartService mallShoppingCartService;
    @Resource
    private OrderService mallOrderService;
    @Resource
    private ShopUserCommentService shopUserCommentService;
    @Resource
    private GoodsService goodsService;

    @GetMapping("/orders/{orderNo}")
    public String orderDetailPage(HttpServletRequest request, @PathVariable("orderNo") String orderNo, HttpSession httpSession) {
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        OrderDetailVO orderDetailVO = mallOrderService.getOrderDetailByOrderNo(orderNo, user.getUserId());
        List<ShopUserComment> userOrderComment = shopUserCommentService.getShopUserCommentByOrderNo(Long.valueOf(orderNo));
        if (orderDetailVO == null) {
            return "error/error_5xx";
        }
        request.setAttribute("orderDetailVO", orderDetailVO);
        request.setAttribute("userOrderComment", userOrderComment);
        request.setAttribute("commentSize",userOrderComment.size());
        return "mall/order-detail";
    }

    @GetMapping("/orders")
    public String orderListPage(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpSession httpSession) {
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        params.put("userId", user.getUserId());
        if (StringUtils.isEmpty(params.get("page"))) {
            params.put("page", 1);
        }
        params.put("limit", Constants.ORDER_SEARCH_PAGE_LIMIT);
        //封装我的订单数据
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        request.setAttribute("orderPageResult", mallOrderService.getMyOrders(pageUtil));
        request.setAttribute("path", "orders");
        return "mall/my-orders";
    }

    @GetMapping("/saveOrder/{shopId}")
    public String saveOrder(@PathVariable("shopId") String shopId, HttpSession httpSession) {
        System.out.println(shopId);
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        Long shopIdTemp = Long.valueOf(shopId);
        List<ShoppingCartItemVO> myShoppingCartItems = mallShoppingCartService.getMyShoppingCartItemsByShopId(user.getUserId(),shopIdTemp);
        if (StringUtils.isEmpty(user.getAddress().trim())) {
            //无收货地址
            Exception.fail(ServiceResultEnum.NULL_ADDRESS_ERROR.getResult());
        }
        if (CollectionUtils.isEmpty(myShoppingCartItems)) {
            //购物车中无数据则跳转至错误页
            Exception.fail(ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult());
        }
        //保存订单并返回订单号
        String saveOrderResult = mallOrderService.saveOrder(user, myShoppingCartItems);
        //跳转到订单详情页
        return "redirect:/orders/" + saveOrderResult;
    }

    @PutMapping("/orders/{orderNo}/cancel")
    @ResponseBody
    public Result cancelOrder(@PathVariable("orderNo") String orderNo, HttpSession httpSession) {
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        String cancelOrderResult = mallOrderService.cancelOrder(orderNo, user.getUserId());
        if (ServiceResultEnum.SUCCESS.getResult().equals(cancelOrderResult)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(cancelOrderResult);
        }
    }

    @PutMapping("/orders/{orderNo}/finish")
    @ResponseBody
    public Result finishOrder(@PathVariable("orderNo") String orderNo, HttpSession httpSession) {
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        String finishOrderResult = mallOrderService.finishOrder(orderNo, user.getUserId());
        if (ServiceResultEnum.SUCCESS.getResult().equals(finishOrderResult)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(finishOrderResult);
        }
    }


    @PostMapping("/shop-comment")
    @ResponseBody
    public Result addUserComment(@RequestBody ShopUserComment shopUserComment,HttpSession httpSession){
        Long storeId = goodsService.getNewBeeMallGoodsById(shopUserComment.getGoodsId()).getShopId();
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        shopUserComment.setUserId(user.getUserId());
        shopUserComment.setStoreId(storeId);
        String commentResult = shopUserCommentService.saveShopUserComment(shopUserComment);
        if (ServiceResultEnum.SUCCESS.getResult().equals(commentResult)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(commentResult);
        }
    }

    @PostMapping("/reply-comment")
    @ResponseBody
    public Result replyComment(@RequestBody ShopUserComment shopUserComment){
        String commentResult = shopUserCommentService.saveReplyByOrderNo(shopUserComment);
        if (ServiceResultEnum.SUCCESS.getResult().equals(commentResult)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(commentResult);
        }
    }

    @PostMapping("/uploadImg")
    @ResponseBody
    public Result uploadImg(@RequestParam("file") MultipartFile file, @RequestParam("orderNo") Long orderNo, @RequestParam("goodsId") Long goodsId,HttpSession httpSession){
        ShopUserComment shopUserComment = new ShopUserComment();
        System.out.println(orderNo);
        Long storeId = goodsService.getNewBeeMallGoodsById(goodsId).getShopId();
        String on = orderNo.toString();
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        //图片保存名
        String imgPath = on+"To"+user.getUserId().toString() + "To" + goodsId.toString() + file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
        String submitImgResult = null;
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("src/main/resources/static/mall/image/comment/"+imgPath);
            Files.write(path, bytes);
            shopUserComment.setSubmitImg(path.toString());
            shopUserComment.setOrderNo(orderNo);
            shopUserComment.setGoodsId(goodsId);
            shopUserComment.setUserId(user.getUserId());
            shopUserComment.setStoreId(storeId);

            submitImgResult= shopUserCommentService.saveShopUserCommentImg(shopUserComment);
            return ResultGenerator.genSuccessResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultGenerator.genFailResult(submitImgResult);
    }

    @GetMapping("/selectPayType")
    public String selectPayType(HttpServletRequest request, @RequestParam("orderNo") String orderNo, HttpSession httpSession) {
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        Order newBeeMallOrder = mallOrderService.getOrderByOrderNo(orderNo);
        //todo 判断订单userId
        //todo 判断订单状态
        request.setAttribute("orderNo", orderNo);
        request.setAttribute("totalPrice", newBeeMallOrder.getTotalPrice());
        return "mall/pay-select";
    }

    @GetMapping("/payPage")
    public String payOrder(HttpServletRequest request, @RequestParam("orderNo") String orderNo, HttpSession httpSession, @RequestParam("payType") int payType) {
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        Order newBeeMallOrder = mallOrderService.getOrderByOrderNo(orderNo);
        //todo 判断订单userId
        //todo 判断订单状态
        request.setAttribute("orderNo", orderNo);
        request.setAttribute("totalPrice", newBeeMallOrder.getTotalPrice());
        if (payType == 1) {
            return "mall/alipay";
        } else {
            return "mall/wxpay";
        }
    }

    @GetMapping("/paySuccess")
    @ResponseBody
    public Result paySuccess(@RequestParam("orderNo") String orderNo, @RequestParam("payType") int payType) {
        String payResult = mallOrderService.paySuccess(orderNo, payType);
        if (ServiceResultEnum.SUCCESS.getResult().equals(payResult)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(payResult);
        }
    }


    @DeleteMapping("/deleteComment/{orderNo}")
    @ResponseBody
    public Result deleteComment(@PathVariable("orderNo") Long orderNo){
        int deleteCommentResult = shopUserCommentService.deleteByOrderNo(orderNo);
        if (deleteCommentResult>0)
            return ResultGenerator.genSuccessResult();
        else return ResultGenerator.genFailResult("删除失败!");
    }
}
