package com.example.gemery.ssww.linkedlistview;

/**
 * Created by gemery on 2018/4/7.
 */

public interface EventReceiver {
    /**
     * 收到事件: 立即选中 newPos
     * @param newPos
     */
    void selectItem(int newPos);
}
