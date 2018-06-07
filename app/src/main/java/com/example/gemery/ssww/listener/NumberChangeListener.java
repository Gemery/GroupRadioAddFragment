package com.example.gemery.ssww.listener;

import com.example.gemery.ssww.bean.ImaBean;

import java.util.List;

public interface NumberChangeListener {
     void onNumberChange(int position,String num);

     void onNumerChange(int positon, List<ImaBean.ListBean> list);

}
