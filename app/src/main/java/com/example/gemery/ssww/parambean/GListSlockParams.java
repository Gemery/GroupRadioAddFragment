package com.example.gemery.ssww.parambean;

public class GListSlockParams {
    @Override
    public String toString() {
        return "{" +
                "ima:" + ima +
                ", pageSize:'" + pageSize + '\'' +
                ", pageIndex:'" + pageIndex + '\'' +
                '}';
    }

    /**
     * ima : {"s_lock_h00":"string,经销商代码",
     * "s_lock_hcode":"string,门店编号",
     * "s_lock_h01":"string,（锁库单号）备置单号",
     * "s_lock_h02":"string,源单单号",
     * "s_lock_h03":"string,锁单方式（1：订单 2：销售出库单 3：调拨单）",
     * "s_lock_hsdate_1":"integer,锁单开始日期(时间戳)(小范围)",
     * "s_lock_hsdate_2":"integer,锁单开始日期(时间戳)(大范围)",
     * "s_lock_hedate_1":"integer,锁单结束日期（如果结束日期还未出库，则自动释放出库存）(时间戳)(小范围)",
     * "s_lock_hedate_2":"integer,锁单结束日期(时间戳)(大范围)",
     * "s_lock_hconfirm":"string,审核状态","s_lock_e05":"string,物料代码",
     * "s_lock_e06":"string,物料名称",
     * "s_lock_e07":"string,型号",
     * "s_lock_e08":"string,规格"}
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
        @Override
        public String toString() {
            return "{" +
                    "s_lock_h00:'" + s_lock_h00 + '\'' +
                    ", s_lock_hcode:'" + s_lock_hcode + '\'' +
                    ", s_lock_h01:'" + s_lock_h01 + '\'' +
                    ", s_lock_h02:'" + s_lock_h02 + '\'' +
                    ", s_lock_h03:'" + s_lock_h03 + '\'' +
                    ", s_lock_hsdate_1:'" + s_lock_hsdate_1 + '\'' +
                    ", s_lock_hsdate_2:'" + s_lock_hsdate_2 + '\'' +
                    ", s_lock_hedate_1:'" + s_lock_hedate_1 + '\'' +
                    ", s_lock_hedate_2:'" + s_lock_hedate_2 + '\'' +
                    ", s_lock_hconfirm:'" + s_lock_hconfirm + '\'' +
                    ", s_lock_e05:'" + s_lock_e05 + '\'' +
                    ", s_lock_e06:'" + s_lock_e06 + '\'' +
                    ", s_lock_e07:'" + s_lock_e07 + '\'' +
                    ", s_lock_e08:'" + s_lock_e08 + '\'' +
                    '}';
        }

        /**
         * s_lock_h00 : string,经销商代码
         * s_lock_hcode : string,门店编号
         * s_lock_h01 : string,（锁库单号）备置单号
         * s_lock_h02 : string,源单单号
         * s_lock_h03 : string,锁单方式（1：订单 2：销售出库单 3：调拨单）
         * s_lock_hsdate_1 : integer,锁单开始日期(时间戳)(小范围)
         * s_lock_hsdate_2 : integer,锁单开始日期(时间戳)(大范围)
         * s_lock_hedate_1 : integer,锁单结束日期（如果结束日期还未出库，则自动释放出库存）(时间戳)(小范围)
         * s_lock_hedate_2 : integer,锁单结束日期(时间戳)(大范围)
         * s_lock_hconfirm : string,审核状态
         * s_lock_e05 : string,物料代码
         * s_lock_e06 : string,物料名称
         * s_lock_e07 : string,型号
         * s_lock_e08 : string,规格
         */

        private String s_lock_h00;
        private String s_lock_hcode;
        private String s_lock_h01;
        private String s_lock_h02;
        private String s_lock_h03;
        private String s_lock_hsdate_1;
        private String s_lock_hsdate_2;
        private String s_lock_hedate_1;
        private String s_lock_hedate_2;
        private String s_lock_hconfirm;
        private String s_lock_e05;
        private String s_lock_e06;
        private String s_lock_e07;
        private String s_lock_e08;

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

        public String getS_lock_hsdate_1() {
            return s_lock_hsdate_1;
        }

        public void setS_lock_hsdate_1(String s_lock_hsdate_1) {
            this.s_lock_hsdate_1 = s_lock_hsdate_1;
        }

        public String getS_lock_hsdate_2() {
            return s_lock_hsdate_2;
        }

        public void setS_lock_hsdate_2(String s_lock_hsdate_2) {
            this.s_lock_hsdate_2 = s_lock_hsdate_2;
        }

        public String getS_lock_hedate_1() {
            return s_lock_hedate_1;
        }

        public void setS_lock_hedate_1(String s_lock_hedate_1) {
            this.s_lock_hedate_1 = s_lock_hedate_1;
        }

        public String getS_lock_hedate_2() {
            return s_lock_hedate_2;
        }

        public void setS_lock_hedate_2(String s_lock_hedate_2) {
            this.s_lock_hedate_2 = s_lock_hedate_2;
        }

        public String getS_lock_hconfirm() {
            return s_lock_hconfirm;
        }

        public void setS_lock_hconfirm(String s_lock_hconfirm) {
            this.s_lock_hconfirm = s_lock_hconfirm;
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
    }
}
