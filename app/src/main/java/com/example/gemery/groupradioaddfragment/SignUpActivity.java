package com.example.gemery.groupradioaddfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.util.Patterns;

import com.example.gemery.groupradioaddfragment.utils.HttpUtils;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gemery on 2018/4/9.
 */

public class SignUpActivity extends Activity{

    @Bind(R.id.edit_sign_up_name)
    TextInputEditText mName = null;
    @Bind(R.id.edit_sign_up_email)
    TextInputEditText mEmail = null;
    @Bind(R.id.edit_sign_up_phone)
    TextInputEditText mPhone = null;
    @Bind(R.id.edit_sign_up_password)
    TextInputEditText mPassword = null;
    @Bind(R.id.edit_sign_up_re_password)
    TextInputEditText mRePassword = null;

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

    @OnClick(R.id.btn_sign_up)
    void onClickSignUp(){
        Log.e("tag","listener  btn btn ");
        if(checkForm()){
            //网络请求验证
            HttpUtils.Buider()
                    .register(mName.getText().toString(),
                            mEmail.getText().toString(),
                            mPhone.getText().toString(),
                            mPassword.getText().toString(),
                            mRePassword.getText().toString(),
                            new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {

                                }

                                @Override
                                public void onError(Response<String> response) {

                                    Log.e("tag","注册网络出错了");
                                    super.onError(response);
                                }
                            });

        }
    }
    @OnClick(R.id.tv_link_sign_in)
    void toLogin(){
        Intent intent=new Intent(SignUpActivity.this,SignInActivity.class);
        intent.putExtra("action","im_login");
        startActivity(intent);
        finish();

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_sign_up);
        ButterKnife.bind(this);


    }
}
