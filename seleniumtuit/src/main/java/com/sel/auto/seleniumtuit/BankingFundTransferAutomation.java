package com.sel.auto.seleniumtuit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BankingFundTransferAutomation {

    public static void main(String[] args) { 
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Create explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // ======== 1. Login to Banking Application ========
            driver.get("https://parabank.parasoft.com/parabank/index.htm;jsessionid=5101932FE6B67565B16B0C443BAF5670");

            WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("username"))
            );
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginButton"));

            usernameField.sendKeys("your_username");
            passwordField.sendKeys("your_password");
            loginButton.click();

            wait.until(ExpectedConditions.urlContains("dashboard"));
            System.out.println("Login successful");

            // ======== 2. Navigate to Fund Transfer ========
            WebElement fundTransferLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(text(), 'Fund Transfer')]")
                )
            );
            fundTransferLink.click();

            // ======== 3. Select Beneficiary ========
            WebElement beneficiaryDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("beneficiary"))
            );
            beneficiaryDropdown.sendKeys("Beneficiary Name or Account Number");

            // ======== 4. Transfer Amount ========
            WebElement amountField = driver.findElement(By.id("amount"));
            amountField.clear();
            amountField.sendKeys("1000");

            WebElement transferButton = driver.findElement(By.id("transferButton"));
            transferButton.click();

            // ======== 5. Validate Success Message ========
            WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'success') or contains(text(), 'successful')]")
                )
            );
            String message = successMessage.getText();
            System.out.println("Transfer status: " + message);

            if (message.toLowerCase().contains("successful") || 
                message.toLowerCase().contains("success")) {
                System.out.println("Fund transfer validated successfully");
            } else {
                System.out.println("Transfer may have failed: " + message);
            }

            // ======== 6. Logout ========
            WebElement logoutLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(text(), 'Logout')]")
                )
            );
            logoutLink.click();

            // Validate logout (check for login page or URL)
            wait.until(ExpectedConditions.urlContains("login"));
            System.out.println("Logout successful");

        } catch (Exception e) {
            System.err.println("Error during automation: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
