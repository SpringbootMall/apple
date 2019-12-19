package com.apple.mall.controller.mall;


import com.apple.mall.entity.Goods;
import com.apple.mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class IndexController {

    @Autowired
    GoodsService goodsService;
    @GetMapping({"/index", "/", "/index.html"})
    public String getRe(Model model){
        List<Goods> goods = goodsService.findre("推荐");
        model.addAttribute("goods",goods);
        return "mall/index";
    }


}