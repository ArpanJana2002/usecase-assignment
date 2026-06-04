package com.testing.stepdefs;

import com.testing.hooks.Hooks;
import com.testing.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	LoginPage loginPage = new LoginPage(Hooks.driver);

	@Given("user opens login page")
	public void user_opens_login_page() {

		System.out.println("Login Page Opened");
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {

		loginPage.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {

		loginPage.enterPassword(password);
	}

	@Then("user clicks login button")
	public void user_clicks_login_button() throws InterruptedException {

		loginPage.clickLogin();

		Thread.sleep(3000);

		System.out.println("Login Attempt Completed");
	}
}
