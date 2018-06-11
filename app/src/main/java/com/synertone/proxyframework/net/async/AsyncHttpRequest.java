package com.synertone.proxyframework.net.async;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.synertone.proxyframework.net.CallBack;
import com.synertone.proxyframework.net.HttpRequest;

import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class AsyncHttpRequest implements HttpRequest{
    private AsyncHttpClient asyncHttpClient;

    public AsyncHttpRequest() {
        asyncHttpClient=new AsyncHttpClient();
    }

    @Override
    public void get(String url, Map<String, String> params, final CallBack callback) {
        //拼接 get请求 url
        StringBuffer sb=new StringBuffer("?");
        if (null != params) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        url += sb.toString();
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                callback.onSuccess(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                callback.onFailure(statusCode,error);
            }
        });
    }

    @Override
    public void post(String url, Map<String, String> hashMap, final CallBack callback) {

    }
}
