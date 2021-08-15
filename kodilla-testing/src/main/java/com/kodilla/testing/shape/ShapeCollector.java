package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    List<Shape> shapes = new ArrayList<>();

    void addFigure(Shape shape) {
    shapes.add(shape);
    }

    boolean removeFigure(Shape shape) {
        if (shapes.contains(shape)) {
            shapes.remove(shape);
            return true;
        }
        else return false;
    }

    Shape getFigure(int n) {
        return shapes.get(n);
    }

    String showFigures() {
        String figuresList = "";

        for (Shape shape : shapes) {
            figuresList += shape.getShapeName() + ", ";
        }
        return figuresList;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
