package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {


    @Autowired
    TaskListDao taskListDao;

    @Test
    void testFindByListName() throws SQLException {

        //Given
        Connection conn;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "kodilla_user");
        connectionProps.put("password", "kodilla_Pass123");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" +
                        "&useSSL=False",
                connectionProps);


        String listName = "User1 Tasks";
        String description = "Tasks of J. Rambo";
        TaskList testedList = new TaskList(listName, description);

        //When
        taskListDao.save(testedList);

        //Then
        assertEquals(testedList, taskListDao.findByListName(listName));

        //Cleanup
        Statement statement = conn.createStatement();
        statement.execute("drop table tasklists");
    }
}
