package com.practice.tax;

public class TaxSlab20Percent implements TaxSlab {
    private static final double LOWER_LIMIT = 20000;
    private static final double RATE = 0.2;

    @Override
    public double calculateTax(double income) {
        if (income <= LOWER_LIMIT) {
            return 0.0;
        }

        double taxableIncome = income - LOWER_LIMIT;
        return taxableIncome * RATE;
    }
}
