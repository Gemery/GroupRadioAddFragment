package com.example.gemery.ssww.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.adapter.MyOrderDtailAdapter;
import com.example.gemery.ssww.adapter.SGBagDtailAdapter;
import com.example.gemery.ssww.bean.SGBagDetailBean;
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

public class SGBagDetailActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.sgbag_re_view)
    RecyclerView sgbagReView;
    private View viewHeader;
    private SGBagDtailAdapter mAdapter;
    private SGBagDetailBean.GbagHBean dtBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgbag_detail);
        ButterKnife.bind(this);
        titleBarTitle.setText("销售礼包详情");
        titleOptionsTv.setText("编辑");
        initData();
    }
    private List<SGBagDetailBean.GbagEBean> list = new ArrayList<>();
    private void initData() {
        String s_gbag_h00  = "";
        String s_gbag_h01  = "";
        String s_gbag_h02 = getIntent().getStringExtra("sgbagNumber");
        String  getUrl = Const.W_HOST + "/api/imaData/getgbagList?s_gbag_h00=300005&s_gbag_h01=300005001&s_gbag_h02=" + s_gbag_h02;

        OkGo.<String>get(getUrl)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e("tag",response.body());
                        SGBagDetailBean bean = GsonUtils.parseJSON(response.body(),SGBagDetailBean.class);

                        list = bean.getGbag_e();
                        dtBean = bean.getGbag_h().get(0);
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

        sgbagReView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new SGBagDtailAdapter(list, this);
        sgbagReView.setAdapter(mAdapter);
        // 初始recyclerView 头部
        initRecylerViewHeader();
        mAdapter.addHeaderView(viewHeader);
    }
    @OnClick({R.id.title_options_tv,R.id.title_bar_back})
    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.title_options_tv:
                break;
            case R.id.title_bar_back:
                finish();
                break;
        }
    }
    private void initRecylerViewHeader() {
        viewHeader = LayoutInflater.from(this).inflate(R.layout.item_sgbag_detail_dantou, null);
        ((TextView)viewHeader.findViewById(R.id.s_gbag_h02))
                .setText(dtBean.getS_gbag_h02());
        ((TextView)viewHeader.findViewById(R.id.s_gbag_h03))
                .setText(dtBean.getS_gbag_h03());
        ((TextView)viewHeader.findViewById(R.id.s_gbag_h04))
                .setText(dtBean.getS_gbag_h04());
        ((TextView)viewHeader.findViewById(R.id.s_gbag_h05))
                .setText(dtBean.getS_gbag_h05());
        ((TextView)viewHeader.findViewById(R.id.s_gbag_h06))
                .setText(dtBean.getS_gbag_h06());
        ((TextView)viewHeader.findViewById(R.id.s_gbag_h07))
                .setText(dtBean.getS_gbag_h07());
        ((TextView)viewHeader.findViewById(R.id.s_gbag_hconfirm))
                .setText(dtBean.getS_gbag_hconfirm());
    }
}
