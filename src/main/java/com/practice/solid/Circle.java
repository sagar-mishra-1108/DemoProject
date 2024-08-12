package com.practice.solid;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Circle implements Shape {
    private double radius;

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public int getSides() {
        return 0;
    }

    @Override
    public String getName() {
        return "Circle";
    }
}
