package com.example.gemery.ssww.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.activities.AllOrderListActivity;
import com.example.gemery.ssww.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gemery on 2018/4/3.
 */

public class MineFragment extends Fragment {


    @BindView(R.id.ll_order_all)
    RelativeLayout llOrderAll;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mine, container, false);


        ButterKnife.bind(this, view);
        return view;
    }

    public void loadData() {
        OkGo.<String>get("https://www.baidu.com")
                .tag(getContext())
                .cacheKey("cacheKey")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
                .cacheMode(CacheMode.DEFAULT)
                .execute(new StringCallback() {
                             @Override
                             public void onSuccess(Response<String> response) {
                                 Log.i("tage", response.body());
                             }

                             @Override
                             public void onError(Response<String> response) {
                                 ToastUtil.showToast(getContext(), "网络出错了！！！！！");
                             }
                         }
                );
    }

    @OnClick({R.id.ll_order_all})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.ll_order_all:
                Intent intent = new Intent(getActivity(), AllOrderListActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //ButterKnife.unbind();
    }
}
