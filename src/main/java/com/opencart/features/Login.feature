Feature: Login related test cases

  Scenario: Successfully login is performed with valid credentials
    Given Authentication page is displayed
    And The login form is populated with the fallowing details:
      | company@ddd.dddddysssssssss |
      | 1234qwer                    |
    Then The expert profile is displayed
