package com.kodilla.testing.shape;

public class Square implements Shape {
    private final String name="Square";
    private double field;

    Square(double sideLength){
        field=sideLength*sideLength;
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
