package com.example.gemery.groupradioaddfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gemery on 2018/4/12.
 */

public class QueryActivity extends AppCompatActivity {

    @Bind(R.id.edit_biaohao)
    TextInputEditText editBiaohao;
    @Bind(R.id.edit_xinghao)
    TextInputEditText editXinghao;
    @Bind(R.id.bt_query)
    Button btQuery;
    @Bind(R.id.lv_query)
    ListView lvQuery;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.bt_query)
    public void onViewClicked() {
        OkGo.<String>get("url").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                //TODO
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                //TODO
            }
        });
        lvQuery.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                new String[]{"1","ss","22","333","44444","5555555"}));
    }
}
