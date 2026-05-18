package com.sel.auto.seleniumtuit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightBookingTest {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Launch Browser
        WebDriver driver = new ChromeDriver();

        // Open Website
        driver.get("https://blazedemo.com/");

        // Maximize Browser
        driver.manage().window().maximize();

        Thread.sleep(3000);

        // ================= SEARCH FLIGHTS =================

        // Select Source City
        WebElement fromCity = driver.findElement(By.name("fromPort"));
        fromCity.sendKeys("Boston");

        // Select Destination City
        WebElement toCity = driver.findElement(By.name("toPort"));
        toCity.sendKeys("London");

        System.out.println("Source and Destination Selected");

        Thread.sleep(2000);

        // Find Flights
        driver.findElement(By.cssSelector("input[type='submit']"))
                .click();

        System.out.println("Flight Search Completed");

        Thread.sleep(3000);

        // ================= SELECT FLIGHT =================

        // Choose First Flight
        driver.findElement(
                By.xpath("(//input[@value='Choose This Flight'])[1]"))
                .click();

        System.out.println("Flight Selected");

        Thread.sleep(3000);

        // ================= ENTER PASSENGER DETAILS =================

        // Passenger Name
        driver.findElement(By.id("inputName"))
                .sendKeys("Sarthak Sharma");

        // Address
        driver.findElement(By.id("address"))
                .sendKeys("Mubbai");

        // City
        driver.findElement(By.id("city"))
                .sendKeys("Mumbai");

        // State
        driver.findElement(By.id("state"))
                .sendKeys("Maharastra");

        // Zip Code
        driver.findElement(By.id("zipCode"))
                .sendKeys("700211");

        // Card Holder Name
        driver.findElement(By.id("nameOnCard"))
                .sendKeys("Sarthak Sharma");

        System.out.println("Passenger Details Entered");

        Thread.sleep(3000);

        // ================= BOOK TICKET =================

        driver.findElement(By.cssSelector("input[type='submit']"))
                .click();

        System.out.println("Flight Ticket Booked Successfully");

        Thread.sleep(3000);

        // ================= VALIDATE BOOKING ID =================

        // Capture Booking ID
        String bookingID = driver.findElement(
                By.xpath("//td[text()='Id']/following-sibling::td"))
                .getText();

        System.out.println("Booking ID: " + bookingID);

        // Validation
        if (!bookingID.isEmpty()) {

            System.out.println("Booking ID Validated Successfully");

        } else {

            System.out.println("Booking Failed");

        }

        Thread.sleep(5000);

        // Close Browser
        driver.quit();
    }
}
