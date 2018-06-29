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
    private ODdetailBean.OgaListBean hObj = new ODdetailBean.OgaListBean();
    private void initViewHeader() {
        viewHeader = LayoutInflater.from(this).inflate(R.layout.ab_test_layout,null);

        ((TextView)viewHeader.findViewById(R.id.s_oga01))
            .setText(hObj.getS_oga01());
        ((TextView)viewHeader.findViewById(R.id.s_oga_code))
            .setText(hObj.getS_oga_code());
        ((TextView)viewHeader.findViewById(R.id.s_oga_type))
            .setText(hObj.getS_oga_type());
        ((TextView)viewHeader.findViewById(R.id.s_oga02))
            .setText(hObj.getS_oga02());
        ((TextView)viewHeader.findViewById(R.id.s_oga03))
            .setText(hObj.getS_oga03());
        ((TextView)viewHeader.findViewById(R.id.s_oga04))
            .setText(hObj.getS_oga04());
        ((TextView)viewHeader.findViewById(R.id.s_oga05))
            .setText(hObj.getS_oga05());
        ((TextView)viewHeader.findViewById(R.id.s_oga10))
            .setText(hObj.getS_oga10());
        ((TextView)viewHeader.findViewById(R.id.s_oga06))
            .setText(hObj.getS_oga06());
        ((TextView)viewHeader.findViewById(R.id.s_oga07))
            .setText(hObj.getS_oga07());
        ((TextView)viewHeader.findViewById(R.id.s_oga12))
            .setText(hObj.getS_oga12());
        ((TextView)viewHeader.findViewById(R.id.s_oga13))
            .setText(hObj.getS_oga13());
        ((TextView)viewHeader.findViewById(R.id.s_oga16))
            .setText(hObj.getS_oga16());
        ((TextView)viewHeader.findViewById(R.id.s_oga18))
            .setText(hObj.getS_oga18());
        ((TextView)viewHeader.findViewById(R.id.s_oga_confirm))
            .setText(hObj.getS_oga_confirm());
        ((TextView)viewHeader.findViewById(R.id.s_ogauser))
            .setText(hObj.getS_ogauser());
        ((TextView)viewHeader.findViewById(R.id.s_oga18))
                .setText(hObj.getS_oga18());
        ((TextView)viewHeader.findViewById(R.id.s_oga19))
                .setText(hObj.getS_oga19());
        ((TextView)viewHeader.findViewById(R.id.s_oga20))
                .setText(hObj.getS_oga20());
        ((TextView)viewHeader.findViewById(R.id.s_oga21))
                .setText(hObj.getS_oga21());
        ((TextView)viewHeader.findViewById(R.id.s_oga22))
                .setText(hObj.getS_oga22());
        ((TextView)viewHeader.findViewById(R.id.s_oga24))
                .setText(hObj.getS_oga24());
        ((TextView)viewHeader.findViewById(R.id.s_oga25))
                .setText(hObj.getS_oga25());

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
                    hObj = obj.getOgaList().get(0);
                    initRecyclerView();
                    break;
            }

        }


    };


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
