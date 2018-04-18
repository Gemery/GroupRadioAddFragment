package com.example.gemery.ssww.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.MainActivity;
import com.example.gemery.ssww.service.MsfService;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.HttpUtils;
import com.example.gemery.ssww.utils.PreferencesUtils;
import com.example.gemery.ssww.utils.ToastUtil;
import com.joanzapata.iconify.widget.IconTextView;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketIDFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Registration;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gemery on 2018/4/16.
 */

public class SignInActivity extends Activity {

    @BindView(R.id.edit_sign_in_email)
    TextInputEditText mEmail;
    @BindView(R.id.edit_sign_in_password)
    TextInputEditText mPassword;
    @BindView(R.id.btn_sign_in)
    AppCompatButton btnSignIn;
    @BindView(R.id.tv_link_sign_up)
    AppCompatTextView tvLinkSignUp;
    @BindView(R.id.icon_sign_in_wechat)
    IconTextView iconSignInWechat;

    SharedPreferences usersp;
    private ProgressDialog loginDialog;
    private String username;
    private String password;
    private XMPPConnection connection;
    private BroadcastReceiver receiver;
    private SignInActivity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_sign_in);
        ButterKnife.bind(this);
        mContext = this;
        initReceiver();
        init();

    }

    private void initReceiver() {
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals(Const.ACTION_IS_LOGIN_SUCCESS)){
                    if(loginDialog.isShowing()){
                        loginDialog.dismiss();
                    }
                    boolean isLoginSuccess=intent.getBooleanExtra("isLoginSuccess", false);
                    if(isLoginSuccess){//登录成功
                        Intent intent2=new Intent(mContext,MainActivity.class);
                        startActivity(intent2);
                        finish();
                    }else{
                        ToastUtil.showToast(mContext, "登录失败，请检您的网络是否正常以及用户名和密码是否正确");
                    }
                }
            }
        };
        //注册广播接收者
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(Const.ACTION_IS_LOGIN_SUCCESS);
        registerReceiver(receiver, mFilter);


    }


    protected void init() {
        usersp=getSharedPreferences("user",0);
        if (!usersp.getString("username","").equals("")&&!usersp.getString("userpsw","").equals("")){
            mEmail.setText(usersp.getString("username",""));
            mPassword.setText(usersp.getString("userpsw",""));
        }
        loginDialog=new ProgressDialog(this);
        loginDialog.setTitle("提示");
        loginDialog.setMessage("正在请求服务器，请稍后");

    }
    @OnClick(R.id.btn_sign_in)
    public void onClickView(){


        if(!checkForm()){
            username=mEmail.getText().toString();
            password=mPassword.getText().toString();


            PreferencesUtils.putSharePre(mContext, "username", username);
            PreferencesUtils.putSharePre(mContext, "pwd", password);
            loginDialog.show();
            //启动核心Service
            Intent intent=new Intent(this,MsfService.class);
            startService(intent);


            HttpUtils.Buider().login(username, password,
                    new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            loginDialog.dismiss();
                            //TODO
                           // Log.e("tage",response.body());
                            try {
                                JSONObject object = new JSONObject(response.body());
                                //Log.e("tage",object.toString());
                                if(object.getString("success").equals("true")){
                                    // 第一次登陆  ---》
                                    usersp=getSharedPreferences("user",0);
                                    SharedPreferences.Editor editor = usersp.edit();
                                    //editor.putString("uid", object.getString("g_uid"));
                                    editor.putString("username", username);
                                    editor.putString("userpsw", password);
                                    editor.commit();

                                    Intent intent=new Intent(SignInActivity.this,MainActivity.class);
                                    intent.putExtra("action","im_login");
                                    startActivity(intent);
                                    finish();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(Response<String> response) {
                            super.onError(response);
                            //TODO
                        }
                    });

        }


    }

//    @OnClick(R.id.tv_link_sign_in)
//    public void onLinkClick(){
//        Intent intent=new Intent(SignInActivity.this,SignUpActivity.class);
//        intent.putExtra("action","to_sign_up");
//        startActivity(intent);
//        finish();
//    }

    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;

        if (email.isEmpty() || email.length() < 6) {
            mEmail.setError("请输入正确的用户名 ");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        return isPass;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(receiver);
    }
}
