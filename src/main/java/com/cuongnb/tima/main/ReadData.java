package com.cuongnb.tima.main;

import com.cuongnb.tima.model.Lender;
import com.cuongnb.tima.model.LenderLoanScore;
import com.cuongnb.tima.model.LenderProfile;
import com.cuongnb.tima.model.Loan;
import com.cuongnb.tima.utils.MapUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * created by cuongnb on 26/01/2018
 */
public class ReadData {
    private List<Loan> readLoan(String filename) {
        try (Stream<String> stream = Files.lines(Paths.get("data/" + filename))) {
            return stream.map(Loan::new).collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Lender> readLender() {
        try (Stream<String> stream = Files.lines(Paths.get("data/total_loan_to_lender.tsv"))) {
            return stream.map(Lender::new).collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        ReadData readData = new ReadData();
        Map<Integer, List<Loan>> lenderLoans = requireNonNull(readData.readLoan("tima.tsv")).stream().collect(groupingBy(Loan::getLenderId));

        List<LenderProfile> lenderProfiles = new ArrayList<>();
        /*Build lender profile*/
        Map<Integer, Lender> lenderMaps = requireNonNull(readData.readLender()).stream().collect(toMap(Lender::getLenderId, lender -> lender));
        lenderLoans.forEach((integer, loans) ->
                lenderProfiles.add(new LenderProfile(lenderMaps.get(integer), integer, loans)));

        /*Test*/
        List<Loan> loanTests = readData.readLoan("loanToTest.tsv");
        assert loanTests != null;
        Loan loanTest = loanTests.stream().filter(Loan::isAccept).findFirst().get();
        System.out.println("test for loanId :" + loanTest.toString());
        Map<Integer, Double> topLender = lenderProfiles.stream()
                .map(lenderProfile -> {
                    double score = lenderProfile.getScore(loanTest);
                    return new LenderLoanScore(loanTest.getLoanId(), lenderProfile.getLenderId(), score);
                })
                .collect(toMap(LenderLoanScore::getLenderId, LenderLoanScore::getScore));
        topLender = MapUtils.sortByValueDESC(topLender);
        topLender.forEach((integer, aDouble) -> System.out.println(integer + "\t" + aDouble));
    }
}
