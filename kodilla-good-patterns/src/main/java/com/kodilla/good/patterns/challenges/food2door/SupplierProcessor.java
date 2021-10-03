package com.kodilla.good.patterns.challenges.food2door;

public class SupplierProcessor {
    private FoodSupplier foodSupplier;
    private OrderEntry orderEntry;

    public SupplierProcessor(FoodSupplier foodSupplier, OrderEntry orderEntry) {
        this.foodSupplier = foodSupplier;
        this.orderEntry = orderEntry;
    }

    public boolean processOrder() {
        if (foodSupplier.process(orderEntry)) {
            System.out.println("Order for " + orderEntry.getProduct().getName() + " from " + foodSupplier.getName() + " is completed");
            return true;
        } else {
            System.out.println("Order from " + foodSupplier.getName() + " is rejected");
            return false;
        }
    }
}
