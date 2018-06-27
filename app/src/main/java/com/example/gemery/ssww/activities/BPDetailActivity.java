package com.example.gemery.ssww.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.BasePriceBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BPDetailActivity extends AppCompatActivity {

    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.s_pb00)
    TextView sPb00;
    @BindView(R.id.s_pb01)
    TextView sPb01;
    @BindView(R.id.s_pb02)
    TextView sPb02;
    @BindView(R.id.s_ph03)
    TextView sPh03;
    @BindView(R.id.s_pb04)
    TextView sPb04;
    @BindView(R.id.s_pb05)
    TextView sPb05;
    @BindView(R.id.s_pb06)
    TextView sPb06;
    @BindView(R.id.s_pb07)
    TextView sPb07;
    @BindView(R.id.s_pb08)
    TextView sPb08;
    @BindView(R.id.s_pb09)
    TextView sPb09;
    @BindView(R.id.s_pb10)
    TextView sPb10;
    @BindView(R.id.s_pb12)
    TextView sPb12;
    @BindView(R.id.s_pb11)
    TextView sPb11;
    @BindView(R.id.s_pb_confirm_state)
    TextView sPbConfirmState;
    @BindView(R.id.s_pb_confirm_user)
    TextView sPbConfirmUser;
    @BindView(R.id.s_pb_confirm_date)
    TextView sPbConfirmDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bp_detail);
        ButterKnife.bind(this);
        titleBarTitle.setText("面价详细信息");
        titleOptionsTv.setText("");
        initData();

        initView();
    }
    @OnClick({R.id.title_options_tv,R.id.title_bar_back})
    public void onViewClick(View view){
           switch (view.getId()){
               case R.id.title_bar_back:
                   finish();
                   break;
               case R.id.title_options_tv:
                   break;

           }
    }

    BasePriceBean.ListBean bean;

    private void initView() {
        sPb00.setText(bean.getS_pb00());
        sPb01.setText(String.valueOf(bean.getS_pb01()));
        sPb02.setText(bean.getS_pb02());
        sPh03.setText(bean.getS_pb03());
        sPb04.setText(bean.getS_pb04());
        sPb05.setText(bean.getS_pb05());
        sPb06.setText(bean.getS_pb06());
        sPb07.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(bean.getS_pb07())));
        sPb08.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(bean.getS_pb08())));
        sPb09.setText(String.valueOf(bean.getS_pb09()));
        sPb10.setText(String.valueOf(bean.getS_pb10()));
        sPb11.setText(bean.getS_pb11());
        sPb12.setText(bean.getS_pb12());
        sPbConfirmState.setText(bean.getS_pb_confirm_state());
        sPbConfirmUser.setText(bean.getS_pb_confirm_user());
        sPbConfirmDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(bean.getS_pb_confirm_date())));
    }

    private void initData() {
        Bundle bundle = getIntent().getExtras();

        bean = (BasePriceBean.ListBean) bundle.getSerializable("bpDetail");

    }
}
