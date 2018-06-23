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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.InstallOrdBen;
import com.example.gemery.ssww.bean.SPecpBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SPecpSearchActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.s_pecp_h01)
    EditText sPecpH01;
    @BindView(R.id.s_pecp_e04)
    EditText sPecpE04;
    @BindView(R.id.s_pecp_e05)
    EditText sPecpE05;
    @BindView(R.id.s_pecp_e06)
    EditText sPecpE06;
    @BindView(R.id.text_start_date)
    TextView textStartDate;
    @BindView(R.id.text_end_date)
    TextView textEndDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specp_search);
        ButterKnife.bind(this);
        titleBarTitle.setText("特殊价格搜索");
        titleOptionsTv.setText("重置");

    }
    private void clearForm(){
        sPecpH01.setText("");
        sPecpE04.setText("");
        sPecpE05.setText("");
        sPecpE06.setText("");
        textStartDate.setText("");
        textEndDate.setText("");
    }
    @OnClick({R.id.title_bar_back, R.id.title_options_tv, R.id.action_send_button})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                clearForm();
                break;
            case R.id.action_send_button:
                initSearchData();
                break;
        }
    }
    private String getFormJson() {
        String upJson = "";
        if (!textEndDate.getText().toString().isEmpty()) {
            String endDate = "s_pecp_h05_1" + ":" + new Date(textEndDate.getText().toString()).getTime() + ",";
            upJson += endDate;
        }
        if (!textStartDate.getText().toString().isEmpty()) {
            String endDate = "s_pecp_h05_2" + ":" + new Date(textEndDate.getText().toString()).getTime() + ",";
            upJson += endDate;
        }
        if (!sPecpH01.getText().toString().isEmpty()) {
            String filterB = "s_pecp_h01" + ":\"" + sPecpH01.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sPecpE04.getText().toString().isEmpty()) {
            String filterB = "s_pecp_e04" + ":\"" + sPecpE04.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sPecpE05.getText().toString().isEmpty()) {
            String filterB = "s_pecp_e05" + ":\"" + sPecpE05.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sPecpE06.getText().toString().isEmpty()) {
            String filterB = "s_pecp_e06" + ":\"" + sPecpE06.getText().toString() + "\",";
            upJson += filterB;
        }

        return upJson;
    }
    private String getUpJson() {
        String upJson = "{" + getFormJson() + "}";
        Log.e("tag", upJson);
        return upJson;
    }
    private String search_order_url = Const.W_HOST + "/api/salesData/seachPecpList";
    private void initSearchData() {
        OkGo.<String>post(search_order_url)
                .tag(this)
                .upJson(getUpJson())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //Log.e("tag",response.body());
                        List<SPecpBean> obj = GsonUtils.jsonToArrayList(response.body(), SPecpBean.class);
                        if (obj.size() != 0) {
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
                    ToastUtil.showToast(SPecpSearchActivity.this, "您输入的条件没有匹配的订单");

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