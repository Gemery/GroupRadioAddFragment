package com.example.gemery.ssww.adapter;


import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gemery.groupradioaddfragment.R;
import com.example.gemery.ssww.bean.OeaBen;
import com.example.gemery.ssww.bean.StorageBean;
import com.example.gemery.ssww.utils.Const;
import com.example.gemery.ssww.utils.GsonUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsy on 2018/6/28.
 */
public class SlockOrderEditAdapter extends RecyclerView.Adapter<SlockOrderEditAdapter.MyHolder> {

    private RecyclerView mRecyclerView;

    private List<OeaBen.OebListBean> data = new ArrayList<>();
    private Context mContext;

    private View VIEW_FOOTER;
    private View VIEW_HEADER;

    //Type
    private int TYPE_NORMAL = 1000;
    private int TYPE_HEADER = 1001;
    private int TYPE_FOOTER = 1002;

    public SlockOrderEditAdapter(List<OeaBen.OebListBean> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }
    @Override
    public SlockOrderEditAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            return new MyHolder(VIEW_FOOTER);
        } else if (viewType == TYPE_HEADER) {
            return new MyHolder(VIEW_HEADER);
        } else {
            return new MyHolder(getLayout(R.layout.ab_item_lock_order_edit,parent));
        }
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        if (!isHeaderView(position) && !isFooterView(position)) {
            if (haveHeaderView()) position--;
            // 规格
            ((TextView) holder.itemView.findViewById(R.id.content_wl_gg))
                    .setText(data.get(position).getS_oeb06());
            // 型号
            ((TextView) holder.itemView.findViewById(R.id.content_wl_xh))
                    .setText(data.get(position).getS_oeb05());
            //名称
            ((TextView) holder.itemView.findViewById(R.id.content_wl_name))
                    .setText(data.get(position).getS_oeb04());
            //物料代码
            ((TextView) holder.itemView.findViewById(R.id.wl_content_code))
                    .setText(data.get(position).getS_oeb03());

            // 数量
            final int finalPostion = position;
            TextView slTv = ((TextView) holder.itemView.findViewById(R.id.s_gbag_e07));
            slTv.setText("0");

            holder.itemView.findViewById(R.id.sl_count_bl).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    double count = Double.parseDouble(slTv.getText().toString());
                    if(count == 0){
                        return;
                    }else{
                        count--;
                        slTv.setText(String.valueOf(count));
                        // 监听数据变化
                        data.get(finalPostion).setS_oeb07(String.valueOf(count));
                    }
                }
            });
            holder.itemView.findViewById(R.id.sl_count_pl).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    double count = Double.parseDouble(slTv.getText().toString());
                    double aMax = Double.parseDouble(data.get(finalPostion).getS_oeb07())
                              - Double.parseDouble(data.get(finalPostion).getS_oeb16())
                              - Double.parseDouble(data.get(finalPostion).getS_oebud02());
                    double bMax = Double.parseDouble(data.get(finalPostion).getS_oebud01())
                              - Double.parseDouble(data.get(finalPostion).getS_oebud02());
                    double slockMax = (aMax > bMax) ? aMax : bMax;
                    Log.e("tag",aMax+ "---->"+bMax);
                    if(count == slockMax){
                        return;
                    }else {
                        count++;
                        slTv.setText(String.valueOf(count));
                        data.get(finalPostion).setS_oeb07(String.valueOf(count));
                    }

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



