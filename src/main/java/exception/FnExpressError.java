package exception;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class FnExpressError implements Serializable {

    private int errorCode;

    private String errorMsg;

    private String json;

    public static FnExpressError fromJson(JSONObject jsonObject) {
        if (jsonObject.getIntValue("code") != 200) {
            FnExpressError error = new FnExpressError();
            JSONObject jsonError = jsonObject.getJSONObject("error");
            error.setErrorCode(jsonError.getIntValue("code"));
            error.setErrorMsg(jsonError.getString("msg"));
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
