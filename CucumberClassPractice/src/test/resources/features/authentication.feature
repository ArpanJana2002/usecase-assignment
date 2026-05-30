@Smoke
Feature: OrangeHRM User Authentication

  Background:
    Given browser session is started
    And login portal is opened

  @Regression
  Scenario: Successful login with valid credentials

    When employee enters username "Admin"
    And employee enters password "admin123"
    Then employee submits login request
    And dashboard page should be displayed
    And employee signs out from application


  @Sanity
  Scenario: Unsuccessful login with invalid credentials

    When employee enters username "Admin"
    And employee enters password "wrongPassword"
    Then employee submits login request
    And invalid credential warning should appear