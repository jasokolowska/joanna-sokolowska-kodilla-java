package com.kodilla.good.patterns.challenges.food2door;

public class HealthyShop implements FoodSupplier{
    private final String name = "Healthy Shop";

    @Override
    public boolean process(OrderEntry orderEntry) {
        if (orderEntry.getProduct().getAvailableQuantity() >= orderEntry.getQuantity()) {
            System.out.println("Order form Healthy Shop is processed...");
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }
}
