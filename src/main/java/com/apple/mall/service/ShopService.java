package com.apple.mall.service;

import com.apple.mall.dao.ShopMapper;
import com.apple.mall.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class ShopService {

    @Autowired
    ShopMapper shopMapper;

    public List<Shop> findshop(String shopName){

        return shopMapper.findshop(shopName);
    }

    public Shop shop(Long id){

        return shopMapper.shop(id);
    }

    public List<Shop> FindAllShopsWithSellerId(long sellerId) {
        return shopMapper.FindAllShopsWithSellerId(sellerId);
    }


}
