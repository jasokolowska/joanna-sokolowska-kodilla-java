package com.kodilla.good.patterns.challenges.food2door;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderEntry orderEntry = orderRequestRetriever.retrieve();

        SupplierProcessor extraFoodShop = new SupplierProcessor(new ExtraFoodShop(), orderEntry);
        extraFoodShop.processOrder();

        SupplierProcessor healthyShop = new SupplierProcessor(new HealthyShop(), orderEntry);
        healthyShop.processOrder();

        SupplierProcessor glutenFreeShop = new SupplierProcessor(new GlutenFreeShop(), orderEntry);
        glutenFreeShop.processOrder();
    }
}
