package com.pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {

    WebDriver driver;
    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAddressPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit your account information")));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Address Book"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New Address"))).click();
    }

    public void addAddress(Map<String, String> data) {
        driver.findElement(By.id("input-firstname")).sendKeys(data.get("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(data.get("lastname"));
        driver.findElement(By.id("input-address-1")).sendKeys(data.get("address1"));
        driver.findElement(By.id("input-city")).sendKeys(data.get("city"));
        driver.findElement(By.id("input-postcode")).sendKeys(data.get("postcode"));
        WebElement countryDropdown = driver.findElement(By.id("input-country"));
        Select country = new Select(countryDropdown);
        country.selectByVisibleText(data.get("country"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-zone")));
        WebElement regionDropdown = driver.findElement(By.id("input-zone"));
        Select region = new Select(regionDropdown);
        region.selectByVisibleText(data.get("region"));
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    public boolean validateSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
        String successMessage = success.getText();
        System.out.println(successMessage);
        return successMessage.contains("Your address has been successfully");
    }
}