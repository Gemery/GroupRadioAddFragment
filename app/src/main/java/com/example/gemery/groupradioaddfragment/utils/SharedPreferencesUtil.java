package com.example.gemery.groupradioaddfragment.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.gemery.groupradioaddfragment.AppExample;


/**
 * GYMATE
 * <p>
 * Created by gemery on 2018/4/8
 */
public class SharedPreferencesUtil {
    private static final String ISFIRSTRUN="is_first_run";
    public static void setIsfirstrun(String flag){
        Context context= AppExample.getContext();
        SharedPreferences sp=context.getSharedPreferences(ISFIRSTRUN,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(ISFIRSTRUN,flag);
        editor.commit();
    }
    public static String getIsfirstrun(){
        Context context= AppExample.getContext();
        SharedPreferences sp=context.getSharedPreferences(ISFIRSTRUN,Context.MODE_PRIVATE);
        return sp.getString(ISFIRSTRUN,"");
    }
}
