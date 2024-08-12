package com.practice.collection.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortStream {
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

        Comparator<Employee> byName = Comparator.comparing(Employee::getName);
        Comparator<Employee> byAge = Comparator.comparing(Employee::getAge);
        Comparator<Employee> byDesignation = Comparator.comparing(Employee::getDesignation);
        Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary);

        System.out.println("Sorting By Name");
        List<Employee> sortedByName = employees.stream().sorted(byName).collect(Collectors.toList());
        sortedByName.forEach(System.out::println);

        System.out.println("Sorting By Age");
        List<Employee> sortedByAge = employees.stream().sorted(byAge).collect(Collectors.toList());
        sortedByAge.forEach(System.out::println);

        System.out.println("Sorting By Designation");
        List<Employee> sortedByDesignation = employees.stream().sorted(byDesignation).collect(Collectors.toList());
        sortedByDesignation.forEach(System.out::println);

        System.out.println("Sorting By Salary");
        List<Employee> sortedBySalary = employees.stream().sorted(bySalary).collect(Collectors.toList());
        sortedBySalary.forEach(System.out::println);

        System.out.println("Sorting By Name then Age then Designation then Salary");
        List<Employee> sortedByNameAgeDesignationSalary = employees.stream()
                .sorted(byName.thenComparing(byAge).thenComparing(byDesignation).thenComparing(bySalary))
                .collect(Collectors.toList());
        sortedByNameAgeDesignationSalary.forEach(System.out::println);
    }
}
