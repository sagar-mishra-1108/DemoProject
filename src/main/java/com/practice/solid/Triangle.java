package com.practice.solid;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Triangle implements Shape {
    private double base;
    private double height;

    @Override
    public double calculateArea() {
        return base * height / 2;
    }

    @Override
    public int getSides() {
        return 3;
    }

    @Override
    public String getName() {
        return "Triangle";
    }
}
