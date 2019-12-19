package com.apple.mall.service;

import com.apple.mall.entity.Shop;
import com.apple.mall.util.PageQueryUtil;
import com.apple.mall.util.PageResult;

import java.util.List;

public interface ShopManageService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getMallShopsPage(PageQueryUtil pageUtil);

//    /**
//     * 查询所有店铺
//     *
//     * @return
//     */
//    List<Shop> findAllMallShop();

    /**
     * 通过店铺名查询店铺
     *
     * @param shopName
     * @return
     */
    List<Shop> findMallShopByName(String shopName);

    /**
     * 通过店铺ID查询店铺
     *
     * @param id
     * @return
     */
    Shop findMallShopById(Integer id);

    /**
     * 店铺禁用与解除禁用(0-未锁定 1-已锁定)
     *
     * @param ids
     * @param lockStatus
     * @return
     */
    Boolean lockShops(Integer[] ids, int lockStatus);

}
