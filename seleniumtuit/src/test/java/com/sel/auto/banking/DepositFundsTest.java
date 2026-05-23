package banking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DepositFundsTest extends LoginTest {

	@Test
	public void depositFundsTest() {

		login();

		driver.findElement(By.linkText("Open New Account")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("type")));

		WebElement button = driver.findElement(By.xpath("//input[@value='Open New Account']"));

		button.click();

		WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("openAccountResult")));

		Assert.assertTrue(result.getText().contains("Congratulations"));

		System.out.println("Deposit Successful");
	}
}