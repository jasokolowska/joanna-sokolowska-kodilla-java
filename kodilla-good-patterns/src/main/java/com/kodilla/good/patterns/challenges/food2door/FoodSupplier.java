package com.kodilla.good.patterns.challenges.food2door;

public interface FoodSupplier {
    String getName();
    boolean process(OrderEntry orderEntry);
}
