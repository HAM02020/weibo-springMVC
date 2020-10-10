package com.mfs.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class AccessToken {
    private String access_token;
    private String expires_in;
    private String uid;

    public  AccessToken(){

    }
    public AccessToken(String resp){
        JSONObject object = JSON.parseObject(resp);
        access_token = object.getString("access_token");
        expires_in = object.getString("expires_in");
        uid = object.getString("uid");
    }
    @Override
    public String toString() {
        return "AAAAAccessToken{" +
                "access_token='" + access_token + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
