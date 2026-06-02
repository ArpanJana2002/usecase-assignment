package com.seleniumdocker;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;

	// OrangeHRM running in Docker
	protected String baseURL = "http://orangehrm:80";

	// Selenium Grid Hub URL (service name from docker-compose)
	protected String gridURL = "http://selenium-hub:4444/wd/hub";

	@BeforeMethod
	public void setUp() throws Exception {

		ChromeOptions options = new ChromeOptions();

		// Optional (recommended for Docker stability)
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox");

		// Connect to Selenium Grid
		driver = new RemoteWebDriver(new URL(gridURL), options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Open OrangeHRM
		driver.get(baseURL);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}