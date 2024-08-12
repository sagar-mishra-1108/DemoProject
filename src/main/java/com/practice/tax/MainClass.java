package com.practice.tax;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();

        int feed = 1;
        Scanner sc = new Scanner(System.in);
        while (feed == 1) {
            System.out.println("Enter income : ");
            double income = sc.nextDouble();

            double tax = taxCalculator.calculateTotalTax(income);
            System.out.println("Total tax : " + tax + " and income after tax is : " + (income - tax));
            System.out.println("Press 0 to stop or 1 to calculate another income : ");
            feed = sc.nextInt();
        }
    }
}
