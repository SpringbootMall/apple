package com.apple.mall.service.impl;

import com.apple.mall.dao.ShopManageMapper;
import com.apple.mall.dao.ShopMapper;
import com.apple.mall.entity.Shop;
import com.apple.mall.service.ShopManageService;
import com.apple.mall.util.PageQueryUtil;
import com.apple.mall.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopManageServiceImpl implements ShopManageService {

    @Autowired
    private ShopManageMapper shopManageMapper;

    @Override
    public PageResult getMallShopsPage(PageQueryUtil pageUtil) {
        List<Shop> shopList = shopManageMapper.findAllMallShopList(pageUtil);
        int total = shopManageMapper.getMallShopsPage(pageUtil);
        PageResult pageResult = new PageResult(shopList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

//    @Override
//    public List<Shop> findAllMallShop() {
//        return null;
//    }

    @Override
    public List<Shop> findMallShopByName(String shopName) {
        return shopManageMapper.findMallShopByName(shopName);
    }

    @Override
    public Shop findMallShopById(Integer id) {
        return shopManageMapper.findMallShopById(id);
    }
}
