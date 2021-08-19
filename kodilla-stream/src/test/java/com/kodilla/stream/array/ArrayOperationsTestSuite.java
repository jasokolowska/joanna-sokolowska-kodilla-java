package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] testedArray = {1,2,3,4,5,6,7,8,9};

        //When
        double result = ArrayOperation.getAverage(testedArray);

        //Then
        Assertions.assertEquals(5,result);
    }
}
