package model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-12-14.
 */
public class RequestBody implements Serializable {

    private String appId;
    private Integer salt;
    private String signature;
    private Object data;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
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
                "appId='" + appId + '\'' +
                ", salt=" + salt +
                ", signature='" + signature + '\'' +
                ", data=" + data +
                '}';
    }
}
