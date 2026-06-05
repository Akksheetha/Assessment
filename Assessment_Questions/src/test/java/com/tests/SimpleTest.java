package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Products")).click();
        driver.findElement(By.id("search_product")).sendKeys("Top");
        driver.findElement(By.id("submit_search")).click();
        String result = driver.findElement(By.xpath("//h2[contains(text(),'SEARCHED PRODUCTS')]")).getText();

        if(result.contains("SEARCHED PRODUCTS")) {
            System.out.println("Search Successful");
        } else {
            System.out.println("Search Failed");
        }

        driver.quit();
    }
}