package com.kodilla.intersection;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Intersection {
    private static final Random random = new Random();

    private List<IntersectionEntry> entries;

    public Intersection() {
        this.entries = new LinkedList<>();
//        loadIntersection();
    }

    public List<IntersectionEntry> getEntries() {
        return entries;
    }


    public void updateDistance(Car car, double timeUnit) {
        double currentDistance = car.getDistance();
        double newDistance = currentDistance + (car.getSpeed() * timeUnit);
        car.setDistance(newDistance);
    }

    public void run() {

//        while (true) {
//            driveThroughIntersection();
//            placeCarOnIntersection();
//            try{
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(entries);
//        }
    }

    public boolean checkRightOfWay(IntersectionEntry entry) {
        Direction direction = entry.getCars().get(0).getDirection();
        String rightEntryName = entry.getExits().get(Direction.RIGHT);
        String frontEntryName = entry.getExits().get(Direction.STRAIGHT);

        IntersectionEntry rightEntry = entries.stream()
                .filter(intersectionEntry -> intersectionEntry.getName().equals(rightEntryName))
                .toList()
                .get(0);

        IntersectionEntry frontEntry = entries.stream()
                .filter(intersectionEntry -> intersectionEntry.getName().equals(frontEntryName))
                .toList()
                .get(0);

        if (direction.equals(Direction.RIGHT)) {
//            entry.getCars().remove(0);
            System.out.println("Car removed RIGHT");
            return true;
        } else if (direction.equals(Direction.STRAIGHT) && rightEntry.getCars().size() == 0) {
//            entry.getCars().remove(0);
            System.out.println("Car removed STRAIGHT");
            return true;
        } else if (direction.equals(Direction.LEFT) && rightEntry.getCars().size() == 0
                && frontEntry.getCars().size() == 0) {
//            entry.getCars().remove(0);
            System.out.println("Car removed LEFT");
            return true;
        }
        return false;
    }

    public void driveThroughIntersection() {
        int counter = 0;

        for (IntersectionEntry entry : entries) {
            if (entry.getCars().size() > 0 ) {
                Direction direction = entry.getCars().get(0).getDirection();
                String rightEntryName = entry.getExits().get(Direction.RIGHT);
                String frontEntryName = entry.getExits().get(Direction.STRAIGHT);

                IntersectionEntry rightEntry = entries.stream()
                        .filter(intersectionEntry -> intersectionEntry.getName().equals(rightEntryName))
                        .toList()
                        .get(0);

                IntersectionEntry frontEntry = entries.stream()
                        .filter(intersectionEntry -> intersectionEntry.getName().equals(frontEntryName))
                        .toList()
                        .get(0);


                if (direction.equals(Direction.RIGHT)) {
                    entry.getCars().remove(0);
                    System.out.println("Car removed RIGHT");
                } else if (direction.equals(Direction.STRAIGHT) && rightEntry.getCars().size() == 0) {
                    entry.getCars().remove(0);
                    System.out.println("Car removed STRAIGHT");
                } else if (direction.equals(Direction.LEFT) && rightEntry.getCars().size() == 0
                        && frontEntry.getCars().size() == 0) {
                    entry.getCars().remove(0);
                    System.out.println("Car removed LEFT");
                } else if (counter == 0) {
                    counter++;
                } else {
                    if (entry.getCars().size() > 0) {
                        entry.getCars().remove(0);
                        System.out.println("Randomly picked car removed");
                    }
                }
            }
        }
    }

    public void placeCarOnIntersection() {
        int randomNbr = random.nextInt(3);
        this.entries.get(randomNbr).getCars().add(new Car());
    }

    public void loadIntersection() {
        this.entries.add(new IntersectionEntry(0,"N"));
        this.entries.add(new IntersectionEntry(1,"E"));
        this.entries.add(new IntersectionEntry(2,"S"));
        this.entries.add(new IntersectionEntry(3,"W"));

        this.entries.get(0).getCars().add(new Car());

        loadExits();
    }

    public void loadExits() {
        this.entries.get(0).addExit(Direction.RIGHT, "W");
        this.entries.get(0).addExit(Direction.LEFT, "E");
        this.entries.get(0).addExit(Direction.STRAIGHT, "S");

        this.entries.get(1).addExit(Direction.RIGHT, "N");
        this.entries.get(1).addExit(Direction.LEFT, "S");
        this.entries.get(1).addExit(Direction.STRAIGHT, "W");

        this.entries.get(2).addExit(Direction.RIGHT, "W");
        this.entries.get(2).addExit(Direction.LEFT, "E");
        this.entries.get(2).addExit(Direction.STRAIGHT, "N");

        this.entries.get(3).addExit(Direction.LEFT,"N");
        this.entries.get(3).addExit(Direction.RIGHT, "S");
        this.entries.get(3).addExit(Direction.STRAIGHT, "E");
    }
}
