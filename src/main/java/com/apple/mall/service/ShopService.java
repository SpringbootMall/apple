package com.apple.mall.service;


import com.apple.mall.entity.Shop;
import com.apple.mall.util.PageQueryUtil;
import com.apple.mall.util.PageResult;

import java.util.List;


public interface ShopService {


    List<Shop> findshop(String shopName);

    Shop shop(Long id);

   List<Shop> FindAllShopsWithSellerId(long sellerId);

    String register(Shop shop);

    /**
     * 后台分页--商家申请店铺
     *
     * @param pageUtil
     * @return
     */
    PageResult getShopApplyPage(PageQueryUtil pageUtil);

    /**
     * 店铺通过与否(0-申请 1-通过 2-拒绝)
     *
     * @param ids
     * @param applyStatus
     * @return
     */
    Boolean modifyShopsApply(Integer[] ids, int applyStatus);
}
