package com.kodilla.spring.forum;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class ForumUserTestSuite {

    @Test
    void testGetUsername() {
        //Given
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.kodilla.spring.forum");

        // When
        String name = applicationContext.getBean(ForumUser.class).getUsername();

        //Then
        Assertions.assertEquals("John Smith", name);
    }
}
