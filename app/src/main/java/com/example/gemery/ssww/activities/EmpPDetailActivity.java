package com.example.gemery.ssww.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.EmpPriceBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmpPDetailActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.s_pch00)
    TextView sPch00;
    @BindView(R.id.s_pch01)
    TextView sPch01;
    @BindView(R.id.s_pch02)
    TextView sPch02;
    @BindView(R.id.s_pch02_desc)
    TextView sPch02Desc;
    @BindView(R.id.s_pch04)
    TextView sPch04;
    @BindView(R.id.s_pch05)
    TextView sPch05;
    @BindView(R.id.s_pch_confirm)
    TextView sPchConfirm;
    @BindView(R.id.s_pch07)
    TextView sPch07;
    @BindView(R.id.s_pch08)
    TextView sPch08;
    @BindView(R.id.s_pch09)
    TextView sPch09;
    @BindView(R.id.s_pch10)
    TextView sPch10;
    @BindView(R.id.s_pch11)
    TextView sPch11;
    @BindView(R.id.s_pch12)
    TextView sPch12;
    @BindView(R.id.s_pch13)
    TextView sPch13;
    @BindView(R.id.s_pch14)
    TextView sPch14;
    @BindView(R.id.s_pch15)
    TextView sPch15;
    private EmpPriceBean bean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_price_detail);
        ButterKnife.bind(this);
        titleBarTitle.setText("价格条件详情");
        titleOptionsTv.setText("");

        initData();
        initView();
    }
    @OnClick({R.id.title_bar_back})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                 finish();
            break;
        }
    }
    private void initView() {
        sPch00.setText(bean.getS_pch00());
        sPch01.setText(bean.getS_pch01());
        sPch02.setText(bean.getS_pch02());
        sPch02Desc.setText(bean.getS_pch02_desc());
        sPch04.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(bean.getS_pch04())));
        sPch05.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(bean.getS_pch05())));
        sPchConfirm.setText(bean.getS_pch_confirm());
        sPch07.setText(String.valueOf(bean.getS_pch07()));
        sPch08.setText(bean.getS_pch08());
        sPch09.setText(bean.getS_pch09());
        sPch10.setText(String.valueOf(bean.getS_pch10()));
        sPch11.setText(String.valueOf(bean.getS_pch11()));
        sPch12.setText(bean.getS_pch12());
        sPch13.setText(bean.getS_pch13());
        sPch14.setText(bean.getS_pch14());
        sPch15.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(bean.getS_pch15())));
    }

    private void initData() {
        Bundle bundle = getIntent().getExtras();
         bean = (EmpPriceBean) bundle.getSerializable("priceDetail");
       // Log.e("tag",bean.toString());
    }

}
