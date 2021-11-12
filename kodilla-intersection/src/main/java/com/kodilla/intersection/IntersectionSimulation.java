package com.kodilla.intersection;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class IntersectionSimulation {

    private static final Duration TRANSLATE_DURATION = Duration.seconds(1);
    private final Intersection intersection;
    private final Pane pane;
    private double northX = 212;
    private double northY = 175;
    private double eastX = 335;
    private double eastY = 217;
    private double southX = 293;
    private double southY = 333;
    private double westX = 174;
    private double westY = 296;

    public IntersectionSimulation(Intersection intersection, Pane pane) {
        this.intersection = intersection;
        this.pane = pane;
        intersection.loadIntersection();
    }

    public void run() {
        displayCars();
    }

    private void displayCars() {
        for (IntersectionEntry entry : intersection.getEntries()) {
            for (Car car : entry.getCars()) {
                Rectangle carView = createCar(Color.GREEN);
                pane.getChildren().add(carView);
                createTransition(carView, entry, car);

            }
        }
    }

    private void createTransition(Rectangle carView, IntersectionEntry ie, Car car) {
        TranslateTransition transition = new TranslateTransition(TRANSLATE_DURATION, carView);
//        transition.setCycleCount(Animation.INDEFINITE);

        if (ie.getName().equals("N")) {
            transition.setFromX(190);
            transition.setFromY(0);
            transition.setToY(140);
            carView.setRotate(90);
        }

        transition.setAutoReverse(true);
        transition.play();
    }

    private Rectangle createCar(Color color) {
        final Rectangle rectangle = new Rectangle(50, 25, color);
        return rectangle;
    }
}
