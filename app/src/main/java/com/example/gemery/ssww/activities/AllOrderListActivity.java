package com.example.gemery.ssww.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
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
import com.example.gemery.ssww.bean.DtOrderBean;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.ToastUtil;
import com.example.gemery.ssww.utils.WeiboDialogUtils;
import com.example.gemery.ssww.view.LoadMoreRecyclerView;
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

public class AllOrderListActivity extends AppCompatActivity {
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
    @BindView(R.id.all_order_recycler_view)
    PullLoadMoreRecyclerView allOrderRecyclerView;
    private int pageSize;
    private int totalCount;

    private String get_all_order_url = "http://192.168.1.251:8091/api/Order/getAllstdOrders";
    private int count = 1;
    private  String POST_PARAMS_JSON = "{ima:{},pageSize: 5,pageIndex:" + count + "}";
    private List<DtOrderBean.ListBean> listData = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private Dialog mWeiboDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_order_list);
        ButterKnife.bind(this);
        initData();
        initView();
       // allOrderRecyclerView.setPullRefreshEnable(false);
        allOrderRecyclerView.setFooterViewText("loading");
       allOrderRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
           @Override
           public void onRefresh() {
             initData();
             allOrderRecyclerView.setPullLoadMoreCompleted();
           }

           @Override
           public void onLoadMore() {
                        count++;
                        if(count > pageSize){
                            ToastUtil.showToast(AllOrderListActivity.this," 没有更多数据加载了");
                            allOrderRecyclerView.setPullLoadMoreCompleted();
                            return;
                        }
                        String post_json = "{ima:{},pageSize: 5,pageIndex:" + count + "}";
                        loadMoreData(post_json);


           }
       });
    }
    private void loadMoreData(String postJson){
        Log.e("tag",postJson);
        OkGo.<String>post(get_all_order_url)
                .tag(this)
                .upJson(postJson)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        DtOrderBean obj = GsonUtils.parseJSON(response.body(),DtOrderBean.class);

//                        if(obj.getList()==null){
//                            allOrderRecyclerView.setFooterViewText("没有数据加载了");
//                            return;
//                        }
                        listData.addAll(obj.getList());
                        // 通知 adapter 更新数量
                        adapter.notifyDataSetChanged();
                        allOrderRecyclerView.setPullLoadMoreCompleted();

                    }
                });
    }
    @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
               // TODO Auto-generated method stub
           super.onActivityResult(requestCode, resultCode, intent);
             if (requestCode == 1 && resultCode == 4) {
                      Bundle bundle=intent.getExtras();
                      DtOrderBean obj = (DtOrderBean) bundle.getSerializable("respResult");
                Log.e("tag",obj.toString());
                listData = obj.getList();
                adapter.notifyDataSetChanged();
                  }
         }


    private void initView() {
        titleBarTitle.setText(R.string.order_center);
        titleOptionsTv.setText(R.string.search);

        allOrderRecyclerView.setLinearLayout();
        //allOrderRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                        LayoutInflater.from(AllOrderListActivity.this).inflate(R.layout.item_order_all_dantou,parent,false)
                ) {
                };
                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView) holder.itemView.findViewById(R.id.s_oea01))
                        .setText(listData.get(position).getS_oea01());
                ((TextView) holder.itemView.findViewById(R.id.s_oea04))
                        .setText(listData.get(position).getS_oea04());
                ((TextView) holder.itemView.findViewById(R.id.text_content_emp_code))
                        .setText(listData.get(position).getS_oea05());
                ((TextView) holder.itemView.findViewById(R.id.text_content_date))
                        .setText(listData.get(position).getS_oea07());

                holder.itemView.findViewById(R.id.item_order_linear_layout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AllOrderListActivity.this,OrderDetailActivity.class);
                        intent.putExtra("orderNum",listData.get(position).getS_oea01());
                        startActivity(intent);
                    }
                });


            }

            @Override
            public int getItemCount() {
                return listData.size();
            }
        };


            allOrderRecyclerView.setAdapter(adapter);



    }

    @Override
    protected void onPause() {
        super.onPause();
        count = 1;
    }

    private void initData() {
        mWeiboDialog = WeiboDialogUtils.createLoadingDialog(AllOrderListActivity.this, "加载中...");
        OkGo.<String>post(get_all_order_url)
                .tag(this)
                .upJson(POST_PARAMS_JSON)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String json = response.body();
                        DtOrderBean obj = GsonUtils.parseJSON(json,DtOrderBean.class);
                        listData = obj.getList();
                        pageSize  = obj.getTotalPageCount();
                        totalCount = obj.getTotalCount();
                        //Log.e("tag",listData.toString());
                        WeiboDialogUtils.closeDialog(mWeiboDialog);
                         adapter.notifyDataSetChanged();
                    }
                });

    }
    @OnClick({R.id.title_bar_back,R.id.title_options_tv})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
//                Intent intent = new Intent(this,OrderSearchActivity.class);
//                        intent.putExtra("action","to_search_activity");
//                        startActivity(intent);
                startActivityForResult(new Intent(AllOrderListActivity.this,
                        OrderSearchActivity.class), 1);

                break;
        }
    }
}
