package com.example.gemery.ssww.bean;

import java.io.Serializable;
import java.util.List;

public class BasePriceBean implements Serializable {

    /**
     * list : [{"id":1,"s_pb00":"300005","s_pb01":0,"s_pb02":"1059900138",
     * "s_pb03":"淋浴房屏风","s_pb04":"LA21-01","s_pb05":"","s_pb06":"套         ",
     * "s_pb07":1527350400,"s_pb08":1527436800,"s_pb09":102,"s_pb10":99,
     * "s_pb11":"N","s_pb12":"","s_pb_confirm_state":"Y",
     * "s_pb_confirm_user":"tiptop","s_pb_confirm_date":1527388099,
     * "s_pb_acti":"Y","s_pbud01":"","s_pbud02":"","s_pbud03":"",
     * "s_pbud04":"","s_pbud05":"","s_pbud06":"","s_pbud07":""}]
     * TotalPageCount : 2
     * TotalCount : 14
     */

    private long TotalPageCount;
    private long TotalCount;
    private List<ListBean> list;

    public long getTotalPageCount() {
        return TotalPageCount;
    }

    public void setTotalPageCount(long TotalPageCount) {
        this.TotalPageCount = TotalPageCount;
    }

    public long getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(long TotalCount) {
        this.TotalCount = TotalCount;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable {
        /**
         * id : 1
         * s_pb00 : 300005
         * s_pb01 : 0
         * s_pb02 : 1059900138
         * s_pb03 : 淋浴房屏风
         * s_pb04 : LA21-01
         * s_pb05 :
         * s_pb06 : 套
         * s_pb07 : 1527350400
         * s_pb08 : 1527436800
         * s_pb09 : 102
         * s_pb10 : 99
         * s_pb11 : N
         * s_pb12 :
         * s_pb_confirm_state : Y
         * s_pb_confirm_user : tiptop
         * s_pb_confirm_date : 1527388099
         * s_pb_acti : Y
         * s_pbud01 :
         * s_pbud02 :
         * s_pbud03 :
         * s_pbud04 :
         * s_pbud05 :
         * s_pbud06 :
         * s_pbud07 :
         */

        private long id;
        private String s_pb00;
        private long s_pb01;
        private String s_pb02;
        private String s_pb03;
        private String s_pb04;
        private String s_pb05;
        private String s_pb06;
        private long s_pb07;
        private long s_pb08;
        private long s_pb09;
        private long s_pb10;
        private String s_pb11;
        private String s_pb12;
        private String s_pb_confirm_state;
        private String s_pb_confirm_user;
        private long s_pb_confirm_date;
        private String s_pb_acti;
        private String s_pbud01;
        private String s_pbud02;
        private String s_pbud03;
        private String s_pbud04;
        private String s_pbud05;
        private String s_pbud06;
        private String s_pbud07;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getS_pb00() {
            return s_pb00;
        }

        public void setS_pb00(String s_pb00) {
            this.s_pb00 = s_pb00;
        }

        public long getS_pb01() {
            return s_pb01;
        }

        public void setS_pb01(long s_pb01) {
            this.s_pb01 = s_pb01;
        }

        public String getS_pb02() {
            return s_pb02;
        }

        public void setS_pb02(String s_pb02) {
            this.s_pb02 = s_pb02;
        }

        public String getS_pb03() {
            return s_pb03;
        }

        public void setS_pb03(String s_pb03) {
            this.s_pb03 = s_pb03;
        }

        public String getS_pb04() {
            return s_pb04;
        }

        public void setS_pb04(String s_pb04) {
            this.s_pb04 = s_pb04;
        }

        public String getS_pb05() {
            return s_pb05;
        }

        public void setS_pb05(String s_pb05) {
            this.s_pb05 = s_pb05;
        }

        public String getS_pb06() {
            return s_pb06;
        }

        public void setS_pb06(String s_pb06) {
            this.s_pb06 = s_pb06;
        }

        public long getS_pb07() {
            return s_pb07;
        }

        public void setS_pb07(long s_pb07) {
            this.s_pb07 = s_pb07;
        }

        public long getS_pb08() {
            return s_pb08;
        }

        public void setS_pb08(long s_pb08) {
            this.s_pb08 = s_pb08;
        }

        public long getS_pb09() {
            return s_pb09;
        }

        public void setS_pb09(long s_pb09) {
            this.s_pb09 = s_pb09;
        }

        public long getS_pb10() {
            return s_pb10;
        }

        public void setS_pb10(long s_pb10) {
            this.s_pb10 = s_pb10;
        }

        public String getS_pb11() {
            return s_pb11;
        }

        public void setS_pb11(String s_pb11) {
            this.s_pb11 = s_pb11;
        }

        public String getS_pb12() {
            return s_pb12;
        }

        public void setS_pb12(String s_pb12) {
            this.s_pb12 = s_pb12;
        }

        public String getS_pb_confirm_state() {
            return s_pb_confirm_state;
        }

        public void setS_pb_confirm_state(String s_pb_confirm_state) {
            this.s_pb_confirm_state = s_pb_confirm_state;
        }

        public String getS_pb_confirm_user() {
            return s_pb_confirm_user;
        }

        public void setS_pb_confirm_user(String s_pb_confirm_user) {
            this.s_pb_confirm_user = s_pb_confirm_user;
        }

        public long getS_pb_confirm_date() {
            return s_pb_confirm_date;
        }

        public void setS_pb_confirm_date(long s_pb_confirm_date) {
            this.s_pb_confirm_date = s_pb_confirm_date;
        }

        public String getS_pb_acti() {
            return s_pb_acti;
        }

        public void setS_pb_acti(String s_pb_acti) {
            this.s_pb_acti = s_pb_acti;
        }

        public String getS_pbud01() {
            return s_pbud01;
        }

        public void setS_pbud01(String s_pbud01) {
            this.s_pbud01 = s_pbud01;
        }

        public String getS_pbud02() {
            return s_pbud02;
        }

        public void setS_pbud02(String s_pbud02) {
            this.s_pbud02 = s_pbud02;
        }

        public String getS_pbud03() {
            return s_pbud03;
        }

        public void setS_pbud03(String s_pbud03) {
            this.s_pbud03 = s_pbud03;
        }

        public String getS_pbud04() {
            return s_pbud04;
        }

        public void setS_pbud04(String s_pbud04) {
            this.s_pbud04 = s_pbud04;
        }

        public String getS_pbud05() {
            return s_pbud05;
        }

        public void setS_pbud05(String s_pbud05) {
            this.s_pbud05 = s_pbud05;
        }

        public String getS_pbud06() {
            return s_pbud06;
        }

        public void setS_pbud06(String s_pbud06) {
            this.s_pbud06 = s_pbud06;
        }

        public String getS_pbud07() {
            return s_pbud07;
        }

        public void setS_pbud07(String s_pbud07) {
            this.s_pbud07 = s_pbud07;
        }
    }
}
