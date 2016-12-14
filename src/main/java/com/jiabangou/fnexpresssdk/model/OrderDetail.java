package com.jiabangou.fnexpresssdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-12-14.
 */
public class OrderDetail implements Serializable {

    private Integer transport_station_id; //	int	微仓ID
    private String transport_station_tel; //	string	微仓电话
    private String carrier_driver_id; //	string	配送员ID
    private String carrier_driver_name; //	string	配送员姓名
    private String carrier_driver_phone; //	string	配送员电话
    private Long estimate_arrive_time; //	long	预计送达时间（毫秒）
    private Double order_total_delivery_cost; //	decimal	配送费
    private Double order_total_delivery_discount; //	decimal	配送费折扣
    private Integer order_status; //	int	订单状态
    private String abnormal_code; //	string	运单异常原因code
    private String abnormal_desc; //	string	运单异常原因描述
    private List<EventLogDetail> event_log_details; // 配送单状态log

    public Integer getTransport_station_id() {
        return transport_station_id;
    }

    public void setTransport_station_id(Integer transport_station_id) {
        this.transport_station_id = transport_station_id;
    }

    public String getTransport_station_tel() {
        return transport_station_tel;
    }

    public void setTransport_station_tel(String transport_station_tel) {
        this.transport_station_tel = transport_station_tel;
    }

    public String getCarrier_driver_id() {
        return carrier_driver_id;
    }

    public void setCarrier_driver_id(String carrier_driver_id) {
        this.carrier_driver_id = carrier_driver_id;
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

    public Long getEstimate_arrive_time() {
        return estimate_arrive_time;
    }

    public void setEstimate_arrive_time(Long estimate_arrive_time) {
        this.estimate_arrive_time = estimate_arrive_time;
    }

    public Double getOrder_total_delivery_cost() {
        return order_total_delivery_cost;
    }

    public void setOrder_total_delivery_cost(Double order_total_delivery_cost) {
        this.order_total_delivery_cost = order_total_delivery_cost;
    }

    public Double getOrder_total_delivery_discount() {
        return order_total_delivery_discount;
    }

    public void setOrder_total_delivery_discount(Double order_total_delivery_discount) {
        this.order_total_delivery_discount = order_total_delivery_discount;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public String getAbnormal_code() {
        return abnormal_code;
    }

    public void setAbnormal_code(String abnormal_code) {
        this.abnormal_code = abnormal_code;
    }

    public String getAbnormal_desc() {
        return abnormal_desc;
    }

    public void setAbnormal_desc(String abnormal_desc) {
        this.abnormal_desc = abnormal_desc;
    }

    public List<EventLogDetail> getEvent_log_details() {
        return event_log_details;
    }

    public void setEvent_log_details(List<EventLogDetail> event_log_details) {
        this.event_log_details = event_log_details;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "transport_station_id=" + transport_station_id +
                ", transport_station_tel='" + transport_station_tel + '\'' +
                ", carrier_driver_id='" + carrier_driver_id + '\'' +
                ", carrier_driver_name='" + carrier_driver_name + '\'' +
                ", carrier_driver_phone='" + carrier_driver_phone + '\'' +
                ", estimate_arrive_time=" + estimate_arrive_time +
                ", order_total_delivery_cost=" + order_total_delivery_cost +
                ", order_total_delivery_discount=" + order_total_delivery_discount +
                ", order_status=" + order_status +
                ", abnormal_code='" + abnormal_code + '\'' +
                ", abnormal_desc='" + abnormal_desc + '\'' +
                ", event_log_details=" + event_log_details +
                '}';
    }
}
