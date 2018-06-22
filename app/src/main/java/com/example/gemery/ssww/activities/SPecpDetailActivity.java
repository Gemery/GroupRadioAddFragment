package com.example.gemery.ssww.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.SPecpBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SPecpDetailActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.s_pecp_h00)
    TextView sPecpH00;
    @BindView(R.id.s_pech_h01)
    TextView sPechH01;
    @BindView(R.id.s_pecp_h02)
    TextView sPecpH02;
    @BindView(R.id.s_pecp_h02_desc)
    TextView sPecpH02Desc;
    @BindView(R.id.s_pecp_h05)
    TextView sPecpH05;
    @BindView(R.id.s_pecp_h06)
    TextView sPecpH06;
    @BindView(R.id.s_pecp_hconfirm)
    TextView sPecpHconfirm;
    @BindView(R.id.s_pecp_h04)
    TextView sPecpH04;
    @BindView(R.id.s_pecp_h03)
    TextView sPecpH03;
    private SPecpBean bean;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_detail_price);
        ButterKnife.bind(this);
        titleBarTitle.setText("特殊价格详情");
        titleOptionsTv.setText("");
        initData();
        initView();
    }

    private void initView() {
        sPecpH00.setText(bean.getS_pecp_h00());
        sPechH01.setText(bean.getS_pecp_h01());
        sPecpH02.setText(bean.getS_pecp_h02());
        sPecpH02Desc.setText(bean.getS_pecp_h02_desc());
        sPecpH03.setText(bean.getS_pecp_h03());
        sPecpH04.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(bean.getS_pecp_h04())));
        sPecpH05.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(bean.getS_pecp_h05())));
        sPecpH06.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(bean.getS_pecp_h06())));
        sPecpHconfirm.setText(bean.getS_pecp_hconfirm());
    }

    private void initData() {
        Bundle bundle = getIntent().getExtras();
        bean = (SPecpBean) bundle.getSerializable("specDetail");

        Log.e("tag", bean.toString());
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
