package com.example.gemery.ssww.activities;

import android.app.AlertDialog;
import android.app.Dialog;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.CustomMsg;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.WeiboDialogUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomInfoListActivity extends AppCompatActivity implements PullLoadMoreRecyclerView.PullLoadMoreListener {
    @BindView(R.id.custom_cv)
    PullLoadMoreRecyclerView customCv;
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_bar_left)
    LinearLayout titleBarLeft;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.title_options_img)
    ImageView titleOptionsImg;
    @BindView(R.id.title_bar_right)
    RelativeLayout titleBarRight;
    @BindView(R.id.title)
    LinearLayout title;
    private String get_occ_list = Const.W_HOST+"/api/baseData/getoccList";
    private ArrayList<CustomMsg> listData;
    private Dialog mWeiDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_info_list);
        ButterKnife.bind(this);
        initData();
       // initRecyclerView();

        customCv.setOnPullLoadMoreListener(this);
        customCv.setFooterViewText("Loading");
        customCv.setFooterViewBackgroundColor(R.color.white);
    }
    @OnClick({R.id.title_bar_back,R.id.title_options_tv})
    public void onClickView(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                Intent intent = new Intent(this,CustomEditAcdtivity.class);
                intent.putExtra("action","to_custom_info_input");
                startActivity(intent);
                break;
        }
    }

    private void initRecyclerView() {
        titleBarTitle.setText("终端客户资料");
        titleOptionsTv.setText("添加");

        customCv.setLinearLayout();
        //customCv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        customCv.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder
                        = new RecyclerView.ViewHolder(LayoutInflater.from(CustomInfoListActivity.this)
                        .inflate(R.layout.item_custom_info_ll,parent,false)) {
                };

                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView)holder.itemView.findViewById(R.id.s_occ02)).
                        setText(listData.get(position).getS_occ02());
                ((TextView)holder.itemView.findViewById(R.id.s_occ_04)).
                        setText(listData.get(position).getS_occ04());
                // 建立资料的时间
                ((TextView)holder.itemView.findViewById(R.id.s_occ05)).
                        setText(listData.get(position).getS_occ04());
                // 对应业务员
                ((TextView)holder.itemView.findViewById(R.id.text_content_emp_code)).
                        setText(listData.get(position).getS_occ11());
                final int finalPostion = position;
                holder.itemView.findViewById(R.id.item_order_linear_layout)
                        .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(CustomInfoListActivity.this,CustomDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("customBean",(Serializable) listData.get(finalPostion));
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });

            }

            @Override
            public int getItemCount() {
                return listData.size();
            }
        });

    }

    private String post_occ_list = "{\n" +
            "s_occ11:\"string,业务员\"\n" +
            "}";

    private void initData() {
        Log.e("tag","11-->initdata");
        mWeiDialog = WeiboDialogUtils.createLoadingDialog(this,"正在加载中");
        OkGo.<String>post(get_occ_list)
                .tag(this)
                .upJson(post_occ_list)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WeiboDialogUtils.closeDialog(mWeiDialog);
                         listData = GsonUtils.jsonToArrayList(response.body(),CustomMsg.class);
                        //Log.e("tag",listData.toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initRecyclerView();
                            }
                        });
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Log.e("tag",response.getException().getMessage());
                        if("connect timed out".equals(response.getException().getMessage())){
                            WeiboDialogUtils.closeDialog(mWeiDialog);

                          AlertDialog dialog =  new AlertDialog.Builder(CustomInfoListActivity.this)
                                   .create();

                          dialog.setMessage("请检查网络是否正常");
                        }
                    }
                });
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                customCv.setPullLoadMoreCompleted();
            }
        },2000);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:

                    break;
            }
        }
    };
    private void loadMoreData(){

    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                customCv.setPullLoadMoreCompleted();
            }
        },2000);
    }
}
