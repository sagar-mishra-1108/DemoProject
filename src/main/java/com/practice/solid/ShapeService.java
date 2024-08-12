package com.practice.solid;

public class ShapeService {
    public static void main(String []args) {
        ShapeFactory circleFactory = new CircleFactory(5);
        ShapeFactory triangleFactory = new TriangleFactory(10, 6);
        ShapeFactory rectangleFactory = new RectangleFactory(7, 5);

        Shape circle = circleFactory.createShape();
        Shape triangle = triangleFactory.createShape();
        Shape rectangle = rectangleFactory.createShape();

        printDetails(circle);
        printDetails(triangle);
        printDetails(rectangle);
    }

    private static void printDetails(Shape shape) {
        System.out.println("Name = " + shape.getName());
        System.out.println("Sides = " + shape.getSides());
        System.out.println("Area = " + shape.calculateArea());
    }
}
