package com.practice.solid;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Rectangle implements Shape {
    private double length;
    private double height;

    @Override
    public double calculateArea() {
        return height * length;
    }

    @Override
    public int getSides() {
        return 4;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}
