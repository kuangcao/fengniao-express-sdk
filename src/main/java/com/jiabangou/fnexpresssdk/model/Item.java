package com.jiabangou.fnexpresssdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-12-14.
 */
public class Item implements Serializable {

    private String item_id; //	string	-	否	商品编号
    private String item_name; //	string	-	是	商品名称
    private Integer item_quantity; //	int	-	是	商品数量
    private Double item_price; //	decimal	-	是	商品原价
    private Double item_actual_price; //	decimal	-	是	商品实际支付金额
    private Integer item_size; //	int	-	否	商品尺寸
    private String item_remark; //	string	-	否	商品备注
    private Integer is_need_package; //	int	-	是	是否需要ele打包 0:否 1:是
    private Integer is_agent_purchase; //	int	-	是	是否代购 0:否 1:是
    private Double agent_purchase_price; //	decimal	-	否	代购进价, 如果需要代购 此项必填

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(Integer item_quantity) {
        this.item_quantity = item_quantity;
    }

    public Double getItem_price() {
        return item_price;
    }

    public void setItem_price(Double item_price) {
        this.item_price = item_price;
    }

    public Double getItem_actual_price() {
        return item_actual_price;
    }

    public void setItem_actual_price(Double item_actual_price) {
        this.item_actual_price = item_actual_price;
    }

    public Integer getItem_size() {
        return item_size;
    }

    public void setItem_size(Integer item_size) {
        this.item_size = item_size;
    }

    public String getItem_remark() {
        return item_remark;
    }

    public void setItem_remark(String item_remark) {
        this.item_remark = item_remark;
    }

    public Integer getIs_need_package() {
        return is_need_package;
    }

    public void setIs_need_package(Integer is_need_package) {
        this.is_need_package = is_need_package;
    }

    public Integer getIs_agent_purchase() {
        return is_agent_purchase;
    }

    public void setIs_agent_purchase(Integer is_agent_purchase) {
        this.is_agent_purchase = is_agent_purchase;
    }

    public Double getAgent_purchase_price() {
        return agent_purchase_price;
    }

    public void setAgent_purchase_price(Double agent_purchase_price) {
        this.agent_purchase_price = agent_purchase_price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id='" + item_id + '\'' +
                ", item_name='" + item_name + '\'' +
                ", item_quantity=" + item_quantity +
                ", item_price=" + item_price +
                ", item_actual_price=" + item_actual_price +
                ", item_size=" + item_size +
                ", item_remark='" + item_remark + '\'' +
                ", is_need_package=" + is_need_package +
                ", is_agent_purchase=" + is_agent_purchase +
                ", agent_purchase_price=" + agent_purchase_price +
                '}';
    }
}
