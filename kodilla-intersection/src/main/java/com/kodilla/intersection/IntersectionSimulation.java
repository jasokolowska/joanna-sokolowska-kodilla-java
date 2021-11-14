package com.kodilla.intersection;

import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionSimulation {

    private static final Duration TRANSLATE_DURATION = Duration.seconds(5);
    private final Intersection intersection;
    private final Pane pane;
    private HashMap<String, Point> north = new HashMap<>();
    private HashMap<String, Point> east = new HashMap<>();
    private HashMap<String, Point> south = new HashMap<>();
    private HashMap<String, Point> west = new HashMap<>();

    public IntersectionSimulation(Intersection intersection, Pane pane) {
        this.intersection = intersection;
        this.pane = pane;
        generatePoints();
        intersection.loadIntersection();
    }

    public void run() {
        displayCars();
        checkAvailableMoves();
    }

    private void checkAvailableMoves() {
        for (IntersectionEntry entry : intersection.getEntries()) {
            if (entry.getCars().size() > 0) {
                if (intersection.checkRightOfWay(entry)) {
                    //goStraight()
                    //goLeft()
                    //goRight()
                    Direction direction = entry.getCars().get(0).getDirection();
                    switch (direction) {
                        case RIGHT -> {
                            driveRight(entry);
                        }
                    }
                }
            }
        }
    }

    private void displayCars() {

        for (IntersectionEntry entry : intersection.getEntries()) {

            for (Car car : entry.getCars()) {
                Rectangle carView = createCar(Color.GREEN);
                pane.getChildren().add(carView);

                PathTransition pathTransition = new PathTransition();
                Path path = new Path();
                Point point = getPoint(entry, "Start");
                path.getElements().add(new MoveTo(point.getX(), point.getY()));
                path.getElements().add(moveToIntersection(entry));

                if (intersection.checkRightOfWay(entry)) {

                    Direction direction = entry.getCars().get(0).getDirection();
                    switch (direction) {
                        case LEFT:
                            path.getElements().addAll(driveLeft(entry));
                            break;
                        case RIGHT:
                            path.getElements().addAll(driveRight(entry));
                            break;
                        case STRAIGHT:
                            path.getElements().addAll(driveStraight(entry));
                            break;
                    }
                }
                pathTransition.setPath(path);
                pathTransition.setNode(carView);
                pathTransition.setDuration(TRANSLATE_DURATION);
                pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                pathTransition.play();
            }
        }
    }

    private List<PathElement> driveStraight(IntersectionEntry entry) {
        return null;
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
        return new LineTo(point.getX(), point.getY());
    }

    private Point getPoint(IntersectionEntry ie, String place) {
        String sideOfTheWorld = ie.getName();

        switch (sideOfTheWorld) {
            case "N":
                return north.get(place);
            case "E":
                return east.get(place);
            case "S":
                return south.get(place);
            case "W":
                return west.get(place);
        }
        return null;
    }

    private Rectangle createCar(Color color) {
        final Rectangle rectangle = new Rectangle(50, 25, color);
        return rectangle;
    }

    private void generatePoints() {
        north.put("Start", new Point("N", 215, 0));
        north.put("Intersection", new Point("N", 215, 155));
        north.put("RightTurn", new Point("N", 168, 217));
        north.put("Straight", new Point("N", 215, 512));
        east.put("Start", new Point("E", 512, 215));
        east.put("Intersection", new Point("E", 335, 215));
        east.put("RightTurn", new Point("E", 295, 180));
        east.put("Straight", new Point("E", 0, 215));
        south.put("Start", new Point("S", 295, 512));
        south.put("Intersection", new Point("S", 295, 335));
        south.put("RightTurn", new Point("S", 335, 300));
        south.put("Straight", new Point("S", 295, 0));
        west.put("Start", new Point("W", 0, 295));
        west.put("Intersection", new Point("W", 175, 295));
        west.put("RightTurn", new Point("W", 215, 340));
        west.put("Straight", new Point("W", 512, 300));


    }
}
