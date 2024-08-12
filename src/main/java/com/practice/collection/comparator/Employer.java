package com.practice.collection.comparator;

import java.util.ArrayList;

public class Employer {
    public static void main(String ...a) {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee1 = Employee.builder().id(1).name("Sagar Mishra").age(29).salary(65000.75).designation(Designation.SENIOR_DEVELOPER).build();
        Employee employee2 = Employee.builder().id(3).name("Aryan Singh").age(37).salary(75000.15).designation(Designation.TEAM_LEAD).build();
        Employee employee3 = Employee.builder().id(4).name("Mahesh Babu").age(29).salary(64000.45).designation(Designation.SENIOR_DEVELOPER).build();
        Employee employee4 = Employee.builder().id(6).name("Karuna Sharma").age(37).salary(79000.19).designation(Designation.MANAGER).build();
        Employee employee5 = Employee.builder().id(9).name("Tom Hardy").age(27).salary(58000.00).designation(Designation.DEVELOPER).build();
        Employee employee6 = Employee.builder().id(7).name("Tom Hardy").age(27).salary(48000.00).designation(Designation.INTERN).build();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);

        System.out.println(employees);

        System.out.println("Sorting By Name");
        employees.sort(new EmployeeNameComparator());
        employees.forEach(System.out::println);

        System.out.println("Sorting By Age");
        employees.sort(new EmployeeAgeComparator());
        employees.forEach(System.out::println);

        System.out.println("Sorting By Designation");
        employees.sort(new EmployeeDesignationComparator());
        employees.forEach(System.out::println);

        System.out.println("Sorting By Salary");
        employees.sort(new EmployeeSalaryComparator());
        employees.forEach(System.out::println);

        System.out.println("Sorting By Name then Age then Designation then Salary");
        employees.sort(new EmployeeNameAgeDesignationSalaryComparator());
        employees.forEach(System.out::println);
    }
}
