package com.example.gemery.groupradioaddfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.gemery.groupradioaddfragment.db.UserDaoOpe;
import com.example.gemery.groupradioaddfragment.entity.UserInfo;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gemery on 2018/4/12.
 */

public class QueryActivity extends AppCompatActivity {

    @BindView(R.id.edit_biaohao)
    TextInputEditText editBiaohao;
    @BindView(R.id.edit_xinghao)
    TextInputEditText editXinghao;
    @BindView(R.id.bt_query)
    Button btQuery;
    @BindView(R.id.lv_query)
    ListView lvQuery;
    @BindView(R.id.btn_insert)
    Button btnInsert;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btn_insert)
    public void onBttonClicked(){
        UserDaoOpe.insertData(this,new UserInfo(null,"xiaoming","ni hao","13332576625"));
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
        List<UserInfo> list = UserDaoOpe.queryAll(this);
        lvQuery.setAdapter(new ArrayAdapter<UserInfo>(this,android.R.layout.simple_list_item_1,
                list));
    }
}
