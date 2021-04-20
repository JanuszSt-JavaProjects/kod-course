package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.Random;

public class ArrayOperationsTestSuite {

    @BeforeEach
    void before() {
        System.out.println("\ntested data: ");
    }

    @RepeatedTest(5)
    void testGetAverage() {

        //Given
        int[] testTable = new int[20];
        Random random = new Random();

        for (int i = 0; i < testTable.length; i++) {
            testTable[i] = random.nextInt(100);
        }
        double expectedAvg = (double) Arrays.stream(testTable).sum() / testTable.length;

        //When
        double actualAvg = ArrayOperations.getAverage(testTable);

        //Then
        Assertions.assertEquals(expectedAvg, actualAvg);
    }
}
