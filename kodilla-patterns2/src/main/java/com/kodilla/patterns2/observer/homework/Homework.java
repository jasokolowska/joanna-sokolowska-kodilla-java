package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Homework implements HomeworkObservable{

    private final List<Task> tasks;
    private final Mentee mentee;

    public Homework(Mentee mentee) {
        this.mentee = mentee;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.add(task);
        notifyMentor();
    }

    @Override
    public void notifyMentor() {
        mentee.getMentor().update(this);
    }

    public Mentee getMentee() {
        return mentee;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
