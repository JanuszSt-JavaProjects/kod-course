package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {


    @Test
    void getLastLogTest() {

        //Given
        Logger logger = Logger.LOG;

        //When and Then
        logger.log("log#1");
        Assertions.assertEquals("log#1", logger.getLastLog());

        logger.log("log#2");
        Assertions.assertEquals("log#2", logger.getLastLog());
    }
}
