package com.apple.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MallUserApply {
    private Long applyUserId;

    private Byte applyFlag;

    private String applyReason;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date applyTime;

    private Byte applyIsDeleted;

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public Byte getApplyFlag() {
        return applyFlag;
    }

    public void setApplyFlag(Byte applyFlag) {
        this.applyFlag = applyFlag;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Byte getApplyIsDeleted() {
        return applyIsDeleted;
    }

    public void setApplyIsDeleted(Byte applyIsDeleted) {
        this.applyIsDeleted = applyIsDeleted;
    }

    @Override
    public String toString() {
        return "MallUserApply{" +
                "applyUserId=" + applyUserId +
                ", applyFlag=" + applyFlag +
                ", applyReason='" + applyReason + '\'' +
                ", applyTime=" + applyTime +
                ", applyIsDeleted=" + applyIsDeleted +
                '}';
    }

    //    /***********/
//    //MallUser
//    /***********/
//    private Long userId;
//
//    private String nickName;
//
//    private String loginName;
//
//    private String passwordMd5;
//
//    private String introduceSign;
//
//    private String address;
//
//    private Byte isDeleted;
//
//    private Byte rightFlag;
//
//    private Byte lockedFlag;
//
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    private Date createTime;
//
//    public Byte getApplyFlag() {
//        return applyFlag;
//    }
//
//    public void setApplyFlag(Byte applyFlag) {
//        this.applyFlag = applyFlag;
//    }
//
//    public String getApplyReason() {
//        return applyReason;
//    }
//
//    public void setApplyReason(String applyReason) {
//        this.applyReason = applyReason;
//    }
//
//    public Date getApplyTime() {
//        return applyTime;
//    }
//
//    public void setApplyTime(Date applyTime) {
//        this.applyTime = applyTime;
//    }
//
//    public Long getApplyUserId() {
//        return applyUserId;
//    }
//
//    public void setApplyUserId(Long applyUserId) {
//        this.applyUserId = applyUserId;
//    }
//
//    public Byte getApplyIsDeleted() {
//        return applyIsDeleted;
//    }
//
//    public void setApplyIsDeleted(Byte applyIsDeleted) {
//        this.applyIsDeleted = applyIsDeleted;
//    }
//
//    /***********/
//    //MallUser
//    /***********/
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getNickName() {
//        return nickName;
//    }
//
//    public void setNickName(String nickName) {
//        this.nickName = nickName;
//    }
//
//    public String getLoginName() {
//        return loginName;
//    }
//
//    public void setLoginName(String loginName) {
//        this.loginName = loginName;
//    }
//
//    public String getPasswordMd5() {
//        return passwordMd5;
//    }
//
//    public void setPasswordMd5(String passwordMd5) {
//        this.passwordMd5 = passwordMd5;
//    }
//
//    public String getIntroduceSign() {
//        return introduceSign;
//    }
//
//    public void setIntroduceSign(String introduceSign) {
//        this.introduceSign = introduceSign;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public Byte getIsDeleted() {
//        return isDeleted;
//    }
//
//    public void setIsDeleted(Byte isDeleted) {
//        this.isDeleted = isDeleted;
//    }
//
//    public Byte getRightFlag() {
//        return rightFlag;
//    }
//
//    public void setRightFlag(Byte rightFlag) {
//        this.rightFlag = rightFlag;
//    }
//
//    public Byte getLockedFlag() {
//        return lockedFlag;
//    }
//
//    public void setLockedFlag(Byte lockedFlag) {
//        this.lockedFlag = lockedFlag;
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }

//    @Override
//    public String toString() {
//        return "MallUserApply{" +
//                "applyUserId=" + applyUserId +
//                ", applyFlag=" + applyFlag +
//                ", applyReason='" + applyReason + '\'' +
//                ", applyTime=" + applyTime +
//                ", applyIsDeleted=" + applyIsDeleted +
//                ", userId=" + userId +
//                ", nickName='" + nickName + '\'' +
//                ", loginName='" + loginName + '\'' +
//                ", passwordMd5='" + passwordMd5 + '\'' +
//                ", introduceSign='" + introduceSign + '\'' +
//                ", address='" + address + '\'' +
//                ", isDeleted=" + isDeleted +
//                ", rightFlag=" + rightFlag +
//                ", lockedFlag=" + lockedFlag +
//                ", createTime=" + createTime +
//                '}';
//    }
}