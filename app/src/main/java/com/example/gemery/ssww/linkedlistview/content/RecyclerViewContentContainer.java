package com.example.gemery.ssww.linkedlistview.content;
import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.gemery.ssww.linkedlistview.EventReceiver;
import com.example.gemery.ssww.linkedlistview.base.BaseScrollableContainer;
import com.example.gemery.ssww.linkedlistview.base.BaseViewGroupUtil;

/**
 * Created by gemery on 2018/4/7.
 */

public class RecyclerViewContentContainer extends BaseScrollableContainer<RecyclerView> implements EventReceiver {
    public RecyclerViewContentContainer(Context context, RecyclerView recyclerView) {
        super(context, recyclerView);
    }

    @Override
    protected BaseViewGroupUtil<RecyclerView> getViewUtil() {
        return new RecyclerViewUtil(mViewGroup);
    }

    @Override
    protected void setOnScrollListener() {
        mViewGroup.addOnScrollListener(new ProxyOnScrollListener());
    }

    private class ProxyOnScrollListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if(newState == RecyclerView.SCROLL_STATE_IDLE) {            // 停止滑动
                mRealOnScrollListener.onScrollStop();
            }else if(newState == RecyclerView.SCROLL_STATE_DRAGGING){   // 按下拖动
                mRealOnScrollListener.onScrollStart();
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) { // 滑动
            mRealOnScrollListener.onScrolled();
        }
    }
}