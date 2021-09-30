package com.kodilla.good.patterns.challenges.orders;

public class OrderProcessor {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(final InformationService informationService,
                           final OrderService orderService,
                           final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrder = orderService.order(orderRequest.getUser(), orderRequest.getProduct(),
                orderRequest.getQuantity());

        if (isOrder) {
            informationService.inform(orderRequest.getUser());
            orderRepository.sendOrder(orderRequest.getUser(), orderRequest.getProduct(),
                    orderRequest.getQuantity());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
