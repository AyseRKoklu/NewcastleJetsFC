@wip
Feature: User login

  Background: User navigates to the login page
    Given the user is on the main Hudl page
    And the user clicks on the Hudl login button
    And the user is on the login page

  Scenario Outline: User successfully logs in to the website
    When the user enters valid "<username>" username and "<password>" password
    And clicks on the continue button
    Then verify the home page is displayed
    Examples:
      | username          | password  |
      | arkoklu@gmail.com | Test1234! |
      | aRkOkLu@gmail.com | Test1234! |

  Scenario Outline: User fails to login to the website
    When the user enters invalid "<username>" username and "<password>" password
    And clicks on the login button
    Then verify error messages with "<errorMessage>" error type
    Examples:
      | username          | password  | errorMessage                                  |
      | arkoklu           | Test1234! | We don't recognize that email and/or password |
      | arkoklu@gmail.com | Test1234  | We don't recognize that email and/or password |
      |                   | Test1234! | Please fill in all of the required fields     |
      | arkoklu@gmail.com |           | Please fill in all of the required fields     |
