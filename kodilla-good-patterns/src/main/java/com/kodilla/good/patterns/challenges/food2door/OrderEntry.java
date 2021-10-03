package com.kodilla.good.patterns.challenges.food2door;

public class OrderEntry {
    private Product product;
    private int quantity;

    public OrderEntry(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
