package com.kodilla.good.patterns.challenges.food2door;


public class OrderRequestRetriever {

    public OrderEntry retrieve() {

        Product product = new Product("Książka", 100);
        int quantity = 1;

        return new OrderEntry(product, quantity);
    }
}
