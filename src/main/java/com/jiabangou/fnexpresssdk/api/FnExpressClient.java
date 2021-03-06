package com.jiabangou.fnexpresssdk.api;

import com.jiabangou.fnexpresssdk.model.ResultMessage;

public interface FnExpressClient {

    void setConfigStorage(FnExpressConfigStorage mtWmConfigStorage);

    void setLogListener(LogListener logListener);

    void setAccessTokenListener(AccessTokenListener accessTokenListener);

    void setPushConsumer(PushConsumer pushConsumer);

    void setIsTest(Boolean isTest);

    /**
     * 用于接收获取到的json字符串
     *
     * @return
     */
    ResultMessage pushHandle(String jsonString);

    /**
     * 获取订单服务
     *
     * @return
     */
    OrderService getOrderService();

    /**
     * 获取token服务
     *
     * @return
     */
    AccessTokenService getAccessTokenService();

}
