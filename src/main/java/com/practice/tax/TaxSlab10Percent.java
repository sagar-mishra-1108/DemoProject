package com.practice.tax;

public class TaxSlab10Percent implements TaxSlab {
    private static final double LOWER_LIMIT = 10000;
    private static final double UPPER_LIMIT = 20000;
    private static final double RATE = 0.1;

    @Override
    public double calculateTax(double income) {
        if (income <= LOWER_LIMIT) {
            return 0.0;
        }

        double taxableIncome = Math.min(income, UPPER_LIMIT) - LOWER_LIMIT;
        return taxableIncome * RATE;
    }
}
