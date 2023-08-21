package com.collection.practice.stream;

import java.util.List;
import java.util.stream.Collectors;

public class MyStreamDemo {
    public List<Integer> filterEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Employee> filterByAge(List<Employee> employees) {
        return employees.stream()
                .filter(emp -> emp.getAge() < 30)
                .collect(Collectors.toList());
    }

    public List<String> namesAfterFilterByAge(List<Employee> employees) {
        return employees.stream()
                .filter(emp -> emp.getAge() < 30)
                .map(emp -> String.format("%s %s", emp.getFirstName(), emp.getLastName()))
                .collect(Collectors.toList());
    }
}
