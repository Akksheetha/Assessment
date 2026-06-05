package com.stepdefinitions;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.AddressPage;
import com.utils.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AddressStepDefinition {

    WebDriver driver;
    AddressPage addressPage;
    
    @Given("user is logged into TutorialsNinja")
    public void user_is_logged_into_tutorials_ninja() {
    	// Write code here that turns the phrase above into concrete actions
        driver = HelperClass.driver;
        addressPage = new AddressPage(driver);
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("2k22csbs03@kiot.ac.in");
        driver.findElement(By.id("input-password")).sendKeys("Password@1234");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit your account information")));
        System.out.println("Login Successful");
    }

    @When("user adds a new address with following details")
    public void user_adds_a_new_address_with_following_details(DataTable table) {
    	// Write code here that turns the phrase above into concrete actions
        Map<String, String> data = table.asMap(String.class, String.class);
        addressPage.navigateToAddressPage();
        addressPage.addAddress(data);
    }

    @Then("address should be added successfully")
    public void address_should_be_added_successfully() {
    	// Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(addressPage.validateSuccessMessage());
        System.out.println("Address Added Successfully");
    }
}