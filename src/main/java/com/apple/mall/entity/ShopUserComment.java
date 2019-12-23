package com.apple.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ShopUserComment {
    private Long orderNo;

    private Long goodsId;

    private Long userId;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentCreateTime;

   // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentUpdateTime;

    private String userEvaluation;

    private String addEvaluation;

    private int goodsScore;

    private int serviceScore;

    private int logisticsScore;

    private String submitImg;

    private Byte commentIsDeleted;

    private Long sellerId;

    private Long storeId;

    private String storeReply;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date replyTime;

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    public Date getCommentUpdateTime() {
        return commentUpdateTime;
    }

    public void setCommentUpdateTime(Date commentUpdateTime) {
        this.commentUpdateTime = commentUpdateTime;
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

    public void setGoodsScore(Integer goodsScore) {
        this.goodsScore = goodsScore;
    }

    public int getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(Integer serviceScore) {
        this.serviceScore = serviceScore;
    }

    public int getLogisticsScore() {
        return logisticsScore;
    }

    public void setLogisticsScore(Integer logisticsScore) {
        this.logisticsScore = logisticsScore;
    }

    public String getSubmitImg() {
        return submitImg;
    }

    public void setSubmitImg(String submitImg) {
        this.submitImg = submitImg;
    }

    public Byte getCommentIsDeleted() {
        return commentIsDeleted;
    }

    public void setCommentIsDeleted(Byte commentIsDeleted) {
        this.commentIsDeleted = commentIsDeleted;
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
