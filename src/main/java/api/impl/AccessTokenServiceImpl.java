package api.impl;

import api.AccessTokenListener;
import api.AccessTokenService;
import api.FnExpressConfigStorage;
import api.LogListener;
import model.AccessToken;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * Created by wanglei on 16-12-14.
 */
public class AccessTokenServiceImpl extends BaseServiceImpl implements AccessTokenService {

    public AccessTokenServiceImpl(FnExpressConfigStorage configStorage, CloseableHttpClient httpClient, HttpHost httpProxy,
                                  LogListener listener, AccessTokenListener accessTokenListener, boolean isTest) {
        super(configStorage, httpClient, httpProxy, listener, accessTokenListener, isTest);
    }

    @Override
    public AccessToken getAccessToken() {
        return new AccessToken();
    }

}
