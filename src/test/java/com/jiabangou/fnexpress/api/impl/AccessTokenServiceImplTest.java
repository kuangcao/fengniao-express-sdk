package com.jiabangou.fnexpress.api.impl;

import com.jiabangou.fnexpress.api.ServiceTest;
import com.jiabangou.fnexpresssdk.api.AccessTokenService;
import com.jiabangou.fnexpresssdk.exception.FnExpressErrorException;
import com.jiabangou.fnexpresssdk.model.AccessToken;
import org.junit.Test;

/**
 * Created by wanglei on 16-12-14.
 */
public class AccessTokenServiceImplTest extends ServiceTest {

    @Test
    public void getAccessToken() throws FnExpressErrorException {
        AccessTokenService accessTokenService = expressClient.getAccessTokenService();
        AccessToken accessToken = accessTokenService.getAccessToken();
        System.out.println(accessToken);
    }
}
