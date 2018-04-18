package com.example.gemery.ssww.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.CreationList;
import com.example.gemery.ssww.bean.CreationsString;
import com.example.gemery.ssww.bean.User;
import com.example.gemery.ssww.utils.DensityUtil;
import com.example.gemery.ssww.utils.SpaceItemDecoration;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gemery on 2018/4/3.
 */

public class MessageFragment extends Fragment {
    @BindView(R.id.m_recyclerview)
    RecyclerView mRecyclerView;
  private List<User> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_message,container,false);
        ButterKnife.bind(this,view);
        Banner banner = view.findViewById(R.id.banner);
        initBanner(banner);
        initData();//……………………………………………>
        initRecyclerview();
        return view;
    }

    private void initData() {
        OkGo.<String>post("http://rapapi.org/mockjs/11156/api/creations")
                .params("accessToken","123456")
                .execute(new StringCallback() {
            @Override
                public void onSuccess(Response<String> response) {
                Log.e("tage",response.body());
                String json = response.body();
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    //Log.e("tage",jsonObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
               // CreationList data = gson.fromJson(json,CreationList.class);
        CreationList data = gson.fromJson(CreationsString.creationsList,CreationList.class);
                Log.e("tage",data.toString());
                list = data.getData();
            }
        });

    }

    private void initRecyclerview() {
        //添加Android自带的分割线
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtil.dip2px(getActivity(),10)));
        mRecyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                        LayoutInflater.from(getActivity()).inflate(R.layout.recycler_item,parent,false
                )){};


                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                Log.e("tage",list.get(position).getUserInfo().getAvatar());

                ((TextView) holder.itemView.findViewById(R.id.m_avatar_name)).setText(list.get(position).getUserInfo().getNickName());
                ImageView imageview =  (ImageView) holder.itemView.findViewById(R.id.m_avatar);
                imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
                com.nostra13.universalimageloader.core.ImageLoader.getInstance()
                        .displayImage(list.get(position).getUserInfo().getAvatar(),imageview);


            }
            // 钉钉 打卡

            @Override
            public int getItemCount() {
                return list.size();
            }
        });

    }
// 即时通信
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

        // bannner 使用  是加载 网络图片还是  file:///  本地图片的资源
        // useriverl-loader-ImageLoader  d 使用    全局配字imageloader 在application 配置需要的参数
        // ImageLoader.getInstance 获得单列  套用  displayImage（url , imageview)   小赤佬


    }
}
