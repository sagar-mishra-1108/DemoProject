package com.practice.solid;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RectangleFactory implements  ShapeFactory {
    private double length;
    private double height;

    @Override
    public Shape createShape() {
        return new Rectangle(length, height);
    }
}
