package com.jiabangou.fnexpresssdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-12-14.
 */
public class ReceiverInfo implements Serializable {

    private String receiver_name; //	string	30	是	收货人姓名
    private String receiver_primary_phone; //	string	64	是	收货人联系电话, 只支持手机号, 只支持手机号
    private String receiver_second_phone; //	string	64	否	收货人备用联系电话
    private String receiver_address; //	string	255	是	收货人地址
    private Double receiver_longitude; //	decimal	-	是	收货人经度
    private Double receiver_latitude; //	decimal	-	是	收货人纬度
    private Integer position_source; //	int	-	否	经纬度来源 1:腾讯地图, 2:百度地图, 3:高德地图

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_primary_phone() {
        return receiver_primary_phone;
    }

    public void setReceiver_primary_phone(String receiver_primary_phone) {
        this.receiver_primary_phone = receiver_primary_phone;
    }

    public String getReceiver_second_phone() {
        return receiver_second_phone;
    }

    public void setReceiver_second_phone(String receiver_second_phone) {
        this.receiver_second_phone = receiver_second_phone;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public Double getReceiver_longitude() {
        return receiver_longitude;
    }

    public void setReceiver_longitude(Double receiver_longitude) {
        this.receiver_longitude = receiver_longitude;
    }

    public Double getReceiver_latitude() {
        return receiver_latitude;
    }

    public void setReceiver_latitude(Double receiver_latitude) {
        this.receiver_latitude = receiver_latitude;
    }

    public Integer getPosition_source() {
        return position_source;
    }

    public void setPosition_source(Integer position_source) {
        this.position_source = position_source;
    }

    @Override
    public String toString() {
        return "ReceiverInfo{" +
                "receiver_name='" + receiver_name + '\'' +
                ", receiver_primary_phone='" + receiver_primary_phone + '\'' +
                ", receiver_second_phone='" + receiver_second_phone + '\'' +
                ", receiver_address='" + receiver_address + '\'' +
                ", receiver_longitude=" + receiver_longitude +
                ", receiver_latitude=" + receiver_latitude +
                ", position_source=" + position_source +
                '}';
    }
}
