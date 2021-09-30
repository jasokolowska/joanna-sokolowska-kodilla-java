package com.kodilla.good.patterns.challenges.orders;

public class User {
    private String name;
    private String lastName;
    private Address address;
    private String email;

    public User(String name, String lastName, Address address, String email) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return  name + " " + lastName;
    }
}
