package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //Given

        //When
        double addValue = calculator.add(2,3);
        double subValue = calculator.sub(8,3);
        double mulValue = calculator.mul(2.5, 2);
        double divValue = calculator.div(10, 2);

        //Then
        assertEquals(5, addValue);
        assertEquals(5, subValue);
        assertEquals(5, mulValue);
        assertEquals(5, divValue);
    }
}
