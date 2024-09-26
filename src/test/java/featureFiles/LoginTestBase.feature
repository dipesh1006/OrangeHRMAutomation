## Author: Dipesh Pal
Feature: Log in to OrangeHRM Portal with different Login Creds

  @Regressiontest
  Scenario Outline: Validate User can able to LogIn OrangeHRM Portal
    Given Open the OrangeHRM Portal
    When Try to Log in with "<username>" and "<password>"
    And Click on LogIn Btn
    Then Verify able to login and Dashboard

    Examples: 
      | username | password |
      | Admin    | admin123 |
      | Liza1    | Liza123@ |
