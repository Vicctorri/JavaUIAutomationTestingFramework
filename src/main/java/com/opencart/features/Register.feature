Feature: Register flow test suite

  Scenario: Register page is accessed from the homepage
    Given Homepage is displayed
    When Terms and conditions are accepted
    And Register button from header is clicked
    And The register option is selected
    Then The current url contains "register" keyword

  Scenario: The user is successfully registered
    Given Homepage is displayed
    And Terms and conditions are accepted
    And Register button from header is clicked
    And The register option is selected
    When The register form is populated with data
    And The register button is clicked
    Then User is registered and is displayed "Thank you for registering an account."

