package com.log.test.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    // Wait initialization
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators - OrangeHRM uses class names with underscores
    private By usernameField = By.xpath("//input [@placeholder='Username']");
    private By passwordField = By.xpath("//input [@placeholder='Password']");
    private By loginButton = By.xpath("//button [@type='submit']");

    public void enterUsername(String username) {
        logger.info("Entering username: {}", username);
        WebElement usernameElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(usernameField)
        );
        usernameElement.clear();
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        logger.info("Entering password");
        WebElement passwordElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(passwordField)
        );
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        logger.info("Clicking login button");
        WebElement loginBtn = wait.until(
            ExpectedConditions.elementToBeClickable(loginButton)
        );
        loginBtn.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        logger.info("Login executed with username: {}", username);
    }
}