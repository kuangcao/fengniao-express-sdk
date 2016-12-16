package com.jiabangou.fnexpresssdk.api;

import com.jiabangou.fnexpresssdk.model.PushBody;

/**
 * 推送处理接口, 需要业务自己实现推送后的处理
 * Created by freeway on 16/7/19.
 */
public interface PushConsumer {

    void deliveryStatus(PushBody pushBody);

}
