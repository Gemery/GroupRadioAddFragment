package com.example.gemery.ssww.bean;

import java.io.Serializable;

public class EStoreBean implements Serializable {

    /**
     * id : 3
     * s_est00 : 300005
     * s_est01 : 300005001
     * s_est_name : 佛山三水门店
     * s_est_address1 : 广东省
     * s_est_address2 : 佛山市
     * s_est_address3 : 三水区
     * s_est_address4 : 三达路124
     * s_est_type : 2:零售专卖店
     * s_est_tel : 87292756
     * s_est_phone : 15989217947
     * s_est_re :
     * s_est02 :
     * s_est03 : 10000
     * s_est04 : 1000
     * s_est05 : 中国工商银行
     * s_est06 : xxxxxxxxxxxxx
     * s_est07 : xxx
     * s_est08 :
     * s_est09 : xxxxxx
     * s_est_confirm : N
     * s_est10 : tiptop
     * s_estud01 :
     * s_estud02 :
     * s_estud03 :
     * s_estud04 :
     * s_estud05 :
     * s_estud06 :
     * s_estud07 :
     * s_estud08 :
     * s_estud09 :
     */

    private int id;
    private String s_est00;
    private String s_est01;
    private String s_est_name;
    private String s_est_address1;
    private String s_est_address2;
    private String s_est_address3;
    private String s_est_address4;
    private String s_est_type;

    @Override
    public String toString() {
        return "EStoreBean{" +
                "id=" + id +
                ", s_est00='" + s_est00 + '\'' +
                ", s_est01='" + s_est01 + '\'' +
                ", s_est_name='" + s_est_name + '\'' +
                ", s_est_address1='" + s_est_address1 + '\'' +
                ", s_est_address2='" + s_est_address2 + '\'' +
                ", s_est_address3='" + s_est_address3 + '\'' +
                ", s_est_address4='" + s_est_address4 + '\'' +
                ", s_est_type='" + s_est_type + '\'' +
                ", s_est_tel='" + s_est_tel + '\'' +
                ", s_est_phone='" + s_est_phone + '\'' +
                ", s_est_re='" + s_est_re + '\'' +
                ", s_est02='" + s_est02 + '\'' +
                ", s_est03=" + s_est03 +
                ", s_est04=" + s_est04 +
                ", s_est05='" + s_est05 + '\'' +
                ", s_est06='" + s_est06 + '\'' +
                ", s_est07='" + s_est07 + '\'' +
                ", s_est08='" + s_est08 + '\'' +
                ", s_est09='" + s_est09 + '\'' +
                ", s_est_confirm='" + s_est_confirm + '\'' +
                ", s_est10='" + s_est10 + '\'' +
                ", s_estud01='" + s_estud01 + '\'' +
                ", s_estud02='" + s_estud02 + '\'' +
                ", s_estud03='" + s_estud03 + '\'' +
                ", s_estud04='" + s_estud04 + '\'' +
                ", s_estud05='" + s_estud05 + '\'' +
                ", s_estud06='" + s_estud06 + '\'' +
                ", s_estud07='" + s_estud07 + '\'' +
                ", s_estud08='" + s_estud08 + '\'' +
                ", s_estud09='" + s_estud09 + '\'' +
                '}';
    }

    private String s_est_tel;
    private String s_est_phone;
    private String s_est_re;
    private String s_est02;
    private int s_est03;
    private int s_est04;
    private String s_est05;
    private String s_est06;
    private String s_est07;
    private String s_est08;
    private String s_est09;
    private String s_est_confirm;
    private String s_est10;
    private String s_estud01;
    private String s_estud02;
    private String s_estud03;
    private String s_estud04;
    private String s_estud05;
    private String s_estud06;
    private String s_estud07;
    private String s_estud08;
    private String s_estud09;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getS_est00() {
        return s_est00;
    }

    public void setS_est00(String s_est00) {
        this.s_est00 = s_est00;
    }

    public String getS_est01() {
        return s_est01;
    }

    public void setS_est01(String s_est01) {
        this.s_est01 = s_est01;
    }

    public String getS_est_name() {
        return s_est_name;
    }

    public void setS_est_name(String s_est_name) {
        this.s_est_name = s_est_name;
    }

    public String getS_est_address1() {
        return s_est_address1;
    }

    public void setS_est_address1(String s_est_address1) {
        this.s_est_address1 = s_est_address1;
    }

    public String getS_est_address2() {
        return s_est_address2;
    }

    public void setS_est_address2(String s_est_address2) {
        this.s_est_address2 = s_est_address2;
    }

    public String getS_est_address3() {
        return s_est_address3;
    }

    public void setS_est_address3(String s_est_address3) {
        this.s_est_address3 = s_est_address3;
    }

    public String getS_est_address4() {
        return s_est_address4;
    }

    public void setS_est_address4(String s_est_address4) {
        this.s_est_address4 = s_est_address4;
    }

    public String getS_est_type() {
        return s_est_type;
    }

    public void setS_est_type(String s_est_type) {
        this.s_est_type = s_est_type;
    }

    public String getS_est_tel() {
        return s_est_tel;
    }

    public void setS_est_tel(String s_est_tel) {
        this.s_est_tel = s_est_tel;
    }

    public String getS_est_phone() {
        return s_est_phone;
    }

    public void setS_est_phone(String s_est_phone) {
        this.s_est_phone = s_est_phone;
    }

    public String getS_est_re() {
        return s_est_re;
    }

    public void setS_est_re(String s_est_re) {
        this.s_est_re = s_est_re;
    }

    public String getS_est02() {
        return s_est02;
    }

    public void setS_est02(String s_est02) {
        this.s_est02 = s_est02;
    }

    public int getS_est03() {
        return s_est03;
    }

    public void setS_est03(int s_est03) {
        this.s_est03 = s_est03;
    }

    public int getS_est04() {
        return s_est04;
    }

    public void setS_est04(int s_est04) {
        this.s_est04 = s_est04;
    }

    public String getS_est05() {
        return s_est05;
    }

    public void setS_est05(String s_est05) {
        this.s_est05 = s_est05;
    }

    public String getS_est06() {
        return s_est06;
    }

    public void setS_est06(String s_est06) {
        this.s_est06 = s_est06;
    }

    public String getS_est07() {
        return s_est07;
    }

    public void setS_est07(String s_est07) {
        this.s_est07 = s_est07;
    }

    public String getS_est08() {
        return s_est08;
    }

    public void setS_est08(String s_est08) {
        this.s_est08 = s_est08;
    }

    public String getS_est09() {
        return s_est09;
    }

    public void setS_est09(String s_est09) {
        this.s_est09 = s_est09;
    }

    public String getS_est_confirm() {
        return s_est_confirm;
    }

    public void setS_est_confirm(String s_est_confirm) {
        this.s_est_confirm = s_est_confirm;
    }

    public String getS_est10() {
        return s_est10;
    }

    public void setS_est10(String s_est10) {
        this.s_est10 = s_est10;
    }

    public String getS_estud01() {
        return s_estud01;
    }

    public void setS_estud01(String s_estud01) {
        this.s_estud01 = s_estud01;
    }

    public String getS_estud02() {
        return s_estud02;
    }

    public void setS_estud02(String s_estud02) {
        this.s_estud02 = s_estud02;
    }

    public String getS_estud03() {
        return s_estud03;
    }

    public void setS_estud03(String s_estud03) {
        this.s_estud03 = s_estud03;
    }

    public String getS_estud04() {
        return s_estud04;
    }

    public void setS_estud04(String s_estud04) {
        this.s_estud04 = s_estud04;
    }

    public String getS_estud05() {
        return s_estud05;
    }

    public void setS_estud05(String s_estud05) {
        this.s_estud05 = s_estud05;
    }

    public String getS_estud06() {
        return s_estud06;
    }

    public void setS_estud06(String s_estud06) {
        this.s_estud06 = s_estud06;
    }

    public String getS_estud07() {
        return s_estud07;
    }

    public void setS_estud07(String s_estud07) {
        this.s_estud07 = s_estud07;
    }

    public String getS_estud08() {
        return s_estud08;
    }

    public void setS_estud08(String s_estud08) {
        this.s_estud08 = s_estud08;
    }

    public String getS_estud09() {
        return s_estud09;
    }

    public void setS_estud09(String s_estud09) {
        this.s_estud09 = s_estud09;
    }
}
