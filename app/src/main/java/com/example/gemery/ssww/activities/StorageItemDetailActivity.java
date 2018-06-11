package com.example.gemery.ssww.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.StorageBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StorageItemDetailActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.s_img01)
    TextView sImg01;
    @BindView(R.id.s_img01_desc)
    TextView sImg01Desc;
    @BindView(R.id.s_img02)
    TextView sImg02;
    @BindView(R.id.s_img03)
    TextView sImg03;
    @BindView(R.id.s_img04)
    TextView sImg04;
    @BindView(R.id.s_img04_desc)
    TextView sImg04Desc;
    @BindView(R.id.s_img05)
    TextView sImg05;
    @BindView(R.id.s_img05_desc)
    TextView sImg05Desc;
    @BindView(R.id.s_img06)
    TextView sImg06;
    @BindView(R.id.s_img07)
    TextView sImg07;
    @BindView(R.id.s_img08)
    TextView sImg08;
    private StorageBean.ListBean obj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_item_detail);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initView() {
        titleBarTitle.setText("库存详情");
        titleOptionsTv.setText("编辑");

        sImg01.setText(obj.getS_img01());
        sImg01Desc.setText(obj.getS_img01_desc());
        sImg02.setText(obj.getS_img02());
        sImg03.setText(obj.getS_img03());
        sImg04.setText(obj.getS_img04());
        sImg05.setText(obj.getS_img05());
        sImg06.setText(obj.getS_img06());
        sImg04Desc.setText(obj.getS_img04_desc());
        sImg05Desc.setText(obj.getS_img00());

        sImg07.setText(obj.getS_img07());
        sImg08.setText(String.valueOf(obj.getS_img08()));



    }


    private void initData() {
        //Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
         obj = (StorageBean.ListBean) bundle.getSerializable("storageDetail");
        Log.e("tag", obj.toString());

    }

    @OnClick({R.id.title_bar_back})
    public void viewClick(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
        }
    }
}
