package com.kodilla.good.patterns.challenges.orders;

public interface OrderRepository {
    void sendOrder(User user, Product product, int quantity);
}
