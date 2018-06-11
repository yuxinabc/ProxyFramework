package com.synertone.proxyframework.net.okhttp;

import com.synertone.proxyframework.net.CallBack;
import com.synertone.proxyframework.net.HttpRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpRequest implements HttpRequest{
    private OkHttpClient okHttpClient;

    public OkHttpRequest() {
        this.okHttpClient = new OkHttpClient();
    }

    @Override
    public void get(String url, Map<String, String> params, final CallBack callback) {
        Set<Map.Entry<String, String>> entries = params.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        StringBuilder sb=new StringBuilder("?");
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        url += sb.toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(1,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.body().string());
            }
        });
    }

    @Override
    public void post(String url, Map<String, String> params, final CallBack callback) {
        Set<Map.Entry<String, String>> entries = params.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        FormBody.Builder builder = new FormBody.Builder();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            builder.add(entry.getKey(),entry.getValue());
        }
        RequestBody requestBodyPost =builder.build();
        Request requestPost = new Request.Builder()
                .url(url)
                .post(requestBodyPost)
                .build();
        okHttpClient.newCall(requestPost).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(1,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.body().string());
            }
        });
    }
}
