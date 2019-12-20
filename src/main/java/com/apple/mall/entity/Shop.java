package com.apple.mall.entity;

public class Shop {

    private int shopId;

    private String shopName;

    private String shopOwner;

    private String shopCategory;

    private Byte lockedFlag;

    private Byte isDeleted;

    private String shopCreatTime;

    private String shopImage;

    private String shopIntro;

    private int sellerId;

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public Byte getLockedFlag() {
        return lockedFlag;
    }

    public void setLockedFlag(Byte lockedFlag) {
        this.lockedFlag = lockedFlag;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getShopIntro() {
        return shopIntro;
    }

    public void setShopIntro(String shopIntro) {
        this.shopIntro = shopIntro;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopOwner() {
        return shopOwner;
    }

    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner;
    }

    public String getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(String shopCategory) {
        this.shopCategory = shopCategory;
    }

    public String getShopCreatTime() {
        return shopCreatTime;
    }

    public void setShopCreatTime(String shopCreatTime) {
        this.shopCreatTime = shopCreatTime;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    @Override
    public String toString() {
        return "shop{" +
                "shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", shopOwner='" + shopOwner + '\'' +
                ", shopCategory='" + shopCategory + '\'' +
                ", shopCreatTime='" + shopCreatTime + '\'' +
                ", shopImage='" + shopImage + '\'' +
                ", sellerId='" + sellerId + '\'' +
                '}';
    }
}

