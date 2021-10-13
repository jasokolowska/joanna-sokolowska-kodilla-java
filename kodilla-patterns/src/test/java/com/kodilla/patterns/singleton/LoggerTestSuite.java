package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    private static Logger logger;

    @Test
    void testGetLastLog() {
        //Given
        Logger logger = Logger.INSTANCE;
        logger.log("Pierwszy i ostatni log");

        //When
        String result = logger.getLastLog();

        //Then
        assertEquals("Pierwszy i ostatni log", result);
    }
}
