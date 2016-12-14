package model;

import java.io.Serializable;

/**
 * Created by freeway on 16/7/19.
 */
public class ResultMessage implements Serializable {

    private Integer code;

    private String msg;

    private String data;

    public static ResultMessage buildOk() {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode(200);
        resultMessage.setMsg("success");
        resultMessage.setData("");
        return resultMessage;
    }

    public static ResultMessage buildError(String errorMsg) {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode(-1);
        resultMessage.setMsg(errorMsg == null ? "error" : errorMsg);
        resultMessage.setData("");
        return resultMessage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultMessage{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
