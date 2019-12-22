package com.apple.mall.entity;

import javax.xml.crypto.Data;
import java.util.Date;

public class MallUserApply {
    private long applyUserId;
    private Byte applyFlag;
    private String applyReason;
    private Date applyTime;
    private Byte applyIsDeleted;

    public long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(long applyUserId) {
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
}
