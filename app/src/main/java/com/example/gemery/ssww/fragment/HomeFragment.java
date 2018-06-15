package com.example.gemery.ssww.fragment;

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

import com.example.gemery.ssww.activities.AllOrderListActivity;
import com.example.gemery.ssww.activities.ContactActivity;
import com.example.gemery.ssww.activities.CustomInfoListActivity;
import com.example.gemery.ssww.activities.DispatchActivity;
import com.example.gemery.ssww.activities.EmpMsgActivity;
import com.example.gemery.ssww.activities.InstallOrderListActivity;
import com.example.gemery.ssww.activities.KnowledgeActivity;
import com.example.gemery.ssww.activities.PersonActivity;
import com.example.gemery.ssww.activities.ProductListActivity;
import com.example.gemery.ssww.activities.QueryActivity;
import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.activities.SendMessageActivity;
import com.example.gemery.ssww.activities.StorageActivity;

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
        int icno[] = {R.drawable.psblue, R.drawable.anblue, R.drawable.js,
                R.drawable.empmsg, R.drawable.zs, R.drawable.kccx,
                R.drawable.txl, R.drawable.aproduct,R.drawable.aormsg,
                R.drawable.aorder};
        //图标下的文字
        String name[] = {"配送中心", "安装中心", "结算中心", "员工信息", "知识中心",
                "库存查询", "通讯录","产品列表","客户资料列表","订单中心"};
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
            Intent intent = new Intent(getActivity(),StorageActivity.class);
            intent.putExtra("action","to_storage_activity");
            getActivity().startActivity(intent);
        }
        else if(i == 7){
            Intent intent = new Intent(getActivity(),ProductListActivity.class);
            intent.putExtra("action","to_personal_activity");
            getActivity().startActivity(intent);
        }
        else if(i == 3){
            Intent intent = new Intent(getActivity(),EmpMsgActivity.class);
            intent.putExtra("action","EmpMsgActivity");
            getActivity().startActivity(intent);
        }
        else if(i == 0){
            Intent intent = new Intent(getActivity(),DispatchActivity.class);
            intent.putExtra("action","DispatchActivity");
            getActivity().startActivity(intent);
        }
        else if(i == 1){
            Intent intent = new Intent(getActivity(),InstallOrderListActivity.class);
            intent.putExtra("action","InstallOrderListActivity");
            getActivity().startActivity(intent);
        }
        else if(i == 8){
            Intent intent = new Intent(getActivity(),CustomInfoListActivity.class);
            intent.putExtra("action","to_product_list");
            getActivity().startActivity(intent);
        }
        else if(i == 9){
            Intent intent = new Intent(getActivity(),AllOrderListActivity.class);
            intent.putExtra("action","to_Custom_info_list_activity");
            getActivity().startActivity(intent);
        }
        else if(i == 10){
            Intent intent = new Intent(getActivity(),AllOrderListActivity.class);
            intent.putExtra("action","to_Custom_info_list_activity");
            getActivity().startActivity(intent);
        }
        else {

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("提示").setMessage(dataList.get(i).get("text").toString()).create().show();
        }
    }
}