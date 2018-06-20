package com.example.gemery.ssww.bean;

import java.io.Serializable;

public class EmpMsgBean implements Serializable {

    /**
     * id : 137
     * s_p00 : string
     * s_p_code : string
     * s_p01 : string0001
     * s_p02 : string
     * s_p03 : string
     */

    private int id;
    private String s_p00;
    private String s_p_code;
    private String s_p01;

    @Override
    public String toString() {
        return "EmpMsgBean{" +
                "id=" + id +
                ", s_p00='" + s_p00 + '\'' +
                ", s_p_code='" + s_p_code + '\'' +
                ", s_p01='" + s_p01 + '\'' +
                ", s_p02='" + s_p02 + '\'' +
                ", s_p03='" + s_p03 + '\'' +
                '}';
    }

    private String s_p02;
    private String s_p03;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getS_p00() {
        return s_p00;
    }

    public void setS_p00(String s_p00) {
        this.s_p00 = s_p00;
    }

    public String getS_p_code() {
        return s_p_code;
    }

    public void setS_p_code(String s_p_code) {
        this.s_p_code = s_p_code;
    }

    public String getS_p01() {
        return s_p01;
    }

    public void setS_p01(String s_p01) {
        this.s_p01 = s_p01;
    }

    public String getS_p02() {
        return s_p02;
    }

    public void setS_p02(String s_p02) {
        this.s_p02 = s_p02;
    }

    public String getS_p03() {
        return s_p03;
    }

    public void setS_p03(String s_p03) {
        this.s_p03 = s_p03;
    }
}
