package com.jiabangou.fnexpresssdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.fnexpresssdk.api.AccessTokenListener;
import com.jiabangou.fnexpresssdk.api.FnExpressConfigStorage;
import com.jiabangou.fnexpresssdk.api.LogListener;
import com.jiabangou.fnexpresssdk.exception.FnExpressError;
import com.jiabangou.fnexpresssdk.exception.FnExpressErrorException;
import com.jiabangou.fnexpresssdk.utils.FnExpressUtils;
import com.jiabangou.fnexpresssdk.utils.HttpDeleteWithBody;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseServiceImpl {

    public static final String API_URL = "https://open-anubis.ele.me/anubis-webapi";
    public static final String TEST_API_URL = "https://exam-anubis.ele.me/anubis-webapi";
    public static final String UTF_8 = "UTF-8";
    public static final String DATA = "data";
    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_POST = "POST";
    public static final String HTTP_METHOD_DELETE = "DELETE";
    protected FnExpressConfigStorage configStorage;
    protected HttpHost httpProxy;
    protected CloseableHttpClient httpClient;
    protected LogListener logListener;
    protected AccessTokenListener accessTokenListener;
    protected boolean isTest;

    public BaseServiceImpl(FnExpressConfigStorage configStorage, CloseableHttpClient httpClient,
                           HttpHost httpProxy, LogListener logListener, boolean isTest) {
        this.configStorage = configStorage;
        this.httpClient = httpClient;
        this.httpProxy = httpProxy;
        this.logListener = logListener;
        this.isTest = isTest;
    }

    public BaseServiceImpl(FnExpressConfigStorage configStorage, CloseableHttpClient httpClient, HttpHost httpProxy,
                           LogListener logListener, AccessTokenListener accessTokenListener, boolean isTest) {
        this.configStorage = configStorage;
        this.httpClient = httpClient;
        this.httpProxy = httpProxy;
        this.logListener = logListener;
        this.accessTokenListener = accessTokenListener;
        this.isTest = isTest;
    }

    private void logging(String cmd, String method, boolean isSuccess, String request, String response) {
        if (this.logListener != null) {
            this.logListener.requestEvent(cmd, method, isSuccess, request, response);
        }
    }

    protected String getBaseApiUrl() {
        return isTest ? TEST_API_URL : API_URL;
    }

    protected JSONObject doGet(String url, Object params) throws FnExpressErrorException {
        try {
            return getResponseJsonObject(HTTP_METHOD_GET, url, params);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    protected JSONObject doPost(String url, Object params) throws FnExpressErrorException {
        try {
            return getResponseJsonObject(HTTP_METHOD_POST, url, params);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected JSONObject doDelete(String url, Object params) throws FnExpressErrorException {
        try {
            return getResponseJsonObject(HTTP_METHOD_DELETE, url, params);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JSONObject getResponseJsonObject(String httpMethod, String url, Object params) throws IOException, FnExpressErrorException {

        HttpUriRequest httpUriRequest = null;
        String fullUrl = getBaseApiUrl() + url;
        if (HTTP_METHOD_GET.equals(httpMethod)) {
            List<NameValuePair> nameValuePairs = getNameValuePairs(params);
            HttpGet httpGet = new HttpGet(fullUrl + "?" + URLEncodedUtils.format(nameValuePairs, UTF_8));
            setRequestConfig(httpGet);
            httpUriRequest = httpGet;
        } else if (HTTP_METHOD_POST.equals(httpMethod)) {
            HttpPost httpPost = new HttpPost(fullUrl);
            httpPost.setEntity(new StringEntity(JSON.toJSONString(FnExpressUtils.buildRequestBody(configStorage.getAppId(),
                    accessTokenListener.getAccessToken(), params))));
            setRequestConfig(httpPost);
            httpUriRequest = httpPost;
        } else if (HTTP_METHOD_DELETE.equals(httpMethod)) {
            HttpDeleteWithBody httpDelete = new HttpDeleteWithBody(fullUrl);
            httpDelete.setEntity(new StringEntity(JSON.toJSONString(FnExpressUtils.buildRequestBody(configStorage.getAppId(),
                    accessTokenListener.getAccessToken(), params))));
            setRequestConfig(httpDelete);
            httpUriRequest = httpDelete;
        }

        CloseableHttpResponse response = this.httpClient.execute(httpUriRequest);
        String resultContent = new BasicResponseHandler().handleResponse(response);
        JSONObject jsonObject = JSON.parseObject(resultContent);
        FnExpressError error = FnExpressError.fromJson(jsonObject);
        if (error != null) {
            logging(url, httpMethod, false, httpUriRequest.getURI() + "\nBody:" + JSON.toJSONString(params), resultContent);
            throw new FnExpressErrorException(error.getErrorCode(), error.getErrorMsg(), JSON.toJSONString(params), resultContent);
        }
        logging(url, httpMethod, true, httpUriRequest.getURI() + "\nBody:" + JSON.toJSONString(params), resultContent);
        return jsonObject;
    }

    private List<NameValuePair> getNameValuePairs(Object params) {

        Map<String, String> beanMap = params != null ? getParamsMap(params) : new HashMap<>();

        List<NameValuePair> nameValuePairs = new ArrayList<>();
        for (Map.Entry entry : beanMap.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
        }
        return nameValuePairs;
    }

    protected Map<String, String> getParamsMap(Object obj) {

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(obj);
        final Map<String, String> params = new HashMap<>();
        jsonObject.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .forEach(entry ->
                        params.put(entry.getKey(), TypeUtils.castToString(entry.getValue()))
                );

        return params;
    }

    private void setRequestConfig(HttpRequestBase httpRequestBase) {
        if (httpProxy != null) {
            httpRequestBase.setConfig(RequestConfig.custom().setProxy(httpProxy).build());
        }
    }

    protected <T> List<T> getList(JSONObject jsonObject, String key, Class<T> clazz) {
        JSONArray jsonArray = jsonObject.getJSONArray(key);
        List<T> list = new ArrayList<T>();
        for (Object obj : jsonArray) {
            list.add(TypeUtils.castToJavaBean(obj, clazz));
        }
        return list;
    }

    protected <T> T get(JSONObject jsonObject, String key, Class<T> clazz) {
        JSONObject obj = jsonObject.getJSONObject(key);
        return TypeUtils.castToJavaBean(obj, clazz);
    }

}
