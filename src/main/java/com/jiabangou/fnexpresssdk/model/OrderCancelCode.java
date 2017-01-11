package com.jiabangou.fnexpresssdk.model;

/**
 * Created by wanglei on 16-12-16.
 */
public interface OrderCancelCode {

    /**
     * 其他原因
     */
    int OTHER = 0; //其他原因
    /**
     * 联系不上商户
     */
    int NOT_CONTACT_MERCHANT  = 1; //联系不上商户
    /**
     * 商品已售完
     */
    int GOODS_SOLD_OUT = 2; //商品已售完
    /**
     * 用户取消
     */
    int USER_CANCEL = 3; //用户取消
    /**
     * 运力告不配送 取消订单
     */
    int DELIVERY_NOT_COVER = 4; //蜂鸟配送开放平台将已送达状态回调给商户, 不支持取消
    /**
     * 订单长时间未分配
     */
    int ORDER_NOT_DISTRIBUTE = 5; //订单长时间未分配
    /**
     * 骑手未取件
     */
    int CARRIER_NOT_TAKE = 6; //骑手未取件

}
