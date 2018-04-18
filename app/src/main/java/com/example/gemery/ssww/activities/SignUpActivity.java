package com.example.gemery.ssww.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.util.Patterns;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.activities.SignInActivity;
import com.example.gemery.ssww.utils.HttpUtils;
import com.example.gemery.ssww.utils.ToastUtil;
import com.example.gemery.ssww.utils.XmppConnectionManager;
import com.example.gemery.ssww.utils.XmppUtil;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gemery.groupradioaddfragment.R2.id.password;

/**
 * Created by gemery on 2018/4/9.
 */

public class SignUpActivity extends Activity{

    @BindView(R.id.edit_sign_up_name)
    TextInputEditText mName = null;
    @BindView(R.id.edit_sign_up_email)
    TextInputEditText mEmail = null;
    @BindView(R.id.edit_sign_up_phone)
    TextInputEditText mPhone = null;
    @BindView(R.id.edit_sign_up_password)
    TextInputEditText mPassword = null;
    @BindView(R.id.edit_sign_up_re_password)
    TextInputEditText mRePassword = null;

    private String account;
    private String password_u;
    private SignUpActivity mContext;
    private ProgressDialog dialog;

    private Boolean checkForm(){
        final String name = mName.getText().toString();
        final String email = mEmail.getText().toString();
        final String phone = mPhone.getText().toString();
        final String password = mPassword.getText().toString();
        final String rePassword = mRePassword.getText().toString();

        boolean isPass = true;

        if(name.isEmpty()){
            mName.setError("请输入姓名");
            isPass = false;
        }else{
            mName.setError(null);
        }

        if(email.isEmpty() || Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        }else{
            mEmail.setError(null);
        }

        if(phone.isEmpty()|| phone.length()!=11){


            mPhone.setError("手机号码错误");
            isPass = false;
        }else{
            mPhone.setError(null);
        }

        if(password.isEmpty() || password.length() < 6){
            mPassword.setError("请填写至少六位数密码");
            isPass = false;
        }else{
            mPassword.setError(null);
        }

        if(rePassword.isEmpty() || rePassword.length() < 6 || !( rePassword.equals(password))){
            mRePassword.setError("密码验证错误");
            isPass = false;
        }else{
            mRePassword.setError(null);
        }
        return isPass;
    }
    @SuppressLint("HandlerLeak")
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //Dialog loadDialog;
            if(dialog.isShowing()){
                dialog.dismiss();
            }
            switch (msg.what) {
                case 0:
                    ToastUtil.showToast(mContext, "注册失败");
                    break;
                case 1:
                    ToastUtil.showToast(mContext, "注册成功，请牢记您的账号和密码");
                    //PreferencesUtils.putSharePre(mContext, "username", account);
                    //PreferencesUtils.putSharePre(mContext, "pwd", password);
                    //finish();
                    break;
                case 2:
                    ToastUtil.showToast(mContext, "该昵称已被注册");
                    break;
                case 3:
                    ToastUtil.showToast(mContext, "注册失败");
                    break;
                case 4:
                    ToastUtil.showToast(mContext, "注册失败,请检查您的网络");
                    break;
                default:
                    break;
            }
        }
    };
    @OnClick(R.id.btn_sign_up)
    void onClickSignUp(){
        Log.e("tag","listener  btn btn ");
        account = mEmail.getText().toString();
        password_u = mPassword.getText().toString();
        //if(!checkForm()){
        dialog.setTitle("正在注册...");
        dialog.setMessage("正在连接服务器中 ......");
        dialog.show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    XMPPConnection mXMPPConnection=xmppConnectionManager.init();
                    try {
                        Log.e("tage",mXMPPConnection.toString());
                        mXMPPConnection.connect();

                        int result= XmppUtil.register(mXMPPConnection, account, password_u);

                        mHandler.sendEmptyMessage(result);
                    } catch (XMPPException e) {
                        e.printStackTrace();
                        mHandler.sendEmptyMessage(4);
                    }
                }
            }).start();



            //网络请求验证
//            HttpUtils.Buider()
//                    .register(mName.getText().toString(),
//                            mEmail.getText().toString(),
//                            mPhone.getText().toString(),
//                            mPassword.getText().toString(),
//                            mRePassword.getText().toString(),
//                            new StringCallback() {
//                                @Override
//                                public void onSuccess(Response<String> response) {
//
//                                }
//
//                                @Override
//                                public void onError(Response<String> response) {
//
//                                    Log.e("tag","注册网络出错了");
//                                    super.onError(response);
//                                }
//                            });

        //}
    }
    @OnClick(R.id.tv_link_sign_in)
    void toLogin(){
        Intent intent=new Intent(SignUpActivity.this,SignInActivity.class);
        intent.putExtra("action","im_login");
        startActivity(intent);
        finish();

    }
    private XmppConnectionManager xmppConnectionManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_sign_up);
        ButterKnife.bind(this);
        mContext = this;
        xmppConnectionManager = XmppConnectionManager.getInstance();
        dialog = new ProgressDialog(this);

    }
}
