package com.example.gemery.ssww.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gemery.ssww.activities.LinkedActivity;
import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.activities.OrderEditActivity;
import com.example.gemery.ssww.activities.ProductListActivity;
import com.example.gemery.ssww.adapter.OrderMessageAdapter;
import com.example.gemery.ssww.bean.OeaBen;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gemery on 2018/4/3.
 */

public class ContactFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener,
        AdapterView.OnItemClickListener {
    List<String> mList = new ArrayList<>();
    private String get_all_order_info = "http://192.168.1.251:8091/api/Order/getStandardList?orderNum=stringSA180600013";


    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.listView)
    ListView listView;
    //private ArrayAdapter<String> adapter;

    private OrderMessageAdapter ladapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shopping,container,false);
        ButterKnife.bind(this,view);

        initData();

        swipeRefreshLayout.setColorSchemeColors(
                getResources().getColor(android.R.color.holo_blue_light),
                getResources().getColor(android.R.color.holo_red_light),
                getResources().getColor(android.R.color.holo_orange_light),
                getResources().getColor(android.R.color.holo_green_light));

        swipeRefreshLayout.setOnRefreshListener(this);

        initAdapter();
//        adapter = new ArrayAdapter<String>(getContext(),
//                android.R.layout.simple_list_item_1,
//                mList);
        listView.setAdapter(ladapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    private void initAdapter() {
        ladapter = new OrderMessageAdapter(getActivity(),mList,R.layout.item_order_info);

    }

    private void initData() {

        OkGo.<String>get(get_all_order_info)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e("tag",response.body());
                        String json = response.body();
                        OeaBen obj = GsonUtils.parseJSON(json,OeaBen.class);
                        Log.e("tag",obj.toString());
                    }
                });
        for(int i=0;i<20;i++){
            mList.add("this is a item" + i);
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            switch (msg.what) {
//                case REFRESH_COMPLETE:
//
//                    //3.通知recycleView改变了数据
//                    myAdapter.notifyDataSetChanged();
//                    //4.记得关闭刷新，否则刷新球一直在转
//                    swipeRefreshLayout.setRefreshing(false);
//                    break;
//            }
        }
    };
    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mList.add(0,"加载了一条新数据");
                mList.add(0,"加载了一条新数据");
                ladapter.notifyDataSetChanged();
                ToastUtil.showToast(getContext(),"刷新了一条数据");
                // 加载完数据    将下拉进度条收起来
                swipeRefreshLayout.setRefreshing(false);
            }
        },2000);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getContext(),OrderEditActivity.class);
        intent.putExtra("action","to_orderedit_activity");
        startActivity(intent);

    }
}
