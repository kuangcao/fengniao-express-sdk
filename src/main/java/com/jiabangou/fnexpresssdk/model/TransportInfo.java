package com.jiabangou.fnexpresssdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-12-14.
 */
public class TransportInfo implements Serializable {

    private String transport_name; //	string	64	否	门店名称
    private String transport_address; //	string	255	是	取货点地址
    private Float transport_longitude; //	decimal	-	是	取货点经度
    private Float transport_latitude; //	decimal	-	是	取货点纬度
    private Integer position_source; //	int	-	是	取货点经纬度来源, 1:腾讯地图, 2:百度地图, 3:高德地图
    private String transport_tel; //	string	16	是	取货点联系方式, 只支持手机号,400开头电话以及座机号码
    private String transport_remark; //	string	255	否	取货点备注

    public String getTransport_name() {
        return transport_name;
    }

    public void setTransport_name(String transport_name) {
        this.transport_name = transport_name;
    }

    public String getTransport_address() {
        return transport_address;
    }

    public void setTransport_address(String transport_address) {
        this.transport_address = transport_address;
    }

    public Float getTransport_longitude() {
        return transport_longitude;
    }

    public void setTransport_longitude(Float transport_longitude) {
        this.transport_longitude = transport_longitude;
    }

    public Float getTransport_latitude() {
        return transport_latitude;
    }

    public void setTransport_latitude(Float transport_latitude) {
        this.transport_latitude = transport_latitude;
    }

    public Integer getPosition_source() {
        return position_source;
    }

    public void setPosition_source(Integer position_source) {
        this.position_source = position_source;
    }

    public String getTransport_tel() {
        return transport_tel;
    }

    public void setTransport_tel(String transport_tel) {
        this.transport_tel = transport_tel;
    }

    public String getTransport_remark() {
        return transport_remark;
    }

    public void setTransport_remark(String transport_remark) {
        this.transport_remark = transport_remark;
    }

    @Override
    public String toString() {
        return "TransportInfo{" +
                "transport_name='" + transport_name + '\'' +
                ", transport_address='" + transport_address + '\'' +
                ", transport_longitude=" + transport_longitude +
                ", transport_latitude=" + transport_latitude +
                ", position_source=" + position_source +
                ", transport_tel='" + transport_tel + '\'' +
                ", transport_remark='" + transport_remark + '\'' +
                '}';
    }
}
