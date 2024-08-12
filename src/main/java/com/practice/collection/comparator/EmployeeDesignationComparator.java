package com.practice.collection.comparator;

import java.util.Comparator;

public class EmployeeDesignationComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getDesignation().getRank() - emp2.getDesignation().getRank();
    }
}
