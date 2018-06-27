package com.example.gemery.ssww.bean;

import java.util.List;

public class ODdetailBean {
    /**
     * ogaList : [{"id":"integer,id","s_oga00":"string,经销商代码","s_oga_code":"string,
     * 门店编号","s_oga_type":"string,出库单类型(1：零售；2：工程；3：售后)",
     * "s_oga01":"string,出库单编号","s_oga02":"integer,出库日期(时间戳)",
     * "s_oga03":"string,客户手机号码","s_oga04":"string,客户姓名","s_oga05":"string,
     * 收货地址","s_oga06":"string,安排送货日期（可以是时间范围）","s_oga07":"string,业务员",
     * "s_oga08":"string,订单单号","s_oga09":"double,尾款金额合计（根据明细行已交订金来计算）",
     * "s_oga10":"double,出库单总金额","s_oga11":"string,配送工单号","s_oga12":"string,
     * 上门安装工单号","s_oga_confirm":"string,审核状态","s_oga13":"string,审核人员",
     * "s_oga14":"string,是否收齐款项","s_oga15":"string,是否开税务发票","s_oga16":"double,
     * 开税务发票金额","s_oga17":"string,应收账款发票号码","s_oga18":"string,库存扣账否",
     * "s_oga19":"integer,库存扣账日期(时间戳)","s_oga20":"string,是否锁库存","s_oga21":"string,
     * 锁库存单据编号","s_oga22":"string,客户签收否","s_ogauser":"string,制单人","s_oga24":"integer,
     * 审核日期(时间戳)","s_oga25":"string,是否配送 同时安装 0：否  1：是","s_ogaud01":"string,s_ogaud01",
     * "s_ogaud02":"string,s_ogaud02","s_ogaud03":"string,s_ogaud03","s_ogaud04":"string,s_ogaud04",
     * "s_ogaud05":"string,s_ogaud05","s_ogaud06":"string,s_ogaud06","s_ogaud07":"string,s_ogaud07",
     * "s_ogaud08":"string,s_ogaud08","s_ogaud09":"string,s_ogaud09"}]
     * ogbList : [{"s_ogb01":"string,销售出库单单号","s_ogb02":"integer,出库项次","s_ogb03":"string,
     * 订单单号","s_ogb04":"integer,订单项次","s_ogb05":"string,物料代码","s_ogb06":"string,物料名称",
     * "s_ogb07":"string,型号","s_ogb08":"string,规格","s_ogb09":"string,单位","s_ogb10":"double,出库数量",
     * "s_ogb11":"double,未税单价","s_ogb12":"double,含税单价","s_ogb13":"double,折扣","s_ogb14":"double,
     * 未税金额","s_ogb15":"double,含税金额","s_ogb16":"string,出货仓库","s_ogb17":"string,出货库位",
     * "s_ogb18":"string,批次号","s_ogb19":"double,订单已交订金","s_ogb20":"double,尾款金额",
     * "s_ogb_note":"string,明细备注","s_ogb21":"integer,参与积分数","s_ogbud01":"string,s_ogbud01",
     * "s_ogbud02":"string,s_ogbud02","s_ogbud03":"string,s_ogbud03","s_ogbud04":"string,s_ogbud04",
     * "s_ogbud05":"string,s_ogbud05","s_ogbud06":"string,s_ogbud06","s_ogbud07":"string,s_ogbud07",
     * "s_ogbud08":"string,s_ogbud08"}]
     * flage : string,标志 1：添加 2：修改  3：删除
     */

    private String flage;
    private List<OgaListBean> ogaList;
    private List<OgbListBean> ogbList;

    public String getFlage() {
        return flage;
    }

    public void setFlage(String flage) {
        this.flage = flage;
    }

    public List<OgaListBean> getOgaList() {
        return ogaList;
    }

    public void setOgaList(List<OgaListBean> ogaList) {
        this.ogaList = ogaList;
    }

    public List<OgbListBean> getOgbList() {
        return ogbList;
    }

    public void setOgbList(List<OgbListBean> ogbList) {
        this.ogbList = ogbList;
    }

    public static class OgaListBean {
        /**
         * id : integer,id
         * s_oga00 : string,经销商代码
         * s_oga_code : string,门店编号
         * s_oga_type : string,出库单类型(1：零售；2：工程；3：售后)
         * s_oga01 : string,出库单编号
         * s_oga02 : integer,出库日期(时间戳)
         * s_oga03 : string,客户手机号码
         * s_oga04 : string,客户姓名
         * s_oga05 : string,收货地址
         * s_oga06 : string,安排送货日期（可以是时间范围）
         * s_oga07 : string,业务员
         * s_oga08 : string,订单单号
         * s_oga09 : double,尾款金额合计（根据明细行已交订金来计算）
         * s_oga10 : double,出库单总金额
         * s_oga11 : string,配送工单号
         * s_oga12 : string,上门安装工单号
         * s_oga_confirm : string,审核状态
         * s_oga13 : string,审核人员
         * s_oga14 : string,是否收齐款项
         * s_oga15 : string,是否开税务发票
         * s_oga16 : double,开税务发票金额
         * s_oga17 : string,应收账款发票号码
         * s_oga18 : string,库存扣账否
         * s_oga19 : integer,库存扣账日期(时间戳)
         * s_oga20 : string,是否锁库存
         * s_oga21 : string,锁库存单据编号
         * s_oga22 : string,客户签收否
         * s_ogauser : string,制单人
         * s_oga24 : integer,审核日期(时间戳)
         * s_oga25 : string,是否配送 同时安装 0：否  1：是
         * s_ogaud01 : string,s_ogaud01
         * s_ogaud02 : string,s_ogaud02
         * s_ogaud03 : string,s_ogaud03
         * s_ogaud04 : string,s_ogaud04
         * s_ogaud05 : string,s_ogaud05
         * s_ogaud06 : string,s_ogaud06
         * s_ogaud07 : string,s_ogaud07
         * s_ogaud08 : string,s_ogaud08
         * s_ogaud09 : string,s_ogaud09
         */

        private String id;
        private String s_oga00;
        private String s_oga_code;
        private String s_oga_type;
        private String s_oga01;
        private String s_oga02;
        private String s_oga03;
        private String s_oga04;
        private String s_oga05;
        private String s_oga06;
        private String s_oga07;
        private String s_oga08;
        private String s_oga09;
        private String s_oga10;
        private String s_oga11;
        private String s_oga12;
        private String s_oga_confirm;
        private String s_oga13;
        private String s_oga14;
        private String s_oga15;
        private String s_oga16;
        private String s_oga17;
        private String s_oga18;
        private String s_oga19;
        private String s_oga20;
        private String s_oga21;
        private String s_oga22;
        private String s_ogauser;
        private String s_oga24;
        private String s_oga25;
        private String s_ogaud01;
        private String s_ogaud02;
        private String s_ogaud03;
        private String s_ogaud04;
        private String s_ogaud05;
        private String s_ogaud06;
        private String s_ogaud07;
        private String s_ogaud08;
        private String s_ogaud09;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getS_oga00() {
            return s_oga00;
        }

        public void setS_oga00(String s_oga00) {
            this.s_oga00 = s_oga00;
        }

        public String getS_oga_code() {
            return s_oga_code;
        }

        public void setS_oga_code(String s_oga_code) {
            this.s_oga_code = s_oga_code;
        }

        public String getS_oga_type() {
            return s_oga_type;
        }

        public void setS_oga_type(String s_oga_type) {
            this.s_oga_type = s_oga_type;
        }

        public String getS_oga01() {
            return s_oga01;
        }

        public void setS_oga01(String s_oga01) {
            this.s_oga01 = s_oga01;
        }

        public String getS_oga02() {
            return s_oga02;
        }

        public void setS_oga02(String s_oga02) {
            this.s_oga02 = s_oga02;
        }

        public String getS_oga03() {
            return s_oga03;
        }

        public void setS_oga03(String s_oga03) {
            this.s_oga03 = s_oga03;
        }

        public String getS_oga04() {
            return s_oga04;
        }

        public void setS_oga04(String s_oga04) {
            this.s_oga04 = s_oga04;
        }

        public String getS_oga05() {
            return s_oga05;
        }

        public void setS_oga05(String s_oga05) {
            this.s_oga05 = s_oga05;
        }

        public String getS_oga06() {
            return s_oga06;
        }

        public void setS_oga06(String s_oga06) {
            this.s_oga06 = s_oga06;
        }

        public String getS_oga07() {
            return s_oga07;
        }

        public void setS_oga07(String s_oga07) {
            this.s_oga07 = s_oga07;
        }

        public String getS_oga08() {
            return s_oga08;
        }

        public void setS_oga08(String s_oga08) {
            this.s_oga08 = s_oga08;
        }

        public String getS_oga09() {
            return s_oga09;
        }

        public void setS_oga09(String s_oga09) {
            this.s_oga09 = s_oga09;
        }

        public String getS_oga10() {
            return s_oga10;
        }

        public void setS_oga10(String s_oga10) {
            this.s_oga10 = s_oga10;
        }

        public String getS_oga11() {
            return s_oga11;
        }

        public void setS_oga11(String s_oga11) {
            this.s_oga11 = s_oga11;
        }

        public String getS_oga12() {
            return s_oga12;
        }

        public void setS_oga12(String s_oga12) {
            this.s_oga12 = s_oga12;
        }

        public String getS_oga_confirm() {
            return s_oga_confirm;
        }

        public void setS_oga_confirm(String s_oga_confirm) {
            this.s_oga_confirm = s_oga_confirm;
        }

        public String getS_oga13() {
            return s_oga13;
        }

        public void setS_oga13(String s_oga13) {
            this.s_oga13 = s_oga13;
        }

        public String getS_oga14() {
            return s_oga14;
        }

        public void setS_oga14(String s_oga14) {
            this.s_oga14 = s_oga14;
        }

        public String getS_oga15() {
            return s_oga15;
        }

        public void setS_oga15(String s_oga15) {
            this.s_oga15 = s_oga15;
        }

        public String getS_oga16() {
            return s_oga16;
        }

        public void setS_oga16(String s_oga16) {
            this.s_oga16 = s_oga16;
        }

        public String getS_oga17() {
            return s_oga17;
        }

        public void setS_oga17(String s_oga17) {
            this.s_oga17 = s_oga17;
        }

        public String getS_oga18() {
            return s_oga18;
        }

        public void setS_oga18(String s_oga18) {
            this.s_oga18 = s_oga18;
        }

        public String getS_oga19() {
            return s_oga19;
        }

        public void setS_oga19(String s_oga19) {
            this.s_oga19 = s_oga19;
        }

        public String getS_oga20() {
            return s_oga20;
        }

        public void setS_oga20(String s_oga20) {
            this.s_oga20 = s_oga20;
        }

        public String getS_oga21() {
            return s_oga21;
        }

        public void setS_oga21(String s_oga21) {
            this.s_oga21 = s_oga21;
        }

        public String getS_oga22() {
            return s_oga22;
        }

        public void setS_oga22(String s_oga22) {
            this.s_oga22 = s_oga22;
        }

        public String getS_ogauser() {
            return s_ogauser;
        }

        public void setS_ogauser(String s_ogauser) {
            this.s_ogauser = s_ogauser;
        }

        public String getS_oga24() {
            return s_oga24;
        }

        public void setS_oga24(String s_oga24) {
            this.s_oga24 = s_oga24;
        }

        public String getS_oga25() {
            return s_oga25;
        }

        public void setS_oga25(String s_oga25) {
            this.s_oga25 = s_oga25;
        }

        public String getS_ogaud01() {
            return s_ogaud01;
        }

        public void setS_ogaud01(String s_ogaud01) {
            this.s_ogaud01 = s_ogaud01;
        }

        public String getS_ogaud02() {
            return s_ogaud02;
        }

        public void setS_ogaud02(String s_ogaud02) {
            this.s_ogaud02 = s_ogaud02;
        }

        public String getS_ogaud03() {
            return s_ogaud03;
        }

        public void setS_ogaud03(String s_ogaud03) {
            this.s_ogaud03 = s_ogaud03;
        }

        public String getS_ogaud04() {
            return s_ogaud04;
        }

        public void setS_ogaud04(String s_ogaud04) {
            this.s_ogaud04 = s_ogaud04;
        }

        public String getS_ogaud05() {
            return s_ogaud05;
        }

        public void setS_ogaud05(String s_ogaud05) {
            this.s_ogaud05 = s_ogaud05;
        }

        public String getS_ogaud06() {
            return s_ogaud06;
        }

        public void setS_ogaud06(String s_ogaud06) {
            this.s_ogaud06 = s_ogaud06;
        }

        public String getS_ogaud07() {
            return s_ogaud07;
        }

        public void setS_ogaud07(String s_ogaud07) {
            this.s_ogaud07 = s_ogaud07;
        }

        public String getS_ogaud08() {
            return s_ogaud08;
        }

        public void setS_ogaud08(String s_ogaud08) {
            this.s_ogaud08 = s_ogaud08;
        }

        public String getS_ogaud09() {
            return s_ogaud09;
        }

        public void setS_ogaud09(String s_ogaud09) {
            this.s_ogaud09 = s_ogaud09;
        }
    }

    public static class OgbListBean {
        /**
         * s_ogb01 : string,销售出库单单号
         * s_ogb02 : integer,出库项次
         * s_ogb03 : string,订单单号
         * s_ogb04 : integer,订单项次
         * s_ogb05 : string,物料代码
         * s_ogb06 : string,物料名称
         * s_ogb07 : string,型号
         * s_ogb08 : string,规格
         * s_ogb09 : string,单位
         * s_ogb10 : double,出库数量
         * s_ogb11 : double,未税单价
         * s_ogb12 : double,含税单价
         * s_ogb13 : double,折扣
         * s_ogb14 : double,未税金额
         * s_ogb15 : double,含税金额
         * s_ogb16 : string,出货仓库
         * s_ogb17 : string,出货库位
         * s_ogb18 : string,批次号
         * s_ogb19 : double,订单已交订金
         * s_ogb20 : double,尾款金额
         * s_ogb_note : string,明细备注
         * s_ogb21 : integer,参与积分数
         * s_ogbud01 : string,s_ogbud01
         * s_ogbud02 : string,s_ogbud02
         * s_ogbud03 : string,s_ogbud03
         * s_ogbud04 : string,s_ogbud04
         * s_ogbud05 : string,s_ogbud05
         * s_ogbud06 : string,s_ogbud06
         * s_ogbud07 : string,s_ogbud07
         * s_ogbud08 : string,s_ogbud08
         */

        private String s_ogb01;
        private String s_ogb02;
        private String s_ogb03;
        private String s_ogb04;
        private String s_ogb05;
        private String s_ogb06;
        private String s_ogb07;
        private String s_ogb08;
        private String s_ogb09;
        private String s_ogb10;
        private String s_ogb11;
        private String s_ogb12;
        private String s_ogb13;
        private String s_ogb14;
        private String s_ogb15;
        private String s_ogb16;
        private String s_ogb17;
        private String s_ogb18;
        private String s_ogb19;
        private String s_ogb20;
        private String s_ogb_note;
        private String s_ogb21;
        private String s_ogbud01;
        private String s_ogbud02;
        private String s_ogbud03;
        private String s_ogbud04;
        private String s_ogbud05;
        private String s_ogbud06;
        private String s_ogbud07;
        private String s_ogbud08;

        public String getS_ogb01() {
            return s_ogb01;
        }

        public void setS_ogb01(String s_ogb01) {
            this.s_ogb01 = s_ogb01;
        }

        public String getS_ogb02() {
            return s_ogb02;
        }

        public void setS_ogb02(String s_ogb02) {
            this.s_ogb02 = s_ogb02;
        }

        public String getS_ogb03() {
            return s_ogb03;
        }

        public void setS_ogb03(String s_ogb03) {
            this.s_ogb03 = s_ogb03;
        }

        public String getS_ogb04() {
            return s_ogb04;
        }

        public void setS_ogb04(String s_ogb04) {
            this.s_ogb04 = s_ogb04;
        }

        public String getS_ogb05() {
            return s_ogb05;
        }

        public void setS_ogb05(String s_ogb05) {
            this.s_ogb05 = s_ogb05;
        }

        public String getS_ogb06() {
            return s_ogb06;
        }

        public void setS_ogb06(String s_ogb06) {
            this.s_ogb06 = s_ogb06;
        }

        public String getS_ogb07() {
            return s_ogb07;
        }

        public void setS_ogb07(String s_ogb07) {
            this.s_ogb07 = s_ogb07;
        }

        public String getS_ogb08() {
            return s_ogb08;
        }

        public void setS_ogb08(String s_ogb08) {
            this.s_ogb08 = s_ogb08;
        }

        public String getS_ogb09() {
            return s_ogb09;
        }

        public void setS_ogb09(String s_ogb09) {
            this.s_ogb09 = s_ogb09;
        }

        public String getS_ogb10() {
            return s_ogb10;
        }

        public void setS_ogb10(String s_ogb10) {
            this.s_ogb10 = s_ogb10;
        }

        public String getS_ogb11() {
            return s_ogb11;
        }

        public void setS_ogb11(String s_ogb11) {
            this.s_ogb11 = s_ogb11;
        }

        public String getS_ogb12() {
            return s_ogb12;
        }

        public void setS_ogb12(String s_ogb12) {
            this.s_ogb12 = s_ogb12;
        }

        public String getS_ogb13() {
            return s_ogb13;
        }

        public void setS_ogb13(String s_ogb13) {
            this.s_ogb13 = s_ogb13;
        }

        public String getS_ogb14() {
            return s_ogb14;
        }

        public void setS_ogb14(String s_ogb14) {
            this.s_ogb14 = s_ogb14;
        }

        public String getS_ogb15() {
            return s_ogb15;
        }

        public void setS_ogb15(String s_ogb15) {
            this.s_ogb15 = s_ogb15;
        }

        public String getS_ogb16() {
            return s_ogb16;
        }

        public void setS_ogb16(String s_ogb16) {
            this.s_ogb16 = s_ogb16;
        }

        public String getS_ogb17() {
            return s_ogb17;
        }

        public void setS_ogb17(String s_ogb17) {
            this.s_ogb17 = s_ogb17;
        }

        public String getS_ogb18() {
            return s_ogb18;
        }

        public void setS_ogb18(String s_ogb18) {
            this.s_ogb18 = s_ogb18;
        }

        public String getS_ogb19() {
            return s_ogb19;
        }

        public void setS_ogb19(String s_ogb19) {
            this.s_ogb19 = s_ogb19;
        }

        public String getS_ogb20() {
            return s_ogb20;
        }

        public void setS_ogb20(String s_ogb20) {
            this.s_ogb20 = s_ogb20;
        }

        public String getS_ogb_note() {
            return s_ogb_note;
        }

        public void setS_ogb_note(String s_ogb_note) {
            this.s_ogb_note = s_ogb_note;
        }

        public String getS_ogb21() {
            return s_ogb21;
        }

        public void setS_ogb21(String s_ogb21) {
            this.s_ogb21 = s_ogb21;
        }

        public String getS_ogbud01() {
            return s_ogbud01;
        }

        public void setS_ogbud01(String s_ogbud01) {
            this.s_ogbud01 = s_ogbud01;
        }

        public String getS_ogbud02() {
            return s_ogbud02;
        }

        public void setS_ogbud02(String s_ogbud02) {
            this.s_ogbud02 = s_ogbud02;
        }

        public String getS_ogbud03() {
            return s_ogbud03;
        }

        public void setS_ogbud03(String s_ogbud03) {
            this.s_ogbud03 = s_ogbud03;
        }

        public String getS_ogbud04() {
            return s_ogbud04;
        }

        public void setS_ogbud04(String s_ogbud04) {
            this.s_ogbud04 = s_ogbud04;
        }

        public String getS_ogbud05() {
            return s_ogbud05;
        }

        public void setS_ogbud05(String s_ogbud05) {
            this.s_ogbud05 = s_ogbud05;
        }

        public String getS_ogbud06() {
            return s_ogbud06;
        }

        public void setS_ogbud06(String s_ogbud06) {
            this.s_ogbud06 = s_ogbud06;
        }

        public String getS_ogbud07() {
            return s_ogbud07;
        }

        public void setS_ogbud07(String s_ogbud07) {
            this.s_ogbud07 = s_ogbud07;
        }

        public String getS_ogbud08() {
            return s_ogbud08;
        }

        public void setS_ogbud08(String s_ogbud08) {
            this.s_ogbud08 = s_ogbud08;
        }
    }
}
