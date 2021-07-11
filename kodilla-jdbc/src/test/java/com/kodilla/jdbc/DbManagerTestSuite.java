package com.kodilla.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {

        //Given
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();

        String bodyText = "truncate table POSTS;";
        statement.execute(bodyText);

        bodyText = "INSERT INTO POSTS (USER_ID, BODY) VALUES (3, \"This is my first post !\"); ";
        statement.execute(bodyText);


        bodyText = "INSERT INTO POSTS (USER_ID, BODY) VALUES (2, \"This is my first post too!\");";
        statement.execute(bodyText);

        bodyText = "INSERT INTO POSTS (USER_ID, BODY) VALUES (2, \"How are you?\");";
        statement.execute(bodyText);

        bodyText = "INSERT INTO POSTS (USER_ID, BODY) VALUES (1, \"Quite good, thanks bro!\");";
        statement.execute(bodyText);

        bodyText = "INSERT INTO POSTS (USER_ID, BODY) VALUES (4, \"Yo all! Here is Thomas!\");";
        statement.execute(bodyText);

        bodyText = "INSERT INTO POSTS (USER_ID, BODY) VALUES (4, \"Next post from me\");";
        statement.execute(bodyText);

        bodyText = "INSERT INTO POSTS (USER_ID, BODY) VALUES (5, \"I'm startin' here too ;-)\");";
        statement.execute(bodyText);


        //When
        String sqlStatement = "select USERS.FIRSTNAME, USERS.LASTNAME  from USERS join POSTS on POSTS.USER_ID = USERS.ID " +
                "group by USERS.FIRSTNAME, USERS.LASTNAME " +
                "having Count(BODY) >=2 ;";

        ResultSet resultSet = statement.executeQuery(sqlStatement);

        int usersCounter = 0;

        while (resultSet.next()) {
            usersCounter += 1;
            System.out.println(resultSet.getString(1) + "  " + resultSet.getString(2));
        }

        statement.close();
        resultSet.close();

        //Then
        Assertions.assertTrue(usersCounter == 2);
    }
}