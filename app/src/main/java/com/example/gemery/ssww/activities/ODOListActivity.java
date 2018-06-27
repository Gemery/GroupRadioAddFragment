package com.example.gemery.ssww.activities;

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
import com.example.gemery.ssww.bean.ODOBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ODOListActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.odo_re_view)
    RecyclerView odoReView;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odo_list);
        ButterKnife.bind(this);
        titleBarTitle.setText("出库单列表");
        titleOptionsTv.setText(R.string.search);

        initData();
        initView();
    }

    private List<ODOBean.ListBean> listData = new ArrayList<>();

    private void initView() {
        odoReView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                        LayoutInflater.from(ODOListActivity.this).inflate(R.layout.item_soga_dans,parent,false)
                ) {
                };
                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView) holder.itemView.findViewById(R.id.s_oga01))
                        .setText(listData.get(position).getS_oga01());
                ((TextView) holder.itemView.findViewById(R.id.s_oga04))
                        .setText(listData.get(position).getS_oga04());
                ((TextView) holder.itemView.findViewById(R.id.s_oga05))
                        .setText(listData.get(position).getS_oga05());
                ((TextView) holder.itemView.findViewById(R.id.s_oga06))
                        .setText(listData.get(position).getS_oga06());

                holder.itemView.findViewById(R.id.item_ll_odo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ODOListActivity.this,ODetailActivity.class);
                        intent.putExtra("odoNumber",listData.get(position).getS_oga01());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return listData.size();
            }
        };
        odoReView.setAdapter(mAdapter);

    }

    private String getOdoJsonUrl = Const.W_HOST + "/api/stockData/getOgaList";
    private String upJson = "{ ima: {    },pageSize: 20,pageIndex: 1}";

    private void initData() {
        OkGo.<String>post(getOdoJsonUrl)
                .tag(this)
                .upJson(upJson)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //Log.e("tag",response.body());
                        ODOBean obj = GsonUtils.parseJSON(response.body(), ODOBean.class);
                        Message msg = new Message();
                        msg.what = DATA_UPDATE;
                        msg.obj = obj;
                        handler.sendMessage(msg);
                    }
                });
    }

    private final static int DATA_UPDATE = 1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case DATA_UPDATE:
                    listData = ((ODOBean) msg.obj).getList();
                    mAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
}
