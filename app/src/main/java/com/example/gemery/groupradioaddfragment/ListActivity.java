package com.example.gemery.groupradioaddfragment;

import android.app.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.gemery.groupradioaddfragment.adapter.LeftAdapter;
import com.example.gemery.groupradioaddfragment.adapter.RightAdapter;
import com.example.gemery.groupradioaddfragment.bean.ParaseData;
import com.example.gemery.groupradioaddfragment.http.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;

import rx.Observable;


import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by gemery on 2018/4/7.
 */

public class ListActivity extends Activity {

  private int scrollPosition = 1;

    private ListView mLeft;
    private ListView mRight;
    private RightAdapter rightAdapter;
    private LeftAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_list);
        initView();
        getData();
    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://app.vmoiver.com").build();

        ApiService apiService = retrofit.create(ApiService.class);

        rx.Observable<ParaseData> apiServiceMovieList = apiService.getMoviceList();

        apiServiceMovieList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ParaseData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ParaseData paraseData) {
                        rightAdapter.addRes(paraseData.getData());
                    }
                });
    }

    private void initView() {
        mLeft = (ListView) findViewById(R.id.left);
        mRight = (ListView) findViewById(R.id.right);

        adapter = new LeftAdapter(this);
        mLeft.setAdapter(adapter);

        rightAdapter = new RightAdapter(this, null);
        mRight.setAdapter(rightAdapter);
        mLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setSelectItem(position);

                mRight.setSelection(position);

            }
        });
        mRight.setOnScrollListener(new AbsListView.OnScrollListener() {


            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if (scrollPosition != firstVisibleItem) {
                    adapter.setSelectItem(firstVisibleItem);
                    mLeft.setSelectionFromTop(firstVisibleItem, 40);
                    scrollPosition = firstVisibleItem;
                }

            }
        });

    }
}
