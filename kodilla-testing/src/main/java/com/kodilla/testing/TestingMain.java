package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        // Calculator test

        int a= 100;
        int b= 200;
        int addResult =a+b;
        int subtractResult =a-b;

        Calculator calculator=new Calculator();

        if(calculator.add(a,b) == addResult){
            System.out.println("Test OK");
        }else{
            System.out.println("ERROR!");
        }

        if(calculator.subtract(a,b) == subtractResult){
            System.out.println("Test OK");
        }else{
            System.out.println("ERROR!");
        }
    }
}