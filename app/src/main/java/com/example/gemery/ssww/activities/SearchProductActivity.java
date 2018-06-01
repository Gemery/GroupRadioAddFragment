package com.example.gemery.ssww.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.adapter.OrderMessageAdapter;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SearchProductActivity extends AppCompatActivity {
   @BindView(R.id.lv_order)
    ListView lvOrder;
    List<String> mData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_message);
        ButterKnife.bind(this);
        initData();

        lvOrder.setAdapter(new OrderMessageAdapter(this,mData,R.layout.item_order_info));
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add("芜湖");
        mData.add("shangjiang");
        mData.add("zhilong");


    }
}
