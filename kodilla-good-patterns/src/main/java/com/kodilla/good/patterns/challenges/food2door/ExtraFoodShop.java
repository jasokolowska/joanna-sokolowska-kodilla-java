package com.kodilla.good.patterns.challenges.food2door;

public class ExtraFoodShop implements FoodSupplier {
    private final String name = "Extra Food Shop";

    @Override
    public boolean process(OrderEntry orderEntry) {
        if (orderEntry.getProduct().getAvailableQuantity() >= orderEntry.getQuantity()) {
            System.out.println("Order form Extra Food Shop is processed...");
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }
}
