package com.example.gemery.ssww.bean;

import java.util.List;

public class OeaBen {

    @Override
    public String toString() {
        return "{" +
                "flage:'" + flage + '\'' +
                ", oeaList:" + oeaList +
                ", oebList:" + oebList +
                '}';
    }

    /**
     * oeaList : [{"id":"integer,ID","s_oea00":"string,
     * 经销商代码","s_oea_code":"string,门店编号",
     * "s_oea_type":"string,订单类型（1：零售；2：工程； 3：售后）",
     * "s_oea01":"string,单据编号","s_oea02":"integer,
     * 订单日期(时间戳)","s_oea03":"string,消费者手机号码","s_oea04":"string,消费者姓名",
     * "s_oea05":"string,消费者收货地址","s_oea06":"string,业务员编号",
     * "s_oea07":"string,约定送货日期","s_oea08":"string,价格条件编号",
     * "s_oea_confirm":"string,审核否","s_oea09":"string,审核人",
     * "s_oea10":"integer,审核日期(时间戳)","s_oea11":"double,收订金金额",
     * "s_oea12":"double,单据总金额","s_oea13":"string,是否开发票",
     * "s_oea14":"double,开票金额","s_oeaud01":"string,s_oeaud01",
     * "s_oeaud02":"string,s_oeaud02","s_oeaud03":"string,s_oeaud03",
     * "s_oeaud04":"string,s_oeaud04","s_oeaud05":"string,s_oeaud05","s_oeaud06":"string,
     * s_oeaud06","s_oeaud07":"string,s_oeaud07","s_oeaud08":"string,s_oeaud08"}]
     * oebList : [{"s_oeb01":"string,单据编号","s_oeb02":"integer,项次","s_oeb03":"string,
     * 物料代码","s_oeb04":"string,物料名称","s_oeb05":"string,型号","s_oeb06":"string,规格",
     * "s_oeb07":"double,数量","s_oeb08":"double,税点","s_oeb09":"double,未税单价",
     * "s_oeb10":"double,含税单价","s_oeb11":"double,折扣","s_oeb12":"double,
     * 未税金额","s_oeb13":"double,含税金额","s_oeb14":"integer,约定交货日期(时间戳)",
     * "s_oeb15":"string,结案否","s_oeb16":"double,已发货数量","s_oeb17":"string,
     * 是否锁库存","s_oeb18":"string,锁库存单据编号","s_oeb19":"integer,锁库存结束日期(时间戳)",
     * "s_oeb20":"integer,锁库存数量","s_oeb21":"double,收订金明细金额","s_oeb22":"string,明细备注",
     * "s_oebud01":"string,s_oebud01","s_oebud02":"string,s_oebud02","s_oebud03":"string,s_oebud03",
     * "s_oebud04":"string,s_oebud04","s_oebud05":"string,s_oebud05","s_oebud06":"string,s_oebud06",
     * "s_oebud07":"string,s_oebud07","s_oebud08":"string,s_oebud08","s_oebud09":"string,s_oebud09"}]
     * flage : string,1:添加 2：修改  3：删除
     */

    private String flage;
    private List<OeaListBean> oeaList;
    private List<OebListBean> oebList;

    public String getFlage() {
        return flage;
    }

    public void setFlage(String flage) {
        this.flage = flage;
    }

    public List<OeaListBean> getOeaList() {
        return oeaList;
    }

    public void setOeaList(List<OeaListBean> oeaList) {
        this.oeaList = oeaList;
    }

    public List<OebListBean> getOebList() {
        return oebList;
    }

    public void setOebList(List<OebListBean> oebList) {
        this.oebList = oebList;
    }

    public static class OeaListBean {
        /**
         * id : integer,ID
         * s_oea00 : string,经销商代码
         * s_oea_code : string,门店编号
         * s_oea_type : string,订单类型（1：零售；2：工程； 3：售后）
         * s_oea01 : string,单据编号
         * s_oea02 : integer,订单日期(时间戳)
         * s_oea03 : string,消费者手机号码
         * s_oea04 : string,消费者姓名
         * s_oea05 : string,消费者收货地址
         * s_oea06 : string,业务员编号
         * s_oea07 : string,约定送货日期
         * s_oea08 : string,价格条件编号
         * s_oea_confirm : string,审核否
         * s_oea09 : string,审核人
         * s_oea10 : integer,审核日期(时间戳)
         * s_oea11 : double,收订金金额
         * s_oea12 : double,单据总金额
         * s_oea13 : string,是否开发票
         * s_oea14 : double,开票金额
         * s_oeaud01 : string,s_oeaud01
         * s_oeaud02 : string,s_oeaud02
         * s_oeaud03 : string,s_oeaud03
         * s_oeaud04 : string,s_oeaud04
         * s_oeaud05 : string,s_oeaud05
         * s_oeaud06 : string,s_oeaud06
         * s_oeaud07 : string,s_oeaud07
         * s_oeaud08 : string,s_oeaud08
         */

        private String id;
        private String s_oea00;
        private String s_oea_code;
        private String s_oea_type;
        private String s_oea01;
        private String s_oea02;
        private String s_oea03;
        private String s_oea04;
        private String s_oea05;
        private String s_oea06;
        private String s_oea07;
        private String s_oea08;
        private String s_oea_confirm;
        private String s_oea09;
        private String s_oea10;
        private String s_oea11;
        private String s_oea12;
        private String s_oea13;
        private String s_oea14;
        private String s_oeaud01;
        private String s_oeaud02;
        private String s_oeaud03;
        private String s_oeaud04;
        private String s_oeaud05;
        private String s_oeaud06;
        private String s_oeaud07;
        private String s_oeaud08;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getS_oea00() {
            return s_oea00;
        }

        public void setS_oea00(String s_oea00) {
            this.s_oea00 = s_oea00;
        }

        public String getS_oea_code() {
            return s_oea_code;
        }

        public void setS_oea_code(String s_oea_code) {
            this.s_oea_code = s_oea_code;
        }

        public String getS_oea_type() {
            return s_oea_type;
        }

        public void setS_oea_type(String s_oea_type) {
            this.s_oea_type = s_oea_type;
        }

        public String getS_oea01() {
            return s_oea01;
        }

        public void setS_oea01(String s_oea01) {
            this.s_oea01 = s_oea01;
        }

        public String getS_oea02() {
            return s_oea02;
        }

        public void setS_oea02(String s_oea02) {
            this.s_oea02 = s_oea02;
        }

        public String getS_oea03() {
            return s_oea03;
        }

        public void setS_oea03(String s_oea03) {
            this.s_oea03 = s_oea03;
        }

        public String getS_oea04() {
            return s_oea04;
        }

        public void setS_oea04(String s_oea04) {
            this.s_oea04 = s_oea04;
        }

        public String getS_oea05() {
            return s_oea05;
        }

        public void setS_oea05(String s_oea05) {
            this.s_oea05 = s_oea05;
        }

        public String getS_oea06() {
            return s_oea06;
        }

        public void setS_oea06(String s_oea06) {
            this.s_oea06 = s_oea06;
        }

        public String getS_oea07() {
            return s_oea07;
        }

        public void setS_oea07(String s_oea07) {
            this.s_oea07 = s_oea07;
        }

        public String getS_oea08() {
            return s_oea08;
        }

        public void setS_oea08(String s_oea08) {
            this.s_oea08 = s_oea08;
        }

        public String getS_oea_confirm() {
            return s_oea_confirm;
        }

        public void setS_oea_confirm(String s_oea_confirm) {
            this.s_oea_confirm = s_oea_confirm;
        }

        public String getS_oea09() {
            return s_oea09;
        }

        public void setS_oea09(String s_oea09) {
            this.s_oea09 = s_oea09;
        }

        public String getS_oea10() {
            return s_oea10;
        }

        public void setS_oea10(String s_oea10) {
            this.s_oea10 = s_oea10;
        }

        public String getS_oea11() {
            return s_oea11;
        }

        public void setS_oea11(String s_oea11) {
            this.s_oea11 = s_oea11;
        }

        public String getS_oea12() {
            return s_oea12;
        }

        public void setS_oea12(String s_oea12) {
            this.s_oea12 = s_oea12;
        }

        @Override
        public String toString() {
            return "{" +
                    "id:'" + id + '\'' +
                    ", s_oea00:'" + s_oea00 + '\'' +
                    ", s_oea_code:'" + s_oea_code + '\'' +
                    ", s_oea_type:'" + s_oea_type + '\'' +
                    ", s_oea01:'" + s_oea01 + '\'' +
                    ", s_oea02:'" + s_oea02 + '\'' +
                    ", s_oea03:'" + s_oea03 + '\'' +
                    ", s_oea04:'" + s_oea04 + '\'' +
                    ", s_oea05:'" + s_oea05 + '\'' +
                    ", s_oea06:'" + s_oea06 + '\'' +
                    ", s_oea07:'" + s_oea07 + '\'' +
                    ", s_oea08:'" + s_oea08 + '\'' +
                    ", s_oea_confirm:'" + s_oea_confirm + '\'' +
                    ", s_oea09:'" + s_oea09 + '\'' +
                    ", s_oea10:'" + s_oea10 + '\'' +
                    ", s_oea11:'" + s_oea11 + '\'' +
                    ", s_oea12:'" + s_oea12 + '\'' +
                    ", s_oea13:'" + s_oea13 + '\'' +
                    ", s_oea14:'" + s_oea14 + '\'' +
                    ", s_oeaud01:'" + s_oeaud01 + '\'' +
                    ", s_oeaud02:'" + s_oeaud02 + '\'' +
                    ", s_oeaud03:'" + s_oeaud03 + '\'' +
                    ", s_oeaud04:'" + s_oeaud04 + '\'' +
                    ", s_oeaud05:'" + s_oeaud05 + '\'' +
                    ", s_oeaud06:'" + s_oeaud06 + '\'' +
                    ", s_oeaud07:'" + s_oeaud07 + '\'' +
                    ", s_oeaud08:'" + s_oeaud08 + '\'' +
                    '}';
        }

        public String getS_oea13() {
            return s_oea13;
        }

        public void setS_oea13(String s_oea13) {
            this.s_oea13 = s_oea13;
        }

        public String getS_oea14() {
            return s_oea14;
        }

        public void setS_oea14(String s_oea14) {
            this.s_oea14 = s_oea14;
        }

        public String getS_oeaud01() {
            return s_oeaud01;
        }

        public void setS_oeaud01(String s_oeaud01) {
            this.s_oeaud01 = s_oeaud01;
        }

        public String getS_oeaud02() {
            return s_oeaud02;
        }

        public void setS_oeaud02(String s_oeaud02) {
            this.s_oeaud02 = s_oeaud02;
        }

        public String getS_oeaud03() {
            return s_oeaud03;
        }

        public void setS_oeaud03(String s_oeaud03) {
            this.s_oeaud03 = s_oeaud03;
        }

        public String getS_oeaud04() {
            return s_oeaud04;
        }

        public void setS_oeaud04(String s_oeaud04) {
            this.s_oeaud04 = s_oeaud04;
        }

        public String getS_oeaud05() {
            return s_oeaud05;
        }

        public void setS_oeaud05(String s_oeaud05) {
            this.s_oeaud05 = s_oeaud05;
        }

        public String getS_oeaud06() {
            return s_oeaud06;
        }

        public void setS_oeaud06(String s_oeaud06) {
            this.s_oeaud06 = s_oeaud06;
        }

        public String getS_oeaud07() {
            return s_oeaud07;
        }

        public void setS_oeaud07(String s_oeaud07) {
            this.s_oeaud07 = s_oeaud07;
        }

        public String getS_oeaud08() {
            return s_oeaud08;
        }

        public void setS_oeaud08(String s_oeaud08) {
            this.s_oeaud08 = s_oeaud08;
        }
    }

    public static class OebListBean {
        /**
         * s_oeb01 : string,单据编号
         * s_oeb02 : integer,项次
         * s_oeb03 : string,物料代码
         * s_oeb04 : string,物料名称
         * s_oeb05 : string,型号
         * s_oeb06 : string,规格
         * s_oeb07 : double,数量
         * s_oeb08 : double,税点
         * s_oeb09 : double,未税单价
         * s_oeb10 : double,含税单价
         * s_oeb11 : double,折扣
         * s_oeb12 : double,未税金额
         * s_oeb13 : double,含税金额
         * s_oeb14 : integer,约定交货日期(时间戳)
         * s_oeb15 : string,结案否
         * s_oeb16 : double,已发货数量
         * s_oeb17 : string,是否锁库存
         * s_oeb18 : string,锁库存单据编号
         * s_oeb19 : integer,锁库存结束日期(时间戳)
         * s_oeb20 : integer,锁库存数量
         * s_oeb21 : double,收订金明细金额
         * s_oeb22 : string,明细备注
         * s_oebud01 : string,s_oebud01
         * s_oebud02 : string,s_oebud02
         * s_oebud03 : string,s_oebud03
         * s_oebud04 : string,s_oebud04
         * s_oebud05 : string,s_oebud05
         * s_oebud06 : string,s_oebud06
         * s_oebud07 : string,s_oebud07
         * s_oebud08 : string,s_oebud08
         * s_oebud09 : string,s_oebud09
         */

        private String s_oeb01;
        private String s_oeb02;
        private String s_oeb03;
        private String s_oeb04;
        private String s_oeb05;
        private String s_oeb06;
        private String s_oeb07;
        private String s_oeb08;
        private String s_oeb09;
        private String s_oeb10;
        private String s_oeb11;
        private String s_oeb12;
        private String s_oeb13;
        private String s_oeb14;
        private String s_oeb15;
        private String s_oeb16;
        private String s_oeb17;
        private String s_oeb18;
        private String s_oeb19;
        private String s_oeb20;
        private String s_oeb21;
        private String s_oeb22;
        private String s_oebud01;
        private String s_oebud02;
        private String s_oebud03;
        private String s_oebud04;
        private String s_oebud05;
        private String s_oebud06;
        private String s_oebud07;
        private String s_oebud08;
        private String s_oebud09;

        public String getS_oeb01() {
            return s_oeb01;
        }

        public void setS_oeb01(String s_oeb01) {
            this.s_oeb01 = s_oeb01;
        }

        public String getS_oeb02() {
            return s_oeb02;
        }

        public void setS_oeb02(String s_oeb02) {
            this.s_oeb02 = s_oeb02;
        }

        public String getS_oeb03() {
            return s_oeb03;
        }

        public void setS_oeb03(String s_oeb03) {
            this.s_oeb03 = s_oeb03;
        }

        public String getS_oeb04() {
            return s_oeb04;
        }

        public void setS_oeb04(String s_oeb04) {
            this.s_oeb04 = s_oeb04;
        }

        public String getS_oeb05() {
            return s_oeb05;
        }

        public void setS_oeb05(String s_oeb05) {
            this.s_oeb05 = s_oeb05;
        }

        public String getS_oeb06() {
            return s_oeb06;
        }

        public void setS_oeb06(String s_oeb06) {
            this.s_oeb06 = s_oeb06;
        }

        public String getS_oeb07() {
            return s_oeb07;
        }

        public void setS_oeb07(String s_oeb07) {
            this.s_oeb07 = s_oeb07;
        }

        public String getS_oeb08() {
            return s_oeb08;
        }

        public void setS_oeb08(String s_oeb08) {
            this.s_oeb08 = s_oeb08;
        }

        public String getS_oeb09() {
            return s_oeb09;
        }

        public void setS_oeb09(String s_oeb09) {
            this.s_oeb09 = s_oeb09;
        }

        public String getS_oeb10() {
            return s_oeb10;
        }

        public void setS_oeb10(String s_oeb10) {
            this.s_oeb10 = s_oeb10;
        }

        public String getS_oeb11() {
            return s_oeb11;
        }

        public void setS_oeb11(String s_oeb11) {
            this.s_oeb11 = s_oeb11;
        }

        public String getS_oeb12() {
            return s_oeb12;
        }

        public void setS_oeb12(String s_oeb12) {
            this.s_oeb12 = s_oeb12;
        }

        public String getS_oeb13() {
            return s_oeb13;
        }

        public void setS_oeb13(String s_oeb13) {
            this.s_oeb13 = s_oeb13;
        }

        public String getS_oeb14() {
            return s_oeb14;
        }

        public void setS_oeb14(String s_oeb14) {
            this.s_oeb14 = s_oeb14;
        }

        public String getS_oeb15() {
            return s_oeb15;
        }

        public void setS_oeb15(String s_oeb15) {
            this.s_oeb15 = s_oeb15;
        }

        public String getS_oeb16() {
            return s_oeb16;
        }

        public void setS_oeb16(String s_oeb16) {
            this.s_oeb16 = s_oeb16;
        }

        public String getS_oeb17() {
            return s_oeb17;
        }

        public void setS_oeb17(String s_oeb17) {
            this.s_oeb17 = s_oeb17;
        }

        public String getS_oeb18() {
            return s_oeb18;
        }

        public void setS_oeb18(String s_oeb18) {
            this.s_oeb18 = s_oeb18;
        }

        public String getS_oeb19() {
            return s_oeb19;
        }

        public void setS_oeb19(String s_oeb19) {
            this.s_oeb19 = s_oeb19;
        }

        public String getS_oeb20() {
            return s_oeb20;
        }

        public void setS_oeb20(String s_oeb20) {
            this.s_oeb20 = s_oeb20;
        }

        public String getS_oeb21() {
            return s_oeb21;
        }

        public void setS_oeb21(String s_oeb21) {
            this.s_oeb21 = s_oeb21;
        }

        public String getS_oeb22() {
            return s_oeb22;
        }

        public void setS_oeb22(String s_oeb22) {
            this.s_oeb22 = s_oeb22;
        }

        public String getS_oebud01() {
            return s_oebud01;
        }

        public void setS_oebud01(String s_oebud01) {
            this.s_oebud01 = s_oebud01;
        }

        public String getS_oebud02() {
            return s_oebud02;
        }

        public void setS_oebud02(String s_oebud02) {
            this.s_oebud02 = s_oebud02;
        }

        public String getS_oebud03() {
            return s_oebud03;
        }

        public void setS_oebud03(String s_oebud03) {
            this.s_oebud03 = s_oebud03;
        }

        public String getS_oebud04() {
            return s_oebud04;
        }

        public void setS_oebud04(String s_oebud04) {
            this.s_oebud04 = s_oebud04;
        }

        public String getS_oebud05() {
            return s_oebud05;
        }

        public void setS_oebud05(String s_oebud05) {
            this.s_oebud05 = s_oebud05;
        }

        public String getS_oebud06() {
            return s_oebud06;
        }

        public void setS_oebud06(String s_oebud06) {
            this.s_oebud06 = s_oebud06;
        }

        public String getS_oebud07() {
            return s_oebud07;
        }

        public void setS_oebud07(String s_oebud07) {
            this.s_oebud07 = s_oebud07;
        }

        public String getS_oebud08() {
            return s_oebud08;
        }

        public void setS_oebud08(String s_oebud08) {
            this.s_oebud08 = s_oebud08;
        }

        public String getS_oebud09() {
            return s_oebud09;
        }

        @Override
        public String toString() {
            return "{" +
                    "s_oeb01:'" + s_oeb01 + '\'' +
                    ", s_oeb02:'" + s_oeb02 + '\'' +
                    ", s_oeb03:'" + s_oeb03 + '\'' +
                    ", s_oeb04:'" + s_oeb04 + '\'' +
                    ", s_oeb05:'" + s_oeb05 + '\'' +
                    ", s_oeb06:'" + s_oeb06 + '\'' +
                    ", s_oeb07:'" + s_oeb07 + '\'' +
                    ", s_oeb08:'" + s_oeb08 + '\'' +
                    ", s_oeb09:'" + s_oeb09 + '\'' +
                    ", s_oeb10:'" + s_oeb10 + '\'' +
                    ", s_oeb11:'" + s_oeb11 + '\'' +
                    ", s_oeb12:'" + s_oeb12 + '\'' +
                    ", s_oeb13:'" + s_oeb13 + '\'' +
                    ", s_oeb14:'" + s_oeb14 + '\'' +
                    ", s_oeb15:'" + s_oeb15 + '\'' +
                    ", s_oeb16:'" + s_oeb16 + '\'' +
                    ", s_oeb17:'" + s_oeb17 + '\'' +
                    ", s_oeb18:'" + s_oeb18 + '\'' +
                    ", s_oeb19:'" + s_oeb19 + '\'' +
                    ", s_oeb20:'" + s_oeb20 + '\'' +
                    ", s_oeb21:'" + s_oeb21 + '\'' +
                    ", s_oeb22:'" + s_oeb22 + '\'' +
                    ", s_oebud01:'" + s_oebud01 + '\'' +
                    ", s_oebud02:'" + s_oebud02 + '\'' +
                    ", s_oebud03:'" + s_oebud03 + '\'' +
                    ", s_oebud04:'" + s_oebud04 + '\'' +
                    ", s_oebud05:'" + s_oebud05 + '\'' +
                    ", s_oebud06:'" + s_oebud06 + '\'' +
                    ", s_oebud07:'" + s_oebud07 + '\'' +
                    ", s_oebud08:'" + s_oebud08 + '\'' +
                    ", s_oebud09:'" + s_oebud09 + '\'' +
                    '}';
        }

        public void setS_oebud09(String s_oebud09) {
            this.s_oebud09 = s_oebud09;
        }
    }
}
