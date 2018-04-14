package com.example.gemery.groupradioaddfragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.example.gemery.groupradioaddfragment.utils.HttpUtils;
import com.joanzapata.iconify.widget.IconTextView;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gemery on 2018/4/3.
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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_sign_in);
        ButterKnife.bind(this);

        init();

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
        if(checkForm()){
            username=mEmail.getText().toString();
            password=mPassword.getText().toString();
            Log.e("tage",username);
            HttpUtils.Buider().login(username, password,
                    new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            //TODO
                            Log.e("tage",response.body());
                            try {
                                JSONObject object = new JSONObject(response.body());
                                Log.e("tage",object.toString());
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


}
