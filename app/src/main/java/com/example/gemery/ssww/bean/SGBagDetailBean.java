package com.example.gemery.ssww.bean;

import java.util.List;

public class SGBagDetailBean {


    /**
     * gbag_h : [{"id":7,"s_gbag_h00":"300005",
     * "s_gbag_h01":"300005001",
     * "s_gbag_h02":"12345678",
     * "s_gbag_h03":"xxxxxx","s_gbag_h04":"1211",
     * "s_gbag_h05":"1","s_gbag_h06":"11",
     * "s_gbag_hconfirm":"","s_gbag_h07":"",
     * "s_gbag_h08":0,"s_gbag_h09":212}]
     * gbag_e : [{"s_gbag_e_occ01":"300005",
     * "s_gbag_e_storeid":"300005001",
     * "s_gbag_e00":"12345678","s_gbag_e01":1,
     * "s_gbag_e02":"1059900137",
     * "s_gbag_e03":"淋浴房屏风",
     * "s_gbag_e04":"LA21-01","s_gbag_e05":"",
     * "s_gbag_e06":"","s_gbag_e07":1,"s_gbag_enote":"",
     * "s_gbag_e08":0,"s_gbag_e09":0,"s_gbag_eud01":"",
     * "s_gbag_eud02":"","s_gbag_eud03":"","s_gbag_eud04":"",
     * "s_gbag_eud05":"","s_gbag_eud06":"","s_gbag_eud07":""}]
     * flage : 4
     */

    private String flage;
    private List<GbagHBean> gbag_h;
    private List<GbagEBean> gbag_e;

    public String getFlage() {
        return flage;
    }

    public void setFlage(String flage) {
        this.flage = flage;
    }

    public List<GbagHBean> getGbag_h() {
        return gbag_h;
    }

    public void setGbag_h(List<GbagHBean> gbag_h) {
        this.gbag_h = gbag_h;
    }

    public List<GbagEBean> getGbag_e() {
        return gbag_e;
    }

    public void setGbag_e(List<GbagEBean> gbag_e) {
        this.gbag_e = gbag_e;
    }

    public static class GbagHBean {
        /**
         * id : 7
         * s_gbag_h00 : 300005
         * s_gbag_h01 : 300005001
         * s_gbag_h02 : 12345678
         * s_gbag_h03 : xxxxxx
         * s_gbag_h04 : 1211
         * s_gbag_h05 : 1
         * s_gbag_h06 : 11
         * s_gbag_hconfirm :
         * s_gbag_h07 :
         * s_gbag_h08 : 0
         * s_gbag_h09 : 212
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

    public static class GbagEBean {
        /**
         * s_gbag_e_occ01 : 300005
         * s_gbag_e_storeid : 300005001
         * s_gbag_e00 : 12345678
         * s_gbag_e01 : 1
         * s_gbag_e02 : 1059900137
         * s_gbag_e03 : 淋浴房屏风
         * s_gbag_e04 : LA21-01
         * s_gbag_e05 :
         * s_gbag_e06 :
         * s_gbag_e07 : 1
         * s_gbag_enote :
         * s_gbag_e08 : 0
         * s_gbag_e09 : 0
         * s_gbag_eud01 :
         * s_gbag_eud02 :
         * s_gbag_eud03 :
         * s_gbag_eud04 :
         * s_gbag_eud05 :
         * s_gbag_eud06 :
         * s_gbag_eud07 :
         */

        private String s_gbag_e_occ01;
        private String s_gbag_e_storeid;
        private String s_gbag_e00;
        private int s_gbag_e01;
        private String s_gbag_e02;
        private String s_gbag_e03;
        private String s_gbag_e04;
        private String s_gbag_e05;
        private String s_gbag_e06;
        private int s_gbag_e07;
        private String s_gbag_enote;
        private int s_gbag_e08;
        private int s_gbag_e09;
        private String s_gbag_eud01;
        private String s_gbag_eud02;
        private String s_gbag_eud03;
        private String s_gbag_eud04;
        private String s_gbag_eud05;
        private String s_gbag_eud06;
        private String s_gbag_eud07;

        public String getS_gbag_e_occ01() {
            return s_gbag_e_occ01;
        }

        public void setS_gbag_e_occ01(String s_gbag_e_occ01) {
            this.s_gbag_e_occ01 = s_gbag_e_occ01;
        }

        public String getS_gbag_e_storeid() {
            return s_gbag_e_storeid;
        }

        public void setS_gbag_e_storeid(String s_gbag_e_storeid) {
            this.s_gbag_e_storeid = s_gbag_e_storeid;
        }

        public String getS_gbag_e00() {
            return s_gbag_e00;
        }

        public void setS_gbag_e00(String s_gbag_e00) {
            this.s_gbag_e00 = s_gbag_e00;
        }

        public int getS_gbag_e01() {
            return s_gbag_e01;
        }

        public void setS_gbag_e01(int s_gbag_e01) {
            this.s_gbag_e01 = s_gbag_e01;
        }

        public String getS_gbag_e02() {
            return s_gbag_e02;
        }

        public void setS_gbag_e02(String s_gbag_e02) {
            this.s_gbag_e02 = s_gbag_e02;
        }

        public String getS_gbag_e03() {
            return s_gbag_e03;
        }

        public void setS_gbag_e03(String s_gbag_e03) {
            this.s_gbag_e03 = s_gbag_e03;
        }

        public String getS_gbag_e04() {
            return s_gbag_e04;
        }

        public void setS_gbag_e04(String s_gbag_e04) {
            this.s_gbag_e04 = s_gbag_e04;
        }

        public String getS_gbag_e05() {
            return s_gbag_e05;
        }

        public void setS_gbag_e05(String s_gbag_e05) {
            this.s_gbag_e05 = s_gbag_e05;
        }

        public String getS_gbag_e06() {
            return s_gbag_e06;
        }

        public void setS_gbag_e06(String s_gbag_e06) {
            this.s_gbag_e06 = s_gbag_e06;
        }

        public int getS_gbag_e07() {
            return s_gbag_e07;
        }

        public void setS_gbag_e07(int s_gbag_e07) {
            this.s_gbag_e07 = s_gbag_e07;
        }

        public String getS_gbag_enote() {
            return s_gbag_enote;
        }

        public void setS_gbag_enote(String s_gbag_enote) {
            this.s_gbag_enote = s_gbag_enote;
        }

        public int getS_gbag_e08() {
            return s_gbag_e08;
        }

        public void setS_gbag_e08(int s_gbag_e08) {
            this.s_gbag_e08 = s_gbag_e08;
        }

        public int getS_gbag_e09() {
            return s_gbag_e09;
        }

        public void setS_gbag_e09(int s_gbag_e09) {
            this.s_gbag_e09 = s_gbag_e09;
        }

        public String getS_gbag_eud01() {
            return s_gbag_eud01;
        }

        public void setS_gbag_eud01(String s_gbag_eud01) {
            this.s_gbag_eud01 = s_gbag_eud01;
        }

        public String getS_gbag_eud02() {
            return s_gbag_eud02;
        }

        public void setS_gbag_eud02(String s_gbag_eud02) {
            this.s_gbag_eud02 = s_gbag_eud02;
        }

        public String getS_gbag_eud03() {
            return s_gbag_eud03;
        }

        public void setS_gbag_eud03(String s_gbag_eud03) {
            this.s_gbag_eud03 = s_gbag_eud03;
        }

        public String getS_gbag_eud04() {
            return s_gbag_eud04;
        }

        public void setS_gbag_eud04(String s_gbag_eud04) {
            this.s_gbag_eud04 = s_gbag_eud04;
        }

        public String getS_gbag_eud05() {
            return s_gbag_eud05;
        }

        public void setS_gbag_eud05(String s_gbag_eud05) {
            this.s_gbag_eud05 = s_gbag_eud05;
        }

        public String getS_gbag_eud06() {
            return s_gbag_eud06;
        }

        public void setS_gbag_eud06(String s_gbag_eud06) {
            this.s_gbag_eud06 = s_gbag_eud06;
        }

        public String getS_gbag_eud07() {
            return s_gbag_eud07;
        }

        public void setS_gbag_eud07(String s_gbag_eud07) {
            this.s_gbag_eud07 = s_gbag_eud07;
        }
    }
}
