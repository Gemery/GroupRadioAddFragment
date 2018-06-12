package com.example.gemery.ssww.activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.DtOrderBean;
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
    @BindView(R.id.et_search_text_v2)
    EditText etSearchTextV2;
    @BindView(R.id.search_label_key)
    TextView searchLabelKey;
    @BindView(R.id.et_search_text)
    EditText etSearchText;
    @BindView(R.id.imb_search_clear)
    ImageButton imbSearchClear;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_search);
        ButterKnife.bind(this);
        //initData();
        initView();

    }
    private String search_key= "";
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
private String getInputText(String changeText) {
    // String str = " { ima: { s_img04_desc:\"浪\" },pageSize: 20,pageIndex: 1}";
    switch (checkItem) {
        case 0:
            search_key = "s_oea_type";
            break;
        case 1:
            search_key = "s_oea03";
            break;
        case 2:
            search_key = "s_oea04";
            break;
        case 3:
            search_key = "s_oea01";
            break;

    }
    String auto_post_json = search_key + ":\"" + changeText + "\"";
    return auto_post_json;
}

    private String getFormJson(){
        String upJson = "";
        if(!textEndDate.getText().toString().isEmpty()){
            String endDate = "s_oea02_1" + ":" + new Date(textEndDate.getText().toString()).getTime()+",";
            upJson+=endDate;
        }
        if(!textStartDate.getText().toString().isEmpty()){
            String endDate = "s_oea02_2" + ":" + new Date(textEndDate.getText().toString()).getTime()+",";
            upJson+=endDate;
        }
        if(!etSearchText.getText().toString().isEmpty()){
          // 选项不同
            upJson+=getInputText(etSearchText.getText().toString());
        }
        if(!etSearchTextV2.getText().toString().isEmpty()){
            String filterB = "s_oea_code" +":\""+ etSearchTextV2.getText().toString()+ "\",";
            upJson+=filterB;

        }
        return upJson;
    }
    private int checkItem = 0;
    private void showPopuWindow() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        String[] strArray = {"订单类型", "客户电话", "客户姓名", "订单号"};

        builder.setSingleChoiceItems(strArray, checkItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                checkItem = i;
                searchLabelKey.setText(strArray[checkItem]);
                dialogInterface.dismiss();

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }


    private void initView() {
        titleBarTitle.setText("订单查询");
        titleOptionsTv.setText("");

    }
    private String getUpJson(){
        String upJson = "{ ima: {" + getFormJson() + " },pageSize: 20,pageIndex: 1}";

        Log.e("tag",upJson);
        return upJson;
    }
    private String search_order_url = "http://192.168.1.251:8091/api/Order/getAllstdOrders";
    private void initData() {
       OkGo.<String>post(search_order_url)
               .tag(this)
               .upJson(getUpJson())
               .execute(new StringCallback() {
                   @Override
                   public void onSuccess(Response<String> response) {
                       //Log.e("tag",response.body());
                       DtOrderBean obj = GsonUtils.parseJSON(response.body(),DtOrderBean.class);
                       if(obj.getList().size() != 0){
                           Message msg = new Message();
                           msg.what = GET_DATA_NOT_NULL;
                           msg.obj = obj;
                           mHandler.sendMessage(msg);
                       }
                       else{
                           Message msg = new Message();
                           msg.what = GET_DATA_IS_NULL;
                           mHandler.sendMessage(msg);
                       }
                   }
               });
    }
    public final static int  GET_DATA_IS_NULL = 0;
    public final static int  GET_DATA_NOT_NULL = 1010;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case GET_DATA_IS_NULL:
                    ToastUtil.showToast(OrderSearchActivity.this,"您输入的条件没有匹配的订单");

                    break;
                case GET_DATA_NOT_NULL:
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("respResult", (Serializable) msg.obj);
                    intent.putExtras(bundle);
                   // Log.e("tag",msg.obj.toString());
                    setResult(4,intent);
                    finish();
                    break;
            }
        }
    };

    @OnClick({R.id.search_label_key,R.id.title_bar_back,R.id.action_send_button,R.id.rl_order_start_date,R.id.rl_order_end_date})
    public void onViewClick(View view){
        switch (view.getId()){
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
            case R.id.search_label_key:
            showPopuWindow();
                break;
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.action_send_button:
               initData();
                break;
        }
    }
}
