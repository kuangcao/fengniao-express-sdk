package com.jiabangou.fnexpresssdk.api;

public interface FnExpressConfigStorage {

    String getAppId();

    String getSecret();

    String getHttp_proxy_host();

    int getHttp_proxy_port();

    String getHttp_proxy_username();

    String getHttp_proxy_password();


}
