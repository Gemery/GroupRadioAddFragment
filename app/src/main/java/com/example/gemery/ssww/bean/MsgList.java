package com.example.gemery.ssww.bean;

import java.util.Arrays;
import java.util.List;

public class MsgList {

    private String flage;
    private List<CustomMsg> list;


    public List<CustomMsg> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "{" +
                "flage:'" + flage + '\'' +
                ", list:" + list +
                '}';
    }

    public void setList(List<CustomMsg> list) {
        this.list = list;
    }

    public String getFlage() {
        return flage;
    }

    public void setFlage(String flage) {
        this.flage = flage;
    }


}
