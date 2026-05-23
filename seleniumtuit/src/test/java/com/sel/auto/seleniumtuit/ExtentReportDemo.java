package com.sel.auto.seleniumtuit;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	public static void main(String[] args) throws Exception {
		ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);

		WebDriver driver = new ChromeDriver();

		testValidLogin(driver, extent);
		testFailedLogin(driver, extent);

		driver.quit();
		extent.flush();

		System.out.println("Extent Report Generated: reports/ExtentReport.html");
		System.out.println("Check screenshots folder for failure screenshot.");
	}

	public static void testValidLogin(WebDriver driver, ExtentReports extent) {
		ExtentTest test = extent.createTest("Valid Login Test - PASS");

		try {
			test.info("Browser Launched");

			driver.get("https://www.saucedemo.com");
			test.info("Opened SauceDemo Website");

			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			test.pass("Username Entered");

			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			test.pass("Password Entered");

			driver.findElement(By.id("login-button")).click();
			test.pass("Login Button Clicked");

			String title = driver.getTitle();
			if (title.contains("Swag Labs")) {
				test.pass("Login Successful");
			} else {
				test.fail("Login Failed");
				captureScreenshot(driver, test, "Login Failed Screenshot");
			}

		} catch (Exception e) {
			test.fail("Test failed with exception: " + e.getMessage());
			captureScreenshot(driver, test, "Exception Screenshot");
		}
	}

	public static void testFailedLogin(WebDriver driver, ExtentReports extent) {
		ExtentTest test = extent.createTest("Forced Failure Test - FAIL");

		try {
			test.info("Browser Reused");

			driver.get("https://www.saucedemo.com");
			test.info("Opened SauceDemo Website");

			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			test.pass("Username Entered");

			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			test.pass("Password Entered");

			driver.findElement(By.id("login-button")).click();
			test.pass("Login Button Clicked");

			String title = driver.getTitle();
			if (title.contains("INVALID_TITLE")) {
				test.pass("Dummy Title Check Passed");
			} else {
				test.fail("Expected INVALID_TITLE but got: " + title);
				captureScreenshot(driver, test, "Forced Failure Screenshot");
			}

		} catch (Exception e) {
			test.fail("Test failed with exception: " + e.getMessage());
			captureScreenshot(driver, test, "Exception Screenshot");
		}
	}

	public static void captureScreenshot(WebDriver driver, ExtentTest test, String stepName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		String fileName = System.currentTimeMillis() + ".png";
		String path = "screenshots/" + fileName;

		try {
			Files.createDirectories(Paths.get("screenshots"));
			Files.copy(src.toPath(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			test.fail("Failed to save screenshot: " + e.getMessage());
		}

		test.addScreenCaptureFromPath(path, stepName);
	}
}
