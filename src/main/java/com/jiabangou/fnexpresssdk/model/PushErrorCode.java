package com.jiabangou.fnexpresssdk.model;

import org.apache.commons.lang.StringUtils;

/**
 * Created by wanglei on 16-12-16.
 */
public enum  PushErrorCode {

    SCHEDULE_ORDER_OUT_OF_TIME_ERROR("SCHEDULE_ORDER_OUT_OF_TIME_ERROR", "预订单超时异常"),  //建议商户改派其他配送商
    CARRIER_OFFLINE_ERROR("CARRIER_OFFLINE_ERROR", "超出配送商营业时间"),  // 	建议商户改派其他配送商
    REQUIRE_RECEIVE_TIME_INVALID("REQUIRE_RECEIVE_TIME_INVALID", "预计送达时间不正确"),  //建议输入正确的预计送达时间
    ORDER_OUT_OF_DISTANCE_ERROR("ORDER_OUT_OF_DISTANCE_ERROR", "订单超区"),  //建议商户改派其他配送商
    ORDER_OUT_OF_WEIGHT("ORDER_OUT_OF_WEIGHT", "订单超重"),  //建议商户改派其他配送商
    ORDER_OUT_OF_LOAD_ERROR("ORDER_OUT_OF_LOAD_ERROR", "订单超出运力"),  //建议商户改派其他配送商
    NO_CARRIER_ERROR("NO_CARRIER_ERROR", "当前暂无骑手接单"),  //	请稍后重试	建议商户改派其他配送商
    ORDER_OUT_OF_SERVICE("ORDER_OUT_OF_SERVICE", "运单超服务范围"),  //建议商户改派其他配送商
    ORDER_OUT_OF_TIME_ERROR("ORDER_OUT_OF_TIME_ERROR", "订单超时"),  //建议商户改派其他配送商
    MERCHANT_INTERRUPT_DELIVERY_ERROR("MERCHANT_INTERRUPT_DELIVERY_ERROR", "商户原因中断配送"),  //建议商户改派其他配送商
    MERCHANT_FOOD_ERROR("MERCHANT_FOOD_ERROR", "商家出货问题"),  //建议商户改派其他配送商
    MERCHANT_CALL_LATE_ERROR("MERCHANT_CALL_LATE_ERROR", "呼叫配送晚"),  //建议商户改派其他配送商
    USER_NOT_ANSWER_ERROR("USER_NOT_ANSWER_ERROR", "用户不接电话"),  //建议商户改派其他配送商
    USER_RETURN_ORDER_ERROR("USER_RETURN_ORDER_ERROR", "用户退单"),  //建议为用户办理退款
    USER_ADDRESS_ERROR("USER_ADDRESS_ERROR", "用户地址错误"),  //建议商户改派其他配送商
    DELIVERY_OUT_OF_SERVICE("DELIVERY_OUT_OF_SERVICE", "超出服务范围"),  //建议商户改派其他配送商
    SYSTEM_MARKED_ERROR("SYSTEM_MARKED_ERROR", "系统自动标记异常--订单超过3小时未送达"),  //建议商户改派其他配送商
    CARRIER_REMARK_EXCEPTION_ERROR("CARRIER_REMARK_EXCEPTION_ERROR", "骑手标记异常"),  //建议商户改派其他配送商
    OTHER_ERROR("OTHER_ERROR", "其他"),  //	建议商户改派其他配送商
    NORMAL_ORDER_OUT_OF_TIME_ERROR("NORMAL_ORDER_OUT_OF_TIME_ERROR", "众包无骑手接单"),  //建议商户改派其他配送商
    SYSTEM_ERROR("SYSTEM_ERROR", "系统错误"),  //建议商户改派其他配送商
    UNKNOW_ERROR("UNKNOW_ERROR", "未知错误"),  //建议商户改派其他配送商
    ORDER_REPETITION("ORDER_REPETITION", "订单重复"),  //建议商户改派其他配送商
    CURRENT_STATUS_NOT_ALLOW_CANCEL("CURRENT_STATUS_NOT_ALLOW_CANCEL", "当前订单不允许取消"),  //建议商户改派其他配送商
    USER_CANCEL("USER_CANCEL", "用户发起取消"),  //建议商户改派其他配送商
    SYSTEM_CANCEL("SYSTEM_CANCEL", "系统取消"),  //建议商户改派其他配送商
    MERCHANT_CANCEL("MERCHANT_CANCEL", "商户发起取消"),  //建议商户改派其他配送商
    CARRIER_CANCEL("CARRIER_CANCEL", "配送商发起取消"),  //建议商户改派其他配送商
    DELIVERY_TIMEOUT("DELIVERY_TIMEOUT", "配送超时"),  //系统标记异常	建议商户改派其他配送商
    REJECT_ORDER("REJECT_ORDER", "拒单"),  //目前只有是状态1（待调度）才可以取消
    FOR_UPDATE_TIP("FOR_UPDATE_TIP", "加小费取消"),  //目前只有是状态1（待调度）才可以取消
    ;

    private String code;
    private String name;

    PushErrorCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getErrorCodeName(String code) {
        for (PushErrorCode type : PushErrorCode.values()) {
            if (StringUtils.equals(type.getCode(), code)) {
                return type.getName();
            }
        }
        return "";
    }
}
