package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Signup / Login")
    WebElement signupLoginBtn;

    @FindBy(css = "a[href='/logout']")
    WebElement logoutBtn;

    @FindBy(css = "a[href*='delete_account']")
    WebElement deleteAccount;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    WebElement loggedUser;

    public void clickSignupLogin() {
        signupLoginBtn.click();
    }

    public String getLoggedUser() {
        return loggedUser.getText();
    }
}