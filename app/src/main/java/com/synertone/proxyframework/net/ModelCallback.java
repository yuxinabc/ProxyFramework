package com.synertone.proxyframework.net;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class ModelCallback<T> implements CallBack{
    @Override
    public void onSuccess(String result) {
        Gson gson=new Gson();
        Type genericSuperclass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType= (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        T t = gson.fromJson(result, actualTypeArguments[0]);
        onSuccess(t);
    }

    @Override
    public void onFailure(int code, Throwable t) {

    }
   public abstract void  onSuccess(T t);
}
