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
import com.example.gemery.ssww.bean.EmpPriceBean;
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

public class EmpPSearchActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.s_pch01)
    EditText sPch01;
    @BindView(R.id.s_pch02)
    EditText sPch02;
    @BindView(R.id.s_pce04)
    EditText sPce04;
    @BindView(R.id.s_pce05)
    EditText sPce05;
    @BindView(R.id.text_start_date)
    TextView textStartDate;
    @BindView(R.id.text_end_date)
    TextView textEndDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_price_search);
        ButterKnife.bind(this);
        titleBarTitle.setText("价格搜索");
        titleOptionsTv.setText("重置");

    }

    @OnClick({R.id.title_bar_back, R.id.title_options_tv,R.id.action_send_button})
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
        sPch01.setText("");
        textEndDate.setText("");
        textStartDate.setText("");
        sPch02.setText("");
        sPce04.setText("");
        sPce05.setText("");
    }

    private String getFormJson() {
        String upJson = "";
        if (!textEndDate.getText().toString().isEmpty()) {
            String endDate = "s_pb07" + ":" + new Date(textEndDate.getText().toString()).getTime() + ",";
            upJson += endDate;
        }
        if (!textStartDate.getText().toString().isEmpty()) {
            String endDate = "s_pb08" + ":" + new Date(textEndDate.getText().toString()).getTime() + ",";
            upJson += endDate;
        }
        if (!sPch01.getText().toString().isEmpty()) {
            String filterB = "s_pch01" + ":\"" + sPch01.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sPch02.getText().toString().isEmpty()) {
            String filterB = "s_pch02" + ":\"" + sPch02.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sPce04.getText().toString().isEmpty()) {
            String filterB = "s_pce05" + ":\"" + sPce04.getText().toString() + "\",";
            upJson += filterB;
        }

        if (!sPce05.getText().toString().isEmpty()) {
            String filterB = "s_pce05" + ":\"" + sPce05.getText().toString() + "\",";
            upJson += filterB;
        }
        return upJson;
    }
    // 参数必须 传  s_pch00 经销商代码
    private String getUpJson() {
        String s_pch00 = "300005";
        String upJson = "{s_pch00:\""+s_pch00 +"\"," + getFormJson() + "}";
        Log.e("tag", upJson);
        return upJson;
    }

    //  url
    private String search_price_url = Const.W_HOST + "/api/salesData/seachPcList";

    private void initData() {
        OkGo.<String>post(search_price_url)
                .tag(this)
                .upJson(getUpJson())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //Log.e("tag",response.body());
                        List<EmpPriceBean> obj = GsonUtils.jsonToArrayList(response.body(), EmpPriceBean.class);
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
                    ToastUtil.showToast(EmpPSearchActivity.this, "您输入的条件没有匹配的订单");

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
