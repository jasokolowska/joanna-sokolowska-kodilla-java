package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("no sezam")
                .burgers(2)
                .sauce("standard")
                .ingredients("salad")
                .ingredients("onion")
                .build();
        System.out.println(bigmac);

        //When
        String sauce = bigmac.getSauce();
        int burgersQuantity = bigmac.getBurgers();
        int ingredientsQuantity = bigmac.getIngredients().size();

        //Then
        assertEquals("standard", sauce);
        assertEquals(2, burgersQuantity);
        assertEquals(2, ingredientsQuantity);
    }
}
