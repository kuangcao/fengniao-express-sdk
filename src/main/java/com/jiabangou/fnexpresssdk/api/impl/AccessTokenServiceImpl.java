package com.jiabangou.fnexpresssdk.api.impl;

import com.jiabangou.fnexpresssdk.api.AccessTokenService;
import com.jiabangou.fnexpresssdk.api.FnExpressConfigStorage;
import com.jiabangou.fnexpresssdk.api.LogListener;
import com.jiabangou.fnexpresssdk.exception.FnExpressErrorException;
import com.jiabangou.fnexpresssdk.model.AccessToken;
import com.jiabangou.fnexpresssdk.utils.FnExpressUtils;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanglei on 16-12-14.
 */
public class AccessTokenServiceImpl extends BaseServiceImpl implements AccessTokenService {

    private static final String GET_ACCESS_TOKEN = "/get_access_token";

    public AccessTokenServiceImpl(FnExpressConfigStorage configStorage, CloseableHttpClient httpClient, HttpHost httpProxy,
                                  LogListener listener, boolean isTest) {
        super(configStorage, httpClient, httpProxy, listener, isTest);
    }

    @Override
    public AccessToken getAccessToken() throws FnExpressErrorException {
        Map<String, String> params = new HashMap<>(3);
        params.put("app_id", configStorage.getAppId());
        params.put("salt", String.valueOf(FnExpressUtils.getSalt()));
        params.put("signature", FnExpressUtils.createAccessTokenSignature(configStorage.getAppId(), configStorage.getSecret(),
                Integer.valueOf(params.get("salt"))));
        return get(doGet(GET_ACCESS_TOKEN, params), DATA, AccessToken.class);
    }

}
