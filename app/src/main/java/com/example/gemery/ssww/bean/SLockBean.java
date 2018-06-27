package com.example.gemery.ssww.bean;

import java.util.List;

public class SLockBean {


    @Override
    public String toString() {
        return "{" +
                "flage:'" + flage + '\'' +
                ", lock_h_list:" + lock_h_list +
                ", lock_e_list:" + lock_e_list +
                '}';
    }

    /**
     * lock_h_list : [{"id":"integer,id","s_lock_h00":"string,经销商代码",
     * "s_lock_hcode":"string,门店编号","s_lock_h01":"string,（锁库单号）备置单号",
     * "s_lock_h02":"string,源单单号","s_lock_h03":"string,锁单方式（1：订单 2：销售出库单 3：调拨单）",
     * "s_lock_hsdate":"integer,锁单开始日期(时间戳)","s_lock_hedate":"integer,
     * 锁单结束日期（如果结束日期还未出库，则自动释放出库存）(时间戳)","s_lock_huser":"string,操作人员",
     * "s_lock_hconfirm":"string,审核状态","s_lock_h04":"integer,审核日期(时间戳)",
     * "s_lock_hud01":"string,s_lock_hud01","s_lock_hud02":"string,s_lock_hud02",
     * "s_lock_hud03":"string,s_lock_hud03","s_lock_hud04":"string,
     * s_lock_hud04","s_lock_hud05":"string,s_lock_hud05","s_lock_hud06":"string,s_lock_hud06"}]
     * lock_e_list : [{"s_lock_e01":"string,（锁库单号）备置单号","s_lock_e02":"integer,项次",
     * "s_lock_e03":"string,源单单号","s_lock_e04":"integer,项次","s_lock_e05":"string,
     * 物料代码","s_lock_e06":"string,物料名称","s_lock_e07":"string,型号","s_lock_e08":"string,
     * 规格","s_lock_e09":"string,单位","s_lock_e10":"double,锁库存数量","s_lock_e11":"double,
     * 锁库存已处理量","s_lock_e12":"string,仓库代码",
     * "s_lock_e13":"string,仓库库位","s_lock_e14":"string,批次号",
     * "s_lock_eud01":"string,s_lock_eud01","s_lock_eud02":"string,s_lock_eud02",
     * "s_lock_eud03":"string,s_lock_eud03","s_lock_eud04":"string,s_lock_eud04",
     * "s_lock_eud05":"string,s_lock_eud05","s_lock_eud06":"string,s_lock_eud06"}]
     * flage : string,1:添加 2：修改 3：删除
     */

    private String flage;
    private List<LockHListBean> lock_h_list;
    private List<LockEListBean> lock_e_list;

    public String getFlage() {
        return flage;
    }

    public void setFlage(String flage) {
        this.flage = flage;
    }

    public List<LockHListBean> getLock_h_list() {
        return lock_h_list;
    }

    public void setLock_h_list(List<LockHListBean> lock_h_list) {
        this.lock_h_list = lock_h_list;
    }

    public List<LockEListBean> getLock_e_list() {
        return lock_e_list;
    }

    public void setLock_e_list(List<LockEListBean> lock_e_list) {
        this.lock_e_list = lock_e_list;
    }

    public static class LockHListBean {
        @Override
        public String toString() {
            return "{" +
                    "id:'" + id + '\'' +
                    ", s_lock_h00:'" + s_lock_h00 + '\'' +
                    ", s_lock_hcode:'" + s_lock_hcode + '\'' +
                    ", s_lock_h01:'" + s_lock_h01 + '\'' +
                    ", s_lock_h02:'" + s_lock_h02 + '\'' +
                    ", s_lock_h03:'" + s_lock_h03 + '\'' +
                    ", s_lock_hsdate:'" + s_lock_hsdate + '\'' +
                    ", s_lock_hedate:'" + s_lock_hedate + '\'' +
                    ", s_lock_huser:'" + s_lock_huser + '\'' +
                    ", s_lock_hconfirm:'" + s_lock_hconfirm + '\'' +
                    ", s_lock_h04:'" + s_lock_h04 + '\'' +
                    ", s_lock_hud01:'" + s_lock_hud01 + '\'' +
                    ", s_lock_hud02:'" + s_lock_hud02 + '\'' +
                    ", s_lock_hud03:'" + s_lock_hud03 + '\'' +
                    ", s_lock_hud04:'" + s_lock_hud04 + '\'' +
                    ", s_lock_hud05:'" + s_lock_hud05 + '\'' +
                    ", s_lock_hud06:'" + s_lock_hud06 + '\'' +
                    '}';
        }

        /**
         * id : integer,id
         * s_lock_h00 : string,经销商代码
         * s_lock_hcode : string,门店编号
         * s_lock_h01 : string,（锁库单号）备置单号
         * s_lock_h02 : string,源单单号
         * s_lock_h03 : string,锁单方式（1：订单 2：销售出库单 3：调拨单）
         * s_lock_hsdate : integer,锁单开始日期(时间戳)
         * s_lock_hedate : integer,锁单结束日期（如果结束日期还未出库，则自动释放出库存）(时间戳)
         * s_lock_huser : string,操作人员
         * s_lock_hconfirm : string,审核状态
         * s_lock_h04 : integer,审核日期(时间戳)
         * s_lock_hud01 : string,s_lock_hud01
         * s_lock_hud02 : string,s_lock_hud02
         * s_lock_hud03 : string,s_lock_hud03
         * s_lock_hud04 : string,s_lock_hud04
         * s_lock_hud05 : string,s_lock_hud05
         * s_lock_hud06 : string,s_lock_hud06
         */

        private String id;
        private String s_lock_h00;
        private String s_lock_hcode;
        private String s_lock_h01;
        private String s_lock_h02;
        private String s_lock_h03;
        private String s_lock_hsdate;
        private String s_lock_hedate;
        private String s_lock_huser;
        private String s_lock_hconfirm;
        private String s_lock_h04;
        private String s_lock_hud01;
        private String s_lock_hud02;
        private String s_lock_hud03;
        private String s_lock_hud04;
        private String s_lock_hud05;
        private String s_lock_hud06;

        public String getId() {
            return id;
        }

        public void setId(String id) {
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

        public String getS_lock_hsdate() {
            return s_lock_hsdate;
        }

        public void setS_lock_hsdate(String s_lock_hsdate) {
            this.s_lock_hsdate = s_lock_hsdate;
        }

        public String getS_lock_hedate() {
            return s_lock_hedate;
        }

        public void setS_lock_hedate(String s_lock_hedate) {
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

        public String getS_lock_h04() {
            return s_lock_h04;
        }

        public void setS_lock_h04(String s_lock_h04) {
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

    public static class LockEListBean {
        @Override
        public String toString() {
            return "{" +
                    "s_lock_e01:'" + s_lock_e01 + '\'' +
                    ", s_lock_e02:'" + s_lock_e02 + '\'' +
                    ", s_lock_e03:'" + s_lock_e03 + '\'' +
                    ", s_lock_e04:'" + s_lock_e04 + '\'' +
                    ", s_lock_e05:'" + s_lock_e05 + '\'' +
                    ", s_lock_e06:'" + s_lock_e06 + '\'' +
                    ", s_lock_e07:'" + s_lock_e07 + '\'' +
                    ", s_lock_e08:'" + s_lock_e08 + '\'' +
                    ", s_lock_e09:'" + s_lock_e09 + '\'' +
                    ", s_lock_e10:'" + s_lock_e10 + '\'' +
                    ", s_lock_e11:'" + s_lock_e11 + '\'' +
                    ", s_lock_e12:'" + s_lock_e12 + '\'' +
                    ", s_lock_e13:'" + s_lock_e13 + '\'' +
                    ", s_lock_e14:'" + s_lock_e14 + '\'' +
                    ", s_lock_eud01:'" + s_lock_eud01 + '\'' +
                    ", s_lock_eud02:'" + s_lock_eud02 + '\'' +
                    ", s_lock_eud03:'" + s_lock_eud03 + '\'' +
                    ", s_lock_eud04:'" + s_lock_eud04 + '\'' +
                    ", s_lock_eud05:'" + s_lock_eud05 + '\'' +
                    ", s_lock_eud06:'" + s_lock_eud06 + '\'' +
                    '}';
        }

        /**
         * s_lock_e01 : string,（锁库单号）备置单号
         * s_lock_e02 : integer,项次
         * s_lock_e03 : string,源单单号
         * s_lock_e04 : integer,项次
         * s_lock_e05 : string,物料代码
         * s_lock_e06 : string,物料名称
         * s_lock_e07 : string,型号
         * s_lock_e08 : string,规格
         * s_lock_e09 : string,单位
         * s_lock_e10 : double,锁库存数量
         * s_lock_e11 : double,锁库存已处理量
         * s_lock_e12 : string,仓库代码
         * s_lock_e13 : string,仓库库位
         * s_lock_e14 : string,批次号
         * s_lock_eud01 : string,s_lock_eud01
         * s_lock_eud02 : string,s_lock_eud02
         * s_lock_eud03 : string,s_lock_eud03
         * s_lock_eud04 : string,s_lock_eud04
         * s_lock_eud05 : string,s_lock_eud05
         * s_lock_eud06 : string,s_lock_eud06
         */

        private String s_lock_e01;
        private String s_lock_e02;
        private String s_lock_e03;
        private String s_lock_e04;
        private String s_lock_e05;
        private String s_lock_e06;
        private String s_lock_e07;
        private String s_lock_e08;
        private String s_lock_e09;
        private String s_lock_e10;
        private String s_lock_e11;
        private String s_lock_e12;
        private String s_lock_e13;
        private String s_lock_e14;
        private String s_lock_eud01;
        private String s_lock_eud02;
        private String s_lock_eud03;
        private String s_lock_eud04;
        private String s_lock_eud05;
        private String s_lock_eud06;

        public String getS_lock_e01() {
            return s_lock_e01;
        }

        public void setS_lock_e01(String s_lock_e01) {
            this.s_lock_e01 = s_lock_e01;
        }

        public String getS_lock_e02() {
            return s_lock_e02;
        }

        public void setS_lock_e02(String s_lock_e02) {
            this.s_lock_e02 = s_lock_e02;
        }

        public String getS_lock_e03() {
            return s_lock_e03;
        }

        public void setS_lock_e03(String s_lock_e03) {
            this.s_lock_e03 = s_lock_e03;
        }

        public String getS_lock_e04() {
            return s_lock_e04;
        }

        public void setS_lock_e04(String s_lock_e04) {
            this.s_lock_e04 = s_lock_e04;
        }

        public String getS_lock_e05() {
            return s_lock_e05;
        }

        public void setS_lock_e05(String s_lock_e05) {
            this.s_lock_e05 = s_lock_e05;
        }

        public String getS_lock_e06() {
            return s_lock_e06;
        }

        public void setS_lock_e06(String s_lock_e06) {
            this.s_lock_e06 = s_lock_e06;
        }

        public String getS_lock_e07() {
            return s_lock_e07;
        }

        public void setS_lock_e07(String s_lock_e07) {
            this.s_lock_e07 = s_lock_e07;
        }

        public String getS_lock_e08() {
            return s_lock_e08;
        }

        public void setS_lock_e08(String s_lock_e08) {
            this.s_lock_e08 = s_lock_e08;
        }

        public String getS_lock_e09() {
            return s_lock_e09;
        }

        public void setS_lock_e09(String s_lock_e09) {
            this.s_lock_e09 = s_lock_e09;
        }

        public String getS_lock_e10() {
            return s_lock_e10;
        }

        public void setS_lock_e10(String s_lock_e10) {
            this.s_lock_e10 = s_lock_e10;
        }

        public String getS_lock_e11() {
            return s_lock_e11;
        }

        public void setS_lock_e11(String s_lock_e11) {
            this.s_lock_e11 = s_lock_e11;
        }

        public String getS_lock_e12() {
            return s_lock_e12;
        }

        public void setS_lock_e12(String s_lock_e12) {
            this.s_lock_e12 = s_lock_e12;
        }

        public String getS_lock_e13() {
            return s_lock_e13;
        }

        public void setS_lock_e13(String s_lock_e13) {
            this.s_lock_e13 = s_lock_e13;
        }

        public String getS_lock_e14() {
            return s_lock_e14;
        }

        public void setS_lock_e14(String s_lock_e14) {
            this.s_lock_e14 = s_lock_e14;
        }

        public String getS_lock_eud01() {
            return s_lock_eud01;
        }

        public void setS_lock_eud01(String s_lock_eud01) {
            this.s_lock_eud01 = s_lock_eud01;
        }

        public String getS_lock_eud02() {
            return s_lock_eud02;
        }

        public void setS_lock_eud02(String s_lock_eud02) {
            this.s_lock_eud02 = s_lock_eud02;
        }

        public String getS_lock_eud03() {
            return s_lock_eud03;
        }

        public void setS_lock_eud03(String s_lock_eud03) {
            this.s_lock_eud03 = s_lock_eud03;
        }

        public String getS_lock_eud04() {
            return s_lock_eud04;
        }

        public void setS_lock_eud04(String s_lock_eud04) {
            this.s_lock_eud04 = s_lock_eud04;
        }

        public String getS_lock_eud05() {
            return s_lock_eud05;
        }

        public void setS_lock_eud05(String s_lock_eud05) {
            this.s_lock_eud05 = s_lock_eud05;
        }

        public String getS_lock_eud06() {
            return s_lock_eud06;
        }

        public void setS_lock_eud06(String s_lock_eud06) {
            this.s_lock_eud06 = s_lock_eud06;
        }
    }
}
