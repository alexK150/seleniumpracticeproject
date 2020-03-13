package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

    @Test
    public void wrongUsernameTest(){
        System.out.println("Starting wrong username tests");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();

        //open test page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");

        //enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("фцуквва");

        //enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        //click login button
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();

        //error message
        WebElement errorMessage = driver.findElement(By.id("flash"));
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),"Actual message does not contain expected message." +
                " \nActual Message: " + actualErrorMessage +
                "\nExpected Message: " + expectedErrorMessage);

        driver.quit();
    }

    @Test
    public void wrongPasswordTest(){
        System.out.println("Starting wrong password tests");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();

        //open test page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");

        //enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        //enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("incorrectpassword!");

        //click login button
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();

        //error message
        WebElement errorMessage = driver.findElement(By.id("flash"));
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),"Actual message does not contain expected message." +
                " \nActual Message: " + actualErrorMessage +
                "\nExpected Message: " + expectedErrorMessage);

        driver.quit();
    }
}
