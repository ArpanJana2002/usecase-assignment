package com.sel.auto.seleniumtuit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EcommerceTest {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Launch Browser
        WebDriver driver = new ChromeDriver();

        // Open Website
        driver.get("https://www.saucedemo.com/");

        // Maximize Window
        driver.manage().window().maximize();

        // Login
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        // Add Product to Cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

        // Open Cart
        driver.findElement(By.className("shopping_cart_link"))
                .click();

        // Checkout
        driver.findElement(By.id("checkout"))
                .click();

        // Enter Details
        driver.findElement(By.id("first-name"))
                .sendKeys("James");

        driver.findElement(By.id("last-name"))
                .sendKeys("Turner");

        driver.findElement(By.id("postal-code"))
                .sendKeys("700251");

        driver.findElement(By.id("continue"))
                .click();

        // Finish Order
        driver.findElement(By.id("finish"))
                .click();

        // Print Confirmation
        String msg = driver.findElement(By.className("complete-header"))
                               .getText();

        System.out.println("Order Message: " + msg);

        // Wait for 3 seconds
        Thread.sleep(3000);

        // Close Browser
        driver.quit();
    }
}
