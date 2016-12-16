package com.jiabangou.fnexpress.api;

import com.alibaba.fastjson.JSON;
import com.jiabangou.fnexpresssdk.api.AccessTokenListener;
import com.jiabangou.fnexpresssdk.api.FnExpressClient;
import com.jiabangou.fnexpresssdk.api.PushConsumer;
import com.jiabangou.fnexpresssdk.api.impl.FnExpressClientImpl;
import com.jiabangou.fnexpresssdk.api.impl.FnExpressInMemoryConfigStorage;
import com.jiabangou.fnexpresssdk.model.PushBody;
import org.junit.BeforeClass;

/**
 * Created by wanglei on 16-12-16.
 */
public class ServiceTest {

    protected static FnExpressClient expressClient;

    @BeforeClass
    public static void BeforeClass() {
        FnExpressInMemoryConfigStorage configStorage = new FnExpressInMemoryConfigStorage();
        configStorage.setAppId("406");
        configStorage.setSecret("a2f9073a17c35331d9269fd8bbbcbcae");
        expressClient = new FnExpressClientImpl();
        expressClient.setConfigStorage(configStorage);
        expressClient.setIsTest(false);
        expressClient.setPushConsumer(new PushConsumer() {
            @Override
            public void deliveryStatus(PushBody pushBody) {

            }
        });
        expressClient.setLogListener((cmd, method, isSuccess, request, response) -> {
            System.out.println("cmd:"+cmd);
            System.out.println("method:"+method);
            System.out.println("isSuccess:"+isSuccess);
            System.out.println("request:"+ JSON.toJSONString(request));
            System.out.println("response:"+JSON.toJSONString(response));
        });
        expressClient.setAccessTokenListener(new AccessTokenListener() {
            @Override
            public String getAccessToken() {
                try {
                    return expressClient.getAccessTokenService().getAccessToken().getAccess_token();
                } catch (Exception e){
                    e.printStackTrace();
                    return "";
                }
            }
        });
    }

}
