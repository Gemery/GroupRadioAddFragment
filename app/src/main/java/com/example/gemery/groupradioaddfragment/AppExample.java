package com.example.gemery.groupradioaddfragment;

import android.app.Application;
import android.content.Context;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;

/**
 * Created by gemery on 2018/4/3.
 */

public class AppExample extends Application {
    private static AppExample mApp;
    @Override
    public void onCreate() {
        super.onCreate();

        mApp = this;

        Iconify.with(new FontAwesomeModule())
                .with(new IoniconsModule());

    }

    public static AppExample getInstance(){
        return  mApp;
    }
    public static Context getContext(){
        return mApp;
    }
}
