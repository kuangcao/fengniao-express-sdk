package com.jiabangou.fnexpress.api;

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
        configStorage.setAppId("0471b12c-c761-4610-9142-9a36ee9e860d");
        configStorage.setSecret("8e7398ae-6025-4cf9-bd3c-5a03942cecc6");
        expressClient = new FnExpressClientImpl();
        expressClient.setConfigStorage(configStorage);
        expressClient.setIsTest(true);
        expressClient.setPushConsumer(new PushConsumer() {
            @Override
            public void deliveryStatus(PushBody pushBody) {
                System.out.println("下行更新状态接口");
            }
        });
        expressClient.setLogListener((cmd, method, isSuccess, request, response) -> {
            System.out.println("cmd:"+cmd);
            System.out.println("method:"+method);
            System.out.println("isSuccess:"+isSuccess);
            System.out.println("request:"+ request);
            System.out.println("response:"+ response);
        });
        expressClient.setAccessTokenListener(new AccessTokenListener() {
            @Override
            public String getAccessToken() {
               return "a94f0788-d058-4722-9487-ec1266bf639f";
            }
        });
    }

}
