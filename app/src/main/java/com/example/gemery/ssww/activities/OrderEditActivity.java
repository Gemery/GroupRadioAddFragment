package com.example.gemery.ssww.activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.example.gemery.ssww.utils.Constants;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.RecycleViewDivider;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
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
        listData.add("11122");
        listData.add("22122");
        listData.add("333122");
    }

    private void initView() {
        titleOptionsTv.setText("保存");

        dsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

       dsRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new MyAdapter(listData, this);
        dsRecyclerView.setAdapter(mAdapter);
         viewHeader = LayoutInflater.from(this).inflate(R.layout.item_order_dantou,null);
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

    @OnClick({R.id.title_bar_back, R.id.title_options_tv})
    public void onViewClick(View v) {
        Log.e("tag", "onclick");
        switch (v.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_options_tv:
                // 重置 TODO 所有的属性
                OkGo.<String>post(Constants.EDIT_ORDER_URL)
                        .tag(OrderEditActivity.this)
                        .upJson(Constants.EDIT_POST_JSON)
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
