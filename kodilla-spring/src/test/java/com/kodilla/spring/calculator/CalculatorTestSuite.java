package com.kodilla.spring.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    Calculator calculator;

    @Test
    void TestCalculations() {
        //Given
  /*      ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
*/
        //When
        double a = 10.00;
        double b = 4.00;

        double expectedAdd = 14.00;
        double expectedSub = 6.00;
        double expectedMul = 40.00;
        double expectedDiv = 2.5;

        //Then
        assertEquals(expectedAdd, calculator.add(a, b));
        assertEquals(expectedSub, calculator.sub(a, b));
        assertEquals(expectedMul, calculator.mul(a, b));
        assertEquals(expectedDiv, calculator.div(a, b));
    }


    @Test
    void testWithAnnotationAutowired() {
        //Given

 /*       ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
*/
        //When
        double a = 10.00;
        double b = 4.00;

        double expectedAdd = 14.00;

        //Then
        assertEquals(expectedAdd, calculator.add(a, b));
    }

    @AfterEach
    void after() {
        System.out.println("\n------");
    }
}
