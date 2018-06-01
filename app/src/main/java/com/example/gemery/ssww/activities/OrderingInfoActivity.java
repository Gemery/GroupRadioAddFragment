package com.example.gemery.ssww.activities;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.ConstResponse;
import com.example.gemery.ssww.bean.CustomMsg;
import com.example.gemery.ssww.bean.MsgList;
import com.example.gemery.ssww.utils.GsonUtils;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;

import org.json.JSONException;


import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class OrderingInfoActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
   @BindView(R.id.toolbar)
   Toolbar toolbar;
    private String message_url = "http://192.168.1.251:8091/api/baseData/occExq";
    //  java 代码的字符串引号是 双引号  代码提示是  Alt+Enter  ！！！！！！
    @BindView(R.id.action_send_button)
    Button action_send_button;
    @BindView(R.id.def_spinner)
    Spinner mSpinner;
    private String[] mItems;
    private PopupWindow pw;

    @BindView(R.id.user_def)
    TextView tvWeek;
   //CustomMsg[] list = new CustomMsg[1];
    @BindView(R.id.edit_user_name)
    TextInputEditText mUserName;
    @BindView(R.id.edit_user_phone)
    TextInputEditText mPhone;
    @BindView(R.id.edit_emp)
    TextInputEditText mEmp;
    @BindView(R.id.user_address)
    TextInputEditText mAddress;
    @BindView(R.id.order_message_number)
    TextInputEditText mOrderNum;



    private void  getFormData(){


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_ordering_info);
       ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("添加订单信息");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setOnMenuItemClickListener(this);

        mItems = getResources().getStringArray(R.array.user_def);

       //initSpinner();
        tvWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showPopupWindow();
                singleClick(view);
            }
        });
    }
    /**
     * 单选对话框
     *
     * @param v
     */
    private int checkedItem = 0; //默认选中的item
    public void singleClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("你选择的客户类型是：");
        String[] cities = {"个人客户", "公司客户", "工程客户"};

        builder.setSingleChoiceItems(cities, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                checkedItem = which;
                tvWeek.setText(cities[checkedItem]);
            }
        });
        //设置正面按钮
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        //设置反面按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void showPopupWindow(){
        View myView = getLayoutInflater().inflate(R.layout.pop_week, null);
        pw = new PopupWindow(myView, (int)(getApplicationContext().getResources().getDisplayMetrics().widthPixels),
                LinearLayout.LayoutParams.WRAP_CONTENT, true);
        //注意要设置背景（使用图片或者颜色），否则PopupWIndow会不显示
        pw.setBackgroundDrawable(new ColorDrawable(0xcccddd));
        pw.setFocusable(true);
        //将window视图显示在tvWeek下面
        pw.showAsDropDown(tvWeek);

        ListView lv = (ListView) myView.findViewById(R.id.lv_pop);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, mItems);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                tvWeek.setText(mItems[position]);
                if(pw != null){
                    pw.dismiss();
                }
            }
        });
    }

    private void initSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_dropdown_item, mItems);
        mSpinner.setAdapter(adapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //选择列表项的操作
                Toast.makeText(OrderingInfoActivity.this, "Click" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //未选中时候的操作
            }
        });

    }

    @OnClick(R.id.action_send_button)
    public void onViewClick(View view){
        Log.e("tag","onclick");
        CustomMsg mCustom = new CustomMsg();
        mCustom.setId(33333);
        mCustom.setS_occ00("string00");
        mCustom.setS_occ02("string02");
        mCustom.setS_occ03(mOrderNum.getText().toString());
        mCustom.setS_occ_code("String_code");
        List<CustomMsg> list1 = new ArrayList<>();
        list1.add(mCustom);

        MsgList data = new MsgList();
        data.setFlage("1");
        data.setList(list1);
        Log.e("tag",data.toString());
        //TODO  提交表单请求到后台
    OkGo.<String>post(message_url)
            .tag(this)
            .upJson(data.toString())
           // .upString("helloWorld")
            .execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    Log.e("tag",response.body());
                    String json = response.body();
                    ConstResponse obj = GsonUtils.parseJSON(json, ConstResponse.class);
                    if(obj.getResultCode().equals("0")){
                        new AlertDialog.Builder(OrderingInfoActivity.this)
                                .setTitle("上传到后台")
                                .setMessage("上传完成")
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                })
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                })
                                .create().show();
                    }
                    if(obj.getResultCode().equals("9997")){
                        new AlertDialog.Builder(OrderingInfoActivity.this)
                                .setTitle("上传到后台")
                                .setMessage("该用户资料已经存在，请重新输入")
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                })
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                })
                                .create().show();
                    }
                }

                @Override
                public void onError(Response<String> response) {

                    super.onError(response);
                }
            });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

}
