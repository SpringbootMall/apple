package com.apple.mall.dao;

import com.apple.mall.entity.Shop;
import com.apple.mall.util.PageQueryUtil;

import java.util.List;

public interface ShopManageMapper {
    List<Shop> findAllMallShopList(PageQueryUtil pageUtil);

    int getMallShopsPage(PageQueryUtil pageUtil);

    List<Shop> findMallShopByName(String shopName);

    Shop findMallShopById(Integer id);
}
