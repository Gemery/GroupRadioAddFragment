package com.example.gemery.ssww.bean;

import java.io.Serializable;
import java.util.List;

public class StorageBean {


    @Override
    public String toString() {
        return "StorageBean{" +
                "TotalPageCount=" + TotalPageCount +
                ", TotalCount=" + TotalCount +
                ", list=" + list +
                '}';
    }

    /**
     * list : [{"id":2,"s_img00":"300005","s_img_code":"300005001","s_img01":"1059900138",
     * "s_img01_desc":"淋浴房屏风","s_img02":"LA21-01","s_img03":"","s_img04":"102",
     * "s_img04_desc":"浪鲸仓","s_img05":"121","s_img06":"1","s_img07":"M2",
     * "s_img08":1111,"s_img09":1528186640,"s_imgud01":"","s_imgud02":0,
     * "s_imgud03":0,"s_imgud04":0,"s_imgud05":"","s_imgud06":""}]
     * TotalPageCount : 1
     * TotalCount : 4
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

    public static class ListBean implements Serializable {
        @Override
        public String toString() {
            return "ListBean{" +
                    "id=" + id +
                    ", s_img00='" + s_img00 + '\'' +
                    ", s_img_code='" + s_img_code + '\'' +
                    ", s_img01='" + s_img01 + '\'' +
                    ", s_img01_desc='" + s_img01_desc + '\'' +
                    ", s_img02='" + s_img02 + '\'' +
                    ", s_img03='" + s_img03 + '\'' +
                    ", s_img04='" + s_img04 + '\'' +
                    ", s_img04_desc='" + s_img04_desc + '\'' +
                    ", s_img05='" + s_img05 + '\'' +
                    ", s_img06='" + s_img06 + '\'' +
                    ", s_img07='" + s_img07 + '\'' +
                    ", s_img08=" + s_img08 +
                    ", s_img09=" + s_img09 +
                    ", s_imgud01='" + s_imgud01 + '\'' +
                    ", s_imgud02=" + s_imgud02 +
                    ", s_imgud03=" + s_imgud03 +
                    ", s_imgud04=" + s_imgud04 +
                    ", s_imgud05='" + s_imgud05 + '\'' +
                    ", s_imgud06='" + s_imgud06 + '\'' +
                    '}';
        }

        /**
         * id : 2
         * s_img00 : 300005
         * s_img_code : 300005001
         * s_img01 : 1059900138
         * s_img01_desc : 淋浴房屏风
         * s_img02 : LA21-01
         * s_img03 :
         * s_img04 : 102
         * s_img04_desc : 浪鲸仓
         * s_img05 : 121
         * s_img06 : 1
         * s_img07 : M2
         * s_img08 : 1111.0
         * s_img09 : 1528186640
         * s_imgud01 :
         * s_imgud02 : 0.0
         * s_imgud03 : 0.0
         * s_imgud04 : 0.0
         * s_imgud05 :
         * s_imgud06 :
         */

        private int id;
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
        private double s_img08;
        private int s_img09;
        private String s_imgud01;
        private double s_imgud02;
        private double s_imgud03;
        private double s_imgud04;
        private String s_imgud05;
        private String s_imgud06;

        public int getId() {
            return id;
        }

        public void setId(int id) {
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

        public double getS_img08() {
            return s_img08;
        }

        public void setS_img08(double s_img08) {
            this.s_img08 = s_img08;
        }

        public int getS_img09() {
            return s_img09;
        }

        public void setS_img09(int s_img09) {
            this.s_img09 = s_img09;
        }

        public String getS_imgud01() {
            return s_imgud01;
        }

        public void setS_imgud01(String s_imgud01) {
            this.s_imgud01 = s_imgud01;
        }

        public double getS_imgud02() {
            return s_imgud02;
        }

        public void setS_imgud02(double s_imgud02) {
            this.s_imgud02 = s_imgud02;
        }

        public double getS_imgud03() {
            return s_imgud03;
        }

        public void setS_imgud03(double s_imgud03) {
            this.s_imgud03 = s_imgud03;
        }

        public double getS_imgud04() {
            return s_imgud04;
        }

        public void setS_imgud04(double s_imgud04) {
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
