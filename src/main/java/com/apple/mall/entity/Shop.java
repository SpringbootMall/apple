package com.apple.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Shop {

    private Long shopId;

    private String shopName;

    private String shopOwner;

    private String shopCategory;

    private Byte lockedFlag;

    private Byte isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date shopCreatTime;

    private String shopImage;

    private String shopIntro;

    private long sellerId;

    public byte getShopFlag() {
        return shopFlag;
    }

    public void setShopFlag(byte shopFlag) {
        this.shopFlag = shopFlag;
    }

    private byte shopFlag;

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
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

    public Date getShopCreatTime() {
        return shopCreatTime;
    }

    public void setShopCreatTime(Date shopCreatTime) {
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

