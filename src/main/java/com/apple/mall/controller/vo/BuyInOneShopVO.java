package com.apple.mall.controller.vo;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyInOneShopVO that = (BuyInOneShopVO) o;
        return Objects.equals(shopId, that.shopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId);
    }

    @Override
    public String toString() {
        return "BuyInOneShopVO{" +
                "price=" + price +
                ", shopName='" + shopName + '\'' +
                ", shopId=" + shopId +
                ", shoppingCartItemVOs=" + shoppingCartItemVOs +
                '}';
    }
}
