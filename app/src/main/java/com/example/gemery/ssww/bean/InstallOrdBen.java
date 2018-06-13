package com.example.gemery.ssww.bean;

import java.io.Serializable;
import java.util.List;

public class InstallOrdBen implements Serializable{
    /**
     * list : [{"id":1,"s_ist_h00":"300005","s_ist_hcode":"300005001",
     * "s_ist_h01":"300005001IST180600001","s_ist_h02":"2018-06-08 13:00~2018-06-08 18:00",
     * "s_ist_h03":"15989217947","s_ist_h04":"林鹏辉","s_ist_h05":"家家卫浴有限公司",
     * "s_ist_h06":"linpenghui","s_ist_h07":"13620123454","s_ist_h08":"N:未确认",
     * "s_ist_h09":"tiptop","s_ist_hconfirm":"N","s_ist_h10":"tiptop",
     * "s_ist_h11":1528421476,"s_ist_h02_date":1528434000,"s_ist_hud01":"",
     * "s_ist_hud02":"","s_ist_hud03":"","s_ist_hud04":"","s_ist_hud05":"","s_ist_hud06":""}],
     * TotalPageCount : 1
     * TotalCount : 2
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
         * id : 1
         * s_ist_h00 : 300005
         * s_ist_hcode : 300005001
         * s_ist_h01 : 300005001IST180600001
         * s_ist_h02 : 2018-06-08 13:00~2018-06-08 18:00
         * s_ist_h03 : 15989217947
         * s_ist_h04 : 林鹏辉
         * s_ist_h05 : 家家卫浴有限公司
         * s_ist_h06 : linpenghui
         * s_ist_h07 : 13620123454
         * s_ist_h08 : N:未确认
         * s_ist_h09 : tiptop
         * s_ist_hconfirm : N
         * s_ist_h10 : tiptop
         * s_ist_h11 : 1528421476
         * s_ist_h02_date : 1528434000
         * s_ist_hud01 :
         * s_ist_hud02 :
         * s_ist_hud03 :
         * s_ist_hud04 :
         * s_ist_hud05 :
         * s_ist_hud06 :
         */

        private int id;
        private String s_ist_h00;
        private String s_ist_hcode;
        private String s_ist_h01;
        private String s_ist_h02;
        private String s_ist_h03;
        private String s_ist_h04;
        private String s_ist_h05;
        private String s_ist_h06;
        private String s_ist_h07;
        private String s_ist_h08;
        private String s_ist_h09;
        private String s_ist_hconfirm;
        private String s_ist_h10;
        private int s_ist_h11;
        private int s_ist_h02_date;
        private String s_ist_hud01;
        private String s_ist_hud02;
        private String s_ist_hud03;
        private String s_ist_hud04;
        private String s_ist_hud05;
        private String s_ist_hud06;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getS_ist_h00() {
            return s_ist_h00;
        }

        public void setS_ist_h00(String s_ist_h00) {
            this.s_ist_h00 = s_ist_h00;
        }

        public String getS_ist_hcode() {
            return s_ist_hcode;
        }

        public void setS_ist_hcode(String s_ist_hcode) {
            this.s_ist_hcode = s_ist_hcode;
        }

        public String getS_ist_h01() {
            return s_ist_h01;
        }

        public void setS_ist_h01(String s_ist_h01) {
            this.s_ist_h01 = s_ist_h01;
        }

        public String getS_ist_h02() {
            return s_ist_h02;
        }

        public void setS_ist_h02(String s_ist_h02) {
            this.s_ist_h02 = s_ist_h02;
        }

        public String getS_ist_h03() {
            return s_ist_h03;
        }

        public void setS_ist_h03(String s_ist_h03) {
            this.s_ist_h03 = s_ist_h03;
        }

        public String getS_ist_h04() {
            return s_ist_h04;
        }

        public void setS_ist_h04(String s_ist_h04) {
            this.s_ist_h04 = s_ist_h04;
        }

        public String getS_ist_h05() {
            return s_ist_h05;
        }

        public void setS_ist_h05(String s_ist_h05) {
            this.s_ist_h05 = s_ist_h05;
        }

        public String getS_ist_h06() {
            return s_ist_h06;
        }

        public void setS_ist_h06(String s_ist_h06) {
            this.s_ist_h06 = s_ist_h06;
        }

        public String getS_ist_h07() {
            return s_ist_h07;
        }

        public void setS_ist_h07(String s_ist_h07) {
            this.s_ist_h07 = s_ist_h07;
        }

        public String getS_ist_h08() {
            return s_ist_h08;
        }

        public void setS_ist_h08(String s_ist_h08) {
            this.s_ist_h08 = s_ist_h08;
        }

        public String getS_ist_h09() {
            return s_ist_h09;
        }

        public void setS_ist_h09(String s_ist_h09) {
            this.s_ist_h09 = s_ist_h09;
        }

        public String getS_ist_hconfirm() {
            return s_ist_hconfirm;
        }

        public void setS_ist_hconfirm(String s_ist_hconfirm) {
            this.s_ist_hconfirm = s_ist_hconfirm;
        }

        public String getS_ist_h10() {
            return s_ist_h10;
        }

        public void setS_ist_h10(String s_ist_h10) {
            this.s_ist_h10 = s_ist_h10;
        }

        public int getS_ist_h11() {
            return s_ist_h11;
        }

        public void setS_ist_h11(int s_ist_h11) {
            this.s_ist_h11 = s_ist_h11;
        }

        public int getS_ist_h02_date() {
            return s_ist_h02_date;
        }

        public void setS_ist_h02_date(int s_ist_h02_date) {
            this.s_ist_h02_date = s_ist_h02_date;
        }

        public String getS_ist_hud01() {
            return s_ist_hud01;
        }

        public void setS_ist_hud01(String s_ist_hud01) {
            this.s_ist_hud01 = s_ist_hud01;
        }

        public String getS_ist_hud02() {
            return s_ist_hud02;
        }

        public void setS_ist_hud02(String s_ist_hud02) {
            this.s_ist_hud02 = s_ist_hud02;
        }

        public String getS_ist_hud03() {
            return s_ist_hud03;
        }

        public void setS_ist_hud03(String s_ist_hud03) {
            this.s_ist_hud03 = s_ist_hud03;
        }

        public String getS_ist_hud04() {
            return s_ist_hud04;
        }

        public void setS_ist_hud04(String s_ist_hud04) {
            this.s_ist_hud04 = s_ist_hud04;
        }

        public String getS_ist_hud05() {
            return s_ist_hud05;
        }

        public void setS_ist_hud05(String s_ist_hud05) {
            this.s_ist_hud05 = s_ist_hud05;
        }

        public String getS_ist_hud06() {
            return s_ist_hud06;
        }

        public void setS_ist_hud06(String s_ist_hud06) {
            this.s_ist_hud06 = s_ist_hud06;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "id=" + id +
                    ", s_ist_h00='" + s_ist_h00 + '\'' +
                    ", s_ist_hcode='" + s_ist_hcode + '\'' +
                    ", s_ist_h01='" + s_ist_h01 + '\'' +
                    ", s_ist_h02='" + s_ist_h02 + '\'' +
                    ", s_ist_h03='" + s_ist_h03 + '\'' +
                    ", s_ist_h04='" + s_ist_h04 + '\'' +
                    ", s_ist_h05='" + s_ist_h05 + '\'' +
                    ", s_ist_h06='" + s_ist_h06 + '\'' +
                    ", s_ist_h07='" + s_ist_h07 + '\'' +
                    ", s_ist_h08='" + s_ist_h08 + '\'' +
                    ", s_ist_h09='" + s_ist_h09 + '\'' +
                    ", s_ist_hconfirm='" + s_ist_hconfirm + '\'' +
                    ", s_ist_h10='" + s_ist_h10 + '\'' +
                    ", s_ist_h11=" + s_ist_h11 +
                    ", s_ist_h02_date=" + s_ist_h02_date +
                    ", s_ist_hud01='" + s_ist_hud01 + '\'' +
                    ", s_ist_hud02='" + s_ist_hud02 + '\'' +
                    ", s_ist_hud03='" + s_ist_hud03 + '\'' +
                    ", s_ist_hud04='" + s_ist_hud04 + '\'' +
                    ", s_ist_hud05='" + s_ist_hud05 + '\'' +
                    ", s_ist_hud06='" + s_ist_hud06 + '\'' +
                    '}';
        }
    }
}
