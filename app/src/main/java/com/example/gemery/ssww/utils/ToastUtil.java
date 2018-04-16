package com.example.gemery.ssww.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by gemery on 2018/4/8.
 */

public class ToastUtil {
    public static void showToast(Context context, String msg ){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();

    }
}
