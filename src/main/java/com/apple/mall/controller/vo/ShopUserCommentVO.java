package com.apple.mall.controller.vo;

import java.util.Date;

public class ShopUserCommentVO {
    private Long orderId;
    private Long userId;
    private Date createTime;
    private Date updateTime;
    private String userEvaluation;
    private String addEvaluation;
    private int goodsScore;
    private int serviceScore;
    private int logisticsScore;
    private Long sellerId;
    private Long storeId;
    private String storeReply;

    private Date replyTime;

    @Override
    public String toString() {
        return "ShopUserCommentVO{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userEvaluation='" + userEvaluation + '\'' +
                ", addEvaluation='" + addEvaluation + '\'' +
                ", goodsScore=" + goodsScore +
                ", serviceScore=" + serviceScore +
                ", logisticsScore=" + logisticsScore +
                ", sellerId=" + sellerId +
                ", storeId=" + storeId +
                ", storeReply='" + storeReply + '\'' +
                ", replyTime=" + replyTime +
                '}';
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserEvaluation() {
        return userEvaluation;
    }

    public void setUserEvaluation(String userEvaluation) {
        this.userEvaluation = userEvaluation;
    }

    public String getAddEvaluation() {
        return addEvaluation;
    }

    public void setAddEvaluation(String addEvaluation) {
        this.addEvaluation = addEvaluation;
    }

    public int getGoodsScore() {
        return goodsScore;
    }

    public void setGoodsScore(int goodsScore) {
        this.goodsScore = goodsScore;
    }

    public int getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(int serviceScore) {
        this.serviceScore = serviceScore;
    }

    public int getLogisticsScore() {
        return logisticsScore;
    }

    public void setLogisticsScore(int logisticsScore) {
        this.logisticsScore = logisticsScore;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreReply() {
        return storeReply;
    }

    public void setStoreReply(String storeReply) {
        this.storeReply = storeReply;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
}
