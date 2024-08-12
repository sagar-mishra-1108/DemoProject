package com.practice.solid;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TriangleFactory implements  ShapeFactory {
    private double base;
    private double height;

    @Override
    public Shape createShape() {
        return new Triangle(base, height);
    }
}
