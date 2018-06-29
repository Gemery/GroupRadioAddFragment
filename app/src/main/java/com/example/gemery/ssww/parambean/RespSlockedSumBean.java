package com.example.gemery.ssww.parambean;

import java.io.Serializable;

public class RespSlockedSumBean implements Serializable {

    /**
     * s_lock_e05 : 1059900138
     * lock_sum : 6
     */

    private String s_lock_e05;
    private int lock_sum;

    public String getS_lock_e05() {
        return s_lock_e05;
    }

    public void setS_lock_e05(String s_lock_e05) {
        this.s_lock_e05 = s_lock_e05;
    }

    @Override
    public String toString() {
        return "RespSlockedSumBean{" +
                "s_lock_e05='" + s_lock_e05 + '\'' +
                ", lock_sum=" + lock_sum +
                '}';
    }

    public int getLock_sum() {
        return lock_sum;
    }

    public void setLock_sum(int lock_sum) {
        this.lock_sum = lock_sum;
    }
}
