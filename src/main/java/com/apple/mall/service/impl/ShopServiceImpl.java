package com.apple.mall.service.impl;

import com.apple.mall.dao.ShopMapper;
import com.apple.mall.entity.Shop;
import com.apple.mall.service.ShopManageService;
import com.apple.mall.service.ShopService;
import com.apple.mall.util.PageQueryUtil;
import com.apple.mall.util.PageResult;
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

        shopMapper.insertShop(shop);
        return "开店成功";
    }

    @Override
    public PageResult getShopApplyPage(PageQueryUtil pageUtil) {
        List<Shop> shopList = shopMapper.findShopList(pageUtil);
        int total = shopMapper.getTotalShops(pageUtil);
        PageResult pageResult = new PageResult(shopList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public Boolean modifyShopsApply(Integer[] ids, int applyStatus) {
        if (ids.length < 1) {
            return false;
        }
        return shopMapper.modifyShopApplyBatch(ids,applyStatus)>0;
    }


}
