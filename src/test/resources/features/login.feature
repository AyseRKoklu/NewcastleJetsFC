Feature: User login

  Background: User navigates to the login page
    Given user is on the main Hudl page
    And user clicks on the login button
    And user clicks on the Hudl login button
    And user is on the login page

  Scenario Outline: User successfully logs in to the website
    When user enters "<username>" username and "<password>" password
    And user clicks on the continue button
    Then verify the home page is displayed
    Examples:
      | username          | password  |
      | arkoklu@gmail.com | Test1234! |
      | aRkOkLu@gmail.com | Test1234! |

  Scenario Outline: User fails to login to the website
    When user enters "<username>" username and "<password>" password
    Then verify error messages with "<errorMessage>" error type
    Examples:
      | username          | password  | errorMessage        |
      | arkoklu           | Test1234! | invalid credentials |
      | arkoklu@gmail.com | Test1234  | invalid credentials |
      |                   | Test1234! | email required      |
      | arkoklu@gmail.com |           | password required   |
