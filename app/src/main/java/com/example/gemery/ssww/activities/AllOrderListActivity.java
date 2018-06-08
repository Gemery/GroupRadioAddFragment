package com.example.gemery.ssww.activities;

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

    private String get_all_order_url = "http://192.168.1.251:8091/api/Order/getAllstdOrders";
    private final String POST_PARAMS_JSON = "{\n" +
            "  \"ima\": {\n" +
            "       \n" +
            "  },\n" +
            "  \"pageSize\": \"30\",\n" +
            "  \"pageIndex\": \"1\"\n" +
            "}";
    private List<DtOrderBean.ListBean> listData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_order_list);
        ButterKnife.bind(this);
        initData();
        //initView();
       // allOrderRecyclerView.setPullRefreshEnable(false);
        allOrderRecyclerView.setFooterViewText("loading");
       allOrderRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
           @Override
           public void onRefresh() {
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       allOrderRecyclerView.setPullLoadMoreCompleted();
                   }
               }, 1500);
           }

           @Override
           public void onLoadMore() {
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
//                       list.add("add");
//                       adapter.notifyItemInserted(list.size()-1);
                       ToastUtil.showToast(AllOrderListActivity.this," completed Load More Data");
                       allOrderRecyclerView.setPullLoadMoreCompleted();
                   }
               }, 1500);
           }
       });
    }

    private void initView() {
        titleBarTitle.setText("订单中心");

        allOrderRecyclerView.setLinearLayout();
        //allOrderRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        allOrderRecyclerView.setAdapter(new RecyclerView.Adapter() {
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
        });

    }

    private void initData() {

        OkGo.<String>post(get_all_order_url)
                .tag(this)
                .upJson(POST_PARAMS_JSON)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String json = response.body();
                        DtOrderBean obj = GsonUtils.parseJSON(json,DtOrderBean.class);
                        listData = obj.getList();
                        Log.e("tag",listData.toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initView();
                            }
                        });
                    }
                });

    }
    @OnClick({R.id.title_bar_back})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
        }
    }
}
