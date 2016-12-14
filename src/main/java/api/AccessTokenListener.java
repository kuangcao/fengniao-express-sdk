package api;

/**
 * Created by wanglei on 16-12-14.
 */
public interface AccessTokenListener {

    void save();

    Boolean isExpire();

    String getAccessToken();

}
