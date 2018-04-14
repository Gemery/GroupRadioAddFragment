package com.example.gemery.groupradioaddfragment.bean;

import java.util.List;

/**
 * Created by gemery on 2018/4/14.
 */

public class CreationList {
    private List<User> data;
    private Boolean success;

    @Override
    public String toString() {
        return "CreationList{" +
                "data=" + data +
                ", success=" + success +
                '}';
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
