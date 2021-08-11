package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie do testowania oprogramowania");

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();

        int a = 2;
        int b = 3;

        int addResult = calculator.add(a,b);
        if (addResult == 5) {
            System.out.println("Add test OK");
        } else {
            System.out.println("Add Test Error!");
        }

        int subtractResult = calculator.subtract(a,b);
        if (subtractResult == -1) {
            System.out.println("Subtract test OK");
        } else {
            System.out.println("Subtract Test Error!");
        }
    }
}
