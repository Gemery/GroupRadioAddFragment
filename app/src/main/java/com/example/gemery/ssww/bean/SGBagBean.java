package com.example.gemery.ssww.bean;

import java.io.Serializable;
import java.util.List;

public class SGBagBean implements Serializable{


    /**
     * list : [{"id":8,"s_gbag_h00":"300005",
     * "s_gbag_h01":"300005001",
     * "s_gbag_h02":"1234431","s_gbag_h03":"xxxx121",
     * "s_gbag_h04":"12343","s_gbag_h05":"xx","s_gbag_h06":"12",
     * "s_gbag_hconfirm":"","s_gbag_h07":"","s_gbag_h08":0,
     * "s_gbag_h09":121}]
     * TotalPageCount : 1
     * TotalCount : 8
     */

    private int TotalPageCount;
    private int TotalCount;
    private List<ListBean> list;

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

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable {
        /**
         * id : 8
         * s_gbag_h00 : 300005
         * s_gbag_h01 : 300005001
         * s_gbag_h02 : 1234431
         * s_gbag_h03 : xxxx121
         * s_gbag_h04 : 12343
         * s_gbag_h05 : xx
         * s_gbag_h06 : 12
         * s_gbag_hconfirm :
         * s_gbag_h07 :
         * s_gbag_h08 : 0
         * s_gbag_h09 : 121
         */

        private int id;
        private String s_gbag_h00;
        private String s_gbag_h01;
        private String s_gbag_h02;
        private String s_gbag_h03;
        private String s_gbag_h04;
        private String s_gbag_h05;
        private String s_gbag_h06;
        private String s_gbag_hconfirm;
        private String s_gbag_h07;
        private int s_gbag_h08;
        private int s_gbag_h09;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getS_gbag_h00() {
            return s_gbag_h00;
        }

        public void setS_gbag_h00(String s_gbag_h00) {
            this.s_gbag_h00 = s_gbag_h00;
        }

        public String getS_gbag_h01() {
            return s_gbag_h01;
        }

        public void setS_gbag_h01(String s_gbag_h01) {
            this.s_gbag_h01 = s_gbag_h01;
        }

        public String getS_gbag_h02() {
            return s_gbag_h02;
        }

        public void setS_gbag_h02(String s_gbag_h02) {
            this.s_gbag_h02 = s_gbag_h02;
        }

        public String getS_gbag_h03() {
            return s_gbag_h03;
        }

        public void setS_gbag_h03(String s_gbag_h03) {
            this.s_gbag_h03 = s_gbag_h03;
        }

        public String getS_gbag_h04() {
            return s_gbag_h04;
        }

        public void setS_gbag_h04(String s_gbag_h04) {
            this.s_gbag_h04 = s_gbag_h04;
        }

        public String getS_gbag_h05() {
            return s_gbag_h05;
        }

        public void setS_gbag_h05(String s_gbag_h05) {
            this.s_gbag_h05 = s_gbag_h05;
        }

        public String getS_gbag_h06() {
            return s_gbag_h06;
        }

        public void setS_gbag_h06(String s_gbag_h06) {
            this.s_gbag_h06 = s_gbag_h06;
        }

        public String getS_gbag_hconfirm() {
            return s_gbag_hconfirm;
        }

        public void setS_gbag_hconfirm(String s_gbag_hconfirm) {
            this.s_gbag_hconfirm = s_gbag_hconfirm;
        }

        public String getS_gbag_h07() {
            return s_gbag_h07;
        }

        public void setS_gbag_h07(String s_gbag_h07) {
            this.s_gbag_h07 = s_gbag_h07;
        }

        public int getS_gbag_h08() {
            return s_gbag_h08;
        }

        public void setS_gbag_h08(int s_gbag_h08) {
            this.s_gbag_h08 = s_gbag_h08;
        }

        public int getS_gbag_h09() {
            return s_gbag_h09;
        }

        public void setS_gbag_h09(int s_gbag_h09) {
            this.s_gbag_h09 = s_gbag_h09;
        }
    }
}
