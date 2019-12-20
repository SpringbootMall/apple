package com.apple.mall.controller.seller;

import com.apple.mall.common.CategoryLevelEnum;
import com.apple.mall.common.Constants;
import com.apple.mall.common.ServiceResultEnum;
import com.apple.mall.controller.vo.UserVO;
import com.apple.mall.entity.Goods;
import com.apple.mall.entity.GoodsCategory;
import com.apple.mall.entity.Shop;
import com.apple.mall.service.CategoryService;
import com.apple.mall.service.GoodsService;
import com.apple.mall.service.ShopService;
import com.apple.mall.util.PageQueryUtil;
import com.apple.mall.util.Result;
import com.apple.mall.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class

SellerController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/ListGoods")    //查找全部
    public String ListGood(Model model){
        List<Goods> goods = goodsService.ListGood();
        model.addAttribute("goods",goods);
        return "seller/ListGoods";
    }



    @RequestMapping("/FindGood")    //查找
    public String FindGoodWithId(String goodsId){
        goodsService.FindGoodWithId(goodsId);
        return "seller/MyShop";
    }

    @RequestMapping("/InsertGoods")  //增加
    public String InsertGood(Goods good, Model model){
        goodsService.InsertGood(good);
        long shopId = good.getShopId();
        return "redirect:mall/MyShop"+"?shopId="+shopId;
    }



    @RequestMapping("/DeleteGood")  //删除
    public String DeleteGood(String goodsId,int shopId){
        goodsService.DeleteGood(goodsId);
        return "redirect:seller/MyShop"+"?shopId="+shopId;
    }

    @RequestMapping("/UpdateGood")  //更新
    public String UpdateGood(Goods Good){
        goodsService.UpdateGood(Good);
        return "redirect:seller/MyShop";
    }

    @GetMapping("/seller")  //打印商家所有店的信息
    public String FindShopWithSellerId(HttpSession session, Model model){
        UserVO user = (UserVO) session.getAttribute(Constants.MALL_USER_SESSION_KEY);
        long sellerId = user.getUserId();
        List<Shop> shops = shopService.FindAllShopsWithSellerId(sellerId);
        model.addAttribute("shops",shops);
        return "seller/seller";
    }



    @GetMapping("/seller/goods")
    public String goodsPage(HttpSession session,int shopId) {
        session.setAttribute("shopId",shopId);
        return "seller/goods";
    }


    @RequestMapping(value = "/seller/goods/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params, HttpSession session) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);

        int shopId = Integer.parseInt(String.valueOf(session.getAttribute("shopId")));
        return ResultGenerator.genSuccessResult(goodsService.getShopGoodsPage(pageUtil,shopId));
//        return ResultGenerator.genSuccessResult(goodsService.getNewBeeMallGoodsPage(pageUtil));
    }

    @GetMapping("/seller/goods/edit")
    public String edit(HttpServletRequest request) {
        request.setAttribute("path", "edit");
        //查询所有的一级分类
        List<GoodsCategory> firstLevelCategories = categoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(0L), CategoryLevelEnum.LEVEL_ONE.getLevel());
        if (!CollectionUtils.isEmpty(firstLevelCategories)) {
            //查询一级分类列表中第一个实体的所有二级分类
            List<GoodsCategory> secondLevelCategories = categoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(firstLevelCategories.get(0).getCategoryId()), CategoryLevelEnum.LEVEL_TWO.getLevel());
            if (!CollectionUtils.isEmpty(secondLevelCategories)) {
                //查询二级分类列表中第一个实体的所有三级分类
                List<GoodsCategory> thirdLevelCategories = categoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(secondLevelCategories.get(0).getCategoryId()), CategoryLevelEnum.LEVEL_THREE.getLevel());
                request.setAttribute("firstLevelCategories", firstLevelCategories);
                request.setAttribute("secondLevelCategories", secondLevelCategories);
                request.setAttribute("thirdLevelCategories", thirdLevelCategories);
                request.setAttribute("path", "goods-edit");
                return "seller/goods_edit";
            }
        }
        return "admin/error/error_5xx";
    }


    @GetMapping("/seller/goods/edit/{goodsId}")
    public String edit(HttpServletRequest request, @PathVariable("goodsId") Long goodsId) {
        request.setAttribute("path", "edit");
        Goods goods = goodsService.getNewBeeMallGoodsById(goodsId);
        if (goods == null) {
            return "error/error_400";
        }
        if (goods.getGoodsCategoryId() > 0) {
            if (goods.getGoodsCategoryId() != null || goods.getGoodsCategoryId() > 0) {
                //有分类字段则查询相关分类数据返回给前端以供分类的三级联动显示
                GoodsCategory currentGoodsCategory = categoryService.getGoodsCategoryById(goods.getGoodsCategoryId());
                //商品表中存储的分类id字段为三级分类的id，不为三级分类则是错误数据
                if (currentGoodsCategory != null && currentGoodsCategory.getCategoryLevel() == CategoryLevelEnum.LEVEL_THREE.getLevel()) {
                    //查询所有的一级分类
                    List<GoodsCategory> firstLevelCategories = categoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(0L), CategoryLevelEnum.LEVEL_ONE.getLevel());
                    //根据parentId查询当前parentId下所有的三级分类
                    List<GoodsCategory> thirdLevelCategories = categoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(currentGoodsCategory.getParentId()), CategoryLevelEnum.LEVEL_THREE.getLevel());
                    //查询当前三级分类的父级二级分类
                    GoodsCategory secondCategory = categoryService.getGoodsCategoryById(currentGoodsCategory.getParentId());
                    if (secondCategory != null) {
                        //根据parentId查询当前parentId下所有的二级分类
                        List<GoodsCategory> secondLevelCategories = categoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(secondCategory.getParentId()), CategoryLevelEnum.LEVEL_TWO.getLevel());
                        //查询当前二级分类的父级一级分类
                        GoodsCategory firestCategory = categoryService.getGoodsCategoryById(secondCategory.getParentId());
                        if (firestCategory != null) {
                            //所有分类数据都得到之后放到request对象中供前端读取
                            request.setAttribute("firstLevelCategories", firstLevelCategories);
                            request.setAttribute("secondLevelCategories", secondLevelCategories);
                            request.setAttribute("thirdLevelCategories", thirdLevelCategories);
                            request.setAttribute("firstLevelCategoryId", firestCategory.getCategoryId());
                            request.setAttribute("secondLevelCategoryId", secondCategory.getCategoryId());
                            request.setAttribute("thirdLevelCategoryId", currentGoodsCategory.getCategoryId());
                        }
                    }
                }
            }
        }
        if (goods.getGoodsCategoryId() == 0) {
            //查询所有的一级分类
            List<GoodsCategory> firstLevelCategories = categoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(0L), CategoryLevelEnum.LEVEL_ONE.getLevel());
            if (!CollectionUtils.isEmpty(firstLevelCategories)) {
                //查询一级分类列表中第一个实体的所有二级分类
                List<GoodsCategory> secondLevelCategories = categoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(firstLevelCategories.get(0).getCategoryId()), CategoryLevelEnum.LEVEL_TWO.getLevel());
                if (!CollectionUtils.isEmpty(secondLevelCategories)) {
                    //查询二级分类列表中第一个实体的所有三级分类
                    List<GoodsCategory> thirdLevelCategories = categoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(secondLevelCategories.get(0).getCategoryId()), CategoryLevelEnum.LEVEL_THREE.getLevel());
                    request.setAttribute("firstLevelCategories", firstLevelCategories);
                    request.setAttribute("secondLevelCategories", secondLevelCategories);
                    request.setAttribute("thirdLevelCategories", thirdLevelCategories);
                }
            }
        }
        request.setAttribute("goods", goods);
        request.setAttribute("path", "goods-edit");
        return "seller/goods_edit";
    }

    @RequestMapping(value = "/seller/goods/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody Goods goods) {
        if (StringUtils.isEmpty(goods.getGoodsName())
                || StringUtils.isEmpty(goods.getGoodsIntro())
                || StringUtils.isEmpty(goods.getTag())
                || Objects.isNull(goods.getOriginalPrice())
                || Objects.isNull(goods.getGoodsCategoryId())
                || Objects.isNull(goods.getSellingPrice())
                || Objects.isNull(goods.getStockNum())
                || Objects.isNull(goods.getGoodsSellStatus())
                || StringUtils.isEmpty(goods.getGoodsCoverImg())
                || StringUtils.isEmpty(goods.getGoodsDetailContent())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = goodsService.saveNewBeeMallGoods(goods);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    @RequestMapping(value = "seller/goods/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody Goods goods) {
        if (Objects.isNull(goods.getGoodsId())
                || StringUtils.isEmpty(goods.getGoodsName())
                || StringUtils.isEmpty(goods.getGoodsIntro())
                || StringUtils.isEmpty(goods.getTag())
                || Objects.isNull(goods.getOriginalPrice())
                || Objects.isNull(goods.getSellingPrice())
                || Objects.isNull(goods.getGoodsCategoryId())
                || Objects.isNull(goods.getStockNum())
                || Objects.isNull(goods.getGoodsSellStatus())
                || StringUtils.isEmpty(goods.getGoodsCoverImg())
                || StringUtils.isEmpty(goods.getGoodsDetailContent())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = goodsService.updateNewBeeMallGoods(goods);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    @RequestMapping(value = "/seller/goods/status/{sellStatus}", method = RequestMethod.PUT)
    @ResponseBody
    public Result delete(@RequestBody Long[] ids, @PathVariable("sellStatus") int sellStatus) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (sellStatus != Constants.SELL_STATUS_UP && sellStatus != Constants.SELL_STATUS_DOWN) {
            return ResultGenerator.genFailResult("状态异常！");
        }
        if (goodsService.batchUpdateSellStatus(ids, sellStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

}
