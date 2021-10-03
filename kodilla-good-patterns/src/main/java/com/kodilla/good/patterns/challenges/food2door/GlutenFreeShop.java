package com.kodilla.good.patterns.challenges.food2door;

public class GlutenFreeShop implements FoodSupplier{
    private final String name = "Gluten Free Shop";

    @Override
    public boolean process(OrderEntry orderEntry) {
        if (orderEntry.getProduct().getAvailableQuantity() >= orderEntry.getQuantity()) {
            System.out.println("Order form Gluten Free Shop is processed...");
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }
}
