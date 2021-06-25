package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TaskList {

    private List<String> tasks;

    public TaskList(String... task) {
        tasks = new ArrayList<>(Arrays.asList(task));
    }

    void addTask(String nextTask) {
        tasks.add(nextTask);
    }

    public LinkedList<String> getTasks() {
        return new LinkedList<>(tasks);
    }
}
