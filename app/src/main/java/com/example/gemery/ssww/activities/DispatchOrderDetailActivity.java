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
import com.example.gemery.ssww.utils.Const;
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
    private String dispatch_order_detail_url = Const.W_HOST+"/api/AfterSale/getSdtList?orderNum=";
    private MyDispatchDtailAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch_order_detail);
        ButterKnife.bind(this);
        titleBarTitle.setText("配送单详情");
        titleOptionsTv.setText("");
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
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h01))
                .setText(hObj.getS_sdt_h01());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h02))
                .setText(hObj.getS_sdt_h02());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h03))
                .setText(hObj.getS_sdt_h03());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h04))
                .setText(hObj.getS_sdt_h04());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h05))
                .setText(hObj.getS_sdt_h05());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h06))
                .setText(hObj.getS_sdt_h06());

        ((TextView) viewHeader.findViewById(R.id.s_sdt_h07))
                .setText(hObj.getS_sdt_h07());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h08))
                .setText(hObj.getS_sdt_h08());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h09))
                .setText(hObj.getS_sdt_h09());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h10))
                .setText(hObj.getS_sdt_h10());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h11))
                .setText(hObj.getS_sdt_h11());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h01))
                .setText(hObj.getS_sdt_h01());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h12))
                .setText(hObj.getS_sdt_h12());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h13))
                .setText(hObj.getS_sdt_h13());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h14))
                .setText(hObj.getS_sdt_h14());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h15))
                .setText(hObj.getS_sdt_h15());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h16))
                .setText(hObj.getS_sdt_h16());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h17))
                .setText(hObj.getS_sdt_h17());
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h18))
                .setText(String.valueOf(String.valueOf(hObj.getS_sdt_h18())));
        ((TextView) viewHeader.findViewById(R.id.s_sdt_h02_date))
                .setText(String.valueOf(hObj.getS_sdt_h02_date()));
        ((TextView) viewHeader.findViewById(R.id.s_sdt_hnote))
                .setText(hObj.getS_sdt_hnote());
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
