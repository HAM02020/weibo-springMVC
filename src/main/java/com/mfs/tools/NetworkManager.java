package com.mfs.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mfs.dao.AccessTokenDao;
import com.mfs.entity.AccessToken;
import com.mfs.enums.WBHttpMethod;
import com.mfs.http.WBCommon;
import okhttp3.*;


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NetworkManager extends OkHttpClient {



    private Request request;
    private HttpUrl url;
    private AccessToken access_token;
    private AccessTokenDao accessTokenDao;


    private static NetworkManager instance = new NetworkManager();
    public static NetworkManager Shared()
    {
        return instance;
    }

    public NetworkManager(){
         this.accessTokenDao= (AccessTokenDao) ApplicationContextHelper.getBean("accessTokenDao");
         if(accessTokenDao.queryAll(0,2).size()>0)
             this.access_token = accessTokenDao.queryAll(0,1).get(0);
    }

    public Response request(WBHttpMethod method, String urlStr, Map<String,String> params) throws IOException {
        Request.Builder requestBuilder = new Request.Builder();

        if(method.equals(WBHttpMethod.GET)){
            HttpUrl.Builder urlBuilder = HttpUrl.parse(urlStr).newBuilder();

            if(params!=null){
                for(Map.Entry<String,String> param : params.entrySet()){
                    urlBuilder.addQueryParameter(param.getKey(),param.getValue());
                }
            }

            url = urlBuilder.build();

            requestBuilder.url(url)
                    .get();
        }
        else if(method.equals(WBHttpMethod.POST)){
            //构建表单制造者
            FormBody.Builder formBuilder = new FormBody.Builder();
            //向表单制造者赋值
            for(Map.Entry<String,String> param : params.entrySet()){
                formBuilder.add(param.getKey(),param.getValue());
            }
            //从表单制造者生成body
            RequestBody requestBody = formBuilder.build();
            //request 制造者赋值
            requestBuilder.post(requestBody)
                    .url(urlStr);
        }
        request = requestBuilder.build();
        return newCall(request).execute();

    }
    public Response getAccessToken(String code) throws IOException {
        String urlStr = "https://api.weibo.com/oauth2/access_token";

        Map<String,String> params = new ConcurrentHashMap<>();
        params.put("client_id", WBCommon.WBAppKey);
        params.put("client_secret",WBCommon.WBAPPSecret);
        params.put("grant_type","authorization_code");
        params.put("code",code);
        params.put("redirect_uri",WBCommon.WBRedirectURI);

        return request(WBHttpMethod.POST, urlStr, params);
    }

    public Response tokenRequest(String url,Map<String,String> params) throws IOException {
        params.put("access_token",access_token.getAccess_token());
        return request(WBHttpMethod.GET,url,params);
    }

    public JSONArray getStatusList(long sinceId,long maxId) throws IOException {
        Map<String,String> params = new ConcurrentHashMap<>();
        params.put("since_id",String.valueOf(sinceId));
        params.put("max_id",String.valueOf(maxId));

        String responseStr = tokenRequest("https://api.weibo.com/2/statuses/home_timeline.json",params).body().string();
        JSONArray statuses = JSON.parseObject(responseStr).getJSONArray("statuses");
        return statuses;
    }

    public String getUserInfo(long uid) throws IOException {
        Map<String,String> params = new ConcurrentHashMap<>();
        params.put("uid",String.valueOf(uid));
        String responseStr = tokenRequest("https://api.weibo.com/2/users/show.json",params).body().string();
        return responseStr;
    }

    public JSONObject getReminds(long uid) throws IOException {
        Map<String,String> params = new ConcurrentHashMap<>();
        params.put("uid",String.valueOf(uid));
        String responseStr = tokenRequest("https://api.weibo.com/2/users/show.json",params).body().string();
        return JSON.parseObject(responseStr);
    }

    public AccessToken getAccess_token() {
        return access_token;
    }

    public void setAccess_token(AccessToken access_token) {
        this.access_token = access_token;
    }
}