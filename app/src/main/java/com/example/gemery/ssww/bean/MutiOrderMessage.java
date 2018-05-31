package com.example.gemery.ssww.bean;

import java.util.List;

public class MutiOrderMessage {
    private List<CustomMsg> data;

    public List<CustomMsg> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MutiOrderMessage{" +
                "data=" + data +
                '}';
    }

    public void setData(List<CustomMsg> data) {
        this.data = data;
    }
}
