package com.cuongnb.tima.constant;

/**
 * created by cuongnb on 28/01/2018
 */
public class Medium {
    public static Integer getMedium(String s) {
        switch (s) {
            case "zalo":
                return 1;
            case "slider":
                return 2;
            case "button":
                return 3;
            case "cpc_tunganh_vaytiennhanh":
                return 4;
            case "google":
                return 5;
            default:
                return 0;
        }
    }
}
