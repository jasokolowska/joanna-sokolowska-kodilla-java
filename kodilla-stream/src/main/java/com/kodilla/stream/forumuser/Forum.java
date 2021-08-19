package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.*;

public final class Forum {

    private final List<ForumUser> forumUsersList = new ArrayList<>();

    public Forum() {
        forumUsersList.add(new ForumUser(1234,"jan kowalski",
                'M', LocalDate.of(1956,01,20), 5));
        forumUsersList.add(new ForumUser(2345,"marcin zawadzki",
                'M', LocalDate.of(2005,03,16), 0));
        forumUsersList.add(new ForumUser(3456,"anna nowak",
                'K', LocalDate.of(1986,12,23), 5));
        forumUsersList.add(new ForumUser(4567,"adam nowak",
                'M', LocalDate.of(1991,9,03), 1));
        forumUsersList.add(new ForumUser(5678,"patrycja kowalski",
                'K', LocalDate.of(2002,10,9), 5));
        forumUsersList.add(new ForumUser(6789,"krzysztof pagorski",
                'M', LocalDate.of(2001,05,29), 5));

    }

    public List<ForumUser> getUserList() {
        return forumUsersList;
    }
}
