package com.kodilla.intersection;

import java.util.Random;

public class Car {
    private Direction direction;
    private int distance = 500;
    private int speed = 50;

    public Car() {
        Random randomNbr = new Random();
        this.direction = Direction.fromNumber(randomNbr.nextInt(3));
    }

    public Car(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Car{" +
                "direction=" + direction +
                '}';
    }
}

//1. timer - procedura tik
//a. sprawdzenie czy jakis samochod znajduje sie w odleglosci 0
//b. sposrod nich wybieram ten, ktory ma pierwszenstwo i przenosze na wylot (dystans -1)
//2. na kazdym z wlotow w petli przesuwam samochody o tyle ile wynosi ich speed w kierunku skrzyzowania, zmniejszam dystans
//a. sprawdzam czy pnie przeskoczylam, jesli tak to cofam sie zaraz za poprzedzajacy
//3. Modyfikacja predkosci dla kazdego z aut, uzalezniona od dystansu od auta poprzedzajacego
// (nie moze wieksza niz odleglosci miedzy autami -1)
// przy skrzyzowaniu nalezy zmniejszyc predkosc (przy predkosci 5 skrecaja samochody, liniowo zmniejszac predkosc)
// droga, na ktorej musze ustapic, to predkosc musze zredukowac do zera, a ruszyc dopiero jak
// moge jechac (również przy jezdzie na wprost)
// samochody odjezdzajace (z ujemnym dystansem) zwiekszam predkosc
// usuwam samochody, których dystans jest mniejszy niz -500
// czyszcze ekran i w petli rysuje wszystkie pojazdy w pozycjach wynikajacych z ich distance
// if losowanie nowego (licznik równy 0) {
// - losowy wlot, losowy skret - dodaje do wlotu
// - losuje po ilu tikach ma byc losowanie nastepnego samochodu - od 1 do 5 (losuje liczbe i przypisuje do licznika,
// na poczatku licznik rowny 0, wylosuje po ilu sekundach ma sie pojawic kolejny
// }
// licznik = licznik - 1;
// pelne 500px na ekranie