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
import com.example.gemery.ssww.bean.BasePriceBean;
import com.example.gemery.ssww.bean.SGBagBean;
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

public class SGBagActivity extends AppCompatActivity {

    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.s_gbag_h01)
    EditText sGbagH01;
    @BindView(R.id.s_gbag_h03)
    EditText sGbagH03;
    @BindView(R.id.s_gbag_h04)
    EditText sGbagH04;
    @BindView(R.id.s_gbag_h05)
    EditText sGbagH05;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_gbag_search);
        ButterKnife.bind(this);
        titleBarTitle.setText("销售礼包搜索");
        titleOptionsTv.setText("重置");
    }

    @OnClick({R.id.title_options_tv, R.id.title_bar_back,R.id.action_send_button})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                clearForm();
                break;
            case R.id.action_send_button:
                initData();
                break;

        }
    }

    private void clearForm() {
        sGbagH01.setText("");
        sGbagH03.setText("");
        sGbagH04.setText("");
        sGbagH05.setText("");
    }

    private String getFormJson() {
        String upJson = "";

        if (!sGbagH01.getText().toString().isEmpty()) {
            String filterB = "s_gbag_h01" + ":\"" + sGbagH01.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sGbagH03.getText().toString().isEmpty()) {
            String filterB = "s_gbag_h03" + ":\"" + sGbagH03.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sGbagH04.getText().toString().isEmpty()) {
            String filterB = "s_gbag_h04" + ":\"" + sGbagH04.getText().toString() + "\",";
            upJson += filterB;
        }

        if (!sGbagH05.getText().toString().isEmpty()) {
            String filterB = "s_gbag_h05" + ":\"" + sGbagH05.getText().toString() + "\",";
            upJson += filterB;
        }
        return upJson;
    }

    private String getUpJson() {
        String upJson = "{ ima: {" + getFormJson() + " },pageSize: 20,pageIndex: 1}";
        Log.e("tag", upJson);
        return upJson;
    }

    //  url
    private String search_sgbag_url = Const.W_HOST + "/api/imaData/getgbag_hList";

    private void initData() {
        OkGo.<String>post(search_sgbag_url)
                .tag(this)
                .upJson(getUpJson())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //Log.e("tag",response.body());
                        SGBagBean obj = GsonUtils.parseJSON(response.body(), SGBagBean.class);
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
                    ToastUtil.showToast(SGBagActivity.this, "您输入的条件没有匹配的订单");

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
}
