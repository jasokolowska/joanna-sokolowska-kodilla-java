package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionTestSuite {


    @DisplayName("When providing empty list then empty list should be returned")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //given
        List<Integer> emptyList = new LinkedList<>();

        //when
        List<Integer> resultList = OddNumbersExterminator.exterminate(emptyList);

        //then
        Assertions.assertEquals(emptyList, resultList);
    }

    @DisplayName("When providing normal list then even numbers list should be returned")
    @Test
    void testOddNumbersExterminatorNormalList () {
        //given
        List<Integer> normalList = new LinkedList<>();
        normalList.add(1);
        normalList.add(2);
        normalList.add(3);
        normalList.add(4);
        normalList.add(5);

        //when
        List<Integer> resultList = OddNumbersExterminator.exterminate(normalList);
        List<Integer> expectedList = new LinkedList<>();
        expectedList.add(2);
        expectedList.add(4);

        //then
        Assertions.assertEquals(expectedList, resultList);
    }
}
