package com.synertone.proxyframework;


import android.os.Bundle;
import android.widget.TextView;

import com.synertone.proxyframework.model.WeatherInfo;
import com.synertone.proxyframework.net.ModelCallback;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {
private TextView tv_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_content=findViewById(R.id.tv_content);
        //json
        Map<String,String> params = new HashMap<>();
        params.put("city","长沙");
        params.put("key","13cb58f5884f9749287abbead9c658f2");
        String url="http://restapi.amap.com/v3/weather/weatherInfo";
       /* httpRequestProxy.get(url, params, new CallBack() {
            @Override
            public void onSuccess(String result) {
                tv_content.setText(result);
            }

            @Override
            public void onFailure(int code, Throwable t) {

            }
        });*/
       /* httpRequestProxy.get(url, params, new ModelCallback<WeatherInfo>() {
            @Override
            public void onSuccess(WeatherInfo weatherInfo) {
                tv_content.setText(weatherInfo.toString());
            }
        });*/
        httpRequestProxy.post(url, params, new ModelCallback<WeatherInfo>() {
            @Override
            public void onSuccess(WeatherInfo weatherInfo) {
                tv_content.setText(weatherInfo.toString());
            }
        });
    }
}
