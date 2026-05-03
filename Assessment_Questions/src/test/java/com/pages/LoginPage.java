package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[data-qa='login-email']")
    WebElement email;

    @FindBy(css = "input[data-qa='login-password']")
    WebElement password;

    @FindBy(css = "button[data-qa='login-button']")
    WebElement loginBtn;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    WebElement errorMsg;

    public void login(String user, String pass) {
        email.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }

    public String getErrorMsg() {
        return errorMsg.getText();
    }
}