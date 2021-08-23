package com.kodilla.rps;

public class Move {
    private int id;
    private String name;

    public Move(int id) {
        this.id = id;
        if (this.id == 1) {
            this.name = "kamień";
        } else if (this.id == 2) {
            this.name = "papier";
        } else if (this.id == 3) {
            this.name = "nożyce";
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
