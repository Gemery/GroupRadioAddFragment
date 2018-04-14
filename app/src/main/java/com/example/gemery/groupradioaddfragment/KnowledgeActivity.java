package com.example.gemery.groupradioaddfragment;

import android.Manifest;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.gemery.groupradioaddfragment.utils.ToastUtil;
import com.silang.superfileview.FileDisplayActivity;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;


/**
 * Created by gemery on 2018/4/10.
 */

public class KnowledgeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.mRecyclerView)
    ListView lv;
    @BindView(R.id.k_banner)
    Banner kBanner;
    @BindView(R.id.taoCi)
    RadioButton taoCi;
    @BindView(R.id.zhiNeng)
    RadioButton zhiNeng;
    @BindView(R.id.yuShiGui)
    RadioButton yuShiGui;
    @BindView(R.id.linYuF)
    RadioButton linYuF;
    @BindView(R.id.radiogrop1)
    RadioGroup radiogrop1;
    @BindView(R.id.xiuXian)
    RadioButton xiuXian;
    @BindView(R.id.wuJin)
    RadioButton wuJin;
    @BindView(R.id.shaoShou)
    RadioButton shaoShou;
    @BindView(R.id.dMian)
    RadioButton dMian;
    @BindView(R.id.radiogroup2)
    RadioGroup radiogroup2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("知识中心");
        setContentView(R.layout.activity_knowledge);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);

        initBanner(kBanner);
        changeImageSize();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initBanner(Banner banner) {
        String[] urls = getResources().getStringArray(R.array.url);
        List list  = Arrays.asList(urls);
        List<String> titles = Arrays.asList(new String[]{"","","","","qu"});
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Picasso.with(KnowledgeActivity.this).load((String)path).into(imageView);
            }
        });

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);//设置圆形指示器与标题
        banner.setIndicatorGravity(BannerConfig.RIGHT);//设置指示器位置
        banner.setDelayTime(2000);  //设置轮播时间
        banner.setImages(list);  //设置图片源
        banner.setBannerTitles(titles);  //设置标题源


        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                ToastUtil.showToast(KnowledgeActivity.this,"您点击了"+ position);;
            }
        });
        banner.start();

        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                new String[]{"这是PDF文档","这是一个word文档","这是Excel文档","这是PPT文档"}));

        lv.setOnItemClickListener(this);

    }

    private void changeImageSize() {
        //定义底部标签图片大小
        Drawable drawableFirst = getResources().getDrawable(R.drawable.tc);
        drawableFirst.setBounds(0, 0, 69, 69);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        taoCi.setCompoundDrawables(null, drawableFirst, null, null);//只放上面

        Drawable drawableSearch = getResources().getDrawable(R.drawable.lyf);
        drawableSearch.setBounds(0, 0, 69, 69);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        zhiNeng.setCompoundDrawables(null, drawableSearch, null, null);//只放上面

        Drawable drawableMe = getResources().getDrawable(R.drawable.ysg);
        drawableMe.setBounds(0, 0, 69, 69);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        yuShiGui.setCompoundDrawables(null, drawableMe, null, null);//只放上面


        Drawable drawableMe2 = getResources().getDrawable(R.drawable.lyf);
        drawableMe2.setBounds(0, 0, 69, 69);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        linYuF.setCompoundDrawables(null, drawableMe, null, null);//只放上面


        Drawable drawableMe3 = getResources().getDrawable(R.drawable.jq);
        drawableMe3.setBounds(0, 0, 69, 69);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        wuJin.setCompoundDrawables(null, drawableMe, null, null);//只放上面


        Drawable drawableMe4 = getResources().getDrawable(R.drawable.xx);
        drawableMe4.setBounds(0, 0, 69, 69);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        xiuXian.setCompoundDrawables(null, drawableMe, null, null);//只放上面


        Drawable drawableMe5 = getResources().getDrawable(R.drawable.jq);
        drawableMe5.setBounds(0, 0, 69, 69);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        shaoShou.setCompoundDrawables(null, drawableMe, null, null);//只放上面


        Drawable drawableMe6 = getResources().getDrawable(R.drawable.dm);
        drawableMe6.setBounds(0, 0, 69, 69);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        dMian.setCompoundDrawables(null, drawableMe, null, null);//只放上面
    }

    @OnClick({R.id.taoCi, R.id.zhiNeng, R.id.yuShiGui, R.id.linYuF, R.id.xiuXian, R.id.wuJin, R.id.shaoShou, R.id.dMian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.taoCi:
                lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                        new String[]{"这是PDF文档","这是一个word文档","这是Excel文档","这是PPT文档"}));
                break;
            case R.id.zhiNeng:
                lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                        new String[]{"1","2","3","4","5","1","2","3","4","5"}));
                break;
            case R.id.yuShiGui:
                break;
            case R.id.linYuF:
                break;
            case R.id.xiuXian:
                break;
            case R.id.wuJin:
                break;
            case R.id.shaoShou:
                break;
            case R.id.dMian:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String path = null;
        switch (i){
            case 0:
                path = "http://www.hrssgz.gov.cn/bgxz/sydwrybgxz/201101/P020110110748901718161.doc";

                String[] perms = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE};

                if (!EasyPermissions.hasPermissions(KnowledgeActivity.this, perms)) {
                    EasyPermissions.requestPermissions(KnowledgeActivity.this, "需要访问手机存储权限！", 10086, perms);
               } else {
                   FileDisplayActivity.show(KnowledgeActivity.this, path);
               }
                break;
            case 1:
                path =  "/storage/emulated/0/test.docx";
                break;
            case 2:
                path = "/storage/emulated/0/test.txt";
                break;

            case 3:
                path = "/storage/emulated/0/test.xlsx";
                break;
            case 4:
                path = "/storage/emulated/0/test.pptx";
                break;

            case 5:
                path = "/storage/emulated/0/test.pdf";
                break;
                default:
        }


    }
}
