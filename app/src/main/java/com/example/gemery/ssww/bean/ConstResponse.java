package com.example.gemery.ssww.bean;

public class ConstResponse {


    /**
     * resultCode : 9997
     * resultid : null
     * resultOrderNum : null
     * icon : Error
     * resultMessage : 该消费者资料已存在
     */

    private String resultCode;
    private Object resultid;
    private Object resultOrderNum;
    private String icon;
    private String resultMessage;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Object getResultid() {
        return resultid;
    }

    public void setResultid(Object resultid) {
        this.resultid = resultid;
    }

    public Object getResultOrderNum() {
        return resultOrderNum;
    }

    public void setResultOrderNum(Object resultOrderNum) {
        this.resultOrderNum = resultOrderNum;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @Override
    public String toString() {
        return "ConstResponse{" +
                "resultCode='" + resultCode + '\'' +
                ", resultid=" + resultid +
                ", resultOrderNum=" + resultOrderNum +
                ", icon='" + icon + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                '}';
    }
}
