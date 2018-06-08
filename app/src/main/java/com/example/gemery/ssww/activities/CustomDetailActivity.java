package com.example.gemery.ssww.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.CustomMsg;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDetailActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.s_occ00)
    TextView sOcc00;
    @BindView(R.id.s_occ_code)
    TextView sOccCode;
    @BindView(R.id.s_occ02)
    TextView sOcc02;
    @BindView(R.id.s_occ_03)
    TextView sOcc03;
    @BindView(R.id.s_occ_04)
    TextView sOcc04;
    @BindView(R.id.s_occ05)
    TextView sOcc05;
    @BindView(R.id.s_occ06)
    TextView sOcc06;
    @BindView(R.id.s_occ07)
    TextView sOcc07;
    @BindView(R.id.s_occ08)
    TextView sOcc08;
    @BindView(R.id.s_occ09)
    TextView sOcc09;
    @BindView(R.id.s_occ10)
    TextView sOcc10;
    @BindView(R.id.s_occ11)
    TextView sOcc11;
    @BindView(R.id.s_occ12)
    TextView sOcc12;
    private CustomMsg obj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_detail);
        ButterKnife.bind(this);

        titleBarTitle.setText("客户资料详情");
        titleOptionsTv.setText("编辑");

        initData();
        initView();

    }

    private void initView() {
        sOccCode.setText(obj.getS_occ_code());
        sOcc00.setText(obj.getS_occ00());
        sOcc02.setText(obj.getS_occ02());
        sOcc03.setText(obj.getS_occ03());
        sOcc04.setText(obj.getS_occ04());
        sOcc05.setText("shijian-->");
        sOcc06.setText(obj.getS_occ06());
        sOcc07.setText(obj.getS_occ07());
        sOcc08.setText(obj.getS_occ08());
        sOcc09.setText(obj.getS_occ09());
        sOcc10.setText(obj.getS_occ10());
        sOcc11.setText(obj.getS_occ11());
        sOcc12.setText(String.valueOf(obj.getS_occ12()));
    }

    @OnClick({R.id.title_bar_back})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
        }

    }

    private void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
         obj = (CustomMsg) bundle.getSerializable("customBean");
        Log.e("tag", obj.toString());

    }
}
