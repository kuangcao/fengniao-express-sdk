package api.impl;

import api.AccessTokenService;
import api.FnExpressConfigStorage;
import api.LogListener;
import exception.FnExpressErrorException;
import model.AccessToken;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import utils.FnExpressUtils;

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
        return get(doPost(GET_ACCESS_TOKEN, params), DATA, AccessToken.class);
    }

}
