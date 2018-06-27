package com.example.gemery.ssww.activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.example.gemery.ssww.bean.OeaBen;
import com.example.gemery.ssww.bean.SLockBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

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

    View viewHeader;
    private MyOrderDtailAdapter mAdapter;
    private TextView vNumber;
    private TextView vType;
    private TextView vStart;
    private TextView vEnd;
    private String orderNum;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slock_edit);
        ButterKnife.bind(this);
        initData();
        initView();

    }



    private List<OeaBen.OebListBean> list = new ArrayList<>();

    private void initView() {
        titleBarTitle.setText("锁库存");
        titleOptionsTv.setText("保存");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new MyOrderDtailAdapter(list, this);
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

        vNumber.setText(orderNum);

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
                String[] types = {"订单", "出库单", "某某"};

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

    private String getOrderDetailUrl = Const.W_HOST + "/api/Order/getStandardList?orderNum=";


    private void initData () {
            Intent intent = getIntent();
             orderNum = intent.getStringExtra("orderNum");

            OkGo.<String>get(getOrderDetailUrl + orderNum)
                    .tag(this)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            //Log.e("tag",response.body());
                            OeaBen oeaBen = GsonUtils.parseJSON(response.body(), OeaBen.class);
                            Message msg = new Message();
                            msg.what = DATA_UPDATE;
                            msg.obj = oeaBen;
                            handler.sendMessage(msg);
                            //list = oeaBen.getOebList();
                        }
                    });

        }
        private final static int DATA_UPDATE = 1;
        private Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case DATA_UPDATE:
                        list = ((OeaBen)msg.obj).getOebList();
                        initView();
                        break;
                }

            }
        };
        private String getFormJson(){
            SLockBean sLockBean = new SLockBean();
            List<SLockBean.LockEListBean> eList = new ArrayList<>();

            // TODO  设置set 属性

                    /** s_lock_e04 : integer,项次
                     * s_lock_e03 : string,源单单号
                    * s_lock_e05 : string,物料代码
                    * s_lock_e06 : string,物料名称
                    * s_lock_e07 : string,型号
                    * s_lock_e08 : string,规格
                    * s_lock_e10 : double,锁库存数量

                    * s_oeb01 : string,单据编号
                    * s_oeb02 : integer,项次
                    * s_oeb03 : string,物料代码
                    * s_oeb04 : string,物料名称
                    * s_oeb05 : string,型号
                    * s_oeb06 : string,规格
                    * s_oeb07 : double,数量
                    */
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
                eList.add(eObj);
            }
            sLockBean.setLock_e_list(eList);
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
            Log.e("tag",sLockBean.toString());

            return sLockBean.toString();
        }

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
