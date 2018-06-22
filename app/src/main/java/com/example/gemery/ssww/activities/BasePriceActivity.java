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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.BasePriceBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasePriceActivity extends AppCompatActivity {

    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.bp_re_view)
    RecyclerView bpReView;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_price);
        ButterKnife.bind(this);
        titleBarTitle.setText("基础面价信息");
        titleOptionsTv.setText(R.string.search);
        initData();

        initView();
    }
    /*
    {
       "ima": {
              "s_pb00": "string,本经销商代码",
       },
        "pageSize": "11",
        "pageIndex": "1"
     }
     */
    private List<BasePriceBean.ListBean> listData = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    listData = (List<BasePriceBean.ListBean>) msg.obj;
                    mAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };


    private String upJson = "{ ima: {    },pageSize: 20,pageIndex: 1}";
    private  String get_data_url = Const.W_HOST +  "/api/salesData/getpbList";
    private void initData() {

        OkGo.<String>post(get_data_url)
                .tag(this)
                .upJson(upJson)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        BasePriceBean obj = GsonUtils.parseJSON(response.body(),BasePriceBean.class);
                        Log.e("tag",obj.toString());
                        Message msg = new Message();
                        msg.what = 1;
                        msg.obj = obj.getList();
                        handler.sendMessage(msg);

                    }
                });
    }
    private void initView(){
        bpReView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerView.Adapter<RecyclerView.ViewHolder>(){
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                        LayoutInflater.from(BasePriceActivity.this).inflate(R.layout.item_base_price,parent,false)
                ) {
                };
                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView)holder.itemView.findViewById(R.id.s_pb03))
                        .setText(listData.get(position).getS_pb03());
                ((TextView)holder.itemView.findViewById(R.id.s_pb09))
                        .setText(String.valueOf(listData.get(position).getS_pb09()));
                ((TextView)holder.itemView.findViewById(R.id.s_pb10))
                        .setText(String.valueOf(listData.get(position).getS_pb10()));
                ((TextView)holder.itemView.findViewById(R.id.s_pb11))
                        .setText(listData.get(position).getS_pb11());

                if(listData.get(position).getS_pb_confirm_state().equals("Y")){
//                    ((LinearLayout)holder.itemView.findViewById(R.id.ll_bp_price))
//                            .setBackgroundResource(R.drawable.arrow_drop_mini);
                }

                holder.itemView.findViewById(R.id.ll_bp_price).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("bpDetail",listData.get(position));
                        Intent intent = new Intent(BasePriceActivity.this,BPDetailActivity.class);
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
        bpReView.setAdapter(mAdapter);
    }

    @OnClick({R.id.title_bar_back,R.id.title_options_tv})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                Intent intent = new Intent(this,BPSearchActivity.class);
                intent.putExtra("action","BPSearchActivity");
                startActivity(intent);
                break;
        }
    }
}
