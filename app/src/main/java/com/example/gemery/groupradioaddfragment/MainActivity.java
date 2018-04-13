package com.example.gemery.groupradioaddfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.gemery.groupradioaddfragment.fragment.HomeFragment;
import com.example.gemery.groupradioaddfragment.fragment.MessageFragment;
import com.example.gemery.groupradioaddfragment.fragment.MineFragment;
import com.example.gemery.groupradioaddfragment.fragment.ContactFragment;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.content)
    FrameLayout mContent;
    @BindView(R.id.rbHome)
    RadioButton mRbHome;
    @BindView(R.id.rbShop)
    RadioButton mRbShop;
    @BindView(R.id.rbMessage)
    RadioButton mRbMessage;
    @BindView(R.id.rbMine)
    RadioButton mRbMine;
    @BindView(R.id.rgTool)
    RadioGroup mRgTools;
    private Fragment[] mFragments;

    private int mIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initOkgo();
       // OkGo.getInstance().init(getApplication());
        ButterKnife.bind(this);

        initFragment();
    }

    private void initOkgo() {
        OkHttpClient.Builder builder = HttpConfig.setOkgoConfig();

        //---------这里给出的是示例代码,告诉你可以这么传,实际使用的时候,根据需要传,不需要就不传-------------//
        HttpHeaders headers = new HttpHeaders();
        headers.put("commonHeaderKey1", "commonHeaderValue1");    //header不支持中文，不允许有特殊字符
        headers.put("commonHeaderKey2", "commonHeaderValue2");
        HttpParams params = new HttpParams();
        params.put("commonParamsKey1", "commonParamsValue1");     //param支持中文,直接传,不要自己编码
        params.put("commonParamsKey2", "这里支持中文参数");
//-------------------------------------------------------------------------------------//

        OkGo.getInstance().init(getApplication())                       //必须调用初始化
                .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置将使用默认的
                .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(3)                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .addCommonHeaders(headers)                      //全局公共头
                .addCommonParams(params);                       //全局公共参数
    }

    private void initFragment() {

        //首页
        HomeFragment homeFragment =new HomeFragment();
        //购物车
        ContactFragment contactFragment =new ContactFragment();

        //消息
        MessageFragment messageFragment =new MessageFragment();
        //个人中心

        MineFragment mineFragment =new MineFragment();

        //添加到数组
        mFragments = new Fragment[]{homeFragment, contactFragment,messageFragment,mineFragment};

        //开启事务

        FragmentTransaction ft =
                getSupportFragmentManager().beginTransaction();

        //添加首页
        ft.add(R.id.content,homeFragment).commit();

        //默认设置为第0个
        setIndexSelected(0);

    }

    private void setIndexSelected(int index) {
        if(mIndex == index)
            return;
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();

        ft.hide(mFragments[mIndex]);
        //判断是否添加
        if(!mFragments[index].isAdded()){
            ft.add(R.id.content,mFragments[index]).show(mFragments[index]);
        }else{
            ft.show(mFragments[index]);
        }

        ft.commit();

        mIndex = index;

    }

    @OnClick({R.id.rbHome,R.id.rbShop,R.id.rbMessage,R.id.rbMine})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.rbHome:
                setIndexSelected(0);
                break;
            case R.id.rbShop:
                setIndexSelected(1);
                break;
            case R.id.rbMessage:
                setIndexSelected(2);
                break;
            case R.id.rbMine:
                setIndexSelected(3);
                break;
        }
    }
}
