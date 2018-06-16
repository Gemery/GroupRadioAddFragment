package com.example.gemery.ssww.activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.ConstResponse;
import com.example.gemery.ssww.bean.CustomMsg;
import com.example.gemery.ssww.bean.MsgList;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.PreferencesUtils;
import com.example.gemery.ssww.utils.SharedPreferencesUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// 终端客户信息 录入界面
public class OrderingInfoActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_bar_left)
    LinearLayout titleBarLeft;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.title_options_img)
    ImageView titleOptionsImg;
    @BindView(R.id.title_bar_right)
    RelativeLayout titleBarRight;
    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.edit_user_name)
    TextInputEditText editUserName;
    @BindView(R.id.edit_user_phone)
    TextInputEditText editUserPhone;
    @BindView(R.id.custom_text_label)
    TextView customTextLabel;
    @BindView(R.id.text_content_custom_emp)
    TextView textContentCustomEmp;
    @BindView(R.id.rl_custom_emp)
    RelativeLayout rlCustomEmp;
    @BindView(R.id.user_address)
    TextInputEditText userAddress;
    @BindView(R.id.text_label)
    TextView textLabel;
    @BindView(R.id.text_content_date)
    TextView textContentDate;
    @BindView(R.id.rl_custom)
    RelativeLayout rlCustom;
    @BindView(R.id.text_label1)
    TextView textLabel1;
    @BindView(R.id.text_content_)
    TextView textContent;
    @BindView(R.id.rl_custom_def)
    RelativeLayout rlCustomDef;
    @BindView(R.id.action_send_button)
    Button actionSendButton;
    // private String get_occ_url = "http://192.168.1.251:8091/api/baseData/getoccList";
    private String message_url = Const.W_HOST+"/api/baseData/occExq";
    //  java 代码的字符串引号是 双引号  代码提示是  Alt+Enter  ！！！！！！


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_info);
        ButterKnife.bind(this);

        initView();
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("终端客户资料录入");

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rlCustomDef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showPopupWindow();
                singleClick(view);
            }
        });
    }


    private void initView() {
        titleBarTitle.setText("终端客户资料录入");
        titleOptionsTv.setText("重置");

    }

    /**
     * 单选对话框
     *
     * @param v
     */
    private int checkedItem = 0; //默认选中的item

    public void singleClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setTitle("你选择的客户类型是：");
        String[] cities = {"个人客户", "公司客户", "工程客户"};

        builder.setSingleChoiceItems(cities, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                checkedItem = which;
                textContent.setText(cities[checkedItem]);
                dialog.dismiss();
            }
        });
        //设置正面按钮
//        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
        //设置反面按钮
//        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    @OnClick({R.id.action_send_button,R.id.title_bar_back,R.id.title_options_tv,R.id.rl_custom})
    public void onViewClick(View view) {
        switch (view.getId()){
            case R.id.rl_custom:
                DatePickerDialog datePicker = new DatePickerDialog(OrderingInfoActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // TODO Auto-generated method stub
                                textContentDate.setText(year + "/ " + (monthOfYear + 1) + "/ " + dayOfMonth);
                                Toast.makeText(OrderingInfoActivity.this,
                                        year + "/" + (monthOfYear + 1) + "/ " + dayOfMonth + "day",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }, 2018, 5, 20);
                datePicker.show();
                break;
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:

                break;
            case R.id.action_send_button:
                Log.e("tag", "onclick");
                CustomMsg mCustom = new CustomMsg();
                mCustom.setId(0);
                mCustom.setS_occ02(editUserName.getText().toString());
                mCustom.setS_occ03(editUserPhone.getText().toString());
                mCustom.setS_occ04(userAddress.getText().toString());
                mCustom.setS_occ11(textContentCustomEmp.getText().toString());
                mCustom.setS_occ04(userAddress.getText().toString());
                mCustom.setS_occ00(PreferencesUtils.getSharePreStr(this,"ssww_code"));
                mCustom.setS_occ_code(PreferencesUtils.getSharePreStr(this,"ssww_dp_number"));
                List<CustomMsg> list1 = new ArrayList<>();
                list1.add(mCustom);

                MsgList data = new MsgList();
                data.setFlage("1");
                data.setList(list1);
                Log.e("tag", data.toString());
                //TODO  提交表单请求到后台
                OkGo.<String>post(message_url)
                        .tag(this)
                        .upJson(data.toString())
                        // .upString("helloWorld")
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                Log.e("tag", response.body());
                                String json = response.body();
                                ConstResponse obj = GsonUtils.parseJSON(json, ConstResponse.class);
                                if (obj.getResultCode().equals("0")) {
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
                                if (obj.getResultCode().equals("9997")) {
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
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
