package com.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SignupPage;

public class BaseTest {

    public static WebDriver driver;

    public HomePage home;
    public LoginPage login;
    public SignupPage signup;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://automationexercise.com");

        home = new HomePage(driver);
        login = new LoginPage(driver);
        signup = new SignupPage(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}