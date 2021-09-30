package com.kodilla.good.patterns.challenges.orders;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("Joanna", "Sokolowska",
                new Address("Nowodworska", 15, "Wroclaw", "51-300"), "joanna_s@op.pl");

        Product product = new Product("Książka", 100);
        int quantity = 1;

        return new OrderRequest(user, product, quantity);
    }
}
