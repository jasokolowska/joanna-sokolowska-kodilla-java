package com.kodilla.intersection;

import java.util.*;

public class IntersectionEntry {
    private String name;
    private List<Car> cars = new ArrayList<>();
    private Map<Direction, String> exits = new HashMap<>();

    public IntersectionEntry(String name) {
        this.name = name;
        Random random = new Random();
        int numberOfCars = random.nextInt(10);
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }
    }

    public void addExit(Direction direction, String name) {
        this.exits.put(direction, name);
    }

    public String getName() {
        return name;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeFirstCar() {
        cars.remove(0);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Map<Direction, String> getExits() {
        return exits;
    }

    @Override
    public String toString() {
        return "IntersectionEntry{" +
                "name='" + name + '\'' +
                ", cars=" + cars +
                ", exits=" + exits +
                '}';
    }
}
