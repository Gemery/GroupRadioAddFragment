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
import com.example.gemery.ssww.bean.EmpPriceBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.PreferencesUtils;
import com.example.gemery.ssww.utils.WeiboDialogUtils;
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

public class EmpPListActivity extends AppCompatActivity {

    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.price_re_view)
    RecyclerView priceReView;
    private Dialog weiBoDialog;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_price_list);
        ButterKnife.bind(this);
        titleBarTitle.setText("价格条件列表");
        titleOptionsTv.setText(R.string.search);

        initData();
        initView();
    }

    private void initView() {
        priceReView.setLayoutManager(new LinearLayoutManager(this));

      mAdapter =  new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                        LayoutInflater.from(EmpPListActivity.this).inflate(R.layout.item_emp_plist_lv,parent,false)
                ) {
                };

                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView)holder.itemView.findViewById(R.id.s_pch02)).
                        setText(listData.get(position).getS_pch02());
                ((TextView)holder.itemView.findViewById(R.id.s_pch03_desc)).
                        setText(listData.get(position).getS_pch02_desc());
                long startTime = listData.get(position).getS_pch04();
                Date date1 = new Date(startTime);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = formatter.format(date1);

                long endTime = listData.get(position).getS_pch04();
                Date date2 = new Date(endTime);


                ((TextView)holder.itemView.findViewById(R.id.s_pch04)).
                        setText(dateString);
                ((TextView)holder.itemView.findViewById(R.id.s_pch05)).
                        setText(formatter.format(date2));


                holder.itemView.findViewById(R.id.ll_item_emp_price).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(EmpPListActivity.this,EmpPDetailActivity.class);
                        Bundle bundle  = new Bundle();
                        bundle.putSerializable("priceDetail",listData.get(position));
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

        priceReView.setAdapter(mAdapter);
    }

    private String getJsonDataUrl = Const.W_HOST + "/api/salesData/getpcFromUserCode?sw_code=";
    private List<EmpPriceBean> listData = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    listData = (List<EmpPriceBean>) msg.obj;
                    mAdapter.notifyDataSetChanged();
                   break;
            }

        }
    };


    private void initData() {
        // TODO 获得员工编号
         String sw_code = "300005001000101";
        getJsonDataUrl +=sw_code;
        weiBoDialog = WeiboDialogUtils.createLoadingDialog(this,"正在加载....");
        OkGo.<String>get(getJsonDataUrl)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WeiboDialogUtils.closeDialog(weiBoDialog);
                        //Log.e("tag",response.body());
                        List<EmpPriceBean> list = GsonUtils.jsonToArrayList(response.body(),EmpPriceBean.class);
                        Message msg = new Message();
                        msg.what = 1;
                        msg.obj = list;
                        handler.sendMessage(msg);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);

                    }
                });

    }
    public final static int REQUEST_CODE = 2;
    public final static int RESULT_CODE = 4;
    @OnClick({R.id.title_options_tv,R.id.title_bar_back})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                Intent intent = new Intent(EmpPListActivity.this,EmpPSearchActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_CODE){
            Bundle bundle = data.getExtras();
            listData = (List<EmpPriceBean>) bundle.getSerializable("respResult");
            mAdapter.notifyDataSetChanged();
        }

    }
}
