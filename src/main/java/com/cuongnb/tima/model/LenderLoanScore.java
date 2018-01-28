package com.cuongnb.tima.model;

/**
 * created by cuongnb on 26/01/2018
 */
public class LenderLoanScore {
    private int loanId;
    private int lenderId;
    private Double score;

    public LenderLoanScore(int loanId, int lenderId, double score) {
        this.loanId = loanId;
        this.lenderId = lenderId;
        this.score = score;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getLenderId() {
        return lenderId;
    }

    public void setLenderId(int lenderId) {
        this.lenderId = lenderId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "LenderLoanScore{" +
                "loanId=" + loanId +
                ", lenderId=" + lenderId +
                ", score=" + score +
                '}';
    }
}
