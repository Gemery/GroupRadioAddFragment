package com.example.gemery.ssww.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.InstallOrdBen;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InstOrdDetailActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.s_ist_h01)
    TextView sIstH01;
    @BindView(R.id.s_ist_h06)
    TextView sIstH06;
    @BindView(R.id.s_ist_h02)
    TextView sIstH02;
    @BindView(R.id.s_ist_h05)
    TextView sIstH05;
    @BindView(R.id.s_ist_h08)
    TextView sIstH08;
    @BindView(R.id.s_ist_h03)
    TextView sIstH03;
    @BindView(R.id.ist_h04)
    TextView sIstH04;
    @BindView(R.id.ist_h09)
    TextView sIstH09;
    @BindView(R.id.s_ist_h07)
    TextView sIstH07;
    @BindView(R.id.s_ist_hconfirm)
    TextView sIstHconfirm;
    @BindView(R.id.ist_h10)
    TextView sIstH10;
    private InstallOrdBen.ListBean obj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inst_ord_detail);
        ButterKnife.bind(this);

        initData();
        initView();
    }

    private void initView() {
        titleBarTitle.setText("安装单详情");

        sIstH01.setText(obj.getS_ist_h01());
        sIstH06.setText(obj.getS_ist_h06());
        sIstH08.setText(obj.getS_ist_h08());
        sIstH02.setText(obj.getS_ist_h02());
        sIstH05.setText(obj.getS_ist_h05());
        sIstH03.setText(obj.getS_ist_h03());
        sIstH04.setText(obj.getS_ist_h04());
        sIstH07.setText(obj.getS_ist_h07());
        sIstH09.setText(obj.getS_ist_h09());
        sIstH10.setText(obj.getS_ist_h10());
        sIstHconfirm.setText(obj.getS_ist_hconfirm());

    }

    private void initData() {
        Bundle bundle = getIntent().getExtras();
        obj = (InstallOrdBen.ListBean) bundle.getSerializable("installOrder");


    }

    @OnClick({R.id.title_bar_back})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
        }
    }
}
