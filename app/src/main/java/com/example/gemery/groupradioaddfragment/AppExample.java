package com.example.gemery.groupradioaddfragment;

import android.app.Application;
import android.content.Context;

/**
 * Created by gemery on 2018/4/3.
 */

public class AppExample extends Application {
    private static AppExample mApp;
    @Override
    public void onCreate() {
        super.onCreate();

        mApp = this;

    }

    public static AppExample getInstance(){
        return  mApp;
    }
    public static Context getContext(){
        return mApp;
    }
}
