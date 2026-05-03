package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "name")
    WebElement name;

    @FindBy(css = "input[data-qa='signup-email']")
    WebElement email;

    @FindBy(css = "button[data-qa='signup-button']")
    WebElement signupBtn;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "zipcode")
    WebElement zip;

    @FindBy(id = "mobile_number")
    WebElement mobile;

    @FindBy(css = "button[data-qa='create-account']")
    WebElement createAccountBtn;

    @FindBy(css = "a[data-qa='continue-button']")
    WebElement continueBtn;

    @FindBy(xpath = "//b[text()='Account Created!']")
    WebElement successMsg;

    @FindBy(xpath = "//p[contains(text(),'Email Address already exist')]")
    WebElement errorMsg;

    public void enterSignupDetails(String username, String userEmail) {
        name.sendKeys(username);
        email.sendKeys(userEmail);
        signupBtn.click();
    }

    public void fillAccountForm(String pass) {

        password.sendKeys(pass);
        firstName.sendKeys("Test");
        lastName.sendKeys("User");
        address.sendKeys("Chennai");
        state.sendKeys("TN");
        city.sendKeys("Chennai");
        zip.sendKeys("600001");
        mobile.sendKeys("9999999999");

        createAccountBtn.click();
    }

    public void clickContinue() {
        continueBtn.click();
    }

    public String getSuccessMsg() {
        return successMsg.getText();
    }

    public String getErrorMsg() {
        return errorMsg.getText();
    }
}