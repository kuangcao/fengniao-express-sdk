package com.jiabangou.fnexpresssdk.exception;

/**
 * 美团外卖错误
 */
public class FnExpressErrorException extends Exception {

    protected int code;

    public FnExpressErrorException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "MtWmErrorException{" +
                "code=" + code +
                ", message=" + getMessage() +
                "} " + super.toString();
    }

}
