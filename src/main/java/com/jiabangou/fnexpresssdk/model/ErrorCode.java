package com.jiabangou.fnexpresssdk.model;

/**
 * Created by wanglei on 16-12-16.
 */
public enum ErrorCode {

    REQUEST_FAILED(40000,  "请求失败"),
    APP_ID_NOT_EXIST(40001,  "appid不存在"),
    SIGNATURE_INCORRECT(40002,  "验证签名失败"),
    SALT_OUT_OF_RANGE(40003,  "salt不在范围内"),
    ACCESS_TOKEN_INCORRECT(40004,  "token不正确或token已失效"),
    PARAMS_IS_REQUIRED(50010,  "缺失必填项"),
    ORDER_ID_REPEATED(50011,  "订单号重复提交"),
    ORDER_ARRIVED_TIME_LESS_THAN_CURRENT_TIME(50012,  "订单预计送达时间小于当前时间"),
    QUERY_ORDER_ERROR(50018,  "查询订单错误"),
    QUERY_DELIVERY_ORDER_ERROR(50019,  "查询运单错误"),
    ORDER_NOT_CREATE(50025,  "订单暂未生成"),
    DELIVERY_ORDER_NOT_CREATE(50026,  "运单暂未生成"),
    ORDER_NOT_EXIST(50037,  "订单不存在"),
    FIELD_TOO_LONG(50040,  "字段值过长"),
    FIELD_NOT_TO_RULES(50041,  "字段值不符合规则"),
    NO_SERVICE_TYPE(50042,  "无此服务类型"),
    DELIVERY_NOT_COVER(500070,  "没有运力覆盖"),
    UNBIND_MINI_STORE(500080,  "没有绑定微仓"),
    MINI_STORE_AND_DELIVERY_NOT_MATCH(500090,  "用户绑定的微仓和运力覆盖范围不匹配"),
    CANCEL_ORDER_FAILED(50101,  "商户取消订单失败"),
    NOT_ALLOW_CANCEL_ORDER(50102,  "当前订单状态不允许取消"),
    ORDER_ARRIVED_TIME_TOO_LATE(50104,  "预计送达时间过长，请修改后重新推送"),
    NOT_BUY_SERVICE_OR_SERVICE_OFFLINE(50110,  "未购买服务或服务已下线"),
    ORDER_DELIVERY_DISTANCE_TOO_LONG(500060,  "订单配送距离太远了超过阈值"),
    ORDER_OVERWEIGHT(500100,  "订单超重"),
//    ORDER_ARRIVED_TIME_TOO_LATE(50019,  "预计送达时间过长"),
    ;

    private int code;
    private String name;

    ErrorCode(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getErrorCodeName(int code) {
        for (ErrorCode type : ErrorCode.values()) {
            if (type.getCode() == code) {
                return type.getName();
            }
        }
        return "";
    }
}
