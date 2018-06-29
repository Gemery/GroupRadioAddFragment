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
import android.view.View;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.AppExample;
import com.example.gemery.ssww.MainActivity;
import com.example.gemery.ssww.bean.LoginResultInfoBean;
import com.example.gemery.ssww.service.MsfService;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.HttpUtils;
import com.example.gemery.ssww.utils.PreferencesUtils;
import com.example.gemery.ssww.utils.ToastUtil;
import com.joanzapata.iconify.widget.IconTextView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketIDFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
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

    private static Chat chat;


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

    private XMPPConnection connection;
    private BroadcastReceiver receiver;
    private SignInActivity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_sign_in);
        ButterKnife.bind(this);

        mContext = this;
        //initReceiver();
        initData();

    }

    private void initData() {
        loginDialog = new ProgressDialog(this);
        loginDialog.setTitle("提示");
        loginDialog.setMessage("正在请求服务器...");
        usersp = getSharedPreferences("user",0);
        if(!usersp.getString("username","").equals("") && !usersp.getString("userpsw","").equals("")){
            mEmail.setText(usersp.getString("username",""));
            mPassword.setText(usersp.getString("userpsw",""));
        }

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



    @OnClick({R.id.icon_sign_in_wechat,R.id.btn_sign_in})
    public void onClickView(View view){
        switch (view.getId()){
            case R.id.icon_sign_in_wechat:
                Intent intent=new Intent(SignInActivity.this,SignUpActivity.class);
                intent.putExtra("action","im_login");
                startActivity(intent);
                finish();
                break;

            case R.id.btn_sign_in:
        if(checkForm()){
           String username=mEmail.getText().toString();
            String password=mPassword.getText().toString();
            loginDialog.show();

           //start(Intent(this,MsfService.class)); //启动核心Service 建立长连接    reciver接受广播（携带后台状态码）做处理验证
            String login_url = Const.W_HOST + "/api/baseData/userSign?"+ "s_zx02=" + username + "&s_zx08=" + password;

            OkGo.<String>get(login_url)
                    .tag(this)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            loginDialog.dismiss();
                                LoginResultInfoBean object = GsonUtils.parseJSON(response.body(),LoginResultInfoBean.class);
                                if(object.getServerCode().getResultMessage().equals("登录成功")){
                                    // 第一次登陆  --->
                                    Log.e("tag","state->success");
                                    if(usersp.getString("username","").equals("")) {
                                        //usersp = getSharedPreferences("user", 0);
                                        SharedPreferences.Editor editor = usersp.edit();
                                        editor.putString("username", username);
                                        editor.putString("userpsw", password);
                                        editor.commit();
                                    }
                                    Intent intent=new Intent(SignInActivity.this,MainActivity.class);
                                    intent.putExtra("action","im_login");
                                    startActivity(intent);
                                    finish();
                                }
                               else if(object.getServerCode().getResultMessage().equals("登录用户名或密码不正确")){
                                    //mPassword.setError("登录用户名或密码不正确");
                                    Log.e("tag",login_url);

                                }
                        }
                        @Override
                        public void onError(Response<String> response) {
                            super.onError(response);
                        }
                    });
        }
        break;
        }

    }

    private boolean checkForm() {
         String email = mEmail.getText().toString();
         String password = mPassword.getText().toString();
        boolean isPass = true;

        if (email.isEmpty() || email.length() < 5) {
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



    public static void semdmessage(final String msg,final String msgto) {

        //³õÊ¼»¯·¢ËÍÏûÏ¢
        ChatManager chatManager = AppExample.xmppConnection.getChatManager();
        chat = chatManager.createChat(msgto, null);
        new Thread()
        {
            @Override
            public void run() {
                try {
                    chat.sendMessage(msg);
                    //sendhandlemsg(User,msg,true);
                } catch (XMPPException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //unregisterReceiver(receiver);
    }
}
