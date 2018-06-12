package com.example.gemery.ssww.bean;

import java.io.Serializable;

public class DispatchBean implements Serializable {

    /**
     * ima : {"s_sdt_h00":"string,经销商代码",
     * "s_sdt_hcode":"string,门店编号",
     * "s_sdt_h01":"string,配送单据编号",
     * "s_sdt_h02_date1":"integer,配送日期  小范围",
     * "s_sdt_h02_date2":"integer,配送日期  大范围",
     * "s_sdt_h03":"string,客户手机号码",
     * "s_sdt_h04":"string,客户姓名","s_sdt_h05":"string,
     * 客户详细收货地址","s_sdt_h06":"string,派送司机",
     * "s_sdt_h07":"string,司机手机号码","s_sdt_h08":"string,派送车牌号",
     * "s_sdt_h09":"string,发货仓库代码","s_sdt_h10":"string,发货仓库地址",
     * "s_sdt_hnote":"string,备注","s_sdt_h11":"string,是否送达的同时需要安装否",
     * "s_sdt_h12":"string,安装师傅","s_sdt_h13":"string,安装师傅手机号码",
     * "s_sdt_h14":"string,送达确认否","s_sdt_h15":"string,安装确认",
     * "s_sdt_hconfirm":"string,审核否","s_sdt_e03":"string,产品代码",
     * "s_sdt_e04":"string,产品名称","s_sdt_e05":"string,型号","s_sdt_e06":"string,规格"}
     * pageSize : integer,每页显示记录数
     * pageIndex : integer,页码
     */

    private ImaBean ima;
    private String pageSize;
    private String pageIndex;

    public ImaBean getIma() {
        return ima;
    }

    public void setIma(ImaBean ima) {
        this.ima = ima;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    public static class ImaBean {
        /**
         * s_sdt_h00 : string,经销商代码
         * s_sdt_hcode : string,门店编号
         * s_sdt_h01 : string,配送单据编号
         * s_sdt_h02_date1 : integer,配送日期  小范围
         * s_sdt_h02_date2 : integer,配送日期  大范围
         * s_sdt_h03 : string,客户手机号码
         * s_sdt_h04 : string,客户姓名
         * s_sdt_h05 : string,客户详细收货地址
         * s_sdt_h06 : string,派送司机
         * s_sdt_h07 : string,司机手机号码
         * s_sdt_h08 : string,派送车牌号
         * s_sdt_h09 : string,发货仓库代码
         * s_sdt_h10 : string,发货仓库地址
         * s_sdt_hnote : string,备注
         * s_sdt_h11 : string,是否送达的同时需要安装否
         * s_sdt_h12 : string,安装师傅
         * s_sdt_h13 : string,安装师傅手机号码
         * s_sdt_h14 : string,送达确认否
         * s_sdt_h15 : string,安装确认
         * s_sdt_hconfirm : string,审核否
         * s_sdt_e03 : string,产品代码
         * s_sdt_e04 : string,产品名称
         * s_sdt_e05 : string,型号
         * s_sdt_e06 : string,规格
         */

        private String s_sdt_h00;
        private String s_sdt_hcode;
        private String s_sdt_h01;
        private String s_sdt_h02_date1;
        private String s_sdt_h02_date2;
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
        private String s_sdt_hconfirm;
        private String s_sdt_e03;
        private String s_sdt_e04;
        private String s_sdt_e05;
        private String s_sdt_e06;

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

        public String getS_sdt_h02_date1() {
            return s_sdt_h02_date1;
        }

        public void setS_sdt_h02_date1(String s_sdt_h02_date1) {
            this.s_sdt_h02_date1 = s_sdt_h02_date1;
        }

        public String getS_sdt_h02_date2() {
            return s_sdt_h02_date2;
        }

        public void setS_sdt_h02_date2(String s_sdt_h02_date2) {
            this.s_sdt_h02_date2 = s_sdt_h02_date2;
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

        public String getS_sdt_hconfirm() {
            return s_sdt_hconfirm;
        }

        public void setS_sdt_hconfirm(String s_sdt_hconfirm) {
            this.s_sdt_hconfirm = s_sdt_hconfirm;
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
    }
}
