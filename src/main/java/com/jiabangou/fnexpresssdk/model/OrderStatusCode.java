package com.jiabangou.fnexpresssdk.model;

/**
 * Created by wanglei on 16-12-16.
 */
public interface OrderStatusCode {

    /**
     * 系统已接单
     */
    int ORDER_CONFIRMED = 1; //蜂鸟配送开放平台接单后,商户接收到系统已接单状态, 支持取消
    /**
     * 已分配骑手
     */
    int ORDER_ASSIGNED = 20; //蜂鸟配送开放平台接单后,商户接收到已分配骑手状态, 支持取消
    /**
     * 骑手已到店
     */
    int CARRIER_ARRIVED = 80; //蜂鸟配送开放平台将骑手已到店状态回调给商户, 支持取消
    /**
     * 配送中(不支持取消)
     */
    int ORDER_DELIVERING = 2; //蜂鸟配送开放平台将骑手配送中状态回调给商户, 不支持取消
    /**
     * 已送达(不支持取消)
     */
    int ORDER_ARRIVED = 3; //蜂鸟配送开放平台将已送达状态回调给商户, 不支持取消
    /**
     * 已取消(同步取消不需要关注此状态)
     */
    int ORDER_CANCELED = 4; //商户主动取消订单请求处理成功后,蜂鸟配送开放平台将已取消状态回调给商户
    /**
     * 异常
     */
    int ORDER_EXCEPTION = 5; //推单到物流开放平台后任何阶段产生异常,蜂鸟配送开放平台将异常状态回调给商户

}
