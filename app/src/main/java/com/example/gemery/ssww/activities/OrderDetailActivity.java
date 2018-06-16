package com.example.gemery.ssww.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.adapter.MyAdapter;
import com.example.gemery.ssww.adapter.MyOrderDtailAdapter;
import com.example.gemery.ssww.bean.OeaBen;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.ToastUtil;
import com.example.gemery.ssww.view.LoadMoreRecyclerView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDetailActivity extends AppCompatActivity  {
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.order_detail_rc)
    RecyclerView orderDetailRc;
    private final String get_one_order_url = Const.W_HOST+"/api/Order/getStandardList?orderNum=";

    private List<OeaBen.OebListBean> list = new ArrayList<>();

    private OeaBen.OeaListBean dtBean = new OeaBen.OeaListBean();
    private MyOrderDtailAdapter mAdapter;
    private View viewHeader;
    private TextView textContentBH;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);

        initData();
        //initView();
    }

    private void initData() {
        Intent intent = getIntent();
        String orderNum = intent.getStringExtra("orderNum");
        OkGo.<String>get(get_one_order_url + orderNum)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //Log.e("tag",response.body());
                        OeaBen oeaBen = GsonUtils.parseJSON(response.body(),OeaBen.class);
                        list = oeaBen.getOebList();
                        dtBean = oeaBen.getOeaList().get(0);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initView();
                            }
                        });
                    }
                });
    }
    private  void initView(){
        titleBarTitle.setText("订单详细信息");
        titleOptionsTv.setText("编辑");
        orderDetailRc.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new MyOrderDtailAdapter(list, this);
        orderDetailRc.setAdapter(mAdapter);
        // 初始recyclerView 头部
        initRecylerViewHeader();

        mAdapter.addHeaderView(viewHeader);


    }

    private void initRecylerViewHeader() {
        viewHeader = LayoutInflater.from(this).inflate(R.layout.item_order_detail_dantou,null);
        textContentBH = (TextView) viewHeader.findViewById(R.id.text_content_bh);
        TextView csName = (TextView) viewHeader.findViewById(R.id.content_cs_name);
        TextView   currentDate = (TextView) viewHeader.findViewById(R.id.text_content_date);
        TextView csEmp = (TextView) viewHeader.findViewById(R.id.text_content_emp_code);
        TextView csPhone = (TextView) viewHeader.findViewById(R.id.content_cs_phone);
        TextView customAddress = (TextView) viewHeader.findViewById(R.id.content_cs_address);

        textContentBH.setText(dtBean.getS_oea01());
        csName.setText(dtBean.getS_oea04());
        currentDate.setText(dtBean.getS_oea07());
        csEmp.setText(dtBean.getS_oea06());
        csPhone.setText(dtBean.getS_oea03());
        customAddress.setText(dtBean.getS_oea05());
    }

    @OnClick({R.id.title_bar_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
        }
    }


}
