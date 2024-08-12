package com.practice.solid;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CircleFactory implements  ShapeFactory {
    private double radius;

    @Override
    public Shape createShape() {
        return new Circle(radius);
    }
}
