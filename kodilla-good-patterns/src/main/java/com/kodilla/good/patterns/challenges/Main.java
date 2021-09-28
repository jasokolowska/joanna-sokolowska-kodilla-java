package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        Map<String, List<String>> movies = movieStore.getMovies();

        movies.entrySet().stream()
                .flatMap(stringListEntry -> stringListEntry.getValue().stream())
                .forEach(s -> System.out.print(s + "!"));
    }
}
