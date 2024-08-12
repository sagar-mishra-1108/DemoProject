package com.practice.tax;

public class TaxCalculator {
    private final TaxSlab noTax;
    private final TaxSlab tenPercentTax;
    private final TaxSlab twentyPercentTax;

    public TaxCalculator() {
        this.noTax = new TaxSlabNoTax();
        this.tenPercentTax = new TaxSlab10Percent();
        this.twentyPercentTax = new TaxSlab20Percent();
    }

    public double calculateTotalTax(double income) {
        double totalTax = 0.0;
        totalTax += noTax.calculateTax(income);
        totalTax += tenPercentTax.calculateTax(income);
        totalTax += twentyPercentTax.calculateTax(income);
        return totalTax;
    }
}
