package com.example.gemery.ssww.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.gemery.ssww.bean.Msg;

import java.text.FieldPosition;
import java.util.List;

/**
 * Created by gemery on 2018/4/19.
 */

public class ChatAdapter extends BaseAdapter {
    private Context mContext;
    private List<Msg> list;
    public ChatAdapter(Context mContext, List<Msg> list) {
        super();
        this.mContext = mContext;
        this.list = list;


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
