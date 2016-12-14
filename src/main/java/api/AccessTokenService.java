package api;

import exception.FnExpressErrorException;
import model.AccessToken;

/**
 * Created by wanglei on 16-12-14.
 */
public interface AccessTokenService {

    AccessToken getAccessToken() throws FnExpressErrorException;

}
