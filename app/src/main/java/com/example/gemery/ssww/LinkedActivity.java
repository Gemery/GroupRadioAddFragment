package com.example.gemery.ssww;

import android.app.Activity;

/**
 * Created by gemery on 2018/4/7.
 */
import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;



import butterknife.BindView;
import butterknife.ButterKnife;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.adapter.RightArrayAdapter;
import com.example.gemery.ssww.linkedlistview.OnItemClickListener;
import com.example.gemery.ssww.linkedlistview.base.BaseScrollableContainer;
import com.example.gemery.ssww.linkedlistview.content.RecyclerViewContentContainer;
import com.example.gemery.ssww.linkedlistview.tab.ListViewTabContainer;
import com.example.gemery.ssww.linkedlistview.ui.LinkedLayout;
import com.example.gemery.ssww.linkedlistview.widget.RealSectionIndexer;
import com.example.gemery.ssww.utils.ToastUtil;

public class LinkedActivity extends Activity {

    @BindView(R.id.linked_layout)
    LinkedLayout mLinkedLayout;

    private BaseScrollableContainer mTabContainer;      // 左边的 Tab 页
    private BaseScrollableContainer mContentContainer;  // 右边的 content 页

    List<Integer> mData = Stream.iterate(0, item -> item+1)
            .limit(500)
            .collect(Collectors.toList());

    List<String> lData  = new ArrayList<>();

    List<String> rData  = new ArrayList<>();



    @Override
    public boolean moveDatabaseFrom(Context sourceContext, String name) {
        return super.moveDatabaseFrom(sourceContext, name);
    }

    private SectionIndexer mSectionIndexer = new RealSectionIndexer(mData);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkedview);
        ButterKnife.bind(this);
        initData();
        initTabContainer();
        initContentContainer();
        initLinkedLayout();

    }

    private void initData() {
        for(int i = 0 ;i< 10;i++){
            lData.add("xxx系列"+ i);
            for(int j= 0 ;j<10;j++){
                rData.add(i + "===这是右边的内容---->" + j);

            }
        }
    }

    private void initTabContainer() {
        ListView mListView = new ListView(this);
        mListView.setAdapter(new ArrayAdapter<>(this, R.layout.item_common,
                lData
        ));

        mTabContainer = new ListViewTabContainer(this, mListView);
    }

    private void initContentContainer() {
        RecyclerView mRecyclerView = new RecyclerView(this);
        //mRecyclerView.setBackgroundColor(getResources().getColor(android.R.color.background_light));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RightArrayAdapter<String> adapter = new RightArrayAdapter<>(this,R.layout.right_item, rData, mSectionIndexer);

        mRecyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Log.e("tag","执行了 onClick 方法");
                ToastUtil.showToast(LinkedActivity.this,"show toast");
//                Intent intent=new Intent(LinkedActivity.this,SignUpActivity.class);
//                intent.putExtra("action","to_recycler_item");
//                startActivity(intent);
//                finish();
            }

            @Override
            public void onLongClick(int position) {

            }
        });
        mContentContainer = new RecyclerViewContentContainer(this, mRecyclerView);


    }

    private void initLinkedLayout() {
        mLinkedLayout.setContainers(mTabContainer, mContentContainer);
        mLinkedLayout.setSectionIndexer(mSectionIndexer);
    }
}
