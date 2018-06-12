package com.example.gemery.ssww.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.DtDispatchBean;
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

public class DispatchActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTV;
    @BindView(R.id.dispatch_re_view)
    PullLoadMoreRecyclerView dispatchReView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);
        ButterKnife.bind(this);

        initData();
        initView();
    }
   private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
    private void initView() {
        titleBarTitle.setText(R.string.dispatch_order);
        titleOptionsTV.setText(R.string.search);
        dispatchReView.setPullRefreshEnable(false);
        mAdapter = new RecyclerView.Adapter<RecyclerView.ViewHolder>(){
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                    LayoutInflater.from(DispatchActivity.this).inflate(R.layout.item_dispatch_dantou,
                                parent,false)
                ) {
                };
                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView)holder.itemView.findViewById(R.id.s_sdt_h01))
                        .setText(listData.get(position).getS_sdt_h01());
                ((TextView)holder.itemView.findViewById(R.id.s_sdt_h04))
                        .setText(listData.get(position).getS_sdt_h04());
                ((TextView)holder.itemView.findViewById(R.id.s_sdt_h06))
                        .setText(listData.get(position).getS_sdt_h05());
                ((TextView)holder.itemView.findViewById(R.id.s_sdt_h06))
                        .setText(listData.get(position).getS_sdt_h07());
                ((TextView)holder.itemView.findViewById(R.id.s_sdt_h02))
                        .setText(listData.get(position).getS_sdt_h02());
                holder.itemView.findViewById(R.id.item_order_ll).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(DispatchActivity.this,DispatchOrderDetailActivity.class);
                        intent.putExtra("orderNum",listData.get(position).getS_sdt_h01());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return listData.size();
            }
        };

        dispatchReView.setLinearLayout();
        dispatchReView.setAdapter(mAdapter);

    }

    @OnClick({R.id.title_options_tv, R.id.title_bar_back})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
        }
    }

    private List<DtDispatchBean.ListBean> listData = new ArrayList<>();
    private String get_dispatch_order_url = "http://192.168.1.251:8091/api/AfterSale/getSdtList";
    private String upJson = "{ ima: {    },pageSize: 20,pageIndex: 1}";

    private void initData() {
        OkGo.<String>post(get_dispatch_order_url)
                .tag(this)
                .upJson(upJson)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        DtDispatchBean obj = GsonUtils.parseJSON(response.body(), DtDispatchBean.class);
                        listData = obj.getList();

                        mAdapter.notifyDataSetChanged();
                    }
                });
    }
}
