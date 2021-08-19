package com.kodilla.stream.forumuser;

import java.time.Duration;
import java.time.LocalDate;

public class ForumUser {
    private int userID;
    private String userName;
    private char gender;
    private LocalDate dateOfBirth;
    private int postQuantity;

    public ForumUser(int userID, String userName, char gender, LocalDate dateOfBirth, int postQuantity) {
        this.userID = userID;
        this.userName = userName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.postQuantity = postQuantity;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostQuantity() {
        return postQuantity;
    }

    public void setPostQuantity(int postQuantity) {
        this.postQuantity = postQuantity;
    }

    public boolean compareGender(char gender) {
        if (Character.compare(this.gender, gender) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getAge() {
        return LocalDate.now().getYear() - this.dateOfBirth.getYear();
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", postQuantity=" + postQuantity +
                '}';
    }
}
