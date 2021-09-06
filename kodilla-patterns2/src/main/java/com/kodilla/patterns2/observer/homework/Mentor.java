package com.kodilla.patterns2.observer.homework;


import java.util.ArrayList;
import java.util.List;

public class Mentor implements HomeworkObserver{
    private int id;
    private String name;
    private List<String> homeworksList=new ArrayList<>();  // 4 tests only

    public Mentor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void update(Homework homework) {
        String homeworkTask =homework.getHomeworks().peek();
        homeworksList.add(homeworkTask);
        System.out.println("Student :"+homework.getStudent()+
                " has added a new homework.\nHomework content: "+ homeworkTask);
    }


    public List<String> getHomeworksList() {
        return homeworksList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homeworksList=" + homeworksList +
                '}';
    }
}
