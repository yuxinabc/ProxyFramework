package com.synertone.proxyframework.net;

public interface CallBack {
    void onSuccess(String result);
    void onFailure(int code,Throwable t);
}
