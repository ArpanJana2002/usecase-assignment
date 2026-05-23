package com.sel.auto.banking;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	// REUSABLE LOGIN METHOD

	public void login() {

		// Clear username field
		driver.findElement(By.name("username")).clear();

		// Enter username
		driver.findElement(By.name("username")).sendKeys(username);

		// Clear password field
		driver.findElement(By.name("password")).clear();

		// Enter password
		driver.findElement(By.name("password")).sendKeys(password);

		// Click Login Button
		driver.findElement(By.xpath("//input[@value='Log In']")).click();

		// Wait until Accounts Overview appears
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Accounts Overview")));

		System.out.println("Login Successful");
	}

	// LOGIN TEST

	@Test
	public void loginTest() {

		login();

		Assert.assertTrue(driver.getCurrentUrl().contains("overview"));

		System.out.println("Login Test Passed");
	}
}
