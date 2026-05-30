package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends BaseClass {

    private final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private final By profileMenu = By.cssSelector(".oxd-userdropdown-name");
    private final By logoutOption = By.xpath("//a[text()='Logout']");

    public boolean isDashboardDisplayed() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader))
                .isDisplayed();
    }

    public void logout() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(profileMenu))
                .click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(logoutOption))
                .click();
    }
}