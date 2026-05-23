package com.sel.auto.seleniumtuit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoClass {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/checkbox");

		WebElement element = driver.findElement(By.className("rc-tree-checkbox"));
		element.click();
		Thread.sleep(3000);

		driver.quit();

	}

}
