package com.practice.lambda;

import java.util.stream.Stream;

public class LambdaDemo {

    public static void main(String ...args) {
        LambdaDemo ld = new LambdaDemo();
        Integer[] myIntegers = {20, 10, -40, 80, 30};
        Integer sum = ld.getSum(myIntegers);
        Integer sum2 = ld.getSum2(myIntegers);

        System.out.println(sum);
        System.out.println(sum2);
    }

    public Integer getSum(Integer[] myIntegers) {
        return Stream.of(myIntegers)
                .reduce(0, Integer::sum);
//                .reduce(0, (sum, num) -> sum + num); // same as above
    }

    public Integer getSum2(Integer[] myInt) {
        return Stream.of(myInt).mapToInt(Number::intValue).sum();
    }

}
