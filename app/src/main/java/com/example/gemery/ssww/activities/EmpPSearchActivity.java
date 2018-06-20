package com.example.gemery.ssww.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmpPSearchActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_price_search);
        ButterKnife.bind(this);
        titleBarTitle.setText("价格搜索");
        titleOptionsTv.setText("重置");

    }

    @OnClick({R.id.title_bar_back, R.id.title_options_tv})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                break;
            case R.id.action_send_button:
                break;
        }
    }
}
