package com.sel.auto.banking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BalanceTest extends LoginTest {

	@Test
	public void checkBalanceTest() {

		login();

		driver.findElement(By.linkText("Accounts Overview")).click();

		WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountTable")));

		Assert.assertTrue(table.isDisplayed());

		System.out.println("Balance Check Successful");
	}
}
