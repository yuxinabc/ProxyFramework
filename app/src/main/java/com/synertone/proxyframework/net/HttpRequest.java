package com.synertone.proxyframework.net;

import java.util.Map;

public interface HttpRequest {
    void get(String url, Map<String,String> params, CallBack callback);
    void post(String url, Map<String,String> params,CallBack callback);
}
