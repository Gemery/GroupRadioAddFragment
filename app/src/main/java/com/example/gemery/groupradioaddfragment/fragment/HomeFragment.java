package com.example.gemery.groupradioaddfragment.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.gemery.groupradioaddfragment.ContactActivity;
import com.example.gemery.groupradioaddfragment.KnowledgeActivity;
import com.example.gemery.groupradioaddfragment.PersonActivity;
import com.example.gemery.groupradioaddfragment.QueryActivity;
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
        int icno[] = {R.drawable.ps, R.drawable.anz, R.drawable.js,
                R.drawable.jiangp, R.drawable.zs, R.drawable.kccx,
                R.drawable.txl, R.drawable.gr};
        //图标下的文字
        String name[] = {"配送中心", "安装中心", "结算中心", "功勋榜", "知识中心",
                "库存查询", "通讯录", "个人中心"};
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
        if(i == 4){
            Intent intent = new Intent(getActivity(),KnowledgeActivity.class);
            intent.putExtra("action","to_knowledge_activity");
            getActivity().startActivity(intent);
        }else if(i == 6){
            Intent intent = new Intent(getActivity(),ContactActivity.class);
            intent.putExtra("action","to_contact_activity");
            getActivity().startActivity(intent);
        }
        else if(i == 5){
            Intent intent = new Intent(getActivity(),QueryActivity.class);
            intent.putExtra("action","to_query_activity");
            getActivity().startActivity(intent);
        }
        else if(i == 7){
            Intent intent = new Intent(getActivity(),PersonActivity.class);
            intent.putExtra("action","to_personal_activity");
            getActivity().startActivity(intent);
        }
        else {

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("提示").setMessage(dataList.get(i).get("text").toString()).create().show();
        }
    }
}