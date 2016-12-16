package com.jiabangou.fnexpresssdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-12-14.
 */
public class RequestBody implements Serializable {

    private String app_id;
    private Integer salt;
    private String signature;
    private Object data;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RequestBody{" +
                "app_id='" + app_id + '\'' +
                ", salt=" + salt +
                ", signature='" + signature + '\'' +
                ", data=" + data +
                '}';
    }
}
