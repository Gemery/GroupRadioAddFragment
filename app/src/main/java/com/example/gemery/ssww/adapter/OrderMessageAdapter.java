package com.example.gemery.ssww.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;

import java.util.List;

public class OrderMessageAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;
    private List<String> mData;
    private int resourceId;
    public OrderMessageAdapter(Context context, List<String> mData,int resourceId) {
        this.context = context;
        this.mData = mData;
        this.resourceId = resourceId;
       inflater =  LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(resourceId, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder= (ViewHolder) convertView.getTag();
        }

       holder.csEmp.setText("nihaoxxxx");

        return convertView;
    }


    public static class ViewHolder {
        public TextView csName;
        public TextView csPhone;
        public TextView csOrderNum;
        public TextView csDate;
        public TextView csEmp;

        public ViewHolder(View itemView) {
            csName = (TextView) itemView.findViewById(R.id.cs_name);
            csPhone = (TextView) itemView.findViewById(R.id.cs_phone);
            csOrderNum = (TextView) itemView.findViewById(R.id.order_number);
            csDate = (TextView) itemView.findViewById(R.id.cs_date);
            csEmp = (TextView) itemView.findViewById(R.id.cs_emp);
        }
    }
}
