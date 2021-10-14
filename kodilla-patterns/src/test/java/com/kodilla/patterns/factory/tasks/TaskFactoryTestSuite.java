package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.ShapeFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task result = factory.createTask(TaskFactory.DRIVING);
        result.executeTask();

        //Then
        assertEquals("driving task", result.getTaskName());
        assertTrue(result.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task result = factory.createTask(TaskFactory.PAINTING);
        result.executeTask();

        //Then
        assertEquals("painting task", result.getTaskName());
        assertTrue(result.isTaskExecuted());
    }

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task result = factory.createTask(TaskFactory.SHOPPING);
        result.executeTask();

        //Then
        assertEquals("shopping task", result.getTaskName());
        assertTrue(result.isTaskExecuted());
    }


}
