package com.apple.mall.service.impl;

import com.apple.mall.dao.ShopMapper;
import com.apple.mall.entity.Shop;
import com.apple.mall.service.ShopManageService;
import com.apple.mall.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopMapper shopMapper;

    @Override
    public List<Shop> findshop(String shopName){

        return shopMapper.findshop(shopName);
    }

    @Override
    public Shop shop(Long id){

        return shopMapper.shop(id);
    }

    @Override
    public List<Shop> FindAllShopsWithSellerId(long sellerId) {
        return shopMapper.FindAllShopsWithSellerId(sellerId);
    }

    @Override
    public String register(Shop shop){
        if(shopMapper.findShopByName(shop.getShopName())!=null){
            return "店铺名重复";
        }
        shopMapper.insertShop(shop);
        return "开店成功";
    }
}
