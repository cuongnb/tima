package com.cuongnb.tima.model;

/**
 * created by cuongnb on 26/01/2018
 */
public class Lender {
    private int lenderId;
    private String fullname;
    private int gender;
    private int totalLoanPush;
    private int vip;
    private int cityId;
    private int districtId;

    public Lender(String s) {
        String[] fields = s.split("\t");
        this.lenderId = Integer.parseInt(fields[0]);
        this.totalLoanPush = Integer.parseInt(fields[1]);
        this.vip = Integer.parseInt(fields[2]);
        this.gender = Integer.parseInt(fields[3]);
        this.fullname = fields[4];
        this.cityId = Integer.parseInt(fields[5]);
        this.districtId = Integer.parseInt(fields[6]);
    }

    public int getLenderId() {
        return lenderId;
    }

    public void setLenderId(int lenderId) {
        this.lenderId = lenderId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getTotalLoanPush() {
        return totalLoanPush;
    }

    public void setTotalLoanPush(int totalLoanPush) {
        this.totalLoanPush = totalLoanPush;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }
}
