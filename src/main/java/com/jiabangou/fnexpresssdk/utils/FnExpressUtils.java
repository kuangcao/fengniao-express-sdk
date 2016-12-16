package com.jiabangou.fnexpresssdk.utils;

import com.alibaba.fastjson.JSON;
import com.jiabangou.fnexpresssdk.model.RequestBody;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by freeway on 16/7/19.
 */
public class FnExpressUtils {

    public static RequestBody buildRequestBody(String appId, String accessToken, Object data){
        RequestBody requestBody = new RequestBody();
        requestBody.setApp_id(appId);
        requestBody.setData(urlEncode(JSON.toJSONString(data)));
        requestBody.setSalt(getSalt());
        requestBody.setSignature(createApiSignature(appId, accessToken, data, requestBody.getSalt()));
        return requestBody;
    }

    public static String createAccessTokenSignature(String appId, String secret_key, Integer salt){

        Map<String, String> params = new LinkedHashMap<>(3);
        params.put("app_id", appId);
        params.put("salt", String.valueOf(salt));
        params.put("secret_key", secret_key);
        List<String> paramsList = getParams(params);
        return DigestUtils.md5Hex(urlEncode(StringUtils.join(paramsList, "&")));
    }

    public static String createApiSignature(String appId, String accessToken, Object data, Integer salt){

        Map<String, String> params = new LinkedHashMap<>(3);
        params.put("app_id", appId);
        params.put("access_token", accessToken);
        params.put("data", urlEncode(JSON.toJSONString(data)));
        params.put("salt", String.valueOf(salt));
        List<String> paramsList = getParams(params);
        return DigestUtils.md5Hex(StringUtils.join(paramsList, "&"));
    }

    public static Integer getSalt(){
        return new Random().nextInt(9999-1000+1)+1000;//为变量赋随机值1000-9999
    }

    public static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getParams(Map<String, String> signParams) {
        List<String> params = new ArrayList<>();
        for(Map.Entry entry: signParams.entrySet()){
            String param = entry.getKey() + "=" + entry.getValue();
            params.add(param);
        }
        return params;
    }

    public static RequestBody parseRequestBody(String jsonString, String appId, String accessToken) {

        RequestBody requestBody = JSON.parseObject(jsonString, RequestBody.class);

        if (requestBody == null) {
            throw new RuntimeException("requestBody is null");
        }
        if (requestBody.getApp_id() == null || requestBody.getApp_id().equals("")) {
            throw new RuntimeException("app_id is required");
        }
        if (!appId.equals(requestBody.getApp_id())) {
            throw new RuntimeException("app_id is incorrect");
        }
        if (requestBody.getSalt() == null) {
            throw new RuntimeException("salt is required");
        }
        if (requestBody.getSignature() == null || requestBody.getSignature().equals("")) {
            throw new RuntimeException("app_id is required");
        }

        if (!checkSignature(requestBody, accessToken)) {
            throw new RuntimeException("sig is incorrect");
        }

        return requestBody;
    }

    public static boolean checkSignature(RequestBody requestBody, String accessToken) {
        return createApiSignature(requestBody.getApp_id(), accessToken, requestBody.getData(), requestBody.getSalt()).equals(requestBody.getSignature());
    }



}
