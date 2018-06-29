package com.example.gemery.ssww.activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.adapter.MyOrderDtailAdapter;
import com.example.gemery.ssww.adapter.SlockOrderEditAdapter;
import com.example.gemery.ssww.bean.ODdetailBean;
import com.example.gemery.ssww.bean.OeaBen;
import com.example.gemery.ssww.bean.SLockBean;
import com.example.gemery.ssww.bean.StorageBean;
import com.example.gemery.ssww.parambean.RespSlockedSumBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.google.gson.JsonObject;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SLockEditActivity extends AppCompatActivity {
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_options_tv)
    TextView titleOptionsTv;
    @BindView(R.id.slock_re_view)
    RecyclerView mRecyclerView;

    private int slockMax = 0;

    View viewHeader;
    private SlockOrderEditAdapter mAdapter;
    private TextView vNumber;
    private TextView vType;
    private TextView vStart;
    private TextView vEnd;
    private String orderNum;

    private List<OeaBen.OebListBean> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slock_edit);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initView() {
        titleBarTitle.setText("锁库存");
        titleOptionsTv.setText("保存");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SlockOrderEditAdapter(list, this);


         mRecyclerView.setAdapter(mAdapter);
        // 初始recyclerView 头部
        initRecylerViewHeader();
        mAdapter.addHeaderView(viewHeader);
    }
    private int checkedItem = 0;
    private void initRecylerViewHeader() {
        viewHeader = LayoutInflater.from(this).inflate(R.layout.item_slock_dt,null);
        vNumber = viewHeader.findViewById(R.id.s_lock_h02);
        vType = viewHeader.findViewById(R.id.s_lock_h03);
        vStart   = (TextView)viewHeader.findViewById(R.id.s_lock_hsdate);
        vEnd   = (TextView)viewHeader.findViewById(R.id.s_lock_hedate);

        vNumber.setText(list.get(0).getS_oeb01());
        viewHeader.findViewById(R.id.rl_start_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerend = new DatePickerDialog(SLockEditActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // TODO Auto-generated method stub
                                vStart.setText(year + "/ " + (monthOfYear + 1) + "/ " + dayOfMonth);
                            }
                        }, 2018, 5, 20);
                datePickerend.show();
            }
        });
        viewHeader.findViewById(R.id.rl_order_type).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SLockEditActivity.this);
                //builder.setTitle("你选择的客户类型是：");
                String[] types = {"订单", "销售出库单", "调拨单"};

                builder.setSingleChoiceItems(types, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        checkedItem = which;
                        vType.setText(types[checkedItem]);
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        viewHeader.findViewById(R.id.rl_end_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerend = new DatePickerDialog(SLockEditActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // TODO Auto-generated method stub
                                vEnd.setText(year + "/ " + (monthOfYear + 1) + "/ " + dayOfMonth);
                            }
                        }, 2018, 5, 20);
                datePickerend.show();
            }
        });
    }



    private void initData () {
        Bundle bundle = getIntent().getExtras();
        list = (List<OeaBen.OebListBean>) bundle.getSerializable("listData");
        Log.e("tag",list.toString());
        // 获取该订单的已锁物料的数量及物料代码
        getSlockedSum();
        getStorageCount();

        }
        private boolean jk1 = false;
        private List<String> storageList = new ArrayList<>();
   // 获得该物料的库存数
    private  String getStorageCountUrl = Const.W_HOST + "/api/stockData/getStoreList";
    private void getStorageCount(){
        for(int i= 0;i<list.size();i++){
            String wCode = list.get(0).getS_oeb03();
            String upJson = "{ ima: { s_img01:\""+wCode+"\"},pageSize: 20,pageIndex: 1}";
            OkGo.<String>post(getStorageCountUrl)
                    .tag(this)
                    .upJson(upJson)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            Log.e("tag",response.body());
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(response.body());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            int count = 0;
                            try {
                                count = jsonObject.getInt("TotalCount");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            jk1 = true;
                            if(count == 0){

                            }else{
                                StorageBean obj = GsonUtils.parseJSON(response.body(),StorageBean.class);
                                storageList.add(String.valueOf(obj.getList().get(0).getS_img08()));
                            }


                            Message msg = new Message();
                            msg.what = 1;
                            handler.sendMessage(msg);
                        }
                    });
        }
     }

   private boolean jk2 = false;
    private final static int SLOCK_DATA_UPDATE = 2;
    public ArrayList<RespSlockedSumBean> slockedList = new ArrayList<>();
    private String getSlockedSumlUrl = Const.W_HOST + "/api/stockData/getLockE?s_lock_e03=";
        // 获取该订单的已锁物料的数量及物料代码
    private  void getSlockedSum(){
        SharedPreferences usersp = getSharedPreferences("user", 0);
        String ssww_code = usersp.getString("ssww_code","");
        String dp_number = usersp.getString("dp_number","");
        getSlockedSumlUrl = getSlockedSumlUrl + list.get(0).getS_oeb01() +"&s_lock_h00=" + ssww_code +"&s_lock_hcode=" + dp_number;
        OkGo.<String>get(getSlockedSumlUrl)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        jk2 = true;
                        Log.e("tag",getSlockedSumlUrl + response.body());
                        if(response.body().equals("[]")){
                            slockedList = new ArrayList<>();
                        }else{
                            slockedList = GsonUtils.jsonToArrayList(response.body(),RespSlockedSumBean.class);
                        }
                        Message msg = new Message();
                        msg.what  = 2;
                        handler.sendMessage(msg);

                }});
    }
    private void handlerCount(){
        if(jk1 && jk2){
            if(slockedList.size() != 0){
                for(int i=0;i<list.size();i++){
                    list.get(i).setS_oebud02(String.valueOf(slockedList.get(i).getLock_sum()));
                    list.get(i).setS_oebud03(slockedList.get(i).getS_lock_e05());
                    }
            }else{
                for(int i=0;i<list.size();i++) {
                    list.get(i).setS_oebud02("0");
                    list.get(i).setS_oebud03("0");
                }
            }
            if(storageList.size() != 0){
                for(int i=0;i<list.size();i++){
                    list.get(i).setS_oebud01(storageList.get(i));
                }
            }else{
                for(int i=0;i<list.size();i++){
                    list.get(i).setS_oebud01("0");
                }
            }

            Log.e("tag",list.toString());
            initView();
        }

    }
   private Handler handler = new Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
           switch (msg.what){
               case 1:
                  handlerCount();
                   break;
               case 2:
                   handlerCount();
                   break;
           }

       }
   };
    private String getFormJson(){
        SLockBean sLockBean = new SLockBean();
        List<SLockBean.LockEListBean> eList = new ArrayList<>();
        // TODO  设置set 属性
        for(int i=0;i<list.size();i++){
            SLockBean.LockEListBean eObj = new SLockBean.LockEListBean();
            eObj.setS_lock_e03(vNumber.getText().toString());
            eObj.setS_lock_e05(list.get(i).getS_oeb03());
            eObj.setS_lock_e06(list.get(i).getS_oeb04());
            eObj.setS_lock_e07(list.get(i).getS_oeb05());
            eObj.setS_lock_e08(list.get(i).getS_oeb05());
            eObj.setS_lock_e10(list.get(i).getS_oeb07());
            eObj.setS_lock_e11("0");
            eObj.setS_lock_e12("102");
            eObj.setS_lock_e13("121");
            eObj.setS_lock_e14("1");
            eList.add(eObj); }sLockBean.setLock_e_list(eList);
        List<SLockBean.LockHListBean> hList = new ArrayList<>();
        SLockBean.LockHListBean hObj = new SLockBean.LockHListBean();
        // TODO  设置set 属性
        hObj.setS_lock_h02(vNumber.getText().toString());
        hObj.setS_lock_h03(vType.getText().toString());
        hObj.setS_lock_hsdate(String.valueOf(new Date(vStart.getText().toString()).getTime()));
        hObj.setS_lock_hedate(String.valueOf(new Date(vEnd.getText().toString()).getTime()));
        hList.add(hObj);
        sLockBean.setLock_h_list(hList);
        sLockBean.setFlage("1");
        // Log.e("tag",sLockBean.toString());
        return sLockBean.toString(); }

      private String postSlockOrderUrl = Const.W_HOST + "/api/stockData/lockskExq";
       @OnClick({R.id.title_options_tv,R.id.title_bar_back})
       public void onViewClick(View view){
          switch (view.getId()){
               case R.id.title_options_tv:
                   OkGo.<String>post(postSlockOrderUrl)
                           .tag(this)
                           .upJson(getFormJson())
                           .execute(new StringCallback() {
                               @Override
                               public void onSuccess(Response<String> response) {
                                   Log.e("tag",response.body());
                               }
                           });
                break;
              case R.id.title_bar_back:
                  finish();
                  break;
          }
        }
    }
