package com.kodilla.intersection;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.util.*;

public class IntersectionSimulation {

    private static final Duration TRANSLATE_DURATION = Duration.seconds(2);
    private final Intersection intersection;
    private final Pane pane;
    private HashMap<String, Point> north = new HashMap<>();
    private HashMap<String, Point> east = new HashMap<>();
    private HashMap<String, Point> south = new HashMap<>();
    private HashMap<String, Point> west = new HashMap<>();
    private Timer timer = new Timer();

    public IntersectionSimulation(Intersection intersection, Pane pane) {
        this.intersection = intersection;
        this.pane = pane;
        generatePoints();
        intersection.loadIntersection();
        displayCars();
    }

    public void run() {
//        intersection.run();
    }

    private void updateDistanceCars() {
        for (IntersectionEntry entry : intersection.getEntries()) {
            for (Car car : entry.getCars()) {
                car.updateDistance(0.1);
            }
        }
    }

    private void displayCars() {
        List<PathTransition> paths = new ArrayList<>();

        for (IntersectionEntry entry : intersection.getEntries()) {

            for (Car car : entry.getCars()) {
                Rectangle carView = createCar(car);
                pane.getChildren().add(carView);

                Path path = new Path();
                Point point = getPoint(entry, "Start");
                path.getElements().add(new MoveTo(point.getX(), point.getY()));
                System.out.println("Entry " + entry.getName() + ": car - " + car.getDirection() + ", start point: " + point);
                System.out.println(">>> Intersection point: ");
                path.getElements().add(moveToIntersection(entry));


//                if (intersection.checkRightOfWay(entry)) {
//
//                    Direction direction = entry.getCars().get(0).getDirection();
//                    switch (direction) {
//                        case LEFT:
//                            path.getElements().addAll(driveLeft(entry));
//                            break;
//                        case RIGHT:
//                            path.getElements().addAll(driveRight(entry));
//                            break;
//                        case STRAIGHT:
//                            path.getElements().addAll(driveStraight(entry));
//                            break;
//                    }
//                }
                PathTransition pathTransition = new PathTransition(TRANSLATE_DURATION, path, carView);
                pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                paths.add(pathTransition);
            }
        }
        paths.forEach(Animation::play);
        System.out.println("Koniec pętli");
        System.out.println("Node current x: " + pane.getChildren().get(0).getLayoutX() +
                "\nNode current y: " + pane.getChildren().get(0).getLayoutX());
    }

    private PathElement driveStraight(IntersectionEntry entry) {
        Point straight = getPoint(entry, "Straight");
        return new LineTo(straight.getX(), straight.getY());
    }

    private List<PathElement> driveRight(IntersectionEntry entry) {
        Point rightTurn = getPoint(entry, "RightTurn");
        List<PathElement> elements = new ArrayList<>();
        ArcTo arc = new ArcTo();
        arc.setX(rightTurn.getX());
        arc.setY(rightTurn.getY());
        arc.setRadiusX(100);
        arc.setRadiusY(100);
        arc.setSweepFlag(true);
        elements.add(arc);
        IntersectionEntry nextEntry = intersection.getEntries().get(entry.getNextEntryId());
        Point straight = getPoint(nextEntry, "Straight");
        elements.add(new LineTo(straight.getX(), straight.getY()));

        return elements;
    }

    private List<PathElement> driveLeft(IntersectionEntry entry) {
        IntersectionEntry oppositeEntry = intersection.getEntries().get(entry.getOppositeEntryId());
        Point leftTurn = getPoint(oppositeEntry, "RightTurn");
        List<PathElement> elements = new ArrayList<>();
        ArcTo arc = new ArcTo();
        arc.setX(leftTurn.getX());
        arc.setY(leftTurn.getY());
        arc.setRadiusX(150);
        arc.setRadiusY(150);
        elements.add(arc);
        IntersectionEntry nextEntry = intersection.getEntries().get(oppositeEntry.getNextEntryId());
        Point straight = getPoint(nextEntry, "Straight");
        elements.add(new LineTo(straight.getX(), straight.getY()));

        return elements;
    }

    private PathElement moveToIntersection(IntersectionEntry ie) {
        Point point = getPoint(ie, "Intersection");
        System.out.println(point);
        return new LineTo(point.getX(), point.getY());
    }

    private Point getPoint(IntersectionEntry ie, String place) {
        String sideOfTheWorld = ie.getName();

        switch (sideOfTheWorld) {
            case "N":
                System.out.println("N: " + place);
                return north.get(place);
            case "E":
                System.out.println("E: " + place);
                return east.get(place);
            case "S":
                System.out.println("S: " + place);
                return south.get(place);
            case "W":
                System.out.println("W: " + place);
                return west.get(place);
        }
        return null;
    }

    private Rectangle createCar(Car car) {
        Color color = Color.RED;

        if (car.getDirection() == Direction.RIGHT) {
            color = Color.GREEN;
        } else if (car.getDirection() == Direction.STRAIGHT) {
            color = Color.YELLOW;
        }

        final Rectangle rectangle = new Rectangle(50, 25, color);
        return rectangle;
    }

    private void generatePoints() {
        north.put("Start", new Point("N", 215, 0));
        north.put("Intersection", new Point("N", 215, 155));
        north.put("RightTurn", new Point("N", 168, 217));
        north.put("Straight", new Point("N", 215, 512));
        east.put("Start", new Point("E", 512, 215));
        east.put("Intersection", new Point("E", 360, 215));
        east.put("RightTurn", new Point("E", 295, 180));
        east.put("Straight", new Point("E", 0, 215));
        south.put("Start", new Point("S", 295, 512));
        south.put("Intersection", new Point("S", 295, 360));
        south.put("RightTurn", new Point("S", 335, 300));
        south.put("Straight", new Point("S", 295, 0));
        west.put("Start", new Point("W", 0, 295));
        west.put("Intersection", new Point("W", 150, 295));
        west.put("RightTurn", new Point("W", 215, 340));
        west.put("Straight", new Point("W", 512, 300));
    }
}
