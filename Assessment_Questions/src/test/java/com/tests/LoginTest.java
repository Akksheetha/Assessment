package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SignupPage;
import com.utils.DataProviderClass;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    HomePage home;
    SignupPage signup;
    LoginPage login;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com");

        home = new HomePage(driver);
        signup = new SignupPage(driver);
        login = new LoginPage(driver);
    }

    @Test(priority = 1, dataProvider = "testData1", dataProviderClass = DataProviderClass.class)
    public void registerUser(String name, String email, String pass) {

        home.clickSignupLogin();

        signup.enterSignupDetails(name, email);
        signup.fillAccountForm(pass);
        signup.clickContinue();

        Assert.assertTrue(home.getLoggedUser().contains("Logged in as"));
    }

    @Test(priority = 2)
    public void registerExistingUser() {

        home.clickSignupLogin();

        // ⚠️ use already registered email
        signup.enterSignupDetails("Akkshee", "akkshee1@gmail.com");

        Assert.assertTrue(signup.getErrorMsg().contains("already exist"));
    }

    @Test(priority = 3)
    public void validLogin() {

        home.clickSignupLogin();

        login.login("akkshee1@gmail.com", "Password@1234");

        Assert.assertTrue(home.getLoggedUser().contains("Logged in as"));
    }

    @Test(priority = 4)
    public void invalidLogin() {

        home.clickSignupLogin();

        login.login("wrong@gmail.com", "wrong123");

        Assert.assertTrue(login.getErrorMsg().contains("incorrect"));
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}