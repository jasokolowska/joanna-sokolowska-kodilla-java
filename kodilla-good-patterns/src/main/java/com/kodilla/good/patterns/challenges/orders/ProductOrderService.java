package com.kodilla.good.patterns.challenges.orders;

public class ProductOrderService implements OrderService{

    @Override
    public boolean order(User user, Product product, int quantity) {
        if (quantity <= product.getAvailableQuantity()) {
            return true;
        } else {
            return false;
        }
    }
}
