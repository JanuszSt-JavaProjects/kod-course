package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private final String name = "Triangle";
    private double field;

    Triangle(double bottomLength, double height) {
        field = 0.5*bottomLength*height;
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
