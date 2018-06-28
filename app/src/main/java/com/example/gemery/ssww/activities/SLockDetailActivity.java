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
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.adapter.SlockOrderDetailAdapter;
import com.example.gemery.ssww.bean.SLockBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SLockDetailActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.det_review)
    RecyclerView detReview;
    private SlockOrderDetailAdapter mAdapter;
    private View viewHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slock_detail);
        ButterKnife.bind(this);
        titleBarTitle.setText("锁库存单详情");
        titleOptionsTv.setText("编辑");
        initData();
        //initView();
    }
    private String getDataUrl = Const.W_HOST + "/api/stockData/getLockSkList?orderNum=";
    private void initData() {
        Intent  intent = getIntent();
        String orderNumber = intent.getStringExtra("orderNumber");
        OkGo.<String>get(getDataUrl+orderNumber)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        SLockBean obj = GsonUtils.parseJSON(response.body(),SLockBean.class);
                        Log.e("tag",obj.getFlage());
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
                    SLockBean obj = (SLockBean) msg.obj;
                    listData = obj.getLock_e_list();
                    oData = obj.getLock_h_list().get(0);
//                    mAdapter.notifyDataSetChanged();
                    initView();
                    break;
            }
        }
    };
    private  SLockBean.LockHListBean oData = new SLockBean.LockHListBean();
   private  List<SLockBean.LockEListBean> listData = new ArrayList<>();
    private  void initView(){
        detReview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SlockOrderDetailAdapter(listData,this);
        initViewHeader();
        detReview.setAdapter(mAdapter);
        mAdapter.addHeaderView(viewHeader);

    }

    private void initViewHeader(){
        viewHeader = LayoutInflater.from(this).inflate(R.layout.ab_item_slock_dt,null);
        ((TextView)viewHeader.findViewById(R.id.s_lock_h01))
                .setText(oData.getS_lock_h01());
        ((TextView)viewHeader.findViewById(R.id.s_lock_h02))
                .setText(oData.getS_lock_h02());
        ((TextView)viewHeader.findViewById(R.id.s_lock_h03))
                .setText(oData.getS_lock_h03());
        ((TextView)viewHeader.findViewById(R.id.s_lock_hconfirm))
                .setText(oData.getS_lock_hconfirm());
        ((TextView)viewHeader.findViewById(R.id.s_lock_huser))
                .setText(oData.getS_lock_huser());

        if((oData.getS_lock_h04()).equals("0")){
            ((TextView)viewHeader.findViewById(R.id.s_lock_h04))
                    .setText("未审核");

        }else{
            long time = Long.parseLong(oData.getS_lock_h04());
            ((TextView)viewHeader.findViewById(R.id.s_lock_h04))
                    .setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(time)));
        }

        long time2 = Long.parseLong(oData.getS_lock_hsdate());
        ((TextView)viewHeader.findViewById(R.id.s_lock_hsdate))
        .setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(time2)));

        long time3 = Long.parseLong(oData.getS_lock_hedate());
        ((TextView)viewHeader.findViewById(R.id.s_lock_hedate))
               .setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(time3)));
    }

    @OnClick({R.id.title_options_tv,R.id.title_bar_back})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
        }
    }
}
