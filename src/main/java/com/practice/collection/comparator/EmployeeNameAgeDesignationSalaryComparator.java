package com.practice.collection.comparator;

import java.util.Comparator;

public class EmployeeNameAgeDesignationSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        int nameComparison = emp1.getName().compareTo(emp2.getName());
        int ageComparison = emp1.getAge() - emp2.getAge();
        int designationComparison = emp1.getDesignation().getRank() - emp2.getDesignation().getRank();
        int salaryComparison = Double.compare(emp1.getSalary(), emp2.getSalary());
        return nameComparison == 0
                ? ageComparison == 0
                    ? designationComparison == 0
                        ? salaryComparison
                        : designationComparison
                    : ageComparison
                : nameComparison;

    }
}
