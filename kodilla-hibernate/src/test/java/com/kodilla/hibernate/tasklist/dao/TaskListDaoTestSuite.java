package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.jdbc.DbManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class TaskListDaoTestSuite {


    @Autowired
    TaskListDao taskListDao;

 /*   @Test
    void testFindByListName() throws SQLException {

        //Given
//        Connection conn;
//
//        Properties connectionProps = new Properties();
//        connectionProps.put("user", "kodilla_user");
//        connectionProps.put("password", "kodilla_Pass123");
//        conn = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" +
//                        "&useSSL=False",
//                connectionProps);

        Connection conn = DbManager.getInstance().getConnection();

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
        statement.close();
        conn.close();
    }
*/

    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);

        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);


        TaskList taskList = new TaskList("LISTNAME ", "ToDo tasks");

        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);

        task.setTaskList(taskList);
        task2.setTaskList(taskList);


        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        taskListDao.deleteById(id);

    }
}
