package com.kodilla.patterns2.observer.homework;

import java.util.PriorityQueue;
import java.util.Queue;

public class Homework implements HomeworkObservable {
    private Mentor mentor;
    private Student student;
    private Queue<String> homeworks;


    public Homework(Student student) {
        this.student = student;
        homeworks = new PriorityQueue<>();
    }

    public void addHomework(String homework) {
        homeworks.add(homework);
        notifyMentor();
    }

    @Override
    public void registerMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    @Override
    public void notifyMentor() {
        mentor.update(this);
    }

    @Override
    public void removeMentor(Mentor mentor) {
        mentor = null;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public Student getStudent() {
        return student;
    }

    public Queue<String> getHomeworks() {
        return homeworks;
    }

}
