package com.jiabangou.fnexpresssdk.exception;

/**
 * 美团外卖错误
 */
public class FnExpressErrorException extends Exception {

    protected int code;
    protected String requestString;
    protected String responseString;


    public FnExpressErrorException(int code, String message) {
        super(message);
        this.code = code;
    }

    public FnExpressErrorException(int code, String message, String requestString, String responseString) {
        super(message);
        this.code = code;
        this.requestString = requestString;
        this.responseString = responseString;
    }

    public int getCode() {
        return code;
    }

    public String getRequestString() {
        return requestString;
    }

    public String getResponseString() {
        return responseString;
    }

    @Override
    public String toString() {
        return "FnExpressErrorException{" +
                "code=" + code +
                ", requestString='" + requestString + '\'' +
                ", responseString='" + responseString + '\'' +
                '}';
    }
}
