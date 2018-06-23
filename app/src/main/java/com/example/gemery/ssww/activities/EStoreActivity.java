package com.example.gemery.ssww.activities;

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
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.EStoreBean;
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

public class EStoreActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.custom_cv)
    PullLoadMoreRecyclerView customCv;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estore);
        ButterKnife.bind(this);
        titleBarTitle.setText("门店信息列表");
        titleOptionsTv.setText(R.string.search);

        initData();

        initView();
    }
    @OnClick({R.id.title_bar_back,R.id.title_options_tv})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;

        }
    }
    private void initView() {
      customCv.setLinearLayout();
      mAdapter = new RecyclerView.Adapter<RecyclerView.ViewHolder>(){
          @Override
          public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
              RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                      LayoutInflater.from(EStoreActivity.this).inflate(R.layout.item_estore_msg,parent,false)
              ) {
              };
              return holder;
          }

          @Override
          public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
              String address = listData.get(position).getS_est_address1();
                     address+=listData.get(position).getS_est_address2();
                     address+=listData.get(position).getS_est_address3();
                     address+=listData.get(position).getS_est_address4();

              ((TextView) holder.itemView.findViewById(R.id.s_est_address))
                        .setText(address);
              ((TextView) holder.itemView.findViewById(R.id.s_est_phone))
                        .setText(listData.get(position).getS_est_phone());
              ((TextView) holder.itemView.findViewById(R.id.s_est_name))
                        .setText(listData.get(position).getS_est_name());
          }

          @Override
          public int getItemCount() {
              return listData.size();
          }
      };
      customCv.setAdapter(mAdapter);
      customCv.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
          @Override
          public void onRefresh() {
              new Handler().postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      customCv.setPullLoadMoreCompleted();
                  }
              },1000);
          }

          @Override
          public void onLoadMore() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    customCv.setPullLoadMoreCompleted();
                }
            },1000);
          }
      });
    }
    private List<EStoreBean> listData = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                     listData = (List<EStoreBean>) msg.obj;
                    mAdapter.notifyDataSetChanged();
            }
        }
    };
    private String get_data_url = Const.W_HOST + "/api/baseData/getEstoreList";
    private void initData() {
        OkGo.<String>post(get_data_url)
                .tag(this)
                .upJson("{}")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                       // Log.e("tag",response.body());
                        List<EStoreBean> list = GsonUtils.jsonToArrayList(response.body(),EStoreBean.class);
                        Message msg = new Message();
                        msg.what = 1;
                        msg.obj  = list;
                        handler.sendMessage(msg);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);

                    }
                });

    }

}
