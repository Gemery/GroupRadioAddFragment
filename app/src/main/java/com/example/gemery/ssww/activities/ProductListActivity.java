package com.example.gemery.ssww.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.ImaBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.Constants;
import com.example.gemery.ssww.utils.GsonUtils;
import com.example.gemery.ssww.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductListActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.filter_linear_layout)
    LinearLayout filterLinearLayout;

    @BindView(R.id.filter_first)
    TextView filterFirst;
    @BindView(R.id.filter_second)
    TextView filterSecond;
    @BindView(R.id.filter_three)
    TextView filterThree;
    private PopupWindow mPopWindow;
    @BindView(R.id.list_recyclerview)
    RecyclerView mRecyclerView;
    private List<ImaBean.ListBean> checkData = new ArrayList<>();

    private String get_data_url = Const.W_HOST+"/api/imaData/getimaList";
    //private MutiOrderMessage data;
    private List<ImaBean.ListBean> data = new ArrayList<>();
    private SearchView sv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ButterKnife.bind(this);

        initDatas();
        //initRecyclerView();
        initSearchView();

    }

    private void initSearchView() {
        deletedown();
        // 设置搜索文本监听
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
//                    mListView.setFilterText(newText);
                }else{
                    //DataKit.searchParams.setSearchKey("");
                    //search();
                }
                return false;
            }
            @Override
            public boolean onQueryTextSubmit(String queryText) {
                if (sv != null) {

                    // 得到输入管理对象
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        // 这将让键盘在所有的情况下都被隐藏，但是一般我们在点击搜索按钮后，输入法都会乖乖的自动隐藏的。
                        imm.hideSoftInputFromWindow(sv.getWindowToken(), 0); // 输入法如果是显示状态，那么就隐藏输入法
                    }
                   // DataKit.searchParams.setSearchKey(queryText);
                    sv.clearFocus(); // 不获取焦点
                   // search();
                }
                return true;
            }
        });


    }

    private void deletedown() {//去掉搜索框的下划线
        sv = (SearchView)findViewById(R.id.sv);
        //为该SearchView组件设置事件监听器
        //sv.setOnQueryTextListener(this);
        // 设置该SearchView内默认显示的提示文本
        //sv.setQueryHint("哈雷实验室");
        if (sv != null) {
            try {        //--拿到字节码
                Class<?> argClass = sv.getClass();
                //--指定某个私有属性,mSearchPlate是搜索框父布局的名字
                Field ownField = argClass.getDeclaredField("mSearchPlate");
                //--暴力反射,只有暴力反射才能拿到私有属性
                ownField.setAccessible(true);
                View mView = (View) ownField.get(sv);
                //--设置背景
                mView.setBackgroundColor(Color.TRANSPARENT);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //添加Android自带的分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(
                        LayoutInflater.from(ProductListActivity.this).inflate(R.layout.proudct_item,parent,false
                        )){};
                return holder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView) holder.itemView.findViewById(R.id.item_name)).setText(data.get(position).getS_ima00());

                        ((TextView) holder.itemView.findViewById(R.id.item_price))
                        .setText(data.get(position).getS_ima01());

                        ((TextView) holder.itemView.findViewById(R.id.item_des))
                        .setText(data.get(position).getS_ima02());
                holder.itemView.findViewById(R.id.check_box).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.e("tag",view.toString());
                        if(((CheckBox) holder.itemView.findViewById(R.id.check_box)).isChecked()){
                            checkData.add(data.get(position));

                        }
                    }
                });
                int finalPostion  = position;
                holder.itemView.findViewById(R.id.item_ll).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ProductListActivity.this,ProductDetailActivity.class);
                       Bundle bundle = new Bundle();
                       bundle.putSerializable("productDetail",data.get(finalPostion));
                       intent.putExtras(bundle);
                      startActivity(intent);

                    }
                });



            }

            @Override
            public int getItemCount() {
                return data.size();
            }
        });

    }

    private void initDatas() {
        Log.e("tag","initDatas");
        OkGo.<String>post(get_data_url)
                .tag(this)
                .upJson(Constants.IMA_POST_JSON)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String json = response.body();
                       // Log.e("tag111",json);
                    try {
                       ImaBean obj = GsonUtils.parseJSON(json, ImaBean.class);
                       data = obj.getList();
                        //Log.e("tag", data.toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initRecyclerView();
                            }
                        });

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        Log.e("tag",response.getException().getMessage());
                        super.onError(response);
                    }
                });

    }

    @OnClick({R.id.filter_three,R.id.filter_second,R.id.filter_first,R.id.btn_search,R.id.icon_back_home,R.id.action_add_cart})
    public void onClickedView(View view){
        switch(view.getId()){
            case R.id.action_add_cart:
                if(checkData.size() == 0){
                    ToastUtil.showToast(this,"你还没有选择产品");
                    return;
                }
                Intent intent = new Intent(ProductListActivity.this,OrderEditActivity.class);
                Bundle bundle = new Bundle();
                Log.e("tag",checkData.toString());
                bundle.putSerializable("list", (Serializable) checkData);
               intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.filter_first:
                showPopupWindow();
                break;
            case R.id.icon_back_home:
                  finish();
                break;
            case R.id.btn_search:
                //TODO


                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("tag","zhixingle");
      // checkData.clear();
    }

    @Override
    protected void onPause() {
        super.onPause();
        checkData.clear();
        initRecyclerView();
    }

    private void showPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(ProductListActivity.this).inflate(R.layout.poplyaout, null);
        mPopWindow = new PopupWindow(contentView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setContentView(contentView);
        //设置各个控件的点击响应
        TextView tv1 = (TextView)contentView.findViewById(R.id.pop_computer);
        TextView tv2 = (TextView)contentView.findViewById(R.id.pop_financial);
        TextView tv3 = (TextView)contentView.findViewById(R.id.pop_manage);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        //显示PopupWindow

        //View rootview = LayoutInflater.from(ProductListActivity.this).inflate(R.layout.main, null);
       // mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
        mPopWindow.showAsDropDown(filterLinearLayout);

    }
    private void setDrawableRight(TextView tvVersionStatus){
        Drawable rightDrawable = getResources().getDrawable(R.drawable.arrow_right);
            rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
            tvVersionStatus.setCompoundDrawables(null, null, rightDrawable, null);

    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.pop_computer:{
                setDrawableRight((TextView) v);
                mPopWindow.dismiss();
            }
            break;
            case R.id.pop_financial:{
                setDrawableRight((TextView) v);
                mPopWindow.dismiss();
            }
            break;
            case R.id.pop_manage:{
                setDrawableRight((TextView) v);
                mPopWindow.dismiss();
            }
            break;
        }
    }


}
