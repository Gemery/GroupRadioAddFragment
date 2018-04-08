package com.example.gemery.groupradioaddfragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gemery.groupradioaddfragment.LoginActivity;
import com.example.gemery.groupradioaddfragment.R;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gemery on 2018/4/3.
 */

public class MessageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_message,container,false);
        Banner banner = view.findViewById(R.id.banner);
        initBanner(banner);
        return view;
    }

    private void initBanner(Banner banner) {
        String[] urls = getResources().getStringArray(R.array.url);
        List list  = Arrays.asList(urls);
        List<String> titles = Arrays.asList(new String[]{"","","","","qu"});
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Picasso.with(getContext()).load((String)path).into(imageView);
            }
        });

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);//设置圆形指示器与标题
        banner.setIndicatorGravity(BannerConfig.RIGHT);//设置指示器位置
        banner.setDelayTime(2000);  //设置轮播时间
        banner.setImages(list);  //设置图片源
        banner.setBannerTitles(titles);  //设置标题源

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getContext(),"您点击了"+ position,Toast.LENGTH_LONG).show();;
            }
        });
        banner.start();

    }
}
