package com.kodilla.good.patterns.challenges.orders;

public class OrderDto {

    public User user;
    public boolean isOrdered;

    public OrderDto(final User user, final boolean isOrdered) {
        this.user = user;
        this.isOrdered = isOrdered;
    }

    public User getUser() { return user; }

    public boolean isOrdered() { return isOrdered; }

    @Override
    public String toString() {
        return "Order for: " + user +
                ", isOrdered=" + isOrdered;
    }
}
