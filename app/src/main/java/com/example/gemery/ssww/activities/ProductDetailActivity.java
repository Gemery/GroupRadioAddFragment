package com.example.gemery.ssww.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.ImaBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.s_ima01)
    TextView sIma01;
    @BindView(R.id.s_ima02)
    TextView sIma02;
    @BindView(R.id.s_imaud01)
    TextView sImaud01;
    @BindView(R.id.s_ima021)
    TextView sIma021;
    @BindView(R.id.s_ima25)
    TextView sIma25;
    @BindView(R.id.s_ima1006)
    TextView sIma1006;
    @BindView(R.id.s_img1006_desc)
    TextView sImg1006Desc;
    @BindView(R.id.s_ima1007)
    TextView sIma1007;
    @BindView(R.id.s_ima1007_desc)
    TextView sIma1007Desc;
    @BindView(R.id.s_ima39)
    TextView sIma39;
    @BindView(R.id.s_ima40)
    TextView sIma40;
    @BindView(R.id.s_occ001)
    TextView sOcc001;
    @BindView(R.id.s_ima27)
    TextView sIma27;
    @BindView(R.id.s_ima35)
    TextView sIma35;
    @BindView(R.id.s_id)
    TextView sId;
    @BindView(R.id.s_ima_bag)
    TextView sImaBag;
    @BindView(R.id.s_ima_confirm)
    TextView sImaConfirm;
    private ImaBean.ListBean bean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
        initData();

        initView();

    }

    private void initView() {
        titleOptionsTv.setText("");
        titleBarTitle.setText("产品详细信息");

        sIma01.setText(bean.getS_ima01());
        sIma02.setText(bean.getS_ima021());
        sImaud01.setText(bean.getS_imaud01());
        sIma021.setText(bean.getS_imaud02());
        sIma25.setText(bean.getS_ima25());
        sIma1006.setText(bean.getS_ima1006());
        sImg1006Desc.setText(bean.getS_ima1006_desc());
        sIma1007.setText(bean.getS_ima1007());
        sIma1007Desc.setText(bean.getS_ima1007_desc());
        sIma39.setText(bean.getS_ima39());
        sIma40.setText(bean.getS_ima40());
        sOcc001.setText(bean.getS_ima00());

        sIma27.setText(String.valueOf(bean.getS_ima27()));
        sIma35.setText(bean.getS_ima35());
        sId.setText(String.valueOf(bean.getS_id()));
        sImaBag.setText(bean.getS_ima_bag());
        sImaConfirm.setText(bean.getS_ima_acti());

    }


    private void initData() {
        bean = (ImaBean.ListBean) getIntent().getExtras().getSerializable("productDetail");

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
