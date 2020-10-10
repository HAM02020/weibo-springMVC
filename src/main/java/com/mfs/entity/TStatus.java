package com.mfs.entity;

import java.sql.Timestamp;

public class TStatus {
    public long statusId;
    public long userId;
    public String jsonStr;
    public Timestamp creatTime;

    public long getStatusId() {

        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }

    public Timestamp getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {


        return "TStatus{" +
                "statusId=" + statusId +
                ", userId=" + userId +
                ", jsonStr='" +jsonStr+ '\'' +
                ", creatTime=" + creatTime +
                '}';
    }
}
