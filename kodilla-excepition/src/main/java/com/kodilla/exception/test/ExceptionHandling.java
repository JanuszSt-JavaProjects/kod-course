package com.kodilla.exception.test;

public class ExceptionHandling {

    SecondChallenge secondChallenge = new SecondChallenge();


    public void exceptionHandle(double x, double y) {
        try {
            secondChallenge.probablyIWillThrowException(x, y);
        } catch (Exception e) {
            System.out.println(" Exception occurred!");
        } finally {
            System.out.println(" 'probablyIWillThrowException()' Method has finished! ");
        }
    }
}
