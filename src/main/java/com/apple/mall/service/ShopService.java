package com.apple.mall.service;


import com.apple.mall.entity.Shop;
import java.util.List;


public interface ShopService {


    List<Shop> findshop(String shopName);

    Shop shop(Long id);

   List<Shop> FindAllShopsWithSellerId(long sellerId);


}
