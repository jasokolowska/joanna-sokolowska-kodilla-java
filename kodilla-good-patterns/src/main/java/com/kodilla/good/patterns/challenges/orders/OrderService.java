package com.kodilla.good.patterns.challenges.orders;

public interface OrderService {
    public boolean order(User user, Product product, int quantity);
}
