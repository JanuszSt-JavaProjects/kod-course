package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    TaskListDao taskListDao;

    @Test
    void testFindByListName() {

        //Given
        String listName = "User1 Tasks";
        String description = "Tasks of J. Rambo";
        TaskList testedList = new TaskList(listName, description);

        //When
        taskListDao.save(testedList);

        //Then
        assertEquals(testedList, taskListDao.findByListName(listName));

        //Cleanup
        taskListDao.deleteAll();
    }
}
