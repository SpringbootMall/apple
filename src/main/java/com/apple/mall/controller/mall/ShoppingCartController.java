package com.apple.mall.controller.mall;

import com.apple.mall.common.Constants;
import com.apple.mall.common.ServiceResultEnum;
import com.apple.mall.controller.vo.BuyInOneShopVO;
import com.apple.mall.controller.vo.ShoppingCartItemVO;
import com.apple.mall.controller.vo.UserVO;
import com.apple.mall.entity.ShoppingCartItem;
import com.apple.mall.service.ShoppingCartService;
import com.apple.mall.util.Result;
import com.apple.mall.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingCartController {

    @Resource
    private ShoppingCartService shoppingCartService;

    @GetMapping("/shop-cart")
    public String cartListPage(HttpServletRequest request,
                               HttpSession httpSession) {
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        if(user == null){
            return "mall/login";
        }
        int itemsTotal = 0;
        int priceTotal = 0;
        List<ShoppingCartItemVO> myShoppingCartItems = shoppingCartService.getMyShoppingCartItems(user.getUserId());
        if (!CollectionUtils.isEmpty(myShoppingCartItems)) {
            //订单项总数
            itemsTotal = myShoppingCartItems.stream().mapToInt(ShoppingCartItemVO::getGoodsCount).sum();
            if (itemsTotal < 1) {
                return "error/error_5xx";
            }
            //总价
            for (ShoppingCartItemVO shoppingCartItemVO : myShoppingCartItems) {
                priceTotal += shoppingCartItemVO.getGoodsCount() * shoppingCartItemVO.getSellingPrice();
            }
            if (priceTotal < 1) {
                return "error/error_5xx";
            }
        }
        request.setAttribute("itemsTotal", itemsTotal);
        request.setAttribute("priceTotal", priceTotal);
        request.setAttribute("myShoppingCartItems", myShoppingCartItems);
        return "mall/cart";
    }

    @PostMapping("/shop-cart")
    @ResponseBody
    public Result saveNewBeeMallShoppingCartItem(@RequestBody ShoppingCartItem shoppingCartItem,
                                                 HttpSession httpSession) {
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);

        shoppingCartItem.setUserId(user.getUserId());
        //todo 判断数量
        String saveResult = shoppingCartService.saveNewBeeMallCartItem(shoppingCartItem);
        //添加成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(saveResult)) {
            return ResultGenerator.genSuccessResult();
        }
        //添加失败
        return ResultGenerator.genFailResult(saveResult);
    }

    @PutMapping("/shop-cart")
    @ResponseBody
    public Result updateShoppingCartItem(@RequestBody ShoppingCartItem shoppingCartItem,
                                                   HttpSession httpSession) {
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        shoppingCartItem.setUserId(user.getUserId());
        //todo 判断数量
        String saveResult = shoppingCartService.updateNewBeeMallCartItem(shoppingCartItem);
        //修改成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(saveResult)) {
            return ResultGenerator.genSuccessResult();
        }
        //修改失败
        return ResultGenerator.genFailResult(saveResult);
    }

    @DeleteMapping("/shop-cart/{mallShoppingCartItemId}")
    @ResponseBody
    public Result updateShoppingCartItem(@PathVariable("mallShoppingCartItemId") Long mallShoppingCartItemId,
                                                   HttpSession httpSession) {
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        Boolean deleteResult = shoppingCartService.deleteById(mallShoppingCartItemId);
        //删除成功
        if (deleteResult) {
            return ResultGenerator.genSuccessResult();
        }
        //删除失败
        return ResultGenerator.genFailResult(ServiceResultEnum.OPERATE_ERROR.getResult());
    }

    @GetMapping("/shop-cart/settle")
    public String settlePage(HttpServletRequest request,
                             HttpSession httpSession) {
        int priceTotal = 0;
        UserVO user = (UserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        List<ShoppingCartItemVO> myShoppingCartItems = shoppingCartService.getMyShoppingCartItems(user.getUserId());

        List<BuyInOneShopVO> buyInOneShopVOS = new ArrayList<>();

        int n = 0;
        ArrayList<Long> shopIds = new ArrayList<>();
        ArrayList<String> shopNames = new ArrayList<>();
        Double[] priceInOneShop={0d};

        List<BuyInOneShopVO> buyInOneShopVOList = new ArrayList<>();
        if (CollectionUtils.isEmpty(myShoppingCartItems)) {
            //无数据则不跳转至结算页
            return "/shop-cart";
        } else {
            //第一次遍历获取订单中所有商家（BuyInOneShopVO）
            BuyInOneShopVO buyFirst = new BuyInOneShopVO();

            int price = myShoppingCartItems.get(0).getSellingPrice();
            int num = myShoppingCartItems.get(0).getGoodsCount();
            int sum = price*num;
            buyFirst.setPrice(sum);
            buyFirst.setShopId(myShoppingCartItems.get(0).getShopId());
            buyFirst.setShopName(myShoppingCartItems.get(0).getShopName());
            buyInOneShopVOList.add(buyFirst);
            for(ShoppingCartItemVO shoppingCartItemVO : myShoppingCartItems) {
                    BuyInOneShopVO temp = new BuyInOneShopVO();
                    temp.setShopId(shoppingCartItemVO.getShopId());
                    //插入唯一
                    if(!buyInOneShopVOList.contains(temp)){
                        int price1 = shoppingCartItemVO.getSellingPrice();
                        int num1 = shoppingCartItemVO.getGoodsCount();
                        int sum1 = price1*num1;
                        temp.setPrice(sum1);
                        temp.setShopName(shoppingCartItemVO.getShopName());
                        buyInOneShopVOList.add(temp);
                    }
            }

            //第二次遍历，更新所有店家的订单
            for(int i=0;i<buyInOneShopVOList.size();i++){
                ArrayList<ShoppingCartItemVO> shoppingCartItemVOList= new ArrayList<>();
                int sum2 = 0;
                for(ShoppingCartItemVO shoppingCartItemVO : myShoppingCartItems) {
                    if(buyInOneShopVOList.get(i).getShopId().equals(shoppingCartItemVO.getShopId())){
                        shoppingCartItemVOList.add(shoppingCartItemVO);
                    }
                }
                for(ShoppingCartItemVO shoppingCartItemVO : shoppingCartItemVOList){
                    sum2 += shoppingCartItemVO.getSellingPrice()*shoppingCartItemVO.getGoodsCount();
                }
                buyInOneShopVOList.get(i).setPrice(sum2);
                buyInOneShopVOList.get(i).setShoppingCartItemVOs(shoppingCartItemVOList);
            }
        }
        request.setAttribute("buyInOneShopVOList",buyInOneShopVOList);
        for (int i =0;i<buyInOneShopVOList.size();i++){
            System.out.println(buyInOneShopVOList.get(i).toString());
        }
        return "mall/order-settle";
    }
}
