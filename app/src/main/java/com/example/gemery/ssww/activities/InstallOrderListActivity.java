package com.example.gemery.ssww.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.InstallOrdBen;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InstallOrderListActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.install_re_view)
    PullLoadMoreRecyclerView installReView;
    private String get_data_url = Const.W_HOST+"/api/AfterSale/getIstList";
    private String upJson = "{ ima: {    },pageSize: 20,pageIndex: 1}";
    private RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;
    private List<InstallOrdBen.ListBean> listData = new ArrayList<>();
    private final static int DATA_UPDATE = 100;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case DATA_UPDATE:
                    listData = (List<InstallOrdBen.ListBean>) msg.obj;
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install_order_list);
        ButterKnife.bind(this);
        titleBarTitle.setText("安装单列表");
        titleOptionsTv.setText(R.string.search);
        initData();
        initRecyclerView();
        installReView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        installReView.setPullLoadMoreCompleted();
                    }
                },1000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        installReView.setPullLoadMoreCompleted();
                    }
                },1000);
            }
        });
    }

    private void initRecyclerView() {
        installReView.setPullRefreshEnable(false);
        installReView.setLinearLayout();
        adapter = new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                        LayoutInflater.from(InstallOrderListActivity.this).inflate(R.layout.item_install_order,parent,false)
                ) {
                };
                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView)holder.itemView.findViewById(R.id.s_ist_h01))
                        .setText(listData.get(position).getS_ist_h01());
                ((TextView)holder.itemView.findViewById(R.id.s_ist_h06))
                        .setText(listData.get(position).getS_ist_h06());
                ((TextView)holder.itemView.findViewById(R.id.s_ist_h02))
                        .setText(listData.get(position).getS_ist_h02());
                ((TextView)holder.itemView.findViewById(R.id.s_ist_h05))
                        .setText(listData.get(position).getS_ist_h05());
                ((TextView)holder.itemView.findViewById(R.id.s_ist_h08))
                        .setText(listData.get(position).getS_ist_h08());

                holder.itemView.findViewById(R.id.ll_item_install).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(InstallOrderListActivity.this,InstOrdDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("installOrder",listData.get(position));
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
        installReView.setAdapter(adapter);
    }
    public final static int REQUEST_CODE = 1;
    @OnClick({R.id.title_bar_back,R.id.title_options_tv})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                Intent intent = new Intent(this,InstallSearchActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == 4){
            Bundle bundle = data.getExtras();
            InstallOrdBen ordBen = (InstallOrdBen) bundle.getSerializable("respResult");
            listData = ordBen.getList();
            adapter.notifyDataSetChanged();
        }
    }

    private void initData() {
        OkGo.<String>post(get_data_url)
                .tag(this)
                .upJson(upJson)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        InstallOrdBen obj = GsonUtils.parseJSON(response.body(), InstallOrdBen.class);
                        Message msg = new Message();
                        msg.what = DATA_UPDATE;
                        msg.obj = obj.getList();
                        mHandler.sendMessage(msg);
                    }
                });
    }

}
