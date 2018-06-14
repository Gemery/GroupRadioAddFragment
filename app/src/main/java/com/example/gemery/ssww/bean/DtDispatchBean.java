package com.example.gemery.ssww.bean;

import java.io.Serializable;
import java.util.List;

public class DtDispatchBean implements Serializable {

    @Override
    public String toString() {
        return "DtDispatchBean{" +
                "TotalPageCount='" + TotalPageCount + '\'' +
                ", TotalCount='" + TotalCount + '\'' +
                ", list=" + list +
                '}';
    }

    /**
     * list : [{"id":"integer,id","s_sdt_h00":"string,
     * 经销商代码","s_sdt_hcode":"string,门店编号",
     * "s_sdt_h01":"string,配送单据编号","s_sdt_h02":"string,
     * 配送日期  几点至几点是时间范围","s_sdt_h03":"string,客户手机号码",
     * "s_sdt_h04":"string,客户姓名","s_sdt_h05":"string,客户详细收货地址",
     * "s_sdt_h06":"string,派送司机","s_sdt_h07":"string,司机手机号码",
     * "s_sdt_h08":"string,派送车牌号","s_sdt_h09":"string,发货仓库代码",
     * "s_sdt_h10":"string,发货仓库地址","s_sdt_hnote":"string,备注",
     * "s_sdt_h11":"string,是否送达的同时需要安装否","s_sdt_h12":"string,安装师傅",
     * "s_sdt_h13":"string,安装师傅手机号码","s_sdt_h14":"string,送达确认否",
     * "s_sdt_h15":"string,安装确认","s_sdt_h16":"string,制单人",
     * "s_sdt_hconfirm":"string,审核否","s_sdt_h17":"string,审核人",
     * "s_sdt_h18":"integer,审核日期(时间戳)","s_sdt_h02_date":"integer
     * 配送时间（时间戳） 方便查询","s_sdt_hud01":"string,s_sdt_hud01",
     * "s_sdt_hud02":"string,s_sdt_hud02","s_sdt_hud03":"string,s_sdt_hud03",
     * "s_sdt_hud04":"string,s_sdt_hud04","s_sdt_hud05":"string,s_sdt_hud05",
     * "s_sdt_hud06":"string,s_sdt_hud06","s_sdt_hud07":"string,s_sdt_hud07"}]
     * TotalPageCount : integer,总页数
     * TotalCount : integer,总记录数
     */

    private String TotalPageCount;
    private String TotalCount;
    private List<ListBean> list;

    public String getTotalPageCount() {
        return TotalPageCount;
    }

    public void setTotalPageCount(String TotalPageCount) {
        this.TotalPageCount = TotalPageCount;
    }

    public String getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(String TotalCount) {
        this.TotalCount = TotalCount;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable {

        @Override
        public String toString() {
            return "ListBean{" +
                    "id='" + id + '\'' +
                    ", s_sdt_h00='" + s_sdt_h00 + '\'' +
                    ", s_sdt_hcode='" + s_sdt_hcode + '\'' +
                    ", s_sdt_h01='" + s_sdt_h01 + '\'' +
                    ", s_sdt_h02='" + s_sdt_h02 + '\'' +
                    ", s_sdt_h03='" + s_sdt_h03 + '\'' +
                    ", s_sdt_h04='" + s_sdt_h04 + '\'' +
                    ", s_sdt_h05='" + s_sdt_h05 + '\'' +
                    ", s_sdt_h06='" + s_sdt_h06 + '\'' +
                    ", s_sdt_h07='" + s_sdt_h07 + '\'' +
                    ", s_sdt_h08='" + s_sdt_h08 + '\'' +
                    ", s_sdt_h09='" + s_sdt_h09 + '\'' +
                    ", s_sdt_h10='" + s_sdt_h10 + '\'' +
                    ", s_sdt_hnote='" + s_sdt_hnote + '\'' +
                    ", s_sdt_h11='" + s_sdt_h11 + '\'' +
                    ", s_sdt_h12='" + s_sdt_h12 + '\'' +
                    ", s_sdt_h13='" + s_sdt_h13 + '\'' +
                    ", s_sdt_h14='" + s_sdt_h14 + '\'' +
                    ", s_sdt_h15='" + s_sdt_h15 + '\'' +
                    ", s_sdt_h16='" + s_sdt_h16 + '\'' +
                    ", s_sdt_hconfirm='" + s_sdt_hconfirm + '\'' +
                    ", s_sdt_h17='" + s_sdt_h17 + '\'' +
                    ", s_sdt_h18='" + s_sdt_h18 + '\'' +
                    ", s_sdt_h02_date='" + s_sdt_h02_date + '\'' +
                    ", s_sdt_hud01='" + s_sdt_hud01 + '\'' +
                    ", s_sdt_hud02='" + s_sdt_hud02 + '\'' +
                    ", s_sdt_hud03='" + s_sdt_hud03 + '\'' +
                    ", s_sdt_hud04='" + s_sdt_hud04 + '\'' +
                    ", s_sdt_hud05='" + s_sdt_hud05 + '\'' +
                    ", s_sdt_hud06='" + s_sdt_hud06 + '\'' +
                    ", s_sdt_hud07='" + s_sdt_hud07 + '\'' +
                    '}';
        }

        /**
         * id : integer,id
         * s_sdt_h00 : string,经销商代码
         * s_sdt_hcode : string,门店编号
         * s_sdt_h01 : string,配送单据编号
         * s_sdt_h02 : string,配送日期  几点至几点是时间范围
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
         * s_sdt_h16 : string,制单人
         * s_sdt_hconfirm : string,审核否
         * s_sdt_h17 : string,审核人
         * s_sdt_h18 : integer,审核日期(时间戳)
         * s_sdt_h02_date : integer,配送时间（时间戳） 方便查询
         * s_sdt_hud01 : string,s_sdt_hud01
         * s_sdt_hud02 : string,s_sdt_hud02
         * s_sdt_hud03 : string,s_sdt_hud03
         * s_sdt_hud04 : string,s_sdt_hud04
         * s_sdt_hud05 : string,s_sdt_hud05
         * s_sdt_hud06 : string,s_sdt_hud06
         * s_sdt_hud07 : string,s_sdt_hud07
         */

        private String id;
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
        private String s_sdt_h18;
        private String s_sdt_h02_date;
        private String s_sdt_hud01;
        private String s_sdt_hud02;
        private String s_sdt_hud03;
        private String s_sdt_hud04;
        private String s_sdt_hud05;
        private String s_sdt_hud06;
        private String s_sdt_hud07;

        public String getId() {
            return id;
        }

        public void setId(String id) {
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

        public String getS_sdt_h18() {
            return s_sdt_h18;
        }

        public void setS_sdt_h18(String s_sdt_h18) {
            this.s_sdt_h18 = s_sdt_h18;
        }

        public String getS_sdt_h02_date() {
            return s_sdt_h02_date;
        }

        public void setS_sdt_h02_date(String s_sdt_h02_date) {
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
}
