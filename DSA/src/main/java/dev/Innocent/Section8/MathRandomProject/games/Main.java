package dev.Innocent.Section8.MathRandomProject.games;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        double policyAmount = 100_000_000;
        int beneficiaries = 3;
        float percentageFloat = 1.0f / beneficiaries;
        double percentage = 1.0 / beneficiaries;

        System.out.printf("Payout = %,.2f%n", policyAmount * percentageFloat);
        System.out.printf("Payout = %,.2f%n", policyAmount * percentage);

        double totalUsingFloat = policyAmount -
                ((policyAmount * percentageFloat) * beneficiaries);
        System.out.printf("totalUsingFloat: %,.2f%n", totalUsingFloat);

        double total = policyAmount -
                ((policyAmount * percentage) * beneficiaries);
        System.out.printf("total: %,.2f%n", total);

        String[] tests = {"15.456", "8", "10000.000001", ".123"};
        BigDecimal[] bds = new BigDecimal[tests.length];
        Arrays.setAll(bds, i -> new BigDecimal(tests[i]));

        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale",
                "Precision");
        for (var bd : bds) {
            System.out.printf("%-15s %-15d %-8d %d %n",
                    bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }

        double[] doubles = {15.456, 8, 10000.000001, .123};
        Arrays.setAll(bds, i -> BigDecimal.valueOf(doubles[i]));
        System.out.println("---------------------------");
        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale",
                "Precision");
        for (var bd : bds) {
            System.out.printf("%-15s %-15d %-8d %d %n",
                    bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }

//        BigDecimal test1 = new BigDecimal("1.1111122222333334444455555");
//        BigDecimal test2 = BigDecimal.valueOf(1.1111122222333334444455555);
//
//        System.out.println("---------------------------");
//        System.out.printf("%-30s %-30s %-8s %s%n", "Value", "Unscaled Value", "Scale",
//                "Precision");
//        System.out.printf("%-30s %-30d %-8d %d %n",
//                test1, test1.unscaledValue(), test1.scale(), test1.precision());
//        System.out.printf("%-30s %-30d %-8d %d %n",
//                test2, test2.unscaledValue(), test2.scale(), test2.precision());

    }
}
