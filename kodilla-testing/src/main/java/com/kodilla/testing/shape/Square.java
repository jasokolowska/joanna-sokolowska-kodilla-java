package com.kodilla.testing.shape;

public class Square implements Shape{
    String shapeName;
    double field;

    public Square(String shapeName, double field) {
        this.shapeName = shapeName;
        this.field = field;
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getField() {
        return 0;
    }
}
