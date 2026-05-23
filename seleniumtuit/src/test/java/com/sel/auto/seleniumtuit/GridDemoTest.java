package com.sel.auto.seleniumtuit;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridDemoTest {

    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) throws MalformedURLException {

        if(browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            driver = new RemoteWebDriver(
                    new URL("http://<HUB_IP>.101:4444"),
                    options);
        }

        driver.manage().window().maximize();
    }

    @Test
    public void googleTest() {

        driver.get("https://www.google.com");

        System.out.println("Title : " + driver.getTitle());

        System.out.println("Thread ID : "
                + Thread.currentThread().getId());
    }

    @AfterMethod
    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }
}
