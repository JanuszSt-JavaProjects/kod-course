package com.kodilla.testing.shape;

public class Circle implements Shape {
    private final String name = "Circle";
    private double field;

    Circle(double radius) {
        field = radius*radius*3.14;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return field;
    }
}
