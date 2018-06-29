package com.example.gemery.ssww.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddHeaderActivity extends AppCompatActivity {

    @BindView(R.id.header_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.txt)
    TextView txt;
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_add_header);
        ButterKnife.bind(this);
        initData();
        initRecyclerView();
    }

    private List<String> listA = new ArrayList<>();
    private List<String> listB = new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    initRecyclerView();
                    break;
                case 2:
                    initRecyclerView();
                    break;
                default:

            }
        }
    };
    private boolean jk1 = false;
    private boolean jk2 = false;
    private void initData() {
        OkGo.<String>get("https://www.baidu.com")
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        listA.add("ATring");
                        jk1 = true;
                       Message msg = new Message();
                       msg.what = 1;
                       handler.sendMessage(msg);
                        Log.e("tag", "BBBB");

                    }
                });
        OkGo.<String>get("https://www.baidu.com")
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        listB.add("BTring");
                        Log.e("tag", "AAAAA");
                        jk2 = true;
                        Message msg = new Message();
                        msg.what = 2;
                        handler.sendMessage(msg);
                    }
                });

    }

    private void SetAdapter(){

    }

    private RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;

    public void initRecyclerView() {
        if (jk1 && jk2) {
            txt.setText(listA.get(0) + listB.get(0));
        }else{
            txt.setText("ABAB");
        }

    }
}
