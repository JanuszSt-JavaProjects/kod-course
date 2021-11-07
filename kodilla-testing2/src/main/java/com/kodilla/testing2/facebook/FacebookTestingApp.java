package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {


    //    public static final String CONFIRM_BUTTON ="html/body/div[3]/div[2]/div/div/div/div/div[3]/button[2]";
    //    public static final String CONFIRM_BUTTON ="//button [2]";
    public static final String ACCEPT_COOKIE_BUTTON = "//button [contains(@data-cookiebanner,\"accept_button\")]";

    public static final String CREATE_BUTTON = "//form/div[5]/a";


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(" https://www.facebook.com/");

        WebElement cookieButton = driver.findElement(By.xpath(ACCEPT_COOKIE_BUTTON));
        cookieButton.click();
        WebElement createAccount = driver.findElement(By.xpath(CREATE_BUTTON));
        createAccount.click();


        Thread.sleep(1000);

        WebElement formFirstname = driver.findElement(By.name("firstname"));
        formFirstname.sendKeys("Janusz");
        WebElement formLastname = driver.findElement(By.name("lastname"));
        formLastname.sendKeys("Stolarski");

        WebElement formEmail = driver.findElement(By.name("reg_email__"));
        formEmail.sendKeys("www@www.ww");

        final String BIRTH_DATE = "//*[@id=\"day\"]";
        WebElement birthday = driver.findElement(By.xpath(BIRTH_DATE));
        Select daySelect = new Select(birthday);
        daySelect.selectByIndex(15);

        final String BIRTH_MONTH = "//form[@id=\"reg\"]/div[1]/div[5]/div[2]/span/span/select[2]";
        WebElement birtMonth = driver.findElement(By.xpath(BIRTH_MONTH));
        Select monthSelect = new Select(birtMonth);
        monthSelect.selectByIndex(3);

        final String BIRTH_YEAR = "//select[@id=\"year\"]";
        WebElement birthYear = driver.findElement(By.xpath(BIRTH_YEAR));
        Select yearSelect = new Select(birthYear);
        yearSelect.selectByValue("1970");

        final String SEX = "//input[@name=\"sex\" and  @value=\"2\"]";
        WebElement sex = driver.findElement(By.xpath(SEX));
        sex.click();
    }
}
