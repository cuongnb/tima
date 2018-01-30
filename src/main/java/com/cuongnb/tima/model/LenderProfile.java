package com.cuongnb.tima.model;

import com.cuongnb.tima.constant.Config;
import com.cuongnb.tima.constant.LoanTime;
import com.cuongnb.tima.constant.Money;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by cuongnb on 25/01/2018
 */
public class LenderProfile {
    private int lenderId;
    private int totalLoanAccept = 0;
    private int totalLoanPush = 0;
    private int vip; // value = 0, 1, 100
    private int gender; //
    private int isOneLender;
    private Map<Integer, Integer> citiesLoan;
    private Map<Integer, Integer> genderLoan;
    private Map<Integer, Integer> productType;
    private Map<String, Integer> totalMoney;
    private Map<String, Integer> loanTime;
    private Map<String, Integer> mapSources;
    private Map<String, Integer> mapMedium;
    private Map<String, Integer> mapCampaign;

    public LenderProfile(Lender lender, int lenderId, List<Loan> loans) {
        this.lenderId = lenderId;
        totalLoanAccept = loans.size();
        this.vip = lender.getVip();
        this.gender = lender.getGender();
        this.totalLoanPush = lender.getTotalLoanPush();

        loanTime = new HashMap<>();
        Arrays.stream(LoanTime.values()).forEach(s -> loanTime.put(s.name(), 0));
        totalMoney = new HashMap<>();
        Arrays.stream(Money.values()).forEach(s -> totalMoney.put(s.name(), 0));
        citiesLoan = new HashMap<>();
        genderLoan = new HashMap<>();
        productType = new HashMap<>();
        mapSources = new HashMap<>();
        mapMedium = new HashMap<>();
        mapCampaign = new HashMap<>();

        loans.forEach(loan -> {
            loanTime.put(loan.getTime().name(), loanTime.get(loan.getTime().name()) + 1);
            totalMoney.put(loan.getMoney().name(), totalMoney.get(loan.getMoney().name()) + 1);

            if (loan.getLoanCityId() != -1)
                this.citiesLoan.put(loan.getLoanCityId(), this.citiesLoan.containsKey(loan.getLoanCityId()) ?
                        this.citiesLoan.get(loan.getLoanCityId()) + 1 : 1);
            if (loan.getLoanGender() != -1)
                this.genderLoan.put(loan.getLoanGender(), this.genderLoan.containsKey(loan.getLoanGender()) ?
                        this.genderLoan.get(loan.getLoanGender()) + 1 : 1);
            if (loan.getProductType() != -1)
                this.productType.put(loan.getProductType(), this.productType.containsKey(loan.getProductType()) ?
                        this.productType.get(loan.getProductType()) + 1 : 1);
            if (!loan.getSources().equals("null"))
                this.mapSources.put(loan.getSources().trim().toLowerCase(), this.mapSources.containsKey(loan.getSources().trim().toLowerCase()) ?
                        this.mapSources.get(loan.getSources().trim().toLowerCase()) + 1 : 1);
            if (!loan.getMediums().equals("null"))
                this.mapMedium.put(loan.getMediums().trim().toLowerCase(), this.mapMedium.containsKey(loan.getMediums().trim().toLowerCase()) ?
                        this.mapMedium.get(loan.getMediums().trim().toLowerCase()) + 1 : 1);
            if (!loan.getCampaigns().equals("null"))
                this.mapCampaign.put(loan.getCampaigns().trim().toLowerCase(), this.mapCampaign.containsKey(loan.getCampaigns().trim().toLowerCase()) ?
                        this.mapCampaign.get(loan.getCampaigns().trim().toLowerCase()) + 1 : 1);
        });
    }

    public int getLenderId() {
        return lenderId;
    }

    public Map<String, Integer> getMapSources() {
        return mapSources;
    }

    public Map<String, Integer> getMapMedium() {
        return mapMedium;
    }

    public Map<String, Integer> getMapCampaign() {
        return mapCampaign;
    }

    /**
     * score = (tong so diem tren tung feature * muc do anh huong) / tong so don duoc push
     */
    public Double getScore(Loan loan) {
        Double score = this.loanTime.getOrDefault(loan.getTime().name(), 0) * Config.loanTime
                + this.totalMoney.getOrDefault(loan.getMoney().name(), 0) * Config.totalMoney
                + this.productType.getOrDefault(loan.getProductType(), 0) * Config.productType
                + this.citiesLoan.getOrDefault(loan.getLoanCityId(), 0) * Config.cityLoan
                + this.genderLoan.getOrDefault(loan.getLoanGender(), 0) * Config.gender
                + this.mapSources.getOrDefault(loan.getSources(), 0) + Config.utm
                + this.mapMedium.getOrDefault(loan.getMediums(), 0) + Config.utm
                + this.mapCampaign.getOrDefault(loan.getCampaigns(), 0) + Config.utm;

        return score / (this.totalLoanPush * 1.0);
    }

    @Override
    public String toString() {
        return "LenderProfile{" +
                "lenderId=" + lenderId +
                ", totalLoanAccept=" + totalLoanAccept +
                ", totalLoanPush=" + totalLoanPush +
                ", vip=" + vip +
                ", gender=" + gender +
                ", isOneLender=" + isOneLender +
                ", citiesLoan=" + citiesLoan +
                ", genderLoan=" + genderLoan +
                ", productType=" + productType +
                ", totalMoney=" + totalMoney +
                ", loanTime=" + loanTime +
                ", mapSources=" + mapSources +
                ", mapMedium=" + mapMedium +
                ", mapCampaign=" + mapCampaign +
                '}';
    }
}
