package com.example.gemery.ssww.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.PreferencesUtils;
import com.example.gemery.ssww.utils.WeiboDialogUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmpPListActivity extends AppCompatActivity {

    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.price_re_view)
    RecyclerView priceReView;
    private Dialog weiBoDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_price_list);
        ButterKnife.bind(this);
        titleBarTitle.setText("价格条件列表");
        titleOptionsTv.setText(R.string.search);

        initData();
    }
    private String getJsonDataUrl = Const.W_HOST + "/api/salesData/getpcFromUserCode?sw_code=";

    private void initData() {
        // TODO 获得员工编号
        getJsonDataUrl += PreferencesUtils.getSharePreStr(this,"emp_code");
        weiBoDialog = WeiboDialogUtils.createLoadingDialog(this,"正在加载....");
        OkGo.<String>get(getJsonDataUrl)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WeiboDialogUtils.closeDialog(weiBoDialog);
                        Log.e("tag",response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);

                    }
                });

    }

    @OnClick({R.id.title_options_tv,R.id.title_bar_back})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                Intent intent = new Intent(EmpPListActivity.this,EmpPSearchActivity.class);
                intent.putExtra("action","to_search_price_activity");
                startActivity(intent);
                break;
        }

    }
}
