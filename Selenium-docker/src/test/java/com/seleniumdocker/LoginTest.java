package com.seleniumdocker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	@Test
	public void validLoginTest() {

		// Enter username
		WebElement username = driver.findElement(By.name("username"));
		username.clear();
		username.sendKeys("Admin");

		// Enter password
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("admin123");

		// Click Login button
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// Verify dashboard loaded
		WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));

		Assert.assertTrue(dashboard.isDisplayed(), "Dashboard not visible after login!");

		System.out.println("Login Successful ");
	}

	@Test
	public void invalidLoginTest() {

		// Enter wrong username
		driver.findElement(By.name("username")).sendKeys("WrongUser");

		// Enter wrong password
		driver.findElement(By.name("password")).sendKeys("WrongPass");

		// Click Login
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// Verify error message
		WebElement error = driver.findElement(By.xpath("//p[contains(text(),'Invalid credentials')]"));

		Assert.assertTrue(error.isDisplayed(), "Error message not shown!");

		System.out.println("Invalid Login Test Passed ");
	}

}
