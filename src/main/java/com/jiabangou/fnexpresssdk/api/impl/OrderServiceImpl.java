package com.jiabangou.fnexpresssdk.api.impl;

import com.jiabangou.fnexpresssdk.api.AccessTokenListener;
import com.jiabangou.fnexpresssdk.api.FnExpressConfigStorage;
import com.jiabangou.fnexpresssdk.api.LogListener;
import com.jiabangou.fnexpresssdk.api.OrderService;
import com.jiabangou.fnexpresssdk.exception.FnExpressErrorException;
import com.jiabangou.fnexpresssdk.model.NextDayOrder;
import com.jiabangou.fnexpresssdk.model.Order;
import com.jiabangou.fnexpresssdk.model.OrderDetail;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanglei on 16-9-29.
 */
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

    private static final String ORDER_CREATE = "/v2/order";
    private static final String ORDER_GET = "/v2/order/query";
    private static final String ORDER_CANCEL = "/v2/order/cancel";

    public OrderServiceImpl(FnExpressConfigStorage configStorage, CloseableHttpClient httpClient, HttpHost httpProxy,
                            LogListener listener, AccessTokenListener accessTokenListener, boolean isTest) {
        super(configStorage, httpClient, httpProxy, listener, accessTokenListener, isTest);
    }

    @Override
    public void createOrder(Order order) throws FnExpressErrorException {
        doPost(ORDER_CREATE, order);
    }

    @Override
    public void createNextDayOrder(NextDayOrder order) throws FnExpressErrorException {
        doPost(ORDER_CREATE, order);
    }

    @Override
    public OrderDetail getOrderDetail(String tpOrderId) throws FnExpressErrorException {
        Map<String, String> params = new HashMap<>(1);
        params.put("partner_order_code", tpOrderId);
        return get(doPost(ORDER_GET, params), DATA, OrderDetail.class);
    }

    @Override
    public void syncCancelOrder(String tpOrderId, int cancelCode, String description) throws FnExpressErrorException {
        Map<String, String> params = new HashMap<>(4);
        params.put("partner_order_code", tpOrderId);
        params.put("order_cancel_reason_code", String.valueOf(cancelCode));
        params.put("order_cancel_description", description);
        params.put("order_cancel_time", String.valueOf(System.currentTimeMillis()));
        doPost(ORDER_CANCEL, params);
    }
}
