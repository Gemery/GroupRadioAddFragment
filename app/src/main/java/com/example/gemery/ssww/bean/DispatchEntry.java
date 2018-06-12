package com.example.gemery.ssww.bean;

import java.util.List;

public class DispatchEntry {


    /**
     * sdt_hList : [{"id":12,"s_sdt_h00":"300005","s_sdt_hcode":"300005001","s_sdt_h01":"300005001SDT180600001",
     * "s_sdt_h02":"2018-06-07 12:00~2018-06-07 17:00","s_sdt_h03":"15989217947",
     * "s_sdt_h04":"林鹏辉","s_sdt_h05":"家家卫浴有限公司","s_sdt_h06":"lin",
     * "s_sdt_h07":"15989217947","s_sdt_h08":"粤EHP859","s_sdt_h09":"102","s_sdt_h10":"芦苞工业园","s_sdt_hnote":"12",
     * "s_sdt_h11":"Y","s_sdt_h12":"ceshi","s_sdt_h13":"15989217946","s_sdt_h14":"N",
     * "s_sdt_h15":"N","s_sdt_h16":"tiptop","s_sdt_hconfirm":"N","s_sdt_h17":"",
     * "s_sdt_h18":0,"s_sdt_h02_date":0,"s_sdt_hud01":"","s_sdt_hud02":"",
     * "s_sdt_hud03":"","s_sdt_hud04":"","s_sdt_hud05":"","s_sdt_hud06":"","s_sdt_hud07":""}]
     * sdt_eList : [{"s_sdt_e01":"300005001SDT180600001","s_sdt_e02":1,
     * "s_sdt_e03":"1059900137","s_sdt_e04":"淋浴房屏风","s_sdt_e05":"LA21-01","s_sdt_e06":"","s_sdt_e07":"套         ",
     * "s_sdt_e08":4,"s_sdt_eud01":"","s_sdt_eud02":"","s_sdt_eud03":"","s_sdt_eud04":"",
     * "s_sdt_eud05":"","s_sdt_eud06":"","s_sdt_eud07":""}]
     * flage : 4
     */

    private String flage;
    private List<SdtHListBean> sdt_hList;
    private List<SdtEListBean> sdt_eList;

    public String getFlage() {
        return flage;
    }

    public void setFlage(String flage) {
        this.flage = flage;
    }

    public List<SdtHListBean> getSdt_hList() {
        return sdt_hList;
    }

    public void setSdt_hList(List<SdtHListBean> sdt_hList) {
        this.sdt_hList = sdt_hList;
    }

    public List<SdtEListBean> getSdt_eList() {
        return sdt_eList;
    }

    public void setSdt_eList(List<SdtEListBean> sdt_eList) {
        this.sdt_eList = sdt_eList;
    }

    public static class SdtHListBean {
        /**
         * id : 12
         * s_sdt_h00 : 300005
         * s_sdt_hcode : 300005001
         * s_sdt_h01 : 300005001SDT180600001
         * s_sdt_h02 : 2018-06-07 12:00~2018-06-07 17:00
         * s_sdt_h03 : 15989217947
         * s_sdt_h04 : 林鹏辉
         * s_sdt_h05 : 家家卫浴有限公司
         * s_sdt_h06 : lin
         * s_sdt_h07 : 15989217947
         * s_sdt_h08 : 粤EHP859
         * s_sdt_h09 : 102
         * s_sdt_h10 : 芦苞工业园
         * s_sdt_hnote : 12
         * s_sdt_h11 : Y
         * s_sdt_h12 : ceshi
         * s_sdt_h13 : 15989217946
         * s_sdt_h14 : N
         * s_sdt_h15 : N
         * s_sdt_h16 : tiptop
         * s_sdt_hconfirm : N
         * s_sdt_h17 :
         * s_sdt_h18 : 0
         * s_sdt_h02_date : 0
         * s_sdt_hud01 :
         * s_sdt_hud02 :
         * s_sdt_hud03 :
         * s_sdt_hud04 :
         * s_sdt_hud05 :
         * s_sdt_hud06 :
         * s_sdt_hud07 :
         */

        private int id;
        private String s_sdt_h00;
        private String s_sdt_hcode;
        private String s_sdt_h01;
        private String s_sdt_h02;
        private String s_sdt_h03;
        private String s_sdt_h04;
        private String s_sdt_h05;
        private String s_sdt_h06;
        private String s_sdt_h07;
        private String s_sdt_h08;
        private String s_sdt_h09;
        private String s_sdt_h10;
        private String s_sdt_hnote;
        private String s_sdt_h11;
        private String s_sdt_h12;
        private String s_sdt_h13;
        private String s_sdt_h14;
        private String s_sdt_h15;
        private String s_sdt_h16;
        private String s_sdt_hconfirm;
        private String s_sdt_h17;
        private int s_sdt_h18;
        private int s_sdt_h02_date;
        private String s_sdt_hud01;
        private String s_sdt_hud02;
        private String s_sdt_hud03;
        private String s_sdt_hud04;
        private String s_sdt_hud05;
        private String s_sdt_hud06;
        private String s_sdt_hud07;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getS_sdt_h00() {
            return s_sdt_h00;
        }

        public void setS_sdt_h00(String s_sdt_h00) {
            this.s_sdt_h00 = s_sdt_h00;
        }

        public String getS_sdt_hcode() {
            return s_sdt_hcode;
        }

        public void setS_sdt_hcode(String s_sdt_hcode) {
            this.s_sdt_hcode = s_sdt_hcode;
        }

        public String getS_sdt_h01() {
            return s_sdt_h01;
        }

        public void setS_sdt_h01(String s_sdt_h01) {
            this.s_sdt_h01 = s_sdt_h01;
        }

        public String getS_sdt_h02() {
            return s_sdt_h02;
        }

        public void setS_sdt_h02(String s_sdt_h02) {
            this.s_sdt_h02 = s_sdt_h02;
        }

        public String getS_sdt_h03() {
            return s_sdt_h03;
        }

        public void setS_sdt_h03(String s_sdt_h03) {
            this.s_sdt_h03 = s_sdt_h03;
        }

        public String getS_sdt_h04() {
            return s_sdt_h04;
        }

        public void setS_sdt_h04(String s_sdt_h04) {
            this.s_sdt_h04 = s_sdt_h04;
        }

        public String getS_sdt_h05() {
            return s_sdt_h05;
        }

        public void setS_sdt_h05(String s_sdt_h05) {
            this.s_sdt_h05 = s_sdt_h05;
        }

        public String getS_sdt_h06() {
            return s_sdt_h06;
        }

        public void setS_sdt_h06(String s_sdt_h06) {
            this.s_sdt_h06 = s_sdt_h06;
        }

        public String getS_sdt_h07() {
            return s_sdt_h07;
        }

        public void setS_sdt_h07(String s_sdt_h07) {
            this.s_sdt_h07 = s_sdt_h07;
        }

        public String getS_sdt_h08() {
            return s_sdt_h08;
        }

        public void setS_sdt_h08(String s_sdt_h08) {
            this.s_sdt_h08 = s_sdt_h08;
        }

        public String getS_sdt_h09() {
            return s_sdt_h09;
        }

        public void setS_sdt_h09(String s_sdt_h09) {
            this.s_sdt_h09 = s_sdt_h09;
        }

        public String getS_sdt_h10() {
            return s_sdt_h10;
        }

        public void setS_sdt_h10(String s_sdt_h10) {
            this.s_sdt_h10 = s_sdt_h10;
        }

        public String getS_sdt_hnote() {
            return s_sdt_hnote;
        }

        public void setS_sdt_hnote(String s_sdt_hnote) {
            this.s_sdt_hnote = s_sdt_hnote;
        }

        public String getS_sdt_h11() {
            return s_sdt_h11;
        }

        public void setS_sdt_h11(String s_sdt_h11) {
            this.s_sdt_h11 = s_sdt_h11;
        }

        public String getS_sdt_h12() {
            return s_sdt_h12;
        }

        public void setS_sdt_h12(String s_sdt_h12) {
            this.s_sdt_h12 = s_sdt_h12;
        }

        public String getS_sdt_h13() {
            return s_sdt_h13;
        }

        public void setS_sdt_h13(String s_sdt_h13) {
            this.s_sdt_h13 = s_sdt_h13;
        }

        public String getS_sdt_h14() {
            return s_sdt_h14;
        }

        public void setS_sdt_h14(String s_sdt_h14) {
            this.s_sdt_h14 = s_sdt_h14;
        }

        public String getS_sdt_h15() {
            return s_sdt_h15;
        }

        public void setS_sdt_h15(String s_sdt_h15) {
            this.s_sdt_h15 = s_sdt_h15;
        }

        public String getS_sdt_h16() {
            return s_sdt_h16;
        }

        public void setS_sdt_h16(String s_sdt_h16) {
            this.s_sdt_h16 = s_sdt_h16;
        }

        public String getS_sdt_hconfirm() {
            return s_sdt_hconfirm;
        }

        public void setS_sdt_hconfirm(String s_sdt_hconfirm) {
            this.s_sdt_hconfirm = s_sdt_hconfirm;
        }

        public String getS_sdt_h17() {
            return s_sdt_h17;
        }

        public void setS_sdt_h17(String s_sdt_h17) {
            this.s_sdt_h17 = s_sdt_h17;
        }

        public int getS_sdt_h18() {
            return s_sdt_h18;
        }

        public void setS_sdt_h18(int s_sdt_h18) {
            this.s_sdt_h18 = s_sdt_h18;
        }

        public int getS_sdt_h02_date() {
            return s_sdt_h02_date;
        }

        public void setS_sdt_h02_date(int s_sdt_h02_date) {
            this.s_sdt_h02_date = s_sdt_h02_date;
        }

        public String getS_sdt_hud01() {
            return s_sdt_hud01;
        }

        public void setS_sdt_hud01(String s_sdt_hud01) {
            this.s_sdt_hud01 = s_sdt_hud01;
        }

        public String getS_sdt_hud02() {
            return s_sdt_hud02;
        }

        public void setS_sdt_hud02(String s_sdt_hud02) {
            this.s_sdt_hud02 = s_sdt_hud02;
        }

        public String getS_sdt_hud03() {
            return s_sdt_hud03;
        }

        public void setS_sdt_hud03(String s_sdt_hud03) {
            this.s_sdt_hud03 = s_sdt_hud03;
        }

        public String getS_sdt_hud04() {
            return s_sdt_hud04;
        }

        public void setS_sdt_hud04(String s_sdt_hud04) {
            this.s_sdt_hud04 = s_sdt_hud04;
        }

        public String getS_sdt_hud05() {
            return s_sdt_hud05;
        }

        public void setS_sdt_hud05(String s_sdt_hud05) {
            this.s_sdt_hud05 = s_sdt_hud05;
        }

        public String getS_sdt_hud06() {
            return s_sdt_hud06;
        }

        public void setS_sdt_hud06(String s_sdt_hud06) {
            this.s_sdt_hud06 = s_sdt_hud06;
        }

        public String getS_sdt_hud07() {
            return s_sdt_hud07;
        }

        public void setS_sdt_hud07(String s_sdt_hud07) {
            this.s_sdt_hud07 = s_sdt_hud07;
        }
    }

    public static class SdtEListBean {
        /**
         * s_sdt_e01 : 300005001SDT180600001
         * s_sdt_e02 : 1
         * s_sdt_e03 : 1059900137
         * s_sdt_e04 : 淋浴房屏风
         * s_sdt_e05 : LA21-01
         * s_sdt_e06 :
         * s_sdt_e07 : 套
         * s_sdt_e08 : 4
         * s_sdt_eud01 :
         * s_sdt_eud02 :
         * s_sdt_eud03 :
         * s_sdt_eud04 :
         * s_sdt_eud05 :
         * s_sdt_eud06 :
         * s_sdt_eud07 :
         */

        private String s_sdt_e01;
        private int s_sdt_e02;
        private String s_sdt_e03;
        private String s_sdt_e04;
        private String s_sdt_e05;
        private String s_sdt_e06;
        private String s_sdt_e07;
        private int s_sdt_e08;
        private String s_sdt_eud01;
        private String s_sdt_eud02;
        private String s_sdt_eud03;
        private String s_sdt_eud04;
        private String s_sdt_eud05;
        private String s_sdt_eud06;
        private String s_sdt_eud07;

        public String getS_sdt_e01() {
            return s_sdt_e01;
        }

        public void setS_sdt_e01(String s_sdt_e01) {
            this.s_sdt_e01 = s_sdt_e01;
        }

        public int getS_sdt_e02() {
            return s_sdt_e02;
        }

        public void setS_sdt_e02(int s_sdt_e02) {
            this.s_sdt_e02 = s_sdt_e02;
        }

        public String getS_sdt_e03() {
            return s_sdt_e03;
        }

        public void setS_sdt_e03(String s_sdt_e03) {
            this.s_sdt_e03 = s_sdt_e03;
        }

        public String getS_sdt_e04() {
            return s_sdt_e04;
        }

        public void setS_sdt_e04(String s_sdt_e04) {
            this.s_sdt_e04 = s_sdt_e04;
        }

        public String getS_sdt_e05() {
            return s_sdt_e05;
        }

        public void setS_sdt_e05(String s_sdt_e05) {
            this.s_sdt_e05 = s_sdt_e05;
        }

        public String getS_sdt_e06() {
            return s_sdt_e06;
        }

        public void setS_sdt_e06(String s_sdt_e06) {
            this.s_sdt_e06 = s_sdt_e06;
        }

        public String getS_sdt_e07() {
            return s_sdt_e07;
        }

        public void setS_sdt_e07(String s_sdt_e07) {
            this.s_sdt_e07 = s_sdt_e07;
        }

        public int getS_sdt_e08() {
            return s_sdt_e08;
        }

        public void setS_sdt_e08(int s_sdt_e08) {
            this.s_sdt_e08 = s_sdt_e08;
        }

        public String getS_sdt_eud01() {
            return s_sdt_eud01;
        }

        public void setS_sdt_eud01(String s_sdt_eud01) {
            this.s_sdt_eud01 = s_sdt_eud01;
        }

        public String getS_sdt_eud02() {
            return s_sdt_eud02;
        }

        public void setS_sdt_eud02(String s_sdt_eud02) {
            this.s_sdt_eud02 = s_sdt_eud02;
        }

        public String getS_sdt_eud03() {
            return s_sdt_eud03;
        }

        public void setS_sdt_eud03(String s_sdt_eud03) {
            this.s_sdt_eud03 = s_sdt_eud03;
        }

        public String getS_sdt_eud04() {
            return s_sdt_eud04;
        }

        public void setS_sdt_eud04(String s_sdt_eud04) {
            this.s_sdt_eud04 = s_sdt_eud04;
        }

        public String getS_sdt_eud05() {
            return s_sdt_eud05;
        }

        public void setS_sdt_eud05(String s_sdt_eud05) {
            this.s_sdt_eud05 = s_sdt_eud05;
        }

        public String getS_sdt_eud06() {
            return s_sdt_eud06;
        }

        public void setS_sdt_eud06(String s_sdt_eud06) {
            this.s_sdt_eud06 = s_sdt_eud06;
        }

        public String getS_sdt_eud07() {
            return s_sdt_eud07;
        }

        public void setS_sdt_eud07(String s_sdt_eud07) {
            this.s_sdt_eud07 = s_sdt_eud07;
        }
    }
}
