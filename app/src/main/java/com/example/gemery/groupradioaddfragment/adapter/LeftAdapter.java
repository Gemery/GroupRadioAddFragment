package com.example.gemery.groupradioaddfragment.adapter;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.gemery.groupradioaddfragment.R;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by gemery on 2018/4/7.
 */

public class LeftAdapter extends BaseAdapter {

    List<String> data;
    LayoutInflater inflater;
    private int selectItem=0;

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
        notifyDataSetChanged();
    }

    public LeftAdapter(Context context) {
        data=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("电影"+i);
        }
        inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public String getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView=inflater.inflate(R.layout.left_item,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        holder.mText.setText(data.get(position));

        if (selectItem == position) {
            holder.mText.setTextColor(Color.BLUE);
            holder.mIndicator.setVisibility(View.VISIBLE);
        }else {
            holder.mText.setTextColor(Color.BLACK);
            holder.mIndicator.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

    public static class ViewHolder{

        TextView mText;
        View mIndicator;

        public ViewHolder(View itemView) {
            mText= (TextView) itemView.findViewById(R.id.left_text);
            mIndicator=itemView.findViewById(R.id.left_indicator);
        }
    }



}
