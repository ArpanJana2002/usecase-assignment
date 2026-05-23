package com.sel.auto.banking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WithdrawFundsTest extends LoginTest {

	@Test
	public void withdrawFundsTest() {

		login();

		driver.findElement(By.linkText("Bill Pay")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("payee.name")));

		driver.findElement(By.name("payee.name")).sendKeys("Electricity Bill");

		driver.findElement(By.name("payee.address.street")).sendKeys("Street 1");

		driver.findElement(By.name("payee.address.city")).sendKeys("Kolkata");

		driver.findElement(By.name("payee.address.state")).sendKeys("WB");

		driver.findElement(By.name("payee.address.zipCode")).sendKeys("700001");

		driver.findElement(By.name("payee.phoneNumber")).sendKeys("9876543210");

		driver.findElement(By.name("payee.accountNumber")).sendKeys("12345");

		driver.findElement(By.name("verifyAccount")).sendKeys("12345");

		driver.findElement(By.name("amount")).sendKeys("100");

		driver.findElement(By.xpath("//input[@value='Send Payment']")).click();

		WebElement message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bill Payment Complete')]")));

		Assert.assertTrue(message.isDisplayed());

		System.out.println("Withdraw Successful");
	}
}
