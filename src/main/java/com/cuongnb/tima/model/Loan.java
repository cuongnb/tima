package com.cuongnb.tima.model;

import com.cuongnb.tima.constant.*;

/**
 * created by cuongnb on 25/01/2018
 */
public class Loan {
    private int lenderId;
    private int loanId;
    private int loanGender; // value: 0,1,2
    private int loanCityId;
    private int loanDistrictId;
    private LoanTime time;
    private Money money;
    private int productType;
    private String campaigns;
    private String mediums;
    private String sources;
    private boolean isAccept;

    public String convertToVec() {
        String vec = lenderId + "\t" +
                loanId + "\t" +
                loanGender + "\t" +
                loanCityId + "\t" +
                loanDistrictId + "\t" +
                time.getValue() + "\t" +
                money.getValue() + "\t" +
                productType + "\t" +
                Campaign.getCampaign(campaigns) + "\t" +
                Medium.getMedium(mediums) + "\t" +
                Source.getSource(sources) + "\t" +
                isAccept;
        return vec;
    }

    public Loan(String loan) {
        String[] loans = loan.split("\t");
        try {
            this.lenderId = Integer.parseInt(loans[0].trim());
            this.loanId = Integer.parseInt(loans[1].trim());
            this.loanGender = Integer.parseInt(loans[2].trim());
            this.loanCityId = Integer.parseInt(loans[3].trim());
            this.loanDistrictId = Integer.parseInt(loans[4].trim());
            this.time = LoanTime.from(Integer.parseInt(loans[5].trim()));
            this.money = Money.from(Double.parseDouble(loans[6].trim()));
            this.productType = Integer.parseInt(loans[7].trim());
            this.campaigns = loans[8].trim();
            this.mediums = loans[9].trim();
            this.sources = loans[10].trim();
            this.isAccept = loans[11].trim().equalsIgnoreCase("accept");
        } catch (Exception e) {
            System.out.println(loan);
        }
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getLoanGender() {
        return loanGender;
    }

    public void setLoanGender(int loanGender) {
        this.loanGender = loanGender;
    }

    public int getLoanCityId() {
        return loanCityId;
    }

    public void setLoanCityId(int loanCityId) {
        this.loanCityId = loanCityId;
    }

    public int getLoanDistrictId() {
        return loanDistrictId;
    }

    public void setLoanDistrictId(int loanDistrictId) {
        this.loanDistrictId = loanDistrictId;
    }

    public int getLenderId() {
        return lenderId;
    }

    public void setLenderId(int lenderId) {
        this.lenderId = lenderId;
    }

    public LoanTime getTime() {
        return time;
    }

    public void setTime(LoanTime time) {
        this.time = time;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public String getSources() {
        if (sources == null) sources = "null";
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getMediums() {
        if (mediums == null) mediums = "null";
        return mediums;
    }

    public void setMediums(String mediums) {
        this.mediums = mediums;
    }

    public String getCampaigns() {
        if (campaigns == null) campaigns = "null";
        return campaigns;
    }

    public void setCampaigns(String campaigns) {
        this.campaigns = campaigns;
    }

    public boolean isAccept() {
        return isAccept;
    }

    public void setAccept(boolean accept) {
        isAccept = accept;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "lenderId=" + lenderId +
                ", loanId=" + loanId +
                ", loanGender=" + loanGender +
                ", loanCityId=" + loanCityId +
                ", loanDistrictId=" + loanDistrictId +
                ", time=" + time +
                ", money=" + money +
                ", productType=" + productType +
                ", campaigns='" + campaigns + '\'' +
                ", mediums='" + mediums + '\'' +
                ", sources='" + sources + '\'' +
                ", isAccept=" + isAccept +
                '}';
    }
}
