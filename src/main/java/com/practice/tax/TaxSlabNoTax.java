package com.practice.tax;

public class TaxSlabNoTax implements TaxSlab {
    @Override
    public double calculateTax(double income) {
        return 0.0;
    }
}
