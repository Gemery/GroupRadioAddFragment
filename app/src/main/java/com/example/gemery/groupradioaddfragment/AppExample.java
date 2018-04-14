package com.example.gemery.groupradioaddfragment;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;

import com.example.gemery.groupradioaddfragment.app.Latte;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

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

        Latte.init(mApp).configure();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader loader = ImageLoader.getInstance();
        loader.init(config);

    }

    public static AppExample getInstance() {
        return mApp;
    }

    public static Context getContext() {
        return mApp;
    }
    /**
     * 初始化ImageLoaderConfiguration
     */
}