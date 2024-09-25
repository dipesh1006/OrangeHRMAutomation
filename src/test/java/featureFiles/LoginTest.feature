## Author: Dipesh Pal
Feature: Log in to OrangeHRM Portal with different Login Creds

  @Regressiontest
  Scenario Outline: Validate User can able to LogIn OrangeHRM Portal
    Given Open the OrangeHRM Portal
    When Try to Log in with "<username>" and "<password>"
    And Click on LogIn Btn
    Then Verify "<user>" able to login and Dashboard

    Examples: 
      | username | password   | user          |
      | Admin    | admin123   | amanda user   |
      | Liza1    | Liza123@   | Ravi B        |
      | Dipesh   | Dipesh123@ | Ranga Akunuri |
