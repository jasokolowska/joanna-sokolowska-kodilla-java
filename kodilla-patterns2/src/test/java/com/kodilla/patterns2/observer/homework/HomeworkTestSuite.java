package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTestSuite {

    @Test
    public void testHomework() {
        //Given
        Mentor andrzejJaromin = new Mentor("Andrzej", "Jaromin");
        Mentor jakubWieczorek = new Mentor("Jakub", "Wieczorek");
        Mentee joannaSokolowska = new Mentee("Joanna", "Sokolowska", andrzejJaromin);
        Mentee marcinKubecko = new Mentee("Marcin", "Kubecko", jakubWieczorek);
        Mentee grzegorzTrofimiec = new Mentee("Grzegorz", "Trofimiec", andrzejJaromin);

        Homework jsHomework = new Homework(joannaSokolowska);
        Homework gtHomework = new Homework(grzegorzTrofimiec);
        Homework mkHomework = new Homework(marcinKubecko);

        //When
        jsHomework.addTask(new Task("task1"));
        gtHomework.addTask(new Task("task1"));
        gtHomework.addTask(new Task("task2"));
        mkHomework.addTask(new Task("task 1"));

        //Then
        assertEquals(3, andrzejJaromin.getCounter());
        assertEquals(1, jakubWieczorek.getCounter());
    }

}