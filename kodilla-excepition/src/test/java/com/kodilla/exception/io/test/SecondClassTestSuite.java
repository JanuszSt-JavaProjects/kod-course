package com.kodilla.exception.io.test;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SecondClassTestSuite {

    @Test
    void testProbablyIWillThrowException() {
        // Given
        SecondChallenge secondChallenge = new SecondChallenge();
        double x = 1.5;
        double y = 0;

        // When & Then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(x, y));

        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.5, 10)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.0, 1.5))
        );
    }

    @Test
    void testProbablyIWillThrowExceptionBoundaryValues() {
        // Given
        SecondChallenge secondChallenge = new SecondChallenge();

        // When & Then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 10)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0, 5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.8, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.0, 1.5))
                );
    }
}
