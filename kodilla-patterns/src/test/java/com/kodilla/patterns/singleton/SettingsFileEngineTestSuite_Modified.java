package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SettingsFileEngineTestSuite {

    static SettingsFileEngine en =  SettingsFileEngine.INSTANCE;


        @BeforeAll
    public static void openSettingsFile() {
       en.open("myapp.settings");
    }

    @AfterAll
     static void closeSettingsFile() {
        SettingsFileEngine.INSTANCE.close();
    }

    @Test
    void testGetFileName() {
        //Given
        //When
        String fileName = SettingsFileEngine.INSTANCE.getFileName();
        System.out.println("Opened: " + fileName);
        //Then
        assertEquals("myapp.settings", fileName);
    }

    @Test
    void testLoadSettings() {
        //Given
        //When
        boolean result = SettingsFileEngine.INSTANCE.loadSettings();
        //Then
        assertTrue(result);
    }

    @Test
    void testSaveSettings() {
        //Given
        //When
        boolean result = SettingsFileEngine.INSTANCE.saveSettings();
        //Then
        assertTrue(result);
    }
}