package com.kodilla.good.patterns.challenges.orders;

public class Main {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new EmailService(), new ProductOrderService(), new ProductOrderRepository());
        System.out.println(orderProcessor.process(orderRequest));

    }
}
