package com.testing.hooks;

import org.openqa.selenium.WebDriver;

import com.testing.utils.ConfigReader;
import com.testing.utils.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {

        driver = DriverManager.getDriver();

        String url =
        ConfigReader.getProperties()
                    .getProperty("url");

        driver.get(url);

        System.out.println(
                "Browser Opened"
        );
    }

    @After
    public void tearDown() {

        driver.quit();

        System.out.println(
                "Browser Closed"
        );
    }
}