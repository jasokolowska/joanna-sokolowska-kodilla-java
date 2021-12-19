package com.kodilla.patterns2.observer.homework;

public class Mentee {

    private String firstName;
    private String lastName;
    private Mentor mentor;

    public Mentee(String firstName, String lastName, Mentor mentor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mentor = mentor;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public MentorObserver getMentor() {
        return mentor;
    }
}
