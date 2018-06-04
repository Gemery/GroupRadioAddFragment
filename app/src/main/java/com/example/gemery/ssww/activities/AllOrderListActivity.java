package com.example.gemery.ssww.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllOrderListActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_bar_left)
    LinearLayout titleBarLeft;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.title_options_img)
    ImageView titleOptionsImg;
    @BindView(R.id.title_bar_right)
    RelativeLayout titleBarRight;
    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.all_order_recycler_view)
    RecyclerView allOrderRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_order_list);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initView() {
        titleBarTitle.setText("订单中心");
    }

    private void initData() {

    }
    @OnClick({R.id.title_bar_back})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
        }
    }
}
