package com.jiabangou.fnexpresssdk.api;

import com.jiabangou.fnexpresssdk.exception.FnExpressErrorException;
import com.jiabangou.fnexpresssdk.model.AccessToken;

/**
 * Created by wanglei on 16-12-14.
 */
public interface AccessTokenService {

    AccessToken getAccessToken() throws FnExpressErrorException;

}
