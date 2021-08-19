package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        Forum forumUsersDirectory = new Forum();
        Map<Integer, ForumUser> theResultListOfForumUsers = forumUsersDirectory.getUserList().stream()
                .filter(forumUser -> forumUser.getGender() == 'M')
                .filter(forumUser -> forumUser.getAge() > 20)
                .filter(forumUser -> forumUser.getPostQuantity() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

        theResultListOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);


//        BookDirectory theBookDirectory = new BookDirectory();
//        String theResultStringOfBooks = theBookDirectory.getList().stream()  // [1]
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .map(Book::toString)
//                .collect(Collectors.joining(",\n","<<",">>"));                    // [2]
//
//        System.out.println(theResultStringOfBooks);

//        BookDirectory theBookDirectory = new BookDirectory();
//
//        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .collect(Collectors.toMap(Book::getSignature, book -> book));             // [1]
//
//        System.out.println("# elements: " + theResultMapOfBooks.size());             // [2]
//        theResultMapOfBooks.entrySet().stream()
//                .map(entry -> entry.getKey() + ": " + entry.getValue())                   // [3]
//                .forEach(System.out::println);

//        BookDirectory theBookDirectory = new BookDirectory();
//        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()   // [1]
//                .filter(book -> book.getYearOfPublication() > 2005)                  // [2]
//                .collect(Collectors.toList());                                       // [3]
//
//        System.out.println("# elements: " + theResultListOfBooks.size());       // [4]
//        theResultListOfBooks.stream()                                           // [5]
//                .forEach(System.out::println);

//        BookDirectory theBookDirectory = new BookDirectory();
//        theBookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .forEach(System.out::println);


//        People.getList().stream()
//                .map(String::toUpperCase)                             // [1]
//                .filter(s -> s.length() > 11)                         // [2]
//                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")   // [3]
//                .filter(s -> s.substring(0, 1).equals("M"))           // [4]
//                .forEach(System.out::println);                        // [5]


//        Processor processor = new Processor();                                // [6]
//        Executor codeToExecute = () -> System.out.println("This is an example text.");  // [7]
//        processor.execute(codeToExecute);
//
//        ExpressionExecutor expressionExecutor = new ExpressionExecutor();       // [5]
//
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);           // [6]
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);           // [7]
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);           // [8]
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
//
//        System.out.println("Zadanie - Upiekszacz tekstow");
//
//        PoemBeautifier poemBeautifier = new PoemBeautifier();
//
//        poemBeautifier.beautify("Przykladowy tekst do upiekszenia", (text) -> "ABC " + text + " CBA");
//        poemBeautifier.beautify("Przykladowy tekst do upiekszenia", (text) -> text.toLowerCase());
//        poemBeautifier.beautify("Przykladowy tekst do upiekszenia", (text) -> "***" + text + "***");
//        poemBeautifier.beautify("Przykladowy tekst do upiekszenia", (text) -> text.toUpperCase());
//
//        System.out.println("Using Stream to generate even numbers from 1 to 20");
//        NumbersGenerator.generateEven(20);
    }
}

