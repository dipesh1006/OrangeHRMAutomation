## Author: Dipesh Pal
Feature: Add new Admin and then try to Login with New Admin Credentials

  @Regressiontest
  Scenario Outline: Add new Admin and then try to Login with New Admin Credentials
    Given Open the OrangeHRM Portal
    When Try to Log in with "<username>" and "<password>"
    And Click on LogIn Btn
    And Move to "<Admin_Panel>" and Create A new admin with "<User_Role>", "<Employee_Name>", "<New_Username>", "<New_Password>"
    And Logout from Current User
    Then Login through new user details "<New_Username>" and "<New_Password>"
    And Verify user Login Successfully

    Examples: 
      | username | password | Admin_Panel | User_Role | Employee_Name | New_Username | New_Password |
      | Admin    | admin123 | Admin       | Admin     | D             | Dipesh       | Dipesh123@   |
