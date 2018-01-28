package com.cuongnb.tima.constant;

/**
 * created by cuongnb on 25/01/2018
 */
public enum LoanTime {
    SHORT(0),
    MEDIUM(1),
    LONG(2);

    private int value;

    LoanTime(int i) {
        this.value = i;
    }

    public static LoanTime from(int time) {
        if (time < 30) {
            return SHORT;
        } else if (time <= 90) {
            return MEDIUM;
        } else {
            return LONG;
        }
    }

    public int getValue() {
        return value;
    }
}
