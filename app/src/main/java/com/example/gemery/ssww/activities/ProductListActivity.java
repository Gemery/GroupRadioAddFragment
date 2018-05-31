package com.example.gemery.ssww.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.CreationsString;
import com.example.gemery.ssww.bean.CustomMsg;
import com.example.gemery.ssww.bean.MutiOrderMessage;
import com.example.gemery.ssww.utils.GsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductListActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.filter_linear_layout)
    LinearLayout filterLinearLayout;

    @BindView(R.id.filter_first)
    TextView filterFirst;
    @BindView(R.id.filter_second)
    TextView filterSecond;
    @BindView(R.id.filter_three)
    TextView filterThree;
    private PopupWindow mPopWindow;
    @BindView(R.id.list_recyclerview)
    RecyclerView mRecyclerView;


    private String get_data_url = "http://192.168.1.251:8091/api/baseData/getoccList";
    //private MutiOrderMessage data;
    private List<CustomMsg> data = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ButterKnife.bind(this);

        initDatas();
        initRecyclerView();

    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                        LayoutInflater.from(ProductListActivity.this).inflate(R.layout.proudct_item,parent,false
                        )){};
                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView) holder.itemView.findViewById(R.id.item_name)).setText(data.get(position).getS_occ00());

                        ((TextView) holder.itemView.findViewById(R.id.item_price))
                        .setText(data.get(position).getS_occ02());

                        ((TextView) holder.itemView.findViewById(R.id.item_des))
                        .setText(data.get(position).getS_occ03());
            }

            @Override
            public int getItemCount() {
                return data.size();
            }
        });

    }

    private void initDatas() {
        Log.e("tag","initDatas");
        OkGo.<String>post(get_data_url)
                .params("id","11")
                .params("s_occ00","string")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String json = response.body();
                        Log.e("tag111",json);
                    try {
                        data = GsonUtils.jsonToArrayList(json, CustomMsg.class);
                        Log.e("tag", data.toString());

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        Log.e("tag",response.getException().getMessage());
                        super.onError(response);
                    }
                });

    }

    @OnClick({R.id.filter_three,R.id.filter_second,R.id.filter_first,R.id.btn_search})
    public void onClickedView(View view){
        switch(view.getId()){
            case R.id.filter_first:
                showPopupWindow();
                break;

            case R.id.btn_search:
                Intent intent = new Intent(this,OrderingInfoActivity.class);
                intent.putExtra("action","go to OrderingActivity");
                startActivity(intent);
                break;
        }
    }

    private void showPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(ProductListActivity.this).inflate(R.layout.poplyaout, null);
        mPopWindow = new PopupWindow(contentView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setContentView(contentView);
        //设置各个控件的点击响应
        TextView tv1 = (TextView)contentView.findViewById(R.id.pop_computer);
        TextView tv2 = (TextView)contentView.findViewById(R.id.pop_financial);
        TextView tv3 = (TextView)contentView.findViewById(R.id.pop_manage);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        //显示PopupWindow

        //View rootview = LayoutInflater.from(ProductListActivity.this).inflate(R.layout.main, null);
       // mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
        mPopWindow.showAsDropDown(filterLinearLayout);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.pop_computer:{
                Toast.makeText(this,"clicked computer",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
            }
            break;
            case R.id.pop_financial:{
                Toast.makeText(this,"clicked financial",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
            }
            break;
            case R.id.pop_manage:{
                Toast.makeText(this,"clicked manage", Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
            }
            break;
        }
    }


}
