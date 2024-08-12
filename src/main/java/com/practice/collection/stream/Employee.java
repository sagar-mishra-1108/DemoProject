package com.practice.collection.stream;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Employee {
    private Integer empId;
    private String firstName;
    private String lastName;
    private Double salary;
    private Integer age;
}
