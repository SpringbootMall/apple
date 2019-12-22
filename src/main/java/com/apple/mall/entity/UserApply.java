package com.apple.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserApply {
    long applyUserID;
    Byte applyFlag;
    String applyReason;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date applyTime;

    Byte applyIsDeleted;

    public long getApplyUserID() {
        return applyUserID;
    }

    public void setApplyUserID(long applyUserID) {
        this.applyUserID = applyUserID;
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
}
