package com.example.gemery.groupradioaddfragment.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.gemery.groupradioaddfragment.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gemery on 2018/4/3.
 */

public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {
    private GridView gridView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> dataList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        gridView = (GridView) view.findViewById(R.id.gridview);

        initData();

        String[] from = {"img", "text"};

        int[] to = {R.id.img, R.id.text};

        simpleAdapter = new SimpleAdapter(getContext(), dataList, R.layout.gridview_item, from, to);

        gridView.setAdapter(simpleAdapter);

        gridView.setOnItemClickListener(this);

        return view;
    }

    private void initData() {

        //图标
        int icno[] = {R.drawable.th_text3, R.drawable.th_topple3, R.drawable.th_toy_bot,
                R.drawable.th_wikipanion2, R.drawable.th_yelp, R.drawable.th_youtube, R.drawable.th_textreader,
                R.drawable.th_thisday, R.drawable.th_tnjspsng4hhhj3bd32ae, R.drawable.th_wedict};
        //图标下的文字
        String name[] = {"新闻公告", "名店系统", "客服系统", "流程审批", "考勤签到",
                "报表分析", "记出差申请", "请假申请", "工作日志", "我的提成"};
        dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < icno.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", icno[i]);
            map.put("text", name[i]);
            dataList.add(map);

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("提示").setMessage(dataList.get(i).get("text").toString()).create().show();
    }
}