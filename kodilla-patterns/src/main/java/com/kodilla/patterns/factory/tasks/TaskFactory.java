package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task createTask(final String taskClass) {

        switch (taskClass) {
            case DRIVING:
                return new DrivingTask("driving task", "Wroclaw", "car");
            case PAINTING:
                return new PaintingTask("painting task", "blue", "bedroom");
            case SHOPPING:
                return new ShoppingTask("shopping task", "milk", 2.0);
            default:
                return null;
        }

    }
}
