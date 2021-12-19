package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Mentor implements MentorObserver{
    private String firstName;
    private String lastName;
    private List<Mentee> mentees;
    private int counter;

    public Mentor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mentees = new ArrayList<>();
    }

    public void addMentee(Mentee mentee) {
        mentees.add(mentee);
    }

    @Override
    public void update(Homework homework) {
        counter++;
        System.out.println(homework.getMentee().getFirstName() + " has added new homework to check.\n"
                + "Tasks to check in total: " + counter);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Mentee> getMentees() {
        return mentees;
    }

    public int getCounter() {
        return counter;
    }
}
