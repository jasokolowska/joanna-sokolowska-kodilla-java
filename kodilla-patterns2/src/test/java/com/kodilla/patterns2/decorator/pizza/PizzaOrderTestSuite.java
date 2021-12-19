package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PizzaOrderTestSuite {

    @Test
    void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        BigDecimal orderCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(15), orderCost);
    }

    @Test
    void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        String pizzaOrderDescription = pizzaOrder.getDescription();

        //Then
        assertEquals("Ordered basic pizza", pizzaOrderDescription);
    }

    @Test
    void testBottomPizzaOrderDecorator() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new BottomPizzaOrderDecorator(pizzaOrder);

        //When
        BigDecimal orderCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(20), orderCost);
    }

    @Test
    void testBottomPizzaOrderDecoratorGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new BottomPizzaOrderDecorator(pizzaOrder);

        //When
        String pizzaOrderDescription = pizzaOrder.getDescription();

        //Then
        assertEquals("Ordered basic pizza + bottom changed on thick", pizzaOrderDescription);
    }

    @Test
    void testBottomWithWhiteSaucePizzaOrderDecorator() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new BottomPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new SaucePizzaOrderDecorator(pizzaOrder);

        //When
        BigDecimal orderCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(22), orderCost);
    }

    @Test
    void testBottomWithWhiteSaucePizzaOrderDecoratorGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new BottomPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new SaucePizzaOrderDecorator(pizzaOrder);

        //When
        String pizzaOrderDescription = pizzaOrder.getDescription();

        //Then
        assertEquals("Ordered basic pizza + bottom changed on thick + white sauce", pizzaOrderDescription);
    }

    @Test
    void testBottomWithWhiteSauceAndMushroomsPizzaOrderDecorator() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new BottomPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new SaucePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new MushroomPizzaOrderDecorator(pizzaOrder);

        //When
        BigDecimal orderCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(27), orderCost);
    }

    @Test
    void testBottomWithWhiteSauceAndMushroomsPizzaOrderDecoratorGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new BottomPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new SaucePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new MushroomPizzaOrderDecorator(pizzaOrder);

        //When
        String pizzaOrderDescription = pizzaOrder.getDescription();

        //Then
        assertEquals("Ordered basic pizza + bottom changed on thick + white sauce + mushrooms", pizzaOrderDescription);
    }
}