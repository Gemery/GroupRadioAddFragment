package com.example.gemery.ssww.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
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
import com.example.gemery.ssww.bean.EmpMsgBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.PreferencesUtils;
import com.example.gemery.ssww.utils.WeiboDialogUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmpMsgActivity extends AppCompatActivity implements PullLoadMoreRecyclerView.PullLoadMoreListener {
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
    private String test_url = Const.W_HOST+"/api/baseData/getPositionJsonStr?" + "s_p00=string&s_p_code=string";
    private String get_emp_list_url = Const.W_HOST+"/api/baseData/getPositionJsonStr?";

    private ArrayList<EmpMsgBean> listData = new ArrayList<>();
    private Dialog mWeiDialog;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_list);
        ButterKnife.bind(this);
        initData();

        initRecyclerView();

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
                Intent intent = new Intent(this,OrderingInfoActivity.class);
                intent.putExtra("action","to_custom_info_input");
               // startActivity(intent);
                break;
        }
    }
 
    private void initRecyclerView() {
        titleBarTitle.setText("员工信息资料");
        titleOptionsTv.setText("添加");

        customCv.setLinearLayout();
        //customCv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));



                adapter = new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder
                        = new RecyclerView.ViewHolder(LayoutInflater.from(EmpMsgActivity.this)
                        .inflate(R.layout.item_emp_msg,parent,false)) {
                };

                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView)holder.itemView.findViewById(R.id.s_p03)).
                        setText(listData.get(position).getS_p03());

                final int finalPostion = position;


            }

            @Override
            public int getItemCount() {
                return listData.size();
            }
        };
        customCv.setAdapter(adapter);

    }

    private String post_occ_list = "";

    private void initData() {

         String keyValue1 = "s_p00=" + PreferencesUtils.getSharePreStr(this,"ssww_code");
         String keyValue2 = "s_p_code=" + PreferencesUtils.getSharePreStr(this,"ssww_dp_number");
         get_emp_list_url = get_emp_list_url + keyValue1 + "&" + keyValue2 ;
         Log.e("tag",get_emp_list_url);
        mWeiDialog = WeiboDialogUtils.createLoadingDialog(this,"正在加载中");
        OkGo.<String>get(test_url)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WeiboDialogUtils.closeDialog(mWeiDialog);

                        ArrayList<EmpMsgBean> obj = GsonUtils.jsonToArrayList(response.body(), EmpMsgBean.class);
                        Message msg = new Message();
                        Log.e("tag",obj.toString());
                        msg.what = 2;
                        msg.obj = obj;
                        handler.sendMessage(msg);


                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Log.e("tag",response.getException().getMessage());
                        if("connect timed out".equals(response.getException().getMessage())){
                            WeiboDialogUtils.closeDialog(mWeiDialog);

                            AlertDialog dialog =  new AlertDialog.Builder(EmpMsgActivity.this)
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
                case 2:
                    listData = (ArrayList<EmpMsgBean>) msg.obj;
                    adapter.notifyDataSetChanged();
                    break;


            }
        }
    };

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
