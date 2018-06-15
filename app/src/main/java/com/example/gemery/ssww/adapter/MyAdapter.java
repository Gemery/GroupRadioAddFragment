package com.example.gemery.ssww.adapter;


import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.ImaBean;
import com.example.gemery.ssww.listener.NumberChangeListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsy on 2018/6/4.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private RecyclerView mRecyclerView;

    private List<ImaBean.ListBean> data = new ArrayList<>();
    private Context mContext;

    private View VIEW_FOOTER;
    private View VIEW_HEADER;

    //Type
    private int TYPE_NORMAL = 1000;
    private int TYPE_HEADER = 1001;
    private int TYPE_FOOTER = 1002;

    private NumberChangeListener mListener;
    public MyAdapter(NumberChangeListener listener,List<ImaBean.ListBean> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
        this.mListener = listener;
    }

    @Override
    public MyAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            return new MyHolder(VIEW_FOOTER);
        } else if (viewType == TYPE_HEADER) {
            return new MyHolder(VIEW_HEADER);
        } else {
            return new MyHolder(getLayout(R.layout.item_order_dansheng,parent));
        }
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int  position) {
        if (!isHeaderView(position) && !isFooterView(position)) {
            if (haveHeaderView()) position--;
            //   s_ima1006_desc='门夹系列淋浴房'
            ((TextView) holder.itemView.findViewById(R.id.content_wl_gg))
                    .setText(data.get(position).getS_ima1006_desc());
            // 型号
            ((TextView) holder.itemView.findViewById(R.id.content_wl_xh))
                    .setText(data.get(position).getS_imaud01());
            //名称
            ((TextView) holder.itemView.findViewById(R.id.content_wl_name))
                    .setText(data.get(position).getS_ima02());
            //物料代码
            ((TextView) holder.itemView.findViewById(R.id.wl_content_code))
                    .setText(data.get(position).getS_ima01());
            final int finalPostion = position;
            // 数量
           TextView slTv = ((TextView) holder.itemView.findViewById(R.id.text_content_sl));
                    slTv.setText("1");

            holder.itemView.findViewById(R.id.sl_count_bl).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int count = Integer.parseInt(slTv.getText().toString());
                    if(count == 1){
                        return;
                    }else{
                        count--;
                        slTv.setText(String.valueOf(count));
                        // 监听数据变化
                        data.get(finalPostion).setS_imaud01(String.valueOf(count));
                        mListener.onNumberChange(finalPostion,String.valueOf(count));
                    }
                }
            });
            holder.itemView.findViewById(R.id.sl_count_pl).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int count = Integer.parseInt(slTv.getText().toString());
                        count++;
                        slTv.setText(String.valueOf(count));

                    data.get(finalPostion).setS_imaud01(String.valueOf(count));
                    mListener.onNumberChange(finalPostion,String.valueOf(count));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        int count = (data == null ? 0 : data.size());
        if (VIEW_FOOTER != null) {
            count++;
        }

        if (VIEW_HEADER != null) {
            count++;
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderView(position)) {
            return TYPE_HEADER;
        } else if (isFooterView(position)) {
            return TYPE_FOOTER;
        } else {
            return TYPE_NORMAL;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        try {
            if (mRecyclerView == null && mRecyclerView != recyclerView) {
                mRecyclerView = recyclerView;
            }
            ifGridLayoutManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private View getLayout(int layoutId,ViewGroup parent) {
        return LayoutInflater.from(mContext).inflate(layoutId, parent,false);
    }

    public void addHeaderView(View headerView) {
        if (haveHeaderView()) {
            throw new IllegalStateException("hearview has already exists!");
        } else {
            //避免出现宽度自适应
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            headerView.setLayoutParams(params);
            VIEW_HEADER = headerView;
            ifGridLayoutManager();
            notifyItemInserted(0);
        }

    }

    public void addFooterView(View footerView) {
        if (haveFooterView()) {
            throw new IllegalStateException("footerView has already exists!");
        } else {
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            footerView.setLayoutParams(params);
            VIEW_FOOTER = footerView;
            ifGridLayoutManager();
            notifyItemInserted(getItemCount() - 1);
        }
    }

    private void ifGridLayoutManager() {
        if (mRecyclerView == null) return;
        final RecyclerView.LayoutManager layoutManager = mRecyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager.SpanSizeLookup originalSpanSizeLookup =
                    ((GridLayoutManager) layoutManager).getSpanSizeLookup();
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return (isHeaderView(position) || isFooterView(position)) ?
                            ((GridLayoutManager) layoutManager).getSpanCount() :
                            1;
                }
            });
        }
    }

    private boolean haveHeaderView() {
        return VIEW_HEADER != null;
    }

    public boolean haveFooterView() {
        return VIEW_FOOTER != null;
    }

    private boolean isHeaderView(int position) {
        return haveHeaderView() && position == 0;
    }

    private boolean isFooterView(int position) {
        return haveFooterView() && position == getItemCount() - 1;
    }


    public static class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);
        }
    }

}



