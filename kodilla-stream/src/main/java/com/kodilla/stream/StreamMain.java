package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;

import java.util.Locale;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        Processor processor = new Processor();                                // [6]
        Executor codeToExecute = () -> System.out.println("This is an example text.");  // [7]
        processor.execute(codeToExecute);

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();       // [5]

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);           // [6]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);           // [7]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);           // [8]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Zadanie - Upiekszacz tekstow");

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Przykladowy tekst do upiekszenia", (text) -> "ABC " + text + " CBA");
        poemBeautifier.beautify("Przykladowy tekst do upiekszenia", (text) -> text.toLowerCase());
        poemBeautifier.beautify("Przykladowy tekst do upiekszenia", (text) -> "***" + text + "***");
        poemBeautifier.beautify("Przykladowy tekst do upiekszenia", (text) -> text.toUpperCase());


    }
}
