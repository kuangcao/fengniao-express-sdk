package com.jiabangou.fnexpresssdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-12-14.
 */
public class NextDayOrder implements Serializable {

    private String partner_remark; //	string	255	否	商户备注信息
    private String partner_order_code; //	string	128	是	商户订单号,要求唯一
    private String notify_url; //	string	255	是	回调地址,订单状态变更时会调用此接口传递状态信息
    private Integer order_type; //	int	-	是	订单类型 1: 蜂鸟配送，支持90分钟内送达
    private Long order_add_time; //	long	-	否	下单时间(毫秒)
    private Double order_total_amount; //	decimal	10	是	订单总金额（不包含商家的任何活动以及折扣的金额）
    private Double order_actual_amount; //	decimal	10	是	客户需要支付的金额
    private Double order_weight; //	decimal	11	否	订单总重量（kg），营业类型选定为果蔬生鲜、商店超市、其他三类时必填，大于0kg并且小于等于6kg
    private String order_remark; //	string	255	否	用户备注
    private Integer is_invoiced; //	int	-	是	是否需要发票, 0:不需要, 1:需要
    private String invoice; //	string	128	否	发票抬头, 如果需要发票, 此项必填
    private Integer order_payment_status; //	int	-	是	订单支付状态 0:未支付 1:已支付
    private Integer order_payment_method; //	int	-	是	订单支付方式 1:在线支付
    private Integer is_agent_payment; //	int	-	是	是否需要ele代收 0:否 1:是
    private Double require_payment_pay; //	decimal	-	否	需要代收时客户应付金额, 如需代收款 此项必填
    private Integer goods_count; //	int	-	是	订单货物件数
    private Long require_receive_time; //	long	-	否	需要送达时间（毫秒).
    private ReceiverInfo receiver_info; // 收货信息
    private List<Item> items_json;
    private String serial_number; //	string	6	否	商家订单流水号, 方便配送骑手到店取货, 支持数字,字母及#等常见字符. 如不填写, 蜂鸟将截取商家订单号后4位作为流水号.

    public String getPartner_remark() {
        return partner_remark;
    }

    public void setPartner_remark(String partner_remark) {
        this.partner_remark = partner_remark;
    }

    public String getPartner_order_code() {
        return partner_order_code;
    }

    public void setPartner_order_code(String partner_order_code) {
        this.partner_order_code = partner_order_code;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public Integer getOrder_type() {
        return order_type;
    }

    public void setOrder_type(Integer order_type) {
        this.order_type = order_type;
    }

    public Long getOrder_add_time() {
        return order_add_time;
    }

    public void setOrder_add_time(Long order_add_time) {
        this.order_add_time = order_add_time;
    }

    public Double getOrder_total_amount() {
        return order_total_amount;
    }

    public void setOrder_total_amount(Double order_total_amount) {
        this.order_total_amount = order_total_amount;
    }

    public Double getOrder_actual_amount() {
        return order_actual_amount;
    }

    public void setOrder_actual_amount(Double order_actual_amount) {
        this.order_actual_amount = order_actual_amount;
    }

    public Double getOrder_weight() {
        return order_weight;
    }

    public void setOrder_weight(Double order_weight) {
        this.order_weight = order_weight;
    }

    public String getOrder_remark() {
        return order_remark;
    }

    public void setOrder_remark(String order_remark) {
        this.order_remark = order_remark;
    }

    public Integer getIs_invoiced() {
        return is_invoiced;
    }

    public void setIs_invoiced(Integer is_invoiced) {
        this.is_invoiced = is_invoiced;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Integer getOrder_payment_status() {
        return order_payment_status;
    }

    public void setOrder_payment_status(Integer order_payment_status) {
        this.order_payment_status = order_payment_status;
    }

    public Integer getOrder_payment_method() {
        return order_payment_method;
    }

    public void setOrder_payment_method(Integer order_payment_method) {
        this.order_payment_method = order_payment_method;
    }

    public Integer getIs_agent_payment() {
        return is_agent_payment;
    }

    public void setIs_agent_payment(Integer is_agent_payment) {
        this.is_agent_payment = is_agent_payment;
    }

    public Double getRequire_payment_pay() {
        return require_payment_pay;
    }

    public void setRequire_payment_pay(Double require_payment_pay) {
        this.require_payment_pay = require_payment_pay;
    }

    public Integer getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(Integer goods_count) {
        this.goods_count = goods_count;
    }

    public Long getRequire_receive_time() {
        return require_receive_time;
    }

    public void setRequire_receive_time(Long require_receive_time) {
        this.require_receive_time = require_receive_time;
    }

    public ReceiverInfo getReceiver_info() {
        return receiver_info;
    }

    public void setReceiver_info(ReceiverInfo receiver_info) {
        this.receiver_info = receiver_info;
    }

    public List<Item> getItems_json() {
        return items_json;
    }

    public void setItems_json(List<Item> items_json) {
        this.items_json = items_json;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    @Override
    public String toString() {
        return "Order{" +
                "partner_remark='" + partner_remark + '\'' +
                ", partner_order_code='" + partner_order_code + '\'' +
                ", notify_url='" + notify_url + '\'' +
                ", order_type=" + order_type +
                ", order_add_time=" + order_add_time +
                ", order_total_amount=" + order_total_amount +
                ", order_actual_amount=" + order_actual_amount +
                ", order_weight=" + order_weight +
                ", order_remark='" + order_remark + '\'' +
                ", is_invoiced=" + is_invoiced +
                ", invoice='" + invoice + '\'' +
                ", order_payment_status=" + order_payment_status +
                ", order_payment_method=" + order_payment_method +
                ", is_agent_payment=" + is_agent_payment +
                ", require_payment_pay=" + require_payment_pay +
                ", goods_count=" + goods_count +
                ", require_receive_time=" + require_receive_time +
                ", receiver_info=" + receiver_info +
                ", items_json=" + items_json +
                ", serial_number='" + serial_number + '\'' +
                '}';
    }

}
