package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testLists() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When & Then
        board.getToDoList();
        board.getInProgressList();
        board.getDoneList();
    }

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        board.getToDoList().getTasks().add(0, "Zrobic zadania z modułu 14 kursu kodilla");
        board.getInProgressList().getTasks().add(0, "Zadanie 14.3");
        board.getDoneList().getTasks().add(0, "Zadanie 14.2");

        //When
        String toDoTask = board.getToDoList().getTasks().get(0);
        String inProgressTask = board.getInProgressList().getTasks().get(0);
        String doneTask = board.getDoneList().getTasks().get(0);

        //Then
        assertEquals("Zrobic zadania z modułu 14 kursu kodilla", toDoTask);
        assertEquals("Zadanie 14.3", inProgressTask);
        assertEquals("Zadanie 14.2", doneTask);
    }
}
