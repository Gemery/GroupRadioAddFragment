package com.example.gemery.ssww.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.adapter.MyOrderDtailAdapter;
import com.example.gemery.ssww.bean.ConstResponse;
import com.example.gemery.ssww.bean.ImaBean;
import com.example.gemery.ssww.bean.OeaBen;
import com.example.gemery.ssww.parambean.ResultOutOrderBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.ToastUtil;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDetailActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.order_detail_rc)
    RecyclerView orderDetailRc;
    private final String get_one_order_url = Const.W_HOST + "/api/Order/getStandardList?orderNum=";
    @BindView(R.id.title)
    LinearLayout title;

    private List<OeaBen.OebListBean> list = new ArrayList<>();

    private OeaBen.OeaListBean dtBean = new OeaBen.OeaListBean();
    private MyOrderDtailAdapter mAdapter;
    private View viewHeader;
    private TextView textContentBH;
    private OeaBen oeaBen;
    private String orderNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        orderNum = intent.getStringExtra("orderNum");
        initData();
        isOutStorage();
        //initView();
    }

    private void initData() {

        OkGo.<String>get(get_one_order_url + orderNum)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                         oeaBen = GsonUtils.parseJSON(response.body(), OeaBen.class);
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



    private void initView() {
        titleBarTitle.setText("订单详细信息");
        titleOptionsTv.setText("编辑");
        orderDetailRc.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new MyOrderDtailAdapter(list, this);
        orderDetailRc.setAdapter(mAdapter);
        // 初始recyclerView 头部
        initRecylerViewHeader();
        mAdapter.addHeaderView(viewHeader);

    }
    private String getIsOutUrl = Const.W_HOST + "/api/stockData/getOgaList";
    public ResultOutOrderBean obj;
    private boolean isOutStor = false;
    private  void isOutStorage(){
        String outUpJson = "{ ima:{ s_oga08:\""+ orderNum +"\"},pageSize:20,pageIndex:1}";
        Log.e("tag",outUpJson);
        OkGo.<String>post(getIsOutUrl)
                .tag(this)
                .upJson(outUpJson)
                .execute(new StringCallback() {


                    @Override
                    public void onSuccess(Response<String> response) {
                         obj = GsonUtils.parseJSON(response.body(),ResultOutOrderBean.class);
                        if(obj.getList().size() != 0){
                            isOutStor = true;
                            //Log.e("tag",response.body()+"\n "+isOutStor);
                        }
                        runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    initView();
                                }
                        });
                    }
                });

    }

    private void initRecylerViewHeader() {
        viewHeader = LayoutInflater.from(this).inflate(R.layout.item_order_detail_dantou, null);
        textContentBH = (TextView) viewHeader.findViewById(R.id.text_content_bh);
        TextView csName = (TextView) viewHeader.findViewById(R.id.content_cs_name);
        TextView currentDate = (TextView) viewHeader.findViewById(R.id.text_content_date);
        TextView csEmp = (TextView) viewHeader.findViewById(R.id.text_content_emp_code);
        TextView csPhone = (TextView) viewHeader.findViewById(R.id.content_cs_phone);
        TextView customAddress = (TextView) viewHeader.findViewById(R.id.content_cs_address);

        TextView sOga08 = (TextView) viewHeader.findViewById(R.id.s_oga01);
        RelativeLayout rlOutItem = (RelativeLayout) viewHeader.findViewById(R.id.rl_s_oga01);

        if(isOutStor){
            ((TextView)viewHeader.findViewById(R.id.tv_desc)).setVisibility(View.VISIBLE);
            ((ImageView)viewHeader.findViewById(R.id.img_arrow)).setVisibility(View.VISIBLE);
            sOga08.setText(obj.getList().get(0).getS_oga01());
            rlOutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(OrderDetailActivity.this,ODetailActivity.class);
                  intent.putExtra("orderNumber",obj.getList().get(0).getS_oga01());
                    startActivity(intent);

                }
            });

        }else{
            ((TextView) viewHeader.findViewById(R.id.label_s_oga01)).setText("是否出库 : ");
            sOga08.setText("未出库");
        }

        textContentBH.setText(dtBean.getS_oea01());
        csName.setText(dtBean.getS_oea04());
        currentDate.setText(dtBean.getS_oea07());
        csEmp.setText(dtBean.getS_oea06());
        csPhone.setText(dtBean.getS_oea03());
        customAddress.setText(dtBean.getS_oea05());
    }

    @OnClick({R.id.title_bar_back, R.id.title_options_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                showPopupWindow();
                break;
        }
    }
/*
  { "oeaList": [ {
      "id": "51",
      "s_oea01": "stringSA180600051"}],
  "oebList": [
    { "s_oeb01": "stringSA180600051" }],
  "flage": "3"
}
 */
   private String url = Const.W_HOST + "/api/Order/standardOrderExq";
    private String upJson = "";
    private void showPopupWindow() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.menu_action_item, null);

        PopupWindow popupWindow = new PopupWindow(contentView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);

        contentView.findViewById(R.id.order_slock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderDetailActivity.this,SLockEditActivity.class);
                intent.putExtra("orderNum",orderNum);
                startActivity(intent);
            }
        });
        contentView.findViewById(R.id.order_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderDetailActivity.this,OrderEditActivity.class);
                List<ImaBean.ListBean> listData = new ArrayList<>();
                for(int i=0;i<list.size();i++){
                    /*
                     * s_ima01 : 1059900137
                     * s_ima02 : 淋浴房屏风
                    * s_ima25 : 套 * s_ima1006 : LK
                     * s_ima1006_desc : 门夹系列淋浴房
                     */
                    ImaBean.ListBean obj = new ImaBean.ListBean();
                    obj.setS_ima01(list.get(i).getS_oeb03());
                    obj.setS_ima02(list.get(i).getS_oeb04());
                    obj.setS_imaud01(list.get(i).getS_oeb05());
                    obj.setS_ima1006_desc(list.get(i).getS_oeb06());
                   listData.add(obj);
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", (Serializable) listData);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        contentView.findViewById(R.id.order_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upJson = "{ oeaList: [{ id:"+ dtBean.getId() + ",s_oea01:"
                        + "\"" + dtBean.getS_oea01() + "\"}],"
                        + "oebList:[{ s_oeb01:\"" + dtBean.getS_oea01() +"\"}],"
                        + "flage : 3 }";
                //Log.e("tag",upJson);
                OkGo.<String>post(url)
                        .tag(this)
                        .upJson(upJson)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                               // Log.e("tag",response.body());
                                ConstResponse obj = GsonUtils.parseJSON(response.body(),ConstResponse.class);
                                if(obj.getResultCode().equals("0") && obj.getResultMessage().equals("删除成功")){
                                    ToastUtil.showToast(OrderDetailActivity.this,"删除成功");
                                    finish();
                                }
                            }
                        });
            }
        });

        popupWindow.setContentView(contentView);
        popupWindow.showAtLocation(title, Gravity.BOTTOM,0,0);


    }


}
