package com.synertone.proxyframework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.synertone.proxyframework.net.HttpRequestProxy;
import com.synertone.proxyframework.net.okhttp.OkHttpRequest;

public class BaseActivity extends AppCompatActivity{
   protected HttpRequestProxy httpRequestProxy;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HttpRequestProxy.init(new OkHttpRequest());
        httpRequestProxy= HttpRequestProxy.getInstance();
    }
}
