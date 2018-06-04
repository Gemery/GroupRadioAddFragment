package com.example.gemery.ssww.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;

public class MyAdapter extends Adapter<ViewHolder> {
	private List<String> mDatas;
	private LayoutInflater mInflater;

	public MyAdapter(Context context, List<String> datas) {
		mDatas = new ArrayList<String>(datas);
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getItemCount() {
		return mDatas.size();
	}
	
	public void addAll(List<String> datas) {
		mDatas.addAll(datas);
		notifyDataSetChanged();
	}


	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		MyViewHolder myViewHolder  = (MyViewHolder) holder;
		myViewHolder.tvText.setText(mDatas.get(position));
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		ViewHolder holder = null;
		View itemView = mInflater.inflate(R.layout.item_data, parent, false);
		holder = new MyViewHolder(itemView);
		return holder;
	}
	
	 class MyViewHolder extends ViewHolder {
		TextView tvText;
		public MyViewHolder(View arg0) {
			super(arg0);
			tvText = (TextView) arg0.findViewById(R.id.tv_text);
		}
		
	}
	

}
