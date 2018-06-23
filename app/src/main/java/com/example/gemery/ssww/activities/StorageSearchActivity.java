package com.example.gemery.ssww.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.InstallOrdBen;
import com.example.gemery.ssww.bean.StorageBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.io.Serializable;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StorageSearchActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.s_img04_desc)
    EditText sImg04Desc;
    @BindView(R.id.s_img01_desc)
    EditText sImg01Desc;
    @BindView(R.id.s_img03)
    EditText sImg03;
    @BindView(R.id.s_img02)
    EditText sImg02;
    @BindView(R.id.s_img05)
    EditText sImg05;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_search);
        ButterKnife.bind(this);
        titleBarTitle.setText("库存搜索");
        titleOptionsTv.setText("重置");

    }

    private String getFormJson() {
        String upJson = "";

        if (!sImg04Desc.getText().toString().isEmpty()) {
            String filterB = "s_img04_desc" + ":\"" + sImg04Desc.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sImg01Desc.getText().toString().isEmpty()) {
            String filterB = "s_img01_desc" + ":\"" + sImg01Desc.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sImg02.getText().toString().isEmpty()) {
            String filterB = "s_img02" + ":\"" + sImg02.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sImg03.getText().toString().isEmpty()) {
            String filterB = "s_img03" + ":\"" + sImg03.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sImg05.getText().toString().isEmpty()) {
            String filterB = "s_img05" + ":\"" + sImg05.getText().toString() + "\",";
            upJson += filterB;
        }
        return upJson;
    }

    private void clearForm() {
        sImg05.setText("");
        sImg03.setText("");
        sImg02.setText("");
        sImg04Desc.setText("");
        sImg01Desc.setText("");
    }
    private String getUpJson() {
        String upJson = "{ ima: {" + getFormJson() + " },pageSize: 20,pageIndex: 1}";
        Log.e("tag", upJson);
        return upJson;
    }

    // 安装单 url
    private String search_order_url = Const.W_HOST + "/api/stockData/getStoreList";

    private void initData() {
        OkGo.<String>post(search_order_url)
                .tag(this)
                .upJson(getUpJson())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //Log.e("tag",response.body());
                        StorageBean obj = GsonUtils.parseJSON(response.body(), StorageBean.class);
                        if (obj.getList().size() != 0) {
                            Message msg = new Message();
                            msg.what = GET_DATA_NOT_NULL;
                            msg.obj = obj;
                            mHandler.sendMessage(msg);
                        } else {
                            Message msg = new Message();
                            msg.what = GET_DATA_IS_NULL;
                            mHandler.sendMessage(msg);
                        }
                    }
                });
    }

    public final static int GET_DATA_IS_NULL = 0;
    public final static int GET_DATA_NOT_NULL = 1010;
    public final static int RESULT_CODE = 4;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case GET_DATA_IS_NULL:
                    ToastUtil.showToast(StorageSearchActivity.this, "您输入的条件没有匹配的订单");

                    break;
                case GET_DATA_NOT_NULL:
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("respResult", (Serializable) msg.obj);
                    intent.putExtras(bundle);
                    // Log.e("tag",msg.obj.toString());
                    setResult(RESULT_CODE, intent);
                    finish();
                    break;
            }
        }
    };
    @OnClick({R.id.title_bar_back,R.id.action_send_button})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.action_send_button:
                initData();
                break;
            case R.id.title_options_tv:
                clearForm();
                break;
        }
    }
}
