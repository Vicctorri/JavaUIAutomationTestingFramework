@run
Feature: Register flow test suite

  Scenario: Register page is accessed from the homepage
    Given Homepage is displayed
    When Terms and conditions are accepted
    And Register button from header is clicked
    And The register option is selected
    Then The current url contains "register" keyword

  Scenario: The user is successfully registered
    Given Homepage is displayed
    And Register button from header is clicked
    And The register option is selected
    When The register form is populated with data
    And The register button is clicked
    Then User is registered and is displayed "Thank you for registering an account."


  Scenario Outline: An error message is displayed when invalid <impacted attribute> name is used for register flow
    Given Homepage is displayed
    And Register button from header is clicked
    And The register option is selected
    When The register form is populated with the fallowing data:
      | organizationName | <organizationName> |
      | contactPerson    | <contactPerson>    |
      | email            | <email>            |
    When The register button is clicked
    Then The fallowing list of error messages is displayed:
      | Input is too short (min 2) |
    Examples:
      | impacted attribute | organizationName  | contactPerson  | email               |
      | Organization       | q                 | contactPerson1 | sdddd@ddd.dddd      |
      | Contact Person     | organizationName2 | e              | sdddd@ddd.ddddaswde |
