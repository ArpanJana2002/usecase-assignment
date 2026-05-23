package banking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

	@Test
	public void registerUserTest() {

		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("customer.firstName")).sendKeys("Arpan");

		driver.findElement(By.id("customer.lastName")).sendKeys("Jana");

		driver.findElement(By.id("customer.address.street")).sendKeys("Kolkata Street");

		driver.findElement(By.id("customer.address.city")).sendKeys("Kolkata");

		driver.findElement(By.id("customer.address.state")).sendKeys("West Bengal");

		driver.findElement(By.id("customer.address.zipCode")).sendKeys("700001");

		driver.findElement(By.id("customer.phoneNumber")).sendKeys("9876543210");

		driver.findElement(By.id("customer.ssn")).sendKeys("123456789");

		driver.findElement(By.id("customer.username")).sendKeys(username);

		driver.findElement(By.id("customer.password")).sendKeys(password);

		driver.findElement(By.id("repeatedPassword")).sendKeys(password);

		driver.findElement(By.xpath("//input[@value='Register']")).click();

		WebElement successMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='title']")));

		Assert.assertTrue(successMessage.getText().contains("Welcome"));

		System.out.println("Registration Successful");
	}
}