package com.apple.mall.controller.vo;

import java.util.ArrayList;

public class BuyInOneShopVO {
    private double price;

    private String shopName;

    private Long shopId;

    private ArrayList<ShoppingCartItemVO> shoppingCartItemVOs;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public ArrayList<ShoppingCartItemVO> getShoppingCartItemVOs() {
        return shoppingCartItemVOs;
    }

    public void setShoppingCartItemVOs(ArrayList<ShoppingCartItemVO> shoppingCartItemVOs) {
        this.shoppingCartItemVOs = shoppingCartItemVOs;
    }
}
