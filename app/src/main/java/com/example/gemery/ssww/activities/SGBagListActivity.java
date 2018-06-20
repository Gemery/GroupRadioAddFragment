package com.example.gemery.ssww.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.SGBagBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.WeiboDialogUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SGBagListActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.g_bag_re_view)
    RecyclerView gBagReView;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
    private Dialog weiBoDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gbag);
        ButterKnife.bind(this);
        titleBarTitle.setText("销售礼包列表");
        titleOptionsTv.setText(R.string.search);
        initData();
        initView();
    }

    private void initView() {
        gBagReView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                        LayoutInflater.from(SGBagListActivity.this).inflate(R.layout.item_sgbag_lv,parent,false)
                ) {
                };

                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView)holder.itemView.findViewById(R.id.s_gbag_h02)).
                        setText(listData.get(position).getS_gbag_h02());

                ((TextView)holder.itemView.findViewById(R.id.g_gbag_h03)).
                        setText(listData.get(position).getS_gbag_h03());

                ((TextView)holder.itemView.findViewById(R.id.s_gbag_h05)).
                        setText(listData.get(position).getS_gbag_h05());
                ((TextView)holder.itemView.findViewById(R.id.s_gbag_h09)).
                        setText(String.valueOf(listData.get(position).getS_gbag_h09()));
            }

            @Override
            public int getItemCount() {
                return listData.size();
            }
        };
        gBagReView.setAdapter(mAdapter);

    }
    private List<SGBagBean.ListBean> listData = new ArrayList<>();
    private String upJson = "{ ima: {    },pageSize: 20,pageIndex: 1}";
    private String getJsonStringUrl = Const.W_HOST + "/api/imaData/getgbag_hList";
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    listData = ((SGBagBean)msg.obj).getList();
                    mAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    private void initData() {
        weiBoDialog = WeiboDialogUtils.createLoadingDialog(this,"正在加载....");
        OkGo.<String>post(getJsonStringUrl)
                .tag(this)
                .upJson(upJson)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        weiBoDialog.dismiss();
                        SGBagBean obj = GsonUtils.parseJSON(response.body(),SGBagBean.class);
                        Log.e("tag",obj.toString());
                        Message msg = new Message();
                        msg.what = 1;
                        msg.obj = obj;
                        handler.sendMessage(msg);
                    }
                });

    }

    @OnClick({R.id.title_options_tv,R.id.title_bar_back})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                Intent intent = new Intent(this,SGBagActivity.class);
                intent.putExtra("action","to_sgbag_Activity");
                startActivity(intent);
                break;
        }
    }
}
