package com.jiabangou.fnexpresssdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.fnexpresssdk.api.*;
import com.jiabangou.fnexpresssdk.model.PushBody;
import com.jiabangou.fnexpresssdk.model.RequestBody;
import com.jiabangou.fnexpresssdk.model.ResultMessage;
import com.jiabangou.fnexpresssdk.utils.FnExpressUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by wanglei on 16-9-30.
 */
public class FnExpressClientImpl implements FnExpressClient {

    private FnExpressConfigStorage configStorage;
    private LogListener logListener;
    private AccessTokenListener accessTokenListener;
    private PushConsumer pushConsumer;

    private CloseableHttpClient httpClient;
    private HttpHost httpProxy;

    private OrderService orderService;
    private AccessTokenService accessTokenService;

    private Boolean isTest = false;

    public FnExpressClientImpl() {
    }

    public FnExpressClientImpl(FnExpressConfigStorage configStorage) {
        this.configStorage = configStorage;
    }

    @Override
    public void setConfigStorage(FnExpressConfigStorage configStorage) {

        this.configStorage = configStorage;

        String http_proxy_host = configStorage.getHttp_proxy_host();
        int http_proxy_port = configStorage.getHttp_proxy_port();
        String http_proxy_username = configStorage.getHttp_proxy_username();
        String http_proxy_password = configStorage.getHttp_proxy_password();

        final HttpClientBuilder builder = HttpClients.custom();
        if (StringUtils.isNotBlank(http_proxy_host)) {
            // 使用代理服务器
            if (StringUtils.isNotBlank(http_proxy_username)) {
                // 需要用户认证的代理服务器
                CredentialsProvider credsProvider = new BasicCredentialsProvider();
                credsProvider.setCredentials(
                        new AuthScope(http_proxy_host, http_proxy_port),
                        new UsernamePasswordCredentials(http_proxy_username, http_proxy_password));
                builder
                        .setDefaultCredentialsProvider(credsProvider);
            }
            httpProxy = new HttpHost(http_proxy_host, http_proxy_port);
        }
        httpClient = builder.build();
    }

    @Override
    public void setLogListener(LogListener logListener) {
        this.logListener = logListener;
    }

    @Override
    public void setAccessTokenListener(AccessTokenListener accessTokenListener) {
        this.accessTokenListener = accessTokenListener;
    }

    @Override
    public void setPushConsumer(PushConsumer pushConsumer) {
        this.pushConsumer = pushConsumer;
    }

    @Override
    public void setIsTest(Boolean isTest) {
        this.isTest = isTest;
    }

    @Override
    public ResultMessage pushHandle(String jsonString) {

        try {

            if (this.pushConsumer == null) {
                throw new RuntimeException("pushConsumer does not implement");
            }

            RequestBody requestBody = FnExpressUtils.parseRequestBody(jsonString, configStorage.getAppId(), accessTokenListener.getAccessToken());

            PushBody pushBody = TypeUtils.castToJavaBean(requestBody.getData(), PushBody.class);

            this.pushConsumer.deliveryStatus(pushBody);

            logging("/push_order_status", "POST", true, jsonString, JSONObject.toJSONString(ResultMessage.buildOk()));
            return ResultMessage.buildOk();

        } catch (Exception e) {
            logging("/push_order_status", "POST", false, jsonString, e.getMessage());
            return ResultMessage.buildError(e.getMessage());
        }
    }

    private void logging(String cmd, String method, boolean isSuccess, String request, String response) {
        if (logListener != null) {
            logListener.requestEvent(cmd, method, isSuccess, request, response);
        }
    }

    @Override
    public AccessTokenService getAccessTokenService() {

        if (accessTokenService == null) {
            accessTokenService = new AccessTokenServiceImpl(configStorage, httpClient, httpProxy, logListener, isTest);
        }
        return accessTokenService;
    }

    @Override
    public OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderServiceImpl(configStorage, httpClient, httpProxy, logListener, accessTokenListener, isTest);
        }
        return orderService;
    }

}
