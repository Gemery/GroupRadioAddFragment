package com.example.gemery.ssww.activities;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.MainActivity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.jivesoftware.smack.packet.Bind;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class OrderingInfoActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
   @BindView(R.id.toolbar)
   Toolbar toolbar;
    private String message_url = "";
    //  java 代码的字符串引号是 双引号  代码提示是  Alt+Enter  ！！！！！！
    @BindView(R.id.action_send_button)
    Button action_send_button;
    @BindView(R.id.def_spinner)
    Spinner mSpinner;
    private String[] mItems;
    private PopupWindow pw;

    @BindView(R.id.user_def)
    TextView tvWeek;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_ordering_info);
       ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("添加订单信息");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setOnMenuItemClickListener(this);

        mItems = getResources().getStringArray(R.array.user_def);

       //initSpinner();

        tvWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow();
            }
        });
    }

    private void showPopupWindow(){
        View myView = getLayoutInflater().inflate(R.layout.pop_week, null);
        pw = new PopupWindow(myView, (int)(getApplicationContext().getResources().getDisplayMetrics().widthPixels / 2),
                LinearLayout.LayoutParams.WRAP_CONTENT, true);
        //注意要设置背景（使用图片或者颜色），否则PopupWIndow会不显示
        pw.setBackgroundDrawable(new ColorDrawable(0xcccddd));
        pw.setFocusable(true);
        //将window视图显示在tvWeek下面
        pw.showAsDropDown(tvWeek);

        ListView lv = (ListView) myView.findViewById(R.id.lv_pop);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, mItems);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                tvWeek.setText(mItems[position]);
                if(pw != null){
                    pw.dismiss();
                }
            }
        });
    }

    private void initSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_dropdown_item, mItems);
        mSpinner.setAdapter(adapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //选择列表项的操作
                Toast.makeText(OrderingInfoActivity.this, "Click" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //未选中时候的操作
            }
        });

    }

    @OnClick(R.id.action_send_button)
    public void onViewClick(View view){
        //TODO  提交表单请求到后台
        OkGo.<String>post(message_url)
                .params("","")
                .params("","")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e("tag",response.body());
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.save_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {


        return false;
    }


}
