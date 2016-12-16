package com.jiabangou.fnexpresssdk.exception;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class FnExpressError implements Serializable {

    private int errorCode;

    private String errorMsg;

    private String json;

    public static FnExpressError fromJson(JSONObject jsonObject) {
        if (jsonObject.getString("code").equals("") || jsonObject.getIntValue("code") != 200) {
            FnExpressError error = new FnExpressError();
            JSONObject jsonError = jsonObject.getJSONObject("error");
            error.setErrorCode(jsonObject.getString("code").equals("") ? -1 : jsonObject.getIntValue("code"));
            error.setErrorMsg(jsonObject.getString("msg"));
            error.setJson(jsonObject.toJSONString());
            return error;
        }
        return null;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

}
