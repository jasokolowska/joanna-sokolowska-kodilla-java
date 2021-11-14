package com.kodilla.intersection;

import java.util.Random;

public class Car {
    private Direction direction;

    public Car() {
        Random randomNbr = new Random();
        this.direction = Direction.fromNumber(randomNbr.nextInt(3));
    }

    public Car(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Car{" +
                "direction=" + direction +
                '}';
    }
}
