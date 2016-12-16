package com.jiabangou.fnexpresssdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-12-16.
 */
public class PushBody implements Serializable {

    private String open_order_code;  //	string	蜂鸟配送开放平台返回的订单号
    private String partner_order_code;  //	string	商户自己的订单号
    private Integer order_status;  //	int	状态码
    private Long push_time;  //	long	状态推送时间(毫秒)
    private String carrier_driver_name;  //	string	蜂鸟配送员姓名
    private String carrier_driver_phone;  //	string	蜂鸟配送员电话
    private String description;  //	string	描述信息
    private String address;  //	string	定点次日达服务独有的字段: 微仓地址
    private Float latitude;  //	long	定点次日达服务独有的字段: 微仓纬度
    private Float longitude;  //	long	定点次日达服务独有的字段: 微仓经度
    private Integer cancel_reason;  //	int	订单取消原因. 1:用户取消, 2:商家取消
    private String error_code;  //	string	错误编码

    public String getOpen_order_code() {
        return open_order_code;
    }

    public void setOpen_order_code(String open_order_code) {
        this.open_order_code = open_order_code;
    }

    public String getPartner_order_code() {
        return partner_order_code;
    }

    public void setPartner_order_code(String partner_order_code) {
        this.partner_order_code = partner_order_code;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public Long getPush_time() {
        return push_time;
    }

    public void setPush_time(Long push_time) {
        this.push_time = push_time;
    }

    public String getCarrier_driver_name() {
        return carrier_driver_name;
    }

    public void setCarrier_driver_name(String carrier_driver_name) {
        this.carrier_driver_name = carrier_driver_name;
    }

    public String getCarrier_driver_phone() {
        return carrier_driver_phone;
    }

    public void setCarrier_driver_phone(String carrier_driver_phone) {
        this.carrier_driver_phone = carrier_driver_phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Integer getCancel_reason() {
        return cancel_reason;
    }

    public void setCancel_reason(Integer cancel_reason) {
        this.cancel_reason = cancel_reason;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        return "PushBody{" +
                "open_order_code='" + open_order_code + '\'' +
                ", partner_order_code='" + partner_order_code + '\'' +
                ", order_status=" + order_status +
                ", push_time=" + push_time +
                ", carrier_driver_name='" + carrier_driver_name + '\'' +
                ", carrier_driver_phone='" + carrier_driver_phone + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", cancel_reason=" + cancel_reason +
                ", error_code='" + error_code + '\'' +
                '}';
    }
}
