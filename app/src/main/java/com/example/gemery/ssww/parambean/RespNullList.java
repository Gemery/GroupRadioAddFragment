package com.example.gemery.ssww.parambean;

import java.util.List;

public class RespNullList {

    /**
     * list : []
     * TotalPageCount : 0
     * TotalCount : 0
     */

    private int TotalPageCount;
    private int TotalCount;
    private List<?> list;

    public int getTotalPageCount() {
        return TotalPageCount;
    }

    public void setTotalPageCount(int TotalPageCount) {
        this.TotalPageCount = TotalPageCount;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
