package com.jiabangou.fnexpress.api.impl;

import com.jiabangou.fnexpresssdk.api.AccessTokenService;
import com.jiabangou.fnexpresssdk.api.FnExpressClient;
import com.jiabangou.fnexpresssdk.api.PushConsumer;
import com.jiabangou.fnexpresssdk.api.impl.FnExpressClientImpl;
import com.jiabangou.fnexpresssdk.api.impl.FnExpressInMemoryConfigStorage;
import com.jiabangou.fnexpresssdk.exception.FnExpressErrorException;
import com.jiabangou.fnexpresssdk.model.AccessToken;
import com.jiabangou.fnexpresssdk.model.PushBody;
import org.junit.Test;

/**
 * Created by wanglei on 16-12-14.
 */
public class AccessTokenServiceImplTest {

    private static final FnExpressClient expressClient = new FnExpressClientImpl();

    private FnExpressClient getClient() {
        FnExpressInMemoryConfigStorage configStorage = new FnExpressInMemoryConfigStorage();
        configStorage.setAppId("0471b12c-c761-4610-9142-9a36ee9e860d");
        configStorage.setSecret("8e7398ae-6025-4cf9-bd3c-5a03942cecc6");
        expressClient.setConfigStorage(configStorage);
        expressClient.setIsTest(false);
        expressClient.setPushConsumer(new PushConsumer() {
            @Override
            public void deliveryStatus(PushBody pushBody) {

            }
        });
        expressClient.setLogListener((cmd, method, isSuccess, request, response) -> {
            System.out.println("cmd:" + cmd);
            System.out.println("method:" + method);
            System.out.println("isSuccess:" + isSuccess);
            System.out.println("request:" + request);
            System.out.println("response:" + response);
        });
        return expressClient;
    }

    @Test
    public void getAccessToken() throws FnExpressErrorException {
        AccessTokenService accessTokenService = getClient().getAccessTokenService();
        AccessToken accessToken = accessTokenService.getAccessToken();
        System.out.println(accessToken);
    }
}
