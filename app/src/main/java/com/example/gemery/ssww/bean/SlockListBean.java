package com.example.gemery.ssww.bean;

import java.util.List;

public class SlockListBean {
    /**
     {"list": [
     {
     "id": "integer,id",
     "s_lock_h00": "string,经销商代码",
     "s_lock_hcode": "string,门店编号",
     "s_lock_h01": "string,（锁库单号）备置单号",
     "s_lock_h02": "string,源单单号",
     "s_lock_h03": "string,锁单方式（1：订单 2：销售出库单 3：调拨单）",
     "s_lock_hsdate": "integer,锁单开始日期(时间戳)",
     "s_lock_hedate": "integer,锁单结束日期（如果结束日期还未出库，则自动释放出库存）(时间戳)",
     "s_lock_huser": "string,操作人员",
     "s_lock_hconfirm": "string,审核状态",
     "s_lock_h04": "integer,审核日期(时间戳)",
     "s_lock_hud01": "string,s_lock_hud01",
     "s_lock_hud02": "string,s_lock_hud02",
     "s_lock_hud03": "string,s_lock_hud03",
     "s_lock_hud04": "string,s_lock_hud04",
     "s_lock_hud05": "string,s_lock_hud05",
     "s_lock_hud06": "string,s_lock_hud06"
     }],
     "TotalPageCount": "integer,总页数",
     "TotalCount": "integer,总记录数"
     }
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

    public static class ListBean {
        /**
         * id : 48
         * s_lock_h00 : null
         * s_lock_hcode : null
         * s_lock_h01 : nullLOCK180600048
         * s_lock_h02 : stringSA180600044
         * s_lock_h03 : 订单
         * s_lock_hsdate : 0
         * s_lock_hedate : 0
         * s_lock_huser : null
         * s_lock_hconfirm : N
         * s_lock_h04 : 0
         * s_lock_hud01 : null
         * s_lock_hud02 : null
         * s_lock_hud03 : null
         * s_lock_hud04 : null
         * s_lock_hud05 : null
         * s_lock_hud06 : null
         */

        private int id;
        private String s_lock_h00;
        private String s_lock_hcode;
        private String s_lock_h01;
        private String s_lock_h02;
        private String s_lock_h03;
        private int s_lock_hsdate;
        private int s_lock_hedate;
        private String s_lock_huser;
        private String s_lock_hconfirm;
        private int s_lock_h04;
        private String s_lock_hud01;
        private String s_lock_hud02;
        private String s_lock_hud03;
        private String s_lock_hud04;
        private String s_lock_hud05;
        private String s_lock_hud06;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getS_lock_h00() {
            return s_lock_h00;
        }

        public void setS_lock_h00(String s_lock_h00) {
            this.s_lock_h00 = s_lock_h00;
        }

        public String getS_lock_hcode() {
            return s_lock_hcode;
        }

        public void setS_lock_hcode(String s_lock_hcode) {
            this.s_lock_hcode = s_lock_hcode;
        }

        public String getS_lock_h01() {
            return s_lock_h01;
        }

        public void setS_lock_h01(String s_lock_h01) {
            this.s_lock_h01 = s_lock_h01;
        }

        public String getS_lock_h02() {
            return s_lock_h02;
        }

        public void setS_lock_h02(String s_lock_h02) {
            this.s_lock_h02 = s_lock_h02;
        }

        public String getS_lock_h03() {
            return s_lock_h03;
        }

        public void setS_lock_h03(String s_lock_h03) {
            this.s_lock_h03 = s_lock_h03;
        }

        public int getS_lock_hsdate() {
            return s_lock_hsdate;
        }

        public void setS_lock_hsdate(int s_lock_hsdate) {
            this.s_lock_hsdate = s_lock_hsdate;
        }

        public int getS_lock_hedate() {
            return s_lock_hedate;
        }

        public void setS_lock_hedate(int s_lock_hedate) {
            this.s_lock_hedate = s_lock_hedate;
        }

        public String getS_lock_huser() {
            return s_lock_huser;
        }

        public void setS_lock_huser(String s_lock_huser) {
            this.s_lock_huser = s_lock_huser;
        }

        public String getS_lock_hconfirm() {
            return s_lock_hconfirm;
        }

        public void setS_lock_hconfirm(String s_lock_hconfirm) {
            this.s_lock_hconfirm = s_lock_hconfirm;
        }

        public int getS_lock_h04() {
            return s_lock_h04;
        }

        public void setS_lock_h04(int s_lock_h04) {
            this.s_lock_h04 = s_lock_h04;
        }

        public String getS_lock_hud01() {
            return s_lock_hud01;
        }

        public void setS_lock_hud01(String s_lock_hud01) {
            this.s_lock_hud01 = s_lock_hud01;
        }

        public String getS_lock_hud02() {
            return s_lock_hud02;
        }

        public void setS_lock_hud02(String s_lock_hud02) {
            this.s_lock_hud02 = s_lock_hud02;
        }

        public String getS_lock_hud03() {
            return s_lock_hud03;
        }

        public void setS_lock_hud03(String s_lock_hud03) {
            this.s_lock_hud03 = s_lock_hud03;
        }

        public String getS_lock_hud04() {
            return s_lock_hud04;
        }

        public void setS_lock_hud04(String s_lock_hud04) {
            this.s_lock_hud04 = s_lock_hud04;
        }

        public String getS_lock_hud05() {
            return s_lock_hud05;
        }

        public void setS_lock_hud05(String s_lock_hud05) {
            this.s_lock_hud05 = s_lock_hud05;
        }

        public String getS_lock_hud06() {
            return s_lock_hud06;
        }

        public void setS_lock_hud06(String s_lock_hud06) {
            this.s_lock_hud06 = s_lock_hud06;
        }
    }
}
