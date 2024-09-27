## Author: Dipesh Pal
Feature: Test Reset Password Functionality

  @testfeature
  Scenario Outline: Test Reset Password Functionality
    Given Open the OrangeHRM Portal
    When Click on Forget Password for user "<Username>"
    Then Verify "<errormsg1>" and "<errormsg2>" in a dialogbox

    Examples: 
      | Username | errormsg1                             | errormsg2                                             |
      | Admin    | Reset Password link sent successfully | A reset password link has been sent to you via email. |
