package com.cuongnb.tima.constant;

/**
 * created by cuongnb on 25/01/2018
 */
public enum Money {
    LOW(0),
    MEDIUM(1),
    HIGH(2);

    private int value;

    Money(int i) {
        this.value = i;
    }

    public static Money from(Double money) {
        if (money < 5000000) {
            return LOW;
        } else if (money <= 30000000) {
            return MEDIUM;
        } else {
            return HIGH;
        }
    }

    public int getValue() {
        return value;
    }
}
