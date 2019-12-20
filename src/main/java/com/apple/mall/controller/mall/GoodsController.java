package com.apple.mall.controller.mall;

import com.apple.mall.common.Constants;
import com.apple.mall.controller.vo.GoodsDetailVO;
import com.apple.mall.controller.vo.SearchPageCategoryVO;
import com.apple.mall.entity.Goods;
import com.apple.mall.entity.Shop;
import com.apple.mall.entity.ShopUserComment;
import com.apple.mall.service.CategoryService;
import com.apple.mall.service.GoodsService;
import com.apple.mall.service.ShopService;
import com.apple.mall.service.ShopUserCommentService;
import com.apple.mall.util.BeanUtil;
import com.apple.mall.util.PageQueryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class GoodsController {

    @Resource
    private GoodsService goodsService;
    @Resource
    ShopService shopService;
    @Resource
    ShopUserCommentService shopUserCommentService;

    @GetMapping({"/search", "/search.html"})
    public String searchPage(String keyword, Model model, HttpServletRequest request) {
        List<Goods> goods = goodsService.searchPage(keyword);
        HttpSession session = request.getSession();
        session.setAttribute("keyword",keyword);
        model.addAttribute("size",goods.size());
        model.addAttribute("goods",goods);
        return "mall/search";
    }

    @GetMapping("/detail")
    public String detailPage(Long goodsId, HttpServletRequest request,Model model) {
        if (goodsId < 1) {
            return "error/error_5xx";
        }
        Goods goods = goodsService.getNewBeeMallGoodsById(goodsId);
        List<ShopUserComment>comments = shopUserCommentService.findComment(goodsId);
        request.setAttribute("goodsDetail", goods);
        model.addAttribute("comments",comments);
        return "mall/detail";
    }

    @GetMapping("/shop")
    public String shop(Long id, Model model){
        List<Goods>goods = goodsService.findgoods(id);
        Shop shop = shopService.shop(id);
        model.addAttribute("goods",goods);
        model.addAttribute("shop",shop);
        return "mall/shop";
    }
    @GetMapping("/findshop")
    public String findshop(String keyword,Model model){
        List<Shop>shops =shopService.findshop(keyword);
        model.addAttribute("shops",shops);
        return "mall/shops";
    }

}
