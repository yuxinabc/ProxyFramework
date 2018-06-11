package com.synertone.proxyframework.net;

import java.util.Map;

public class HttpRequestProxy implements HttpRequest{
    private HttpRequest httpRequest;
    private static HttpRequestProxy httpRequestProxy;
    private HttpRequestProxy(){

    }

    private HttpRequestProxy(HttpRequest httpRequest) {
        this.httpRequest=httpRequest;
    }

    public static void init(HttpRequest httpRequest){
        if(httpRequestProxy==null){
            synchronized (HttpRequestProxy.class){
                if(httpRequestProxy==null){
                    httpRequestProxy=new HttpRequestProxy(httpRequest);
                }
            }
        }
    }

    public static HttpRequestProxy getInstance() {
        return httpRequestProxy;
    }

    @Override
    public void get(String url, Map<String, String> hashMap, CallBack callback) {
        httpRequest.get(url,hashMap,callback);
    }

    @Override
    public void post(String url, Map<String, String> hashMap, CallBack callback) {
        httpRequest.post(url,hashMap,callback);
    }
}
