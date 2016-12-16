package com.jiabangou.fnexpresssdk.api;

import com.jiabangou.fnexpresssdk.exception.FnExpressErrorException;
import com.jiabangou.fnexpresssdk.model.NextDayOrder;
import com.jiabangou.fnexpresssdk.model.Order;
import com.jiabangou.fnexpresssdk.model.OrderDetail;

/**
 * Created by wanglei   on 16-9-29.
 */
public interface OrderService {

    void createOrder(Order order) throws FnExpressErrorException;

    void createNextDayOrder(NextDayOrder order) throws FnExpressErrorException;

    OrderDetail getOrderDetail(String tpOrderId) throws FnExpressErrorException;

    void syncCancelOrder(String tpOrderId, String description) throws FnExpressErrorException;

}
