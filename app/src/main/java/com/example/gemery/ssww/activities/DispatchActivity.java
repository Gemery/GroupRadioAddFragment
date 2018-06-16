package com.example.gemery.ssww.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.gemery.ssww.bean.DtDispatchBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.WeiboDialogUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import org.w3c.dom.Text;

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
    private Dialog mWeiDialog;

    @BindView(R.id.show_empty_view)
    TextView tView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);
        ButterKnife.bind(this);

        titleBarTitle.setText(R.string.dispatch_order);
        titleOptionsTV.setText(R.string.search);
        dispatchReView.setPullRefreshEnable(false);
        initData();
        initView();
    }
   private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
    private void initView() {

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
                        .setText(listData.get(position).getS_sdt_h06());
                ((TextView)holder.itemView.findViewById(R.id.s_sdt_h02))
                        .setText(listData.get(position).getS_sdt_h02());
                ((TextView)holder.itemView.findViewById(R.id.s_sdt_h05))
                        .setText(listData.get(position).getS_sdt_h05());

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
   public final static int REQUEST_CODE = 1;
    public final static int RESULT_CODE = 4;
    @OnClick({R.id.title_options_tv, R.id.title_bar_back})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                Intent intent = new Intent(this,DispatchSearchActivity.class);
                startActivityForResult(intent,REQUEST_CODE);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_CODE){
            Bundle bundle = data.getExtras();
            DtDispatchBean obj = (DtDispatchBean) bundle.getSerializable("respResult");

            listData = obj.getList();
            //Log.e("tag",obj.toString());
            mAdapter.notifyDataSetChanged();

        }
    }



    private List<DtDispatchBean.ListBean> listData = new ArrayList<>();
    private String get_dispatch_order_url = Const.W_HOST+"/api/AfterSale/getSdtList";
    private String upJson = "{ ima: {    },pageSize: 20,pageIndex: 1}";

    private void initData() {

       mWeiDialog =  WeiboDialogUtils.createLoadingDialog(this,"正在加载中");
        OkGo.<String>post(get_dispatch_order_url)
                .tag(this)
                .upJson(upJson)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        DtDispatchBean obj = GsonUtils.parseJSON(response.body(), DtDispatchBean.class);
                        listData = obj.getList();

                        Log.e("|tag",listData.toString());
                        WeiboDialogUtils.closeDialog(mWeiDialog);
                        if(listData.size() == 0){
                            tView.setVisibility(View.VISIBLE);
                            tView.setText("没有你要的数据");
                        }else{
                            mAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Log.e("tag",response.getException().getMessage());
                        if("connect timed out".equals(response.getException().getMessage())){
                            WeiboDialogUtils.closeDialog(mWeiDialog);
                            tView.setVisibility(View.VISIBLE);
                            tView.setText("请检查网络是否链接正常");
                        }
                    }
                });
    }
}
