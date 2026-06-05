package assessment_questions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggingIn {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoblaze.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.id("login2"));
		element.click();
		WebElement name = driver.findElement(By.id("loginusername"));
		name.click();
		name.sendKeys("Admin");
		WebElement pass = driver.findElement(By.id("loginpassword"));
		pass.click();
		pass.sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		String check = user.getText();
		if (check.contains("Welcome")) {
			System.out.println("Login Successful");
		}
		driver.findElement(By.linkText("Laptops")).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("tbodyid"), "MacBook Pro"));
		List<WebElement> products = driver.findElements(By.className("hrefch"));
		List<String> productList = new ArrayList<>();
		for (WebElement p : products) {
			productList.add(p.getText());
		}
		Collections.sort(productList);
		Set<String> productSet = new LinkedHashSet<>(productList);
		for (String product : productSet) {
			System.out.println("Found Laptop: " + product);
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);
		boolean found = false;
		for (WebElement p : products) {
			if (p.getText().equalsIgnoreCase("MacBook Pro")) {
				js.executeScript("arguments[0].scrollIntoView(true);", p);
				act.moveToElement(p).click().perform();
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("MacBook Pro Found");
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));
		String title = driver.findElement(By.xpath("//h2")).getText();
		if (title.equalsIgnoreCase("MacBook Pro")) {
			System.out.println("Navigated to MacBook Pro page");
		}
		 driver.quit();

	}
}