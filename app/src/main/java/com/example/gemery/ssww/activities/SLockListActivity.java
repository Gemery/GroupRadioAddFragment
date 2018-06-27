package com.example.gemery.ssww.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.parambean.GListSlockParams;
import com.example.gemery.ssww.utils.Const;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SLockListActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    private final static String PAGE_SIZE = "20";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slock_list);
        ButterKnife.bind(this);
        titleBarTitle.setText("锁库存列表");
        titleOptionsTv.setText(R.string.search);
        initData();

    }
    private String getDataUrl = Const.W_HOST + "/api/stockData/searchLockSkList";

    private String getUpJson(){
        GListSlockParams obj = new GListSlockParams();
        GListSlockParams.ImaBean innerObj = new GListSlockParams.ImaBean();
        obj.setIma(innerObj);
        obj.setPageIndex("1");
        obj.setPageSize(PAGE_SIZE);

        return obj.toString();
    }
  private String upJson = "{ ima:{},pageSize:20,pageIndex:1}";
    private void initData() {
        OkGo.<String>post(getDataUrl)
                .tag(this)
                .upJson(upJson)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e("tag",response.body());
                    }
                });

    }
    @OnClick({R.id.title_bar_back,R.id.title_options_tv})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                Intent intent = new Intent(this,SLockSearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
