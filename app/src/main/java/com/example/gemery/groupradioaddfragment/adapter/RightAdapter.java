package com.example.gemery.groupradioaddfragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.groupradioaddfragment.bean.ParaseData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gemery on 2018/4/7.
 */

public class RightAdapter extends BaseAdapter {

    List<ParaseData.DataBean> data;
    LayoutInflater inflater;
    Context context;


    public RightAdapter(Context context, List<ParaseData.DataBean> data) {
        this.context=context;
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data=data;
        }else {
            this.data=new ArrayList<>();
        }
    }
    public void addRes(List<ParaseData.DataBean> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public ParaseData.DataBean getItem(int position) {
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
            convertView = inflater.inflate(R.layout.right_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder= (ViewHolder) convertView.getTag();
        }

        holder.mTitle.setText(getItem(position).getTitle());
        holder.mMsg.setText(getItem(position).getTitle());
        Picasso.with(context).load(getItem(position).getImage()).into(holder.mImg);

        return convertView;
    }

    public static class ViewHolder {
        ImageView mImg;
        TextView mTitle;
        TextView mMsg;

        public ViewHolder(View itemView) {
            mImg = (ImageView) itemView.findViewById(R.id.right_img);
            mTitle = (TextView) itemView.findViewById(R.id.right_text);
            mMsg = (TextView) itemView.findViewById(R.id.right_msg);
        }
    }
}
