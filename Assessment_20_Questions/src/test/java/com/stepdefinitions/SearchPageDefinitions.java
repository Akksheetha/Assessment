package com.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.SearchPage;
import com.utils.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageDefinitions {
	
	WebDriver driver;
	SearchPage obj;
	@Given("the user is on product search page")
	public void the_user_is_on_product_search_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver = HelperClass.driver;
		obj = new SearchPage(driver);
	}

	@When("user tries to search a product {string} in the product page")
	public void user_tries_to_search_a_product_in_the_product_page(String product) {
	    // Write code here that turns the phrase above into concrete actions
	    obj.searchProduct(product);
	}

	@When("based on the product {string}")
	public void based_on_the_product(String result) {
		// Write code here that turns the phrase above into concrete actions
		if(result.equals("contain")) {
		    String meeting = driver.findElement(By.xpath("//*[@id='content']/h2")).getText();
		    Assert.assertTrue(meeting.contains("Products meeting the search criteria"));
		} else {
		    String notmeeting = driver.findElement(By.xpath("//*[@id='content']/p[2]")).getText();
		    Assert.assertTrue(notmeeting.contains("There is no product that matches the search criteria."));
		}
	}

	@Then("proper details of the product or error message should be displayed")
	public void proper_details_of_the_product_or_error_message_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Done");
	    
	}

}
