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
import com.example.gemery.ssww.bean.StorageBean;

import java.io.Serializable;

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

    }


    private void initData() {
        //Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        StorageBean.ListBean obj = (StorageBean.ListBean) bundle.getSerializable("storageDetail");
        Log.e("tag",obj.toString());

    }

    @OnClick({R.id.title_bar_back})
    public void viewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
        }
    }
}
