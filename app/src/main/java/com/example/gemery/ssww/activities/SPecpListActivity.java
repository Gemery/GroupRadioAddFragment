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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.SPecpBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.WeiboDialogUtils;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SPecpListActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.specp_re_view)
    RecyclerView specpReView;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
    private Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spech);
        ButterKnife.bind(this);
        titleBarTitle.setText("特殊价格列表");
        titleOptionsTv.setText(R.string.search);
        initData();
        initView();

    }

    private void initView() {
        specpReView.setLayoutManager(new LinearLayoutManager(this));

       mAdapter =  new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                        LayoutInflater.from(SPecpListActivity.this).inflate(R.layout.item_specp_priceu,parent,false)
                ) {
                };
                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView) holder.itemView.findViewById(R.id.s_pecp_h02))
                        .setText(listData.get(position).getS_pecp_h02());
                ((TextView) holder.itemView.findViewById(R.id.s_pecp_h02_desc))
                        .setText(listData.get(position).getS_pecp_h02_desc());
                ((TextView) holder.itemView.findViewById(R.id.s_pecp_hconfirm))
                        .setText(listData.get(position).getS_pecp_hconfirm());
                ((TextView) holder.itemView.findViewById(R.id.s_pecp_h03))
                        .setText(listData.get(position).getS_pecp_h03());

                holder.itemView.findViewById(R.id.ll_item_spec).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SPecpListActivity.this,SPecpDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("specDetail",listData.get(position));
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });


            }

            @Override
            public int getItemCount() {
                return listData.size();
            }
        };
        specpReView.setAdapter(mAdapter);
    }
    @OnClick({R.id.title_bar_back,R.id.title_options_tv})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                Intent intent = new Intent(this,SPecpSearchActivity.class);
                intent.putExtra("action","---->");
                startActivity(intent);
                break;
        }
    }
    private List<SPecpBean> listData = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 1:
                    listData = (List<SPecpBean>)msg.obj;
                    mAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };

   private String getJsonStrUrl = Const.W_HOST +  "/api/salesData/seachPecpList";
    private String postJsonStr = "{ s_pecp_h00 : \"300005\"}";

    private void initData() {
        dialog = WeiboDialogUtils.createLoadingDialog(this,"正在加载中.....");
        OkGo.<String>post(getJsonStrUrl)
                .tag(this)
                .upJson(postJsonStr)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        dialog.dismiss();
                        List<SPecpBean> list = GsonUtils.jsonToArrayList(response.body(),SPecpBean.class);
                        Message msg = new Message();
                        msg.what = 1;
                        msg.obj = list;
                        handler.sendMessage(msg);
                    }
                });

    }


}
