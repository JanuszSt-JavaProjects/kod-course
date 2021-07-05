package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void drivingTaskTest() {
        // GIVEN
        Task ride1 = new TaskFactory().createTask(TaskFactory.DRIVING);

        //WHEN
        String taskName = "Fast drive";

        //THEN
        assertEquals(taskName, ride1.getTaskName());
    }

    @Test
    void drivingTaskExecuteTest() {
        // GIVEN
        Task ride1 = new TaskFactory().createTask(TaskFactory.DRIVING);

        //WHEN & THEN
        assertFalse(ride1.isTaskExecuted());

        ride1.executeTask();
        assertTrue(ride1.isTaskExecuted());


    }

    @Test
    void paintingTaskTest() {
        // GIVEN
        Task paint1 = new TaskFactory().createTask(TaskFactory.PAINTING);

        //WHEN
        String taskName = "Every hall paint";

        //THEN
        assertEquals(taskName, paint1.getTaskName());
    }

    @Test
    void shoppingTaskTest() {
        // GIVEN
        Task shopping1 = new TaskFactory().createTask(TaskFactory.SHOPPING);


        //WHEN
        String taskName = "Accessories Buy";

        //THEN
        assertEquals(taskName,shopping1.getTaskName());
    }

    @Test
    void wrongTaskName(){

        // Given
        Task task = new TaskFactory().createTask("INCORRECT");


        //WHEN &THEN
        assertNull(task);

    }

/*    @Test                                                            // Nie działa
    void wrongTaskName1(){
        //GIVEN
        Task task = new TaskFactory().createTask("INCORRECT");

        // WHEN & THEN

        assertThrows(IllegalStateException.class, ()->{
            throw new IllegalStateException();
        });

    }*/

}
