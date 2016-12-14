package api.impl;

import api.AccessTokenListener;
import api.FnExpressConfigStorage;
import api.LogListener;
import api.OrderService;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * Created by wanglei on 16-9-29.
 */
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

    private static final String ORDER_CANCEL = "/order/cancel";

    public OrderServiceImpl(FnExpressConfigStorage configStorage, CloseableHttpClient httpClient, HttpHost httpProxy,
                            LogListener listener, AccessTokenListener accessTokenListener, boolean isTest) {
        super(configStorage, httpClient, httpProxy, listener, accessTokenListener, isTest);
    }


}
