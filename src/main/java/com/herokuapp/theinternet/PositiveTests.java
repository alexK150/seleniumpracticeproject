package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PositiveTests {

    @Test
    public void loginTest() {
        System.out.println("Starting loginTest");

        //create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();

        //open test page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");

//        enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
//        enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");
//        click login button
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();
//
//        verifications:
//        new url
//        logout button is visible
        WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        //success login  message
        WebElement successMessage = driver.findElement(By.cssSelector("#flash"));

        //Close browser
        driver.quit();
    }
}
