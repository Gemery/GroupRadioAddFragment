package com.example.gemery.ssww.linkedlistview;

import android.view.View;

/**
 * Created by gemery on 2018/4/7.
 */

public interface EventDispatcher {

    void dispatchItemSelectedEvent(int pos, View fromView);
}