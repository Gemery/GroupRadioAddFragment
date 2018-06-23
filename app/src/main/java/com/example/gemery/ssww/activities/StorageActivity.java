package com.example.gemery.ssww.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.InstallOrdBen;
import com.example.gemery.ssww.bean.StorageBean;
import com.example.gemery.ssww.utils.Const;
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
    private final String get_sotrage_all_url = Const.W_HOST+"/api/stockData/getStoreList";
    private final String edit_storage_url = Const.W_HOST+"/api/stockData/imgExq";
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
    //    @BindView(R.id.my_search_view)
//    SearchView mySearchView;
    @BindView(R.id.search_label_key)
    TextView searchLabelKey;
    @BindView(R.id.label_key_recycler)
    RecyclerView labelKeyRecycler;

    @BindView(R.id.et_search_text)
    EditText etSearchText;
    @BindView(R.id.imb_search_clear)
    ImageButton imbSearchClear;
    @BindView(R.id.search_label_key_v2)
    TextView searchLabelKeyV2;

    @BindView(R.id.et_search_text_v2)
    EditText etSearchTextV2;
    @BindView(R.id.imb_search_clear_v2)
    ImageButton imbSearchClearV2;


    private String search_key = "";

    private List<StorageBean.ListBean> listData = new ArrayList<>();
    private String upJson;
    private RecyclerView.Adapter adapter;

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
        // titleOptionsImg.setVisibility(View.VISIBLE);
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

    class SearchTask implements Runnable {

        @Override
        public void run() {
            Log.e("---SearchTask---", "开始查询");
        }
    }

    private String getInputText(String changeText) {
            /*
      "s_img_code": "string,门店编号",
      "s_img01": "string,物料代码",
      "s_img01_desc": "string,物料名称",
      "s_img02": "string,型号",
      "s_img03": "string,规格",
      "s_img04": "string,仓库代码",
      "s_img04_desc": "string,仓库名称",
      "s_img05": "string,库位",
 */
        // String str = " { ima: { s_img04_desc:\"浪\" },pageSize: 20,pageIndex: 1}";
        switch (checkItem) {
            case 0:
                search_key = "s_img01";
                break;
            case 1:
                search_key = "s_img01_desc";
                break;
            case 2:
                search_key = "s_img02";
                break;
            case 3:
                search_key = "s_img03";
                break;
            case 4:
                search_key = "s_img04";
                break;
            case 5:
                search_key = "s_img04_desc";
                break;
            case 6:
                search_key = "s_img05";
                break;
        }
        String auto_post_json = search_key + ":\"" + changeText + "\"";
        return auto_post_json;
    }

    private String getUpJson() {
        upJson = "{ ima: { " + getInputText(etSearchText.getText().toString()) +
                ","+"s_img_code"+":\""+etSearchTextV2.getText().toString()+"\"},pageSize: 20,pageIndex: 1}";

        return upJson;
    }

    private void search() {
        getUpJson();
        Log.e("tag", upJson);
        OkGo.<String>post(get_sotrage_all_url)
                .tag(this)
                .upJson(upJson)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e("tag", response.body());
                        StorageBean storageBean = GsonUtils.parseJSON(response.body(), StorageBean.class);
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
        titleOptionsTv.setText("搜索");

//        mySearchView.setSearchViewListener(new SearchView.onSearchViewListener() {
//            @Override
//            public boolean onQueryTextChange(String text) {
//                Log.e("tag", text);
//                search_key = text;
//                if (text.length() > 0) {
//                   // new Handler().removeCallbacks(new SearchTask());
//                    //new Handler().postDelayed(new SearchTask(), 500);
//                    search(text);
//                }
//
//                return false;
//            }
//        });
        storageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //storageRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


        adapter = new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                        LayoutInflater.from(StorageActivity.this).inflate(R.layout.item_storage_info, parent, false)
                ) {
                };
                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView) holder.itemView.findViewById(R.id.s_img01))
                        .setText(listData.get(position).getS_img01());
                ((TextView) holder.itemView.findViewById(R.id.s_img01_desc))
                        .setText(listData.get(position).getS_img01_desc());
                ((TextView) holder.itemView.findViewById(R.id.s_img04_desc))
                        .setText(listData.get(position).getS_img04_desc());
                ((TextView) holder.itemView.findViewById(R.id.s_img08))
                        .setText(String.valueOf(listData.get(position).getS_img08()));

                holder.itemView.findViewById(R.id.item_storage_ll).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(StorageActivity.this, StorageItemDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("storageDetail", listData.get(position));
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

        storageRecyclerView.setAdapter(adapter);
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
    @OnClick({R.id.title_bar_back, R.id.title_options_tv, R.id.search_label_key})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.search_label_key:
                showPopuWindow();
                break;
            case R.id.title_options_tv:

                Intent intent = new Intent(this,StorageSearchActivity.class);
                startActivityForResult(intent,1);

                break;
            case R.id.title_bar_back:
                finish();
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1 && resultCode == 4){
            Bundle bundle = data.getExtras();
            StorageBean bean = (StorageBean) bundle.getSerializable("respResult");
            listData = bean.getList();
            adapter.notifyDataSetChanged();
        }

    }

    public int checkItem = 0;

    private void showPopuWindow() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        String[] strArray = {"物料代码", "物料名称", "型号", "规格", "仓库代码", "仓库名称"};

        builder.setSingleChoiceItems(strArray, checkItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                checkItem = i;
                searchLabelKey.setText(strArray[checkItem]);
                dialogInterface.dismiss();

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

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
                ToastUtil.showToast(getContext(), "刷新了一条数据");
                // 加载完数据    将下拉进度条收起来
                storageSwipeLayout.setRefreshing(false);
            }
        }, 2000);
    }
}
