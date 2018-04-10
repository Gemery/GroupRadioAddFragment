package com.example.gemery.groupradioaddfragment.utils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;

/**
 * Created by gemery on 2018/4/9.
 */

public class HttpUtils {
    private static HttpUtils mHttpUtils;

    private  HttpUtils(){

    }

    //单列
    public static HttpUtils Buider(){
        synchronized (HttpUtils.class){
            if(mHttpUtils == null){
                mHttpUtils = new HttpUtils();
            }

        }
        return mHttpUtils;
    }
    //请求
    private void execute(HttpParams params, StringCallback callback,String url){
        OkGo.<String>post(url).params(params).execute(callback);
    }
    //登录
    public void login(String username,String password,StringCallback callback) {
        HttpParams params = new HttpParams();
        params.put("mobile", username);
        params.put("password", password);
        execute(params, callback, "dacheng/login.php");//API
    }
    //注册
    public void register(String username,String email,String phone,String password,
                         String rePassword,StringCallback callback) {
        HttpParams params = new HttpParams();
        params.put("name", username);
        params.put("email", email);
        params.put("phone", phone);
        params.put("password", password);
        params.put("rePassword", rePassword);

        execute(params, callback,"dacheng/reg.php");//API
    }
}
