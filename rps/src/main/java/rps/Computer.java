package rps;

public class Computer implements Player{
    private final String name;
    private int roundsWon;

    public Computer() {
        this.name = "Komputer";
    }

    public String getName() {
        return name;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }
}
