package com.example.gemery.ssww.activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.example.gemery.ssww.bean.StorageBean;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gemery.ssww.AppExample.getContext;

public class StorageActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private final String get_sotrage_all_url = "http://192.168.1.251:8091/api/stockData/getStoreList";
    private final String edit_storage_url = "http://192.168.1.251:8091/api/stockData/imgExq";
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
    @BindView(R.id.storage_recycler_view)
    RecyclerView storageRecyclerView;
    @BindView(R.id.storage_swipe_layout)
    SwipeRefreshLayout storageSwipeLayout;


    private List<StorageBean.ListBean> listData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        ButterKnife.bind(this);
        initData();
       initSwipeView();
    }

    private void initSwipeView() {
        titleBarTitle.setText("库存查询");
        storageSwipeLayout.setColorSchemeColors(
                getResources().getColor(android.R.color.holo_blue_light),
                getResources().getColor(android.R.color.holo_red_light),
                getResources().getColor(android.R.color.holo_orange_light),
                getResources().getColor(android.R.color.holo_green_light));

        storageSwipeLayout.setOnRefreshListener(this);
    }

    private final String post_data_json = "{\n" +
            "  \"ima\": {\n" +
            "    \"id\": \"1\",\n" +
            "    \n" +
            "  },\n" +
            "  \"pageSize\": \"1\",\n" +
            "  \"pageIndex\": \"30\"\n" +
            "}";

    private void initData() {
        OkGo.<String>post(get_sotrage_all_url)
                .tag(this)
                .upJson(post_data_json)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String json = response.body();
                        Log.e("tag", json);
                       StorageBean storageBean = GsonUtils.parseJSON(json, StorageBean.class);
                       listData = storageBean.getList();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    initView();
                                }
                            });
                    }
                });

    }

    private void initView() {
        titleOptionsTv.setText("");
        storageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //storageRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        storageRecyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                        LayoutInflater.from(StorageActivity.this).inflate(R.layout.item_storage_info,parent,false)
                ) {
                };
                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView)holder.itemView.findViewById(R.id.s_img01))
                        .setText(listData.get(position).getS_img01());
                ((TextView)holder.itemView.findViewById(R.id.s_img01_desc))
                        .setText(listData.get(position).getS_img01_desc());
                ((TextView)holder.itemView.findViewById(R.id.s_img04_desc))
                        .setText(listData.get(position).getS_img04_desc());
                ((TextView)holder.itemView.findViewById(R.id.s_img08))
                        .setText(String.valueOf(listData.get(position).getS_img08()));
            }

            @Override
            public int getItemCount() {
                return listData.size();
            }
        });


    }

    /*   post data 模板.........
             ***** "s_img01": "string14233",     物料代码  唯一标识
    {
  "list": [
    {
      "id": "1",
      "s_img00": "string_v1",       必须项
      "s_img_code": "string_v21",    必须项
      "s_img01": "string14233",     必须项
      "s_img01_desc": "string",
      "s_img04":"string",          必须项
      "s_img06":"string",         必须项
      "s_img08": "2",
      "s_img09": "1",
    }
  ],
  "flage": "1"
}
     */
    @OnClick({R.id.title_bar_back,R.id.title_options_tv})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.title_bar_back:
                finish();
                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            switch (msg.what) {
//                case REFRESH_COMPLETE:
//
//                    //3.通知recycleView改变了数据
//                    myAdapter.notifyDataSetChanged();
//                    //4.记得关闭刷新，否则刷新球一直在转
//                    swipeRefreshLayout.setRefreshing(false);
//                    break;
//            }
        }
    };
    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               initData();
                ToastUtil.showToast(getContext(),"刷新了一条数据");
                // 加载完数据    将下拉进度条收起来
                storageSwipeLayout.setRefreshing(false);
            }
        },2000);
    }
}
