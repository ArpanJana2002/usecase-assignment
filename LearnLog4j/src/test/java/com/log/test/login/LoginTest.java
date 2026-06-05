package com.log.test.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.log.test.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;

@Listeners(AllureTestNg.class)
@Epic("OrangeHRM")
@Feature("Login Functionality")
public class LoginTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    private LoginPage loginPage;

    @Test
    @Description("Verify successful login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Valid Login")
    public void testValidLogin() {
        logger.info("Starting valid login test");
        loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        // Verify dashboard appears
        boolean dashboardDisplayed = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
        Assert.assertTrue(dashboardDisplayed, "Dashboard should be displayed after login");
        logger.info("Valid login test passed");
    }
}