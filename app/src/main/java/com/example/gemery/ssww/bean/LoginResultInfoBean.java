package com.example.gemery.ssww.bean;

public class LoginResultInfoBean {

    /**
     * s_bd01 : ssww
     * s_zx00 : 300005
     * s_zx06 : 300005001
     * s_zx01 : 300005001000101
     * s_zx02 : admin
     * s_zx04 : 程序员
     * s_zxud01 :
     * s_zxud02 :
     * serverCode : {"resultCode":"0","resultid":null,"resultOrderNum":null,"icon":null,"resultMessage":"登录成功"}
     */

    private String s_bd01;
    private String s_zx00;
    private String s_zx06;
    private String s_zx01;
    private String s_zx02;
    private String s_zx04;
    private String s_zxud01;
    private String s_zxud02;
    private ServerCodeBean serverCode;

    public String getS_bd01() {
        return s_bd01;
    }

    public void setS_bd01(String s_bd01) {
        this.s_bd01 = s_bd01;
    }

    public String getS_zx00() {
        return s_zx00;
    }

    public void setS_zx00(String s_zx00) {
        this.s_zx00 = s_zx00;
    }

    public String getS_zx06() {
        return s_zx06;
    }

    public void setS_zx06(String s_zx06) {
        this.s_zx06 = s_zx06;
    }

    public String getS_zx01() {
        return s_zx01;
    }

    public void setS_zx01(String s_zx01) {
        this.s_zx01 = s_zx01;
    }

    public String getS_zx02() {
        return s_zx02;
    }

    public void setS_zx02(String s_zx02) {
        this.s_zx02 = s_zx02;
    }

    public String getS_zx04() {
        return s_zx04;
    }

    public void setS_zx04(String s_zx04) {
        this.s_zx04 = s_zx04;
    }

    public String getS_zxud01() {
        return s_zxud01;
    }

    public void setS_zxud01(String s_zxud01) {
        this.s_zxud01 = s_zxud01;
    }

    public String getS_zxud02() {
        return s_zxud02;
    }

    public void setS_zxud02(String s_zxud02) {
        this.s_zxud02 = s_zxud02;
    }

    public ServerCodeBean getServerCode() {
        return serverCode;
    }

    public void setServerCode(ServerCodeBean serverCode) {
        this.serverCode = serverCode;
    }

    public static class ServerCodeBean {
        /**
         * resultCode : 0
         * resultid : null
         * resultOrderNum : null
         * icon : null
         * resultMessage : 登录成功
         */

        private String resultCode;
        private Object resultid;
        private Object resultOrderNum;
        private Object icon;
        private String resultMessage;

        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public Object getResultid() {
            return resultid;
        }

        public void setResultid(Object resultid) {
            this.resultid = resultid;
        }

        public Object getResultOrderNum() {
            return resultOrderNum;
        }

        public void setResultOrderNum(Object resultOrderNum) {
            this.resultOrderNum = resultOrderNum;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public String getResultMessage() {
            return resultMessage;
        }

        public void setResultMessage(String resultMessage) {
            this.resultMessage = resultMessage;
        }
    }
}
