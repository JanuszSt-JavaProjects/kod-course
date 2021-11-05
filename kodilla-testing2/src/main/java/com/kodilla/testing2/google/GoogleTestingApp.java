package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {
    public static final String SEARCHFIELD = "q";                       // [1]

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX); // [2]
        driver.get("https://www.bing.com");                                 // [3]

        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));      // [4]
        searchField.sendKeys("Kodilla");
        searchField.submit();                                                 // [6]
    }
}