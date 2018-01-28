package com.cuongnb.tima.constant;

/**
 * created by cuongnb on 28/01/2018
 */
public class Campaign {
    public static Integer getCampaign(String s) {
        switch (s) {
            case "web":
                return 1;
            case "zalo":
                return 2;
            case "vaytientragoptheongay.com":
                return 3;
            case "map_23nov2017":
                return 4;
            default:
                return 0;
        }
    }
}
