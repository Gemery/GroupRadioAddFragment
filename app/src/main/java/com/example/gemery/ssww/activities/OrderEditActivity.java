package com.example.gemery.ssww.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.ConstResponse;
import com.example.gemery.ssww.utils.Constants;
import com.example.gemery.ssww.utils.GsonUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderEditActivity extends AppCompatActivity {

    @BindView(R.id.edit_user_name)
    TextInputEditText editUserName;
    @BindView(R.id.custom_phone)
    TextInputEditText customPhone;
    @BindView(R.id.custom_address)
    TextInputEditText customAddress;
    @BindView(R.id.emp_number)
    TextInputEditText empNumber;
    @BindView(R.id.ps_date)
    TextInputEditText psDate;
    @BindView(R.id.order_number)
    TextInputEditText orderNumber;
    @BindView(R.id.action_send_button)
    Button actionSendButton;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_edit_order);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        titleOptionsTv.setText("重置");
    }

    @OnClick({R.id.action_send_button, R.id.title_bar_back, R.id.title_options_tv})
    public void onViewClick(View v) {
        Log.e("tag", "onclick");
        switch (v.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                // 重置 TODO 所有的属性
                break;
            case R.id.action_send_button:
                OkGo.<String>post(Constants.EDIT_ORDER_URL)
                        .tag(OrderEditActivity.this)
                        .upJson(Constants.EDIT_POST_JSON)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                Log.e("tag", response.body());
                                ConstResponse rep = GsonUtils.parseJSON(response.body(), ConstResponse.class);
                                if (rep.getResultCode().equals("0")) {

                                    new AlertDialog.Builder(OrderEditActivity.this)
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
                                                    finish();
                                                }
                                            })
                                            .create().show();
                                }


                            }

                            @Override
                            public void onError(Response<String> response) {
                                Log.e("tag", response.getException().getMessage());
                                super.onError(response);
                            }
                        });
                break;
        }
    }
}
