package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;

public class Authentication extends BaseClass {

    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @Given("browser session is started")
    public void browser_session_is_started() {

        Assert.assertNotNull(driver, "Browser is not launched");
    }

    @Given("login portal is opened")
    public void login_portal_is_opened() {

        loginPage.openLoginPage();
    }

    @When("employee enters username {string}")
    public void employee_enters_username(String username) {

        loginPage.enterUsername(username);
    }

    @And("employee enters password {string}")
    public void employee_enters_password(String password) {

        loginPage.enterPassword(password);
    }

    @Then("employee submits login request")
    public void employee_submits_login_request() {

        loginPage.clickLogin();
    }

    @And("dashboard page should be displayed")
    public void dashboard_page_should_be_displayed() {

        Assert.assertTrue(
                dashboardPage.isDashboardDisplayed(),
                "Dashboard not displayed"
        );
    }

    @And("employee signs out from application")
    public void employee_signs_out_from_application() {

        dashboardPage.logout();
    }

    @And("invalid credential warning should appear")
    public void invalid_credential_warning_should_appear() {

        Assert.assertTrue(
                loginPage.isErrorDisplayed(),
                "Error message not displayed"
        );
    }
}