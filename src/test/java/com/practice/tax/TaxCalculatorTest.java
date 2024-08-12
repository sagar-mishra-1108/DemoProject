package com.practice.tax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {
    TaxCalculator taxCalculator;

    @Test
    public void testCalculateTotalTax() {
        taxCalculator = new TaxCalculator();
        double result1 = taxCalculator.calculateTotalTax(25000);
        assertEquals(2000.0, result1);
        double result2 = taxCalculator.calculateTotalTax(35000);
        assertEquals(4000.0, result2);
    }

}