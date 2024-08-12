package com.practice.lambda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Test calls for LambdaDemo
public class LambdaDemoTest {

    LambdaDemo ld;

    @Test
    void getInteger() {
        ld = new LambdaDemo();
        Integer[] myIntegers = {20, 10, -40, 80, 30};
        Integer sum = ld.getSum(myIntegers);
        assertEquals(sum, 100);
    }
}