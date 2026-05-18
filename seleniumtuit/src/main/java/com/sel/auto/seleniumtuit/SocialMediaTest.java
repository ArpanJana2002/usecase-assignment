package com.sel.auto.seleniumtuit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SocialMediaTest {

    public static void main(String[] args) throws InterruptedException {

        // ================= SETUP CHROME DRIVER =================

        WebDriverManager.chromedriver().setup();

        // ================= OPEN BROWSER =================

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // ================= OPEN FACEBOOK =================

        driver.get("https://www.facebook.com/");

        Thread.sleep(3000);
        // 1. LOGIN

        // Enter Email
        driver.findElement(By.id("email"))
                .sendKeys("your_email");

        // Enter Password
        driver.findElement(By.id("pass"))
                .sendKeys("your_password");

        // Click Login
        driver.findElement(By.name("login"))
                .click();

        System.out.println("Login Successful");

        Thread.sleep(5000);

        // 2. NAVIGATE TO PROFILE PAGE

        // Open Profile Page
        driver.findElement(By.xpath("//span[text()='Your profile']"))
                .click();

        System.out.println("Navigated to Profile Page");

        Thread.sleep(5000);

        // 3. UPDATE PROFILE DETAILS

        // Click Edit Bio Button
        driver.findElement(By.xpath("//span[text()='Edit bio']"))
                .click();

        Thread.sleep(3000);

        // Enter New Bio
        WebElement bio = driver.findElement(By.tagName("textarea"));

        bio.clear();

        bio.sendKeys("Automation Tester using Selenium WebDriver");

        // Save Bio
        driver.findElement(By.xpath("//span[text()='Save']"))
                .click();

        System.out.println("Profile Details Updated");

        Thread.sleep(5000);

        // 4. UPLOAD PROFILE PICTURE

        // Click Profile Picture
        driver.findElement(By.xpath("//div[@aria-label='Profile picture actions']"))
                .click();

        Thread.sleep(3000);

        // Click Upload Photo
        driver.findElement(By.xpath("//span[contains(text(),'Upload Photo')]"))
                .click();

        Thread.sleep(3000);

        // Upload File
        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys("C:\\Users\\DELL\\Pictures\\profile.jpg");

        System.out.println("Profile Picture Uploaded");

        Thread.sleep(5000);
      
        // 5. LOGOUT

        // Open Account Menu
        driver.findElement(By.xpath("//div[@aria-label='Account']"))
                .click();

        Thread.sleep(3000);

        // Click Logout
        driver.findElement(By.xpath("//span[text()='Log Out']"))
                .click();

        System.out.println("Logout Successful");

        Thread.sleep(3000);

        // ================= CLOSE BROWSER =================

        driver.quit();
    }
}
