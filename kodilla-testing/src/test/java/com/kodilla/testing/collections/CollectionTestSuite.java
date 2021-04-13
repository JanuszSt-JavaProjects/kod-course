package com.kodilla.testing.collections;


import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }


    @DisplayName("When list is empty then exterminate() method should return input list with warning")
    @Test
    void testOddNumbersExterminatorEmptyList() {

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        List<Integer> testedList = new ArrayList<>();
        int expectedResult = 0;

        //When
        int result = oddNumbersExterminator.exterminate(testedList).size();

        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("When list contains different values exterminate() method should return list with only even values (first test)")
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();


        //When
        List<Integer> testedList = new ArrayList<>();
        testedList.add(-2);
        testedList.add(-1);
        testedList.add(0);
        testedList.add(1);
        testedList.add(2);
        testedList.add(3);

        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(-2);
        expectedList.add(0);
        expectedList.add(2);

        //Then
        Assertions.assertEquals(expectedList, oddNumbersExterminator.exterminate(testedList));
    }


    // Additional task

    @DisplayName("When list contains different values exterminate() method should return list with only even values (second test)")
    @Test
    void testOddNumbersExterminatorNormalList2() {

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        //When
        List<Integer> testedList = Arrays.asList(-2, -1, 0, 1, 2, 3);
        List<Integer> expectedList = Arrays.asList(-2, 0, 2);

        //Then
        Assertions.assertEquals(expectedList, oddNumbersExterminator.exterminate(testedList));
    }
}

