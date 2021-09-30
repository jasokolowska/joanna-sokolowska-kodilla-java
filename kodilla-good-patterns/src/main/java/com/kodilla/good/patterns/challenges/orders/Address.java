package com.kodilla.good.patterns.challenges.orders;

public class Address {
    private String street;
    private int streetNbr;
    private String city;
    private String postalCode;

    public Address(String street, int streetNbr, String city, String postalCode) {
        this.street = street;
        this.streetNbr = streetNbr;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNbr() {
        return streetNbr;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
