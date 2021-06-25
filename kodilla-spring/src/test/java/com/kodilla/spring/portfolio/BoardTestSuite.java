package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTestSuite {

    @Test
    void addTaskTest() {
        //Given
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.portfolio");
        Board board = (Board) context.getBean("getBoard");

        //When
        int TDL_size = board.getToDoList().getTasks().size();
        int IPL_size = board.getInProgressList().getTasks().size();
        int DL_size = board.getDoneList().getTasks().size();

        board.addTask(
                board.getToDoList(), "Task Added to toDoList");
        board.addTask(
                board.getInProgressList(), "Task Added to inProgress List");
        board.addTask(
                board.getDoneList(), "Task Added to Done List");

        int TDL_sizeAfterAdd = board.getToDoList().getTasks().size();
        int IPL_sizeAfterAdd = board.getInProgressList().getTasks().size();
        int DL_sizeAfterAdd = board.getDoneList().getTasks().size();


        //Then
        assertEquals(TDL_size + 1, TDL_sizeAfterAdd);
        assertEquals(IPL_size + 1, IPL_sizeAfterAdd);
        assertEquals(DL_size + 1, DL_sizeAfterAdd);
        System.out.println(" --- ");

        // Additional: Printing
        for (TaskList taskList : board.getAllTasksList()) {

            for (String x : taskList.getTasks()
            ) {
                System.out.println(x);
            }
        }

    }
}
