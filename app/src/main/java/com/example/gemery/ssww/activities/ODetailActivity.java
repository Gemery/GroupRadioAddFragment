package com.example.gemery.ssww.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.adapter.OutOrderDetailAdapter;
import com.example.gemery.ssww.bean.ODdetailBean;
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

public class ODetailActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.out_ord_review)
    RecyclerView outOrdReview;
    private String odoNum;
    private OutOrderDetailAdapter mAdapter;
    private List<ODdetailBean.OgbListBean> list = new ArrayList<>();
    private View viewHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_order_detail);
        ButterKnife.bind(this);
        titleBarTitle.setText("出库单明细");
        titleOptionsTv.setText("");
        initData();
        //initRecyclerView();
    }

    private void initRecyclerView() {
        outOrdReview.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new OutOrderDetailAdapter(list,this);
        initViewHeader();
        mAdapter.addHeaderView(viewHeader);
        outOrdReview.setAdapter(mAdapter);
    }

    private void initViewHeader() {
        viewHeader = LayoutInflater.from(this).inflate(R.layout.ab_test_layout,null);

    }

    private final static int DATA_UPDATE = 1;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case DATA_UPDATE:
                    ODdetailBean obj = (ODdetailBean) msg.obj;
                    list = obj.getOgbList();
                    initRecyclerView();
                    break;
            }

        }


    };

//    private void initView(ODdetailBean obj) {
//        ODdetailBean.OgaListBean hObj = obj.getOgaList().get(0);
//        sOgaCode.setText(hObj.getS_oga_code());
//        sOga01.setText(hObj.getS_oga01());
//        sOga02.setText(hObj.getS_oga02());
//        sOga03.setText(hObj.getS_oga03());
//        sOga04.setText(hObj.getS_oga04());
//        sOga05.setText(hObj.getS_oga05());
//        sOga10.setText(hObj.getS_oga10());
//        sOgaConfirm.setText(hObj.getS_oga_confirm());
//        sOga12.setText(hObj.getS_oga12());
//        sOga13.setText(hObj.getS_oga13());
//        sOga14.setText(hObj.getS_oga14());
//        sOga16.setText(hObj.getS_oga16());
//        sOga18.setText(hObj.getS_oga18());
//        sOga19.setText(hObj.getS_oga19());
//    }

    private String getDataUrl = Const.W_HOST + "/api/stockData/getOgabList?orderNum=";

    private void initData() {

        Intent intent = getIntent();
        odoNum = intent.getStringExtra("odoNumber");
        OkGo.<String>get(getDataUrl + odoNum)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e("tag", response.body());
                        ODdetailBean obj = GsonUtils.parseJSON(response.body(), ODdetailBean.class);
                        Message msg = new Message();
                        msg.what = DATA_UPDATE;
                        msg.obj = obj;
                        handler.sendMessage(msg);
                    }
                });
    }

    @OnClick({R.id.title_bar_back, R.id.title_options_tv})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:

                break;
        }
    }
}
