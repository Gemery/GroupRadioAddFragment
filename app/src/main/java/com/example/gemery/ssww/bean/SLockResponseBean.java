package com.example.gemery.ssww.bean;

import java.util.List;

public class SLockResponseBean {


    /**
     * list : [{"id":"integer,自动编号","s_img00":"string,经销商代码",
     * "s_img_code":"string,门店编号","s_img01":"string,物料代码",
     * "s_img01_desc":"string,物料名称","s_img02":"string,型号",
     * "s_img03":"string,规格","s_img04":"string,仓库代码","s_img04_desc":"string,仓库名称",
     * "s_img05":"string,库位","s_img06":"string,批次号","s_img07":"string,库存单位",
     * "s_img08":"double,库存数量","s_img09":"integer,库存记录最后修改时间（时间戳）",
     * "s_imgud01":"string,s_imgud01","s_imgud02":"double,s_imgud02",
     * "s_imgud03":"double,s_imgud03","s_imgud04":"double,s_imgud04",
     * "s_imgud05":"string,s_imgud05","s_imgud06":"string,s_imgud06"}]
     *
     * s : {"resultCode":"string,返回结果码  0：表示成功  9999
     * ：服务异常 9998：无法连接服务  8888：数据输入不完整","resultid":"string,返回自编号id",
     * "resultOrderNum":"string,返回订单编号",
     * "icon":"string,图标","resultMessage":"string,返回注释"}
     */

    private SBean s;
    private List<ListBean> list;

    public SBean getS() {
        return s;
    }

    public void setS(SBean s) {
        this.s = s;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class SBean {
        /**
         * resultCode : string,返回结果码  0：表示成功  9999：服务异常 9998：无法连接服务  8888：数据输入不完整
         * resultid : string,返回自编号id
         * resultOrderNum : string,返回订单编号
         * icon : string,图标
         * resultMessage : string,返回注释
         */

        private String resultCode;
        private String resultid;
        private String resultOrderNum;
        private String icon;
        private String resultMessage;

        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public String getResultid() {
            return resultid;
        }

        public void setResultid(String resultid) {
            this.resultid = resultid;
        }

        public String getResultOrderNum() {
            return resultOrderNum;
        }

        public void setResultOrderNum(String resultOrderNum) {
            this.resultOrderNum = resultOrderNum;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getResultMessage() {
            return resultMessage;
        }

        public void setResultMessage(String resultMessage) {
            this.resultMessage = resultMessage;
        }
    }

    public static class ListBean {
        /**
         * id : integer,自动编号
         * s_img00 : string,经销商代码
         * s_img_code : string,门店编号
         * s_img01 : string,物料代码
         * s_img01_desc : string,物料名称
         * s_img02 : string,型号
         * s_img03 : string,规格
         * s_img04 : string,仓库代码
         * s_img04_desc : string,仓库名称
         * s_img05 : string,库位
         * s_img06 : string,批次号
         * s_img07 : string,库存单位
         * s_img08 : double,库存数量
         * s_img09 : integer,库存记录最后修改时间（时间戳）
         * s_imgud01 : string,s_imgud01
         * s_imgud02 : double,s_imgud02
         * s_imgud03 : double,s_imgud03
         * s_imgud04 : double,s_imgud04
         * s_imgud05 : string,s_imgud05
         * s_imgud06 : string,s_imgud06
         */

        private String id;
        private String s_img00;
        private String s_img_code;
        private String s_img01;
        private String s_img01_desc;
        private String s_img02;
        private String s_img03;
        private String s_img04;
        private String s_img04_desc;
        private String s_img05;
        private String s_img06;
        private String s_img07;
        private String s_img08;
        private String s_img09;
        private String s_imgud01;
        private String s_imgud02;
        private String s_imgud03;
        private String s_imgud04;
        private String s_imgud05;
        private String s_imgud06;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getS_img00() {
            return s_img00;
        }

        public void setS_img00(String s_img00) {
            this.s_img00 = s_img00;
        }

        public String getS_img_code() {
            return s_img_code;
        }

        public void setS_img_code(String s_img_code) {
            this.s_img_code = s_img_code;
        }

        public String getS_img01() {
            return s_img01;
        }

        public void setS_img01(String s_img01) {
            this.s_img01 = s_img01;
        }

        public String getS_img01_desc() {
            return s_img01_desc;
        }

        public void setS_img01_desc(String s_img01_desc) {
            this.s_img01_desc = s_img01_desc;
        }

        public String getS_img02() {
            return s_img02;
        }

        public void setS_img02(String s_img02) {
            this.s_img02 = s_img02;
        }

        public String getS_img03() {
            return s_img03;
        }

        public void setS_img03(String s_img03) {
            this.s_img03 = s_img03;
        }

        public String getS_img04() {
            return s_img04;
        }

        public void setS_img04(String s_img04) {
            this.s_img04 = s_img04;
        }

        public String getS_img04_desc() {
            return s_img04_desc;
        }

        public void setS_img04_desc(String s_img04_desc) {
            this.s_img04_desc = s_img04_desc;
        }

        public String getS_img05() {
            return s_img05;
        }

        public void setS_img05(String s_img05) {
            this.s_img05 = s_img05;
        }

        public String getS_img06() {
            return s_img06;
        }

        public void setS_img06(String s_img06) {
            this.s_img06 = s_img06;
        }

        public String getS_img07() {
            return s_img07;
        }

        public void setS_img07(String s_img07) {
            this.s_img07 = s_img07;
        }

        public String getS_img08() {
            return s_img08;
        }

        public void setS_img08(String s_img08) {
            this.s_img08 = s_img08;
        }

        public String getS_img09() {
            return s_img09;
        }

        public void setS_img09(String s_img09) {
            this.s_img09 = s_img09;
        }

        public String getS_imgud01() {
            return s_imgud01;
        }

        public void setS_imgud01(String s_imgud01) {
            this.s_imgud01 = s_imgud01;
        }

        public String getS_imgud02() {
            return s_imgud02;
        }

        public void setS_imgud02(String s_imgud02) {
            this.s_imgud02 = s_imgud02;
        }

        public String getS_imgud03() {
            return s_imgud03;
        }

        public void setS_imgud03(String s_imgud03) {
            this.s_imgud03 = s_imgud03;
        }

        public String getS_imgud04() {
            return s_imgud04;
        }

        public void setS_imgud04(String s_imgud04) {
            this.s_imgud04 = s_imgud04;
        }

        public String getS_imgud05() {
            return s_imgud05;
        }

        public void setS_imgud05(String s_imgud05) {
            this.s_imgud05 = s_imgud05;
        }

        public String getS_imgud06() {
            return s_imgud06;
        }

        public void setS_imgud06(String s_imgud06) {
            this.s_imgud06 = s_imgud06;
        }
    }
}
