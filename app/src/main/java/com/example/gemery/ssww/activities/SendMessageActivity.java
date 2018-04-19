package com.example.gemery.ssww.activities;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.AppExample;
import com.example.gemery.ssww.adapter.ChatAdapter;
import com.example.gemery.ssww.bean.Msg;
import com.example.gemery.ssww.db.ChatMsgDao;
import com.example.gemery.ssww.db.SessionDao;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.ToastUtil;
import com.example.gemery.ssww.utils.XmppUtil;

import org.jivesoftware.smack.XMPPException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by gemery on 2018/4/19.
 */

public class SendMessageActivity extends AppCompatActivity {
    private ListView mListView;
    private ChatAdapter mLvAdapter;

    //消息
    private List<Msg> listMsg;

    private ChatMsgDao msgDao;
    private SessionDao sessionDao;
    private SimpleDateFormat sd;
    private int offset;
    private String I,YOU;//为了好区分，I就是自己，YOU就是对方
    private BroadcastReceiver msgOperReciver;
    private Button btnSend;
    private EditText edtText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_chat);


        sd=new SimpleDateFormat("MM-dd HH:mm");
        msgDao=new ChatMsgDao(this);
        sessionDao=new SessionDao(this);
        msgOperReciver=new MsgOperReciver();
        IntentFilter intentFilter=new IntentFilter(Const.ACTION_MSG_OPER);
        registerReceiver(msgOperReciver, intentFilter);


        //initData();
        btnSend = (Button)findViewById(R.id.sendMessage);
        edtText = (EditText) findViewById(R.id.ed_input) ;


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showToast(SendMessageActivity.this,"onclick excute");
                I = "gemery";
                YOU = "xiaoming";
                String content = edtText.getText().toString();
                Log.e("jj","new Thread send message"+content);

                final String message=YOU+Const.SPLIT+I+Const.SPLIT+Const.MSG_TYPE_TEXT+Const.SPLIT+content+Const.SPLIT+sd.format(new Date());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            XmppUtil.sendMessage(AppExample.xmppConnection, message, YOU);
                        } catch (XMPPException e) {
                            e.printStackTrace();
                            Looper.prepare();
                            ToastUtil.showToast(SendMessageActivity.this, "发送失败");
                            Looper.loop();
                        }
                    }
                }).start();


            }
        });
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    mLvAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };


    public void initData(){
        offset=0;
        listMsg=msgDao.queryMsg(YOU,I,offset);
        offset=listMsg.size();
        mLvAdapter = new ChatAdapter(this, listMsg);
        mListView.setAdapter(mLvAdapter);
        mListView.setSelection(listMsg.size());
    }
    /**
     * 执行发送消息 文本类型
     * @param content
     */
    void sendMsgText(String content){
        Msg msg=getChatInfoTo(content, Const.MSG_TYPE_TEXT);
        msg.setMsgId(msgDao.insert(msg));
        listMsg.add(msg);
        offset=listMsg.size();
        mLvAdapter.notifyDataSetChanged();
        //input.setText("");
        final String message=YOU+Const.SPLIT+I+Const.SPLIT+Const.MSG_TYPE_TEXT+Const.SPLIT+content+Const.SPLIT+sd.format(new Date());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    XmppUtil.sendMessage(AppExample.xmppConnection, message, YOU);
                } catch (XMPPException e) {
                    e.printStackTrace();
                    Looper.prepare();
                    ToastUtil.showToast(SendMessageActivity.this, "发送失败");
                    Looper.loop();
                }
            }
        }).start();
        //updateSession(Const.MSG_TYPE_TEXT,content);
    }

    /**
     * 发送的信息
     *  from为收到的消息，to为自己发送的消息
     * @param message => 接收者卍发送者卍消息类型卍消息内容卍发送时间
     * @return
     */
    private Msg getChatInfoTo(String message,String msgtype) {
        String time=sd.format(new Date());
        Msg msg = new Msg();
        msg.setFromUser(YOU);
        msg.setToUser(I);
        msg.setType(msgtype);
        msg.setIsComing(1);
        msg.setContent(message);
        msg.setDate(time);
        return msg;
    }
    /**
     * 接收消息记录操作广播：删除复制
     * @author baiyuliang
     */
    private class MsgOperReciver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int type=intent.getIntExtra("type", 0);
            final int position=intent.getIntExtra("position", 0);
            if(listMsg.size()<=0){
                return;
            }
            final Msg msg=listMsg.get(position);
            switch (type) {
                case 1://聊天记录操作
                    AlertDialog.Builder bd = new AlertDialog.Builder(SendMessageActivity.this);
                    String[] items=null;
                    if(msg.getType().equals(Const.MSG_TYPE_TEXT)){
                        items =  new String[]{"删除记录","删除全部记录","复制文字"};
                    }else{
                        items =  new String[]{"删除记录","删除全部记录"};
                    }
                    bd.setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            switch (arg1) {
                                case 0://删除
                                    listMsg.remove(position);
                                    offset=listMsg.size();
                                    mLvAdapter.notifyDataSetChanged();
                                    msgDao.deleteMsgById(msg.getMsgId());
                                    break;
                                case 1://删除全部
                                    listMsg.removeAll(listMsg);
                                    offset=listMsg.size();
                                    mLvAdapter.notifyDataSetChanged();
                                    msgDao.deleteTableData();
                                    break;
                                case 2://复制
                                    ClipboardManager cmb = (ClipboardManager) SendMessageActivity.this.getSystemService(SendMessageActivity.CLIPBOARD_SERVICE);
                                    cmb.setText(msg.getContent());
                                    Toast.makeText(getApplicationContext(), "已复制到剪切板", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });
                    bd.show();
                    break;
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(msgOperReciver);

    }
}
