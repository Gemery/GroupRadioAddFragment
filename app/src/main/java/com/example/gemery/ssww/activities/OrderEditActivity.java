package com.example.gemery.ssww.activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.adapter.MyAdapter;
import com.example.gemery.ssww.bean.ConstResponse;
import com.example.gemery.ssww.bean.ImaBean;
import com.example.gemery.ssww.bean.OeaBen;
import com.example.gemery.ssww.listener.NumberChangeListener;
import com.example.gemery.ssww.utils.Constants;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.PreferencesUtils;
import com.example.gemery.ssww.utils.RecycleViewDivider;
import com.example.gemery.ssww.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderEditActivity extends AppCompatActivity {

    @BindView(R.id.ds_recycler_view)
    RecyclerView dsRecyclerView;
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
    private List<String> listData = new ArrayList<>();
    private MyAdapter mAdapter;
    private View viewHeader;
    private List<ImaBean.ListBean> list;


    private TextView textContentBH;
    private TextInputEditText edtiUserName;
    private TextInputEditText customAddress;
    private TextInputEditText customPhone;
    private TextView empCode;
    private TextView currentDate;

    private NumberChangeListener numberChangeListener = new NumberChangeListener() {
        @Override
        public void onNumberChange(int position, String num) {
           // 接受recyclerview 的数据变化
           // ToastUtil.showToast(OrderEditActivity.this,num);
            //ToastUtil.showToast(OrderEditActivity.this,String.valueOf(position));
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_edit_order_list);
        ButterKnife.bind(this);

        initData();
        initView();
    }

    private void initData() {
        // TODO   从上一个 界面取 数据过来.....   intent
        Intent intent = getIntent();
        Log.e("tag","xxxlistxxx.....");
        Bundle bundle =  intent.getExtras();
         list = (List<ImaBean.ListBean>) bundle.getSerializable("list");
        Log.e("tag",list.toString());

    }


    private void initView() {
        titleOptionsTv.setText("保存");
        dsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
       dsRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new MyAdapter(numberChangeListener,list, this);
        dsRecyclerView.setAdapter(mAdapter);
        // 初始recyclerView 头部
         viewHeader = LayoutInflater.from(this).inflate(R.layout.item_order_dantou,null);
         textContentBH = (TextView) viewHeader.findViewById(R.id.text_content_bh);
         empCode = (TextView) viewHeader.findViewById(R.id.text_content_emp_code);
         currentDate = (TextView) viewHeader.findViewById(R.id.text_content_date);
         edtiUserName = (TextInputEditText) viewHeader.findViewById(R.id.edit_user_name);
        customPhone = (TextInputEditText) viewHeader.findViewById(R.id.custom_phone);
        customAddress = (TextInputEditText) viewHeader.findViewById(R.id.custom_address);

        mAdapter.addHeaderView(viewHeader);
        viewHeader.findViewById(R.id.rl_text_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                                DatePickerDialog datePicker = new DatePickerDialog(OrderEditActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // TODO Auto-generated method stub
                                ((TextView)viewHeader.findViewById(R.id.text_content_date)).setText(year + "/ " + (monthOfYear + 1) + "/ " + dayOfMonth);
                                Toast.makeText(OrderEditActivity.this,
                                        year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }, 2018, 5, 20);
                datePicker.show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();



    }
    private List<OeaBen.OeaListBean> dtList  = new ArrayList<>();
    private List< OeaBen.OebListBean> dsList  = new ArrayList<>();
   private  OeaBen oeaBen;
    private OeaBen getFormData(){
        oeaBen = new OeaBen();
        oeaBen.setFlage("1");
        //订单单头
        OeaBen.OeaListBean oeaListBean = new OeaBen.OeaListBean();
        oeaListBean.setId("0");
        oeaListBean.setS_oea00(PreferencesUtils.getSharePreStr(this,"ssww_code"));
        oeaListBean.setS_oea_code(PreferencesUtils.getSharePreStr(this,"sww_dp_bumber"));
        //  s_oea01 : string,单据编号
        oeaListBean.setS_oea01(textContentBH.getText().toString());
        oeaListBean.setS_oea07(currentDate.getText().toString());
        oeaListBean.setS_oea02(String.valueOf(new Date().getTime()));
        // 消费者手机号
        oeaListBean.setS_oea03(customPhone.getText().toString());
        oeaListBean.setS_oea05(customAddress.getText().toString());
        // 业务员编号
        oeaListBean.setS_oea06(empCode.getText().toString());
        dtList.add(oeaListBean);
        oeaBen.setOeaList(dtList);
        //订单单身
        for(int i=0;i<list.size();i++){
            OeaBen.OebListBean oebListBean = new OeaBen.OebListBean();
            // 单据编号
            oebListBean.setS_oeb01(textContentBH.getText().toString());
            // 物料代码  TODO s_oeb03 不能一样的 ！！！！！！！！？？？？？
            oebListBean.setS_oeb03(list.get(i).getS_ima00() + i);
            // 型号
            oebListBean.setS_oeb05(list.get(i).getS_ima01());
            //名称
            oebListBean.setS_oeb04(list.get(i).getS_ima02());
            //相次
            oebListBean.setS_oeb02(String.valueOf(1));
            //规格
            oebListBean.setS_oeb06(list.get(i).getS_ima021());
            //    TODO  获得数量
            long id = mAdapter.getItemId(i);

            oebListBean.setS_oeb07(list.get(i).getS_imaud01());
            dsList.add(oebListBean);
        }
      oeaBen.setOebList(dsList);



        return oeaBen;
    }

    @OnClick({R.id.title_bar_back, R.id.title_options_tv})
    public void onViewClick(View v) {
        Log.e("tag", "onclick");
        switch (v.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                // 重置 TODO 所有的属性
                if(oeaBen == null){
                     oeaBen = getFormData();
                }
                Log.e("tag",oeaBen.toString());
                OkGo.<String>post(Constants.EDIT_ORDER_URL)
                        .tag(OrderEditActivity.this)
                        //.upJson(Constants.EDIT_POST_JSON)
                        .upJson(oeaBen.toString())
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                Log.e("tag", response.body());
                                ConstResponse rep = GsonUtils.parseJSON(response.body(), ConstResponse.class);
                                if (rep.getResultCode().equals("0")) {

                                    new AlertDialog.Builder(OrderEditActivity.this)
                                            .setTitle("上传到后台")
                                            .setMessage("上传完成")
                                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.cancel();

                                                }
                                            })
                                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.cancel();
                                                    finish();
                                                }
                                            })
                                            .create().show();
                                }


                            }

                            @Override
                            public void onError(Response<String> response) {
                                Log.e("tag", response.getException().getMessage());
                                super.onError(response);
                            }
                        });
                break;
        }
    }
}
