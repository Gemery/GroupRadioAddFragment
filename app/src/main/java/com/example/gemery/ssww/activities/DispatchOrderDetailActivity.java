package com.example.gemery.ssww.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.adapter.MyDispatchDtailAdapter;
import com.example.gemery.ssww.bean.DispatchEntry;
import com.example.gemery.ssww.utils.GsonUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DispatchOrderDetailActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.order_detail_rc)
    RecyclerView orderDetailRc;
    private String dispatch_order_detail_url = "http://192.168.1.251:8091/api/AfterSale/getSdtList?orderNum=";
    private MyDispatchDtailAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch_order_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String orderNum = intent.getStringExtra("orderNum");

        initData(orderNum);
    }

    private DispatchEntry.SdtHListBean hObj = new DispatchEntry.SdtHListBean();
    private List<DispatchEntry.SdtEListBean> listData = new ArrayList<>();

    private View viewHeader;

    private void initData(String orderNum) {
        OkGo.<String>get(dispatch_order_detail_url + orderNum)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e("tag", response.body());
                        DispatchEntry obj = GsonUtils.parseJSON(response.body(), DispatchEntry.class);
                        hObj = obj.getSdt_hList().get(0);
                        listData = obj.getSdt_eList();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initView();
                            }
                        });
                    }
                });
    }

    private void initView() {
        orderDetailRc.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyDispatchDtailAdapter(listData,this);
        initRcyclerHeaderView();
        orderDetailRc.setAdapter(mAdapter);
        mAdapter.addHeaderView(viewHeader);

    }

    private void initRcyclerHeaderView() {
        viewHeader = LayoutInflater.from(this).inflate(R.layout.item_dispatch_edtail_dantou,null);

    }

    @OnClick({R.id.title_bar_back})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
        }
    }
}
