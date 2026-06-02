package com.seleniumdocker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

	private void login() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@Test
	public void verifyDashboardTitle() {

		login();

		// Verify page title
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("OrangeHRM"), "Title mismatch!");

		System.out.println("Page Title : " + title);
	}

	@Test
	public void verifyNavigationMenu() {

		login();

		// Check if Admin menu exists
		WebElement adminMenu = driver.findElement(By.xpath("//span[text()='Admin']"));

		Assert.assertTrue(adminMenu.isDisplayed(), "Admin menu not found!");

		System.out.println("Navigation Menu visible");
	}

	@Test
	public void navigateToAdminPage() {

		login();

		// Click Admin in sidebar
		driver.findElement(By.xpath("//span[text()='Admin']")).click();

		// Verify Admin page loaded
		WebElement header = driver.findElement(By.xpath("//h6[text()='Admin']"));

		Assert.assertTrue(header.isDisplayed());
		System.out.println("Admin Page loaded");
	}

}
