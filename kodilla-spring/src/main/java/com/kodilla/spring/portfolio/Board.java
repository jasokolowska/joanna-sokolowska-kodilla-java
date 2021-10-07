package com.kodilla.spring.portfolio;

public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public TaskList getToDoList() {
        System.out.println("List To Do: ");
        return toDoList;
    }

    public TaskList getInProgressList() {
        System.out.println("List in Progress: ");
        return inProgressList;
    }

    public TaskList getDoneList() {
        System.out.println("List Done: ");
        return doneList;
    }
}
