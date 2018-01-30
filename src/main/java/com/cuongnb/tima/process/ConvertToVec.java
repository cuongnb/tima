package com.cuongnb.tima.process;

import com.cuongnb.tima.constant.Campaign;
import com.cuongnb.tima.constant.Medium;
import com.cuongnb.tima.constant.Source;
import com.cuongnb.tima.model.Lender;
import com.cuongnb.tima.model.Loan;

/**
 * created by cuongnb on 28/01/2018
 */
public class ConvertToVec {
    public static String convertToVec(Loan loan, Lender lender) {
        return lender.getGender() + "\t" +
                loan.getLoanGender() + "\t" +
                loan.getProductType() + "\t" +
                lender.getCityId() + "\t" +
                loan.getLoanCityId() + "\t" +
                lender.getDistrictId() + "\t" +
                loan.getLoanDistrictId() + "\t" +
                loan.getTime().getValue() + "\t" +
                loan.getMoney().getValue() + "\t" +
                Campaign.getCampaign(loan.getCampaigns()) + "\t" +
                Medium.getMedium(loan.getMediums()) + "\t" +
                Source.getSource(loan.getSources()) + "\t" +
                lender.getVip() + "\t" +
                loan.isAccept();
    }
}
