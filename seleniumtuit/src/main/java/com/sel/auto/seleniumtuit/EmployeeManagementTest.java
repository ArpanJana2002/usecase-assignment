package com.sel.auto.seleniumtuit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmployeeManagementTest {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Launch Browser
        WebDriver driver = new ChromeDriver();

        // Open OrangeHRM Website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Maximize Window
        driver.manage().window().maximize();

        Thread.sleep(3000);

        // ================= LOGIN =================

        driver.findElement(By.name("username"))
                .sendKeys("Admin");

        driver.findElement(By.name("password"))
                .sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        System.out.println("Admin Login Successful");

        Thread.sleep(3000);

        // ================= OPEN PIM =================

        driver.findElement(By.linkText("PIM"))
                .click();

        Thread.sleep(3000);

        // ================= ADD EMPLOYEE =================

        driver.findElement(By.xpath("//button[text()=' Add ']"))
                .click();

        Thread.sleep(3000);

        // First Name
        driver.findElement(By.name("firstName"))
                .sendKeys("Peter");

        // Last Name
        driver.findElement(By.name("lastName"))
                .sendKeys("Nixon");

        // Save Employee
        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        System.out.println("Employee Added Successfully");

        Thread.sleep(5000);

        // ================= SEARCH EMPLOYEE =================

        // Go back to PIM
        driver.findElement(By.linkText("PIM"))
                .click();

        Thread.sleep(3000);

        // Search by Employee Name
        WebElement searchBox = driver.findElement(
                By.xpath("(//input[@placeholder='Type for hints...'])[1]"));

        searchBox.sendKeys("Peter");

        Thread.sleep(2000);

        // Click Search Button
        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        System.out.println("Employee Search Completed");

        Thread.sleep(5000);

        // ================= UPDATE EMPLOYEE =================

        // Click Edit Button
        driver.findElement(By.xpath("(//i[contains(@class,'bi-pencil-fill')])[1]"))
                .click();

        Thread.sleep(3000);

        // Update Last Name
        WebElement lastName = driver.findElement(By.name("lastName"));

        lastName.clear();

        lastName.sendKeys("Johnson");

        // Save Updated Data
        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        System.out.println("Employee Updated Successfully");

        Thread.sleep(5000);

        // ================= DELETE EMPLOYEE =================

        // Go Back to PIM
        driver.findElement(By.linkText("PIM"))
                .click();

        Thread.sleep(3000);

        // Search Employee Again
        WebElement searchEmployee = driver.findElement(
                By.xpath("(//input[@placeholder='Type for hints...'])[1]"));

        searchEmployee.sendKeys("Peter");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        Thread.sleep(5000);

        // Click Delete Button
        driver.findElement(By.xpath("(//i[contains(@class,'bi-trash')])[1]"))
                .click();

        Thread.sleep(2000);

        // Confirm Delete
        driver.findElement(By.xpath("//button[text()=' Yes, Delete ']"))
                .click();

        System.out.println("Employee Deleted Successfully");

        Thread.sleep(5000);

        // ================= LOGOUT =================

        driver.findElement(By.className("oxd-userdropdown-tab"))
                .click();

        Thread.sleep(2000);

        driver.findElement(By.linkText("Logout"))
                .click();

        System.out.println("Logout Successful");

        Thread.sleep(3000);

        // Close Browser
        driver.quit();
    }
}
