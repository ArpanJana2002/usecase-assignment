package com.sel.auto.banking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferFundsTest extends LoginTest {

	@Test
	public void transferFundsTest() {

		login();

		driver.findElement(By.linkText("Transfer Funds")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));

		driver.findElement(By.id("amount")).clear();

		driver.findElement(By.id("amount")).sendKeys("500");

		driver.findElement(By.xpath("//input[@value='Transfer']")).click();

		WebElement message = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Transfer Complete')]")));

		Assert.assertTrue(message.isDisplayed());

		System.out.println("Fund Transfer Successful");
	}
}
