package com.example.gemery.groupradioaddfragment.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.util.Patterns;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.gemery.groupradioaddfragment.R;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gemery on 2018/4/9.
 */

public class SignInDelegate extends Activity {
    @BindView(R.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R.id.edit_sign_in_password)
    TextInputEditText mPassword = null;
    @BindView(R.id.email)
    AutoCompleteTextView email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.email_sign_in_button)
    Button emailSignInButton;
    @BindView(R.id.email_login_form)
    LinearLayout emailLoginForm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
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

    @OnClick(R.id.btn_sign_in)
    void onClickSignIn() {
        if (checkForm()) {
            HttpUtils.Buider().login(mEmail.getText().toString(),
                    mPassword.getText().toString(),
                    new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {

                        }

                        @Override
                        public void onError(Response<String> response) {
                            super.onError(response);

                            Log.e("tag", "登录出错了");
                        }
                    });
        }
    }

}
