Feature: Login functionality

  Scenario: Valid Login

    Given user opens login page

    When user enters username "tomsmith"

    And user enters password "SuperSecretPassword!"

    Then user clicks login button