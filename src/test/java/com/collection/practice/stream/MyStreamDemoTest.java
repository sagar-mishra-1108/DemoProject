package com.collection.practice.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyStreamDemoTest {

    private MyStreamDemo myStreamDemo;

    @BeforeEach
    public void setUp() {
        myStreamDemo = new MyStreamDemo();
    }

    @Test
    public void testFilterEven() {
        List<Integer> numbers = Arrays.asList(9, 2, 3, 5, 8, 6, 11, 35, 89, 96);
        List<Integer> result = myStreamDemo.filterEven(numbers);
        List<Integer> expected = Arrays.asList(2, 8, 6, 96);
        assertEquals(expected, result);
    }

    @Test
    public void testFilterByAge() {
        List<Employee> employees = Arrays.asList(
                Employee.builder().empId(101).firstName("Sagar").lastName("Mishra").age(32).salary(60000.50).build(),
                Employee.builder().empId(103).firstName("Aryan").lastName("Kapoor").age(25).salary(50000.75).build(),
                Employee.builder().empId(106).firstName("Michael").lastName("Jordan").age(36).salary(70000.25).build(),
                Employee.builder().empId(107).firstName("Pallavi").lastName("Hairan").age(21).salary(59000.15).build(),
                Employee.builder().empId(109).firstName("Shruti").lastName("Hasan").age(39).salary(70000.00).build()
        );

        List<Employee> result = myStreamDemo.filterByAge(employees);
        List<Employee> expected = Arrays.asList(
                Employee.builder().empId(103).firstName("Aryan").lastName("Kapoor").age(25).salary(50000.75).build(),
                Employee.builder().empId(107).firstName("Pallavi").lastName("Hairan").age(21).salary(59000.15).build()
        );

        assertEquals(expected.size(), result.size());

        IntStream.range(0, result.size()).forEach(i -> assertThat(expected.get(i), samePropertyValuesAs(result.get(i))));
    }

    @Test
    public void testNamesAfterFilterByAge() {
        List<Employee> employees = Arrays.asList(
                Employee.builder().empId(101).firstName("Sagar").lastName("Mishra").age(32).salary(60000.50).build(),
                Employee.builder().empId(103).firstName("Aryan").lastName("Kapoor").age(25).salary(50000.75).build(),
                Employee.builder().empId(106).firstName("Michael").lastName("Jordan").age(36).salary(70000.25).build(),
                Employee.builder().empId(107).firstName("Pallavi").lastName("Hairan").age(21).salary(59000.15).build(),
                Employee.builder().empId(109).firstName("Shruti").lastName("Hasan").age(39).salary(70000.00).build()
        );

        List<String> result = myStreamDemo.namesAfterFilterByAge(employees);
        List<String> expected = Arrays.asList("Aryan Kapoor", "Pallavi Hairan");

        assertEquals(expected, result);
    }
}