package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {

    @Autowired
    Display display;


    double add(double a, double b) {
        double result = a + b;
        display.displayValue(result);
        return result;
    }

    double sub(double a, double b) {
        double result = a - b;
        display.displayValue(result);
        return result;
    }

    double mul(double a, double b) {
        double result = a * b;
        display.displayValue(result);
        return result;
    }

    double div(double a, double b) {
        double result = a / b;
        display.displayValue(result);
        return result;
    }


}
