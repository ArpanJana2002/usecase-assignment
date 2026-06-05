package com.log.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {
	private static final Logger logger = LogManager.getLogger(TestCase.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("Starting Selenium test...");

        WebDriver driver = new ChromeDriver();
        logger.debug("WebDriver initialized");

        driver.get("https://www.google.com");
        logger.info("Opened Google homepage");

        driver.quit();
        logger.info("Test completed");

	}

}
