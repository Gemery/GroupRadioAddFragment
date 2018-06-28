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
import com.example.gemery.ssww.bean.SlockListBean;
import com.example.gemery.ssww.parambean.GListSlockParams;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SLockListActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    private final static String PAGE_SIZE = "20";
    @BindView(R.id.lk_ord_view)
    RecyclerView lkOrdView;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slock_list);
        ButterKnife.bind(this);
        titleBarTitle.setText("锁库存单列表");
        titleOptionsTv.setText(R.string.search);
        initData();
        initView();
    }

    private List<SlockListBean.ListBean> listData = new ArrayList<>();
    private void initView() {
        lkOrdView.setLayoutManager(new LinearLayoutManager(this));

       mAdapter =  new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                        LayoutInflater.from(SLockListActivity.this).inflate(R.layout.item_re_view_layout,parent,false)
                ){};

                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView)holder.itemView.findViewById(R.id.s_lock_h01))
                        .setText(listData.get(position).getS_lock_h01());
                ((TextView)holder.itemView.findViewById(R.id.s_lock_huser))
                        .setText(listData.get(position).getS_lock_huser());
                ((TextView)holder.itemView.findViewById(R.id.s_lock_hconfirm))
                        .setText(listData.get(position).getS_lock_hconfirm());
                if(listData.get(position).getS_lock_h04() != 0){
                    ((TextView)holder.itemView.findViewById(R.id.s_lock_h04))
                            .setText(new SimpleDateFormat("yyyy-MM-dd").
                                    format(new Date(listData.get(position).getS_lock_h04())));
                }else{
                    ((TextView)holder.itemView.findViewById(R.id.s_lock_h04))
                            .setText("未审核");
                }
                holder.itemView.findViewById(R.id.ll_item_review).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SLockListActivity.this,SLockDetailActivity.class);
                        intent.putExtra("orderNumber",listData.get(position).getS_lock_h01());
                        startActivity(intent);
                    }
                });




            }

            @Override
            public int getItemCount() {
                return listData.size();
            }
        };

       lkOrdView.setAdapter(mAdapter);

    }

    private String getDataUrl = Const.W_HOST + "/api/stockData/searchLockSkList";

    private String getUpJson() {
        GListSlockParams obj = new GListSlockParams();
        GListSlockParams.ImaBean innerObj = new GListSlockParams.ImaBean();
        obj.setIma(innerObj);
        obj.setPageIndex("1");
        obj.setPageSize(PAGE_SIZE);

        return obj.toString();
    }

    private String upJson = "{ ima:{},pageSize:20,pageIndex:1}";

    private void initData() {
        OkGo.<String>post(getDataUrl)
                .tag(this)
                .upJson(upJson)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //Log.e("tag", response.body());
                        SlockListBean obj = GsonUtils.parseJSON(response.body(),SlockListBean.class);
                        Message msg = new Message();
                        msg.what = DATA_UPDATE;
                        msg.obj = obj;
                        handler.sendMessage(msg);

                    }
                });

    }

    @OnClick({R.id.title_bar_back, R.id.title_options_tv})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                Intent intent = new Intent(this, SLockSearchActivity.class);
                startActivity(intent);
                break;
        }
    }
    private final static int DATA_UPDATE = 1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case DATA_UPDATE:
                    listData = ((SlockListBean)msg.obj).getList();
                    mAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
}
