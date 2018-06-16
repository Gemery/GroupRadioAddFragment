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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.DtOrderBean;
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

public class OrderSearchActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.title)
    LinearLayout title;

    @BindView(R.id.text_start_date)
    TextView textStartDate;
    @BindView(R.id.rl_order_start_date)
    RelativeLayout rlOrderStartDate;
    @BindView(R.id.text_end_date)
    TextView textEndDate;
    @BindView(R.id.rl_order_end_date)
    RelativeLayout rlOrderEndDate;
    @BindView(R.id.action_send_button)
    Button actionSendButton;

    @BindView(R.id.search_label_key)
    TextView searchLabelKey;
    @BindView(R.id.s_oea_code)
    EditText sOeaCode;
    @BindView(R.id.s_oea02)
    EditText sOea02;
    @BindView(R.id.s_oea03)
    EditText sOea03;
    @BindView(R.id.s_oeb04)
    EditText sOeb04;
    @BindView(R.id.s_oeb05)
    EditText sOeb05;
    @BindView(R.id.s_oeb06)
    EditText sOeb06;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_search);
        ButterKnife.bind(this);
        initView();

    }

    private String search_key = "";

    /*
         "s_oea_code": "string,门店编号",
        "s_oea06": "string,业务员编号",
        "s_oea_type": "string,订单类型",
        "s_oea01": "string,订单单号",
        "s_oea02_1": "integer,订单日期 小范围",
        "s_oea02_2": "integer,订单日期 大范围",
        "s_oea03": "string,消费者电话号码",
        "s_oea04": "string,消费者姓名",
     */
    private String getFormJson() {
        String upJson = "";
        if (!textEndDate.getText().toString().isEmpty()) {
            String endDate = "s_oea02_1" + ":" + new Date(textEndDate.getText().toString()).getTime() + ",";
            upJson += endDate;
        }
        if (!textStartDate.getText().toString().isEmpty()) {
            String endDate = "s_oea02_2" + ":" + new Date(textEndDate.getText().toString()).getTime() + ",";
            upJson += endDate;
        }

        if (!sOeaCode.getText().toString().isEmpty()) {
            String filterB = "s_oea_code" + ":\"" + sOeaCode.getText().toString() + "\",";
            upJson += filterB;

        }
        if (!sOea02.getText().toString().isEmpty()) {
            String kV1 = "s_oea02" + ":\"" + sOea02.getText().toString() + "\",";
            upJson += kV1;

        }
        if (!sOea03.getText().toString().isEmpty()) {
            String kV2 = "s_oea03" + ":\"" + sOea03.getText().toString() + "\",";
            upJson += kV2;

        }
        if (!sOeb04.getText().toString().isEmpty()) {
            String kV3 = "s_oeb04" + ":\"" + sOeb04.getText().toString() + "\",";
            upJson += kV3;

        }
        if (!sOeb05.getText().toString().isEmpty()) {
            String filterB = "s_oeb05" + ":\"" + sOeb05.getText().toString() + "\",";
            upJson += filterB;

        }
        if (!sOeb06.getText().toString().isEmpty()) {
            String filterB = "s_oeb06" + ":\"" + sOeb06.getText().toString() + "\",";
            upJson += filterB;

        }
        return upJson;
    }
    private void clearFormData(){
        textEndDate.setText("");
        sOeb06.setText("");
        sOeb05.setText("");
        sOeb04.setText("");
        sOea03.setText("");
        sOea02.setText("");
        sOeaCode.setText("");
    }


    private void initView() {
        titleBarTitle.setText("订单查询");
        titleOptionsTv.setText("重置");

    }

    private String getUpJson() {
        String upJson = "{ ima: {" + getFormJson() + " },pageSize: 20,pageIndex: 1}";

        Log.e("tag", upJson);
        return upJson;
    }

    private String search_order_url = Const.W_HOST + "/api/Order/getAllstdOrders";

    private void initData() {
        OkGo.<String>post(search_order_url)
                .tag(this)
                .upJson(getUpJson())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //Log.e("tag",response.body());
                        DtOrderBean obj = GsonUtils.parseJSON(response.body(), DtOrderBean.class);
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
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case GET_DATA_IS_NULL:
                    ToastUtil.showToast(OrderSearchActivity.this, "您输入的条件没有匹配的订单");

                    break;
                case GET_DATA_NOT_NULL:
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("respResult", (Serializable) msg.obj);
                    intent.putExtras(bundle);
                    // Log.e("tag",msg.obj.toString());
                    setResult(4, intent);
                    finish();
                    break;
            }
        }
    };

    @OnClick({R.id.title_options_tv, R.id.title_bar_back, R.id.action_send_button, R.id.rl_order_start_date, R.id.rl_order_end_date})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.rl_order_end_date:
                DatePickerDialog datePicker = new DatePickerDialog(OrderSearchActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // TODO Auto-generated method stub
                                textEndDate.setText(year + "/ " + (monthOfYear + 1) + "/ " + dayOfMonth);
                                Toast.makeText(OrderSearchActivity.this,
                                        year + "/" + (monthOfYear + 1) + "/ " + dayOfMonth + "day",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }, 2018, 5, 20);
                datePicker.show();
                break;
            case R.id.rl_order_start_date:
                DatePickerDialog datePickerend = new DatePickerDialog(OrderSearchActivity.this,
                        new DatePickerDialog.OnDateSetListener() {


                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // TODO Auto-generated method stub
                                new Date().getYear();
                                textStartDate.setText(year + "/ " + (monthOfYear + 1) + "/ " + dayOfMonth);
                                Toast.makeText(OrderSearchActivity.this,
                                        year + "/" + (monthOfYear + 1) + "/ " + dayOfMonth + "day",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }, 2018, 5, 20);
                datePickerend.show();
                break;
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.action_send_button:
                initData();
                break;
            case R.id.title_options_tv:
                clearFormData();
                break;
        }
    }
}
