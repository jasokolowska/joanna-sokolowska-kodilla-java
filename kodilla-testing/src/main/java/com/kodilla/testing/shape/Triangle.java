package com.kodilla.testing.shape;

public class Triangle implements Shape{
    String shapeName;
    double field;

    public Triangle(String shapeName, double field) {
        this.shapeName = shapeName;
        this.field = field;
    }

    @Override
    public String getShapeName() {
        return null;
    }

    @Override
    public double getField() {
        return 0;
    }
}
