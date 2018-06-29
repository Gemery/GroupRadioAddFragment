package com.example.gemery.ssww.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.ODOBean;
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

public class OGASearchActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.s_lock_h02)
    EditText sLockH02;
    @BindView(R.id.s_lock_h01)
    EditText sLockH01;
    @BindView(R.id.s_lock_e05)
    EditText sLockE05;
    @BindView(R.id.s_lock_e07)
    EditText sLockE07;
    @BindView(R.id.s_lock_e08)
    EditText sLockE08;
    @BindView(R.id.text_start_date)
    TextView textStartDate;
    @BindView(R.id.text_end_date)
    TextView textEndDate;
    @BindView(R.id.s_oga04)
    EditText sOga04;
    @BindView(R.id.s_oga03)
    EditText sOga03;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oga_search);
        ButterKnife.bind(this);
        titleBarTitle.setText("出库单搜索");
        titleOptionsTv.setText("重置");
    }

    @OnClick({R.id.title_bar_back, R.id.title_options_tv,
            R.id.action_send_button, R.id.rl_order_end_date, R.id.rl_order_start_date})
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
            case R.id.rl_order_end_date:
                DatePickerDialog datePicker = new DatePickerDialog(OGASearchActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // TODO Auto-generated method stub
                                textEndDate.setText(year + "/ " + (monthOfYear + 1) + "/ " + dayOfMonth);
                            }
                        }, 2018, 5, 20);
                datePicker.show();
                break;
            case R.id.rl_order_start_date:
                DatePickerDialog datePickerend = new DatePickerDialog(OGASearchActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // TODO Auto-generated method stub
                                textStartDate.setText(year + "/ " + (monthOfYear + 1) + "/ " + dayOfMonth);
                            }
                        }, 2018, 5, 20);
                datePickerend.show();
                break;
        }
    }

    private void clearForm() {
        sLockH02.setText("");
        textEndDate.setText("");
        textStartDate.setText("");
        sLockH01.setText("");
        sLockE05.setText("");
        sLockE07.setText("");
        sLockE08.setText("");
        sOga03.setText("");
        sOga04.setText("");
    }

    private String getFormJson() {
        String upJson = "";
        if (!textEndDate.getText().toString().isEmpty()) {
            String endDate = "s_oga02_1" + ":" + new Date(textEndDate.getText().toString()).getTime() + ",";
            upJson += endDate;
        }
        if (!textStartDate.getText().toString().isEmpty()) {
            String endDate = "s_oga02_2" + ":" + new Date(textEndDate.getText().toString()).getTime() + ",";
            upJson += endDate;
        }
        if (!sLockH02.getText().toString().isEmpty()) {
            String filterB = "s_oga08" + ":\"" + sLockH02.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sLockH01.getText().toString().isEmpty()) {
            String filterB = "s_oga01" + ":\"" + sLockH01.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sOga03.getText().toString().isEmpty()) {
            String filterB = "s_oga03" + ":\"" + sOga03.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sOga04.getText().toString().isEmpty()) {
            String filterB = "s_oga04" + ":\"" + sOga04.getText().toString() + "\",";
            upJson += filterB;
        }

        if (!sLockE05.getText().toString().isEmpty()) {
            String filterB = "s_ogb06" + ":\"" + sLockE05.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sLockE07.getText().toString().isEmpty()) {
            String filterB = "s_ogb07" + ":\"" + sLockE07.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sLockE08.getText().toString().isEmpty()) {
            String filterB = "s_ogb08" + ":\"" + sLockE08.getText().toString() + "\",";
            upJson += filterB;
        }
        if (!sLockE08.getText().toString().isEmpty()) {
            String filterB = "s_ogb08" + ":\"" + sLockE08.getText().toString() + "\",";
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
    private String search_lock_order_url = Const.W_HOST + "/api/stockData/getOgaList";

    private void initData() {
        OkGo.<String>post(search_lock_order_url)
                .tag(this)
                .upJson(getUpJson())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //Log.e("tag",response.body());
                        ODOBean obj = GsonUtils.parseJSON(response.body(), ODOBean.class);
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
                    ToastUtil.showToast(OGASearchActivity.this, "您输入的条件没有匹配的订单");

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

