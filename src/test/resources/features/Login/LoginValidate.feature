@ValidLoginPage
Feature: Login Page validation

  Background:
    Given Admin is in login Page

  @validLogin
  Scenario Outline: Validate login with valid credentials
    When Admin enter valid "<credentials>" and clicks login button
    Then Admin should see the "<result>"
    Examples:
    | credentials              | result                  |
    | valid credentials        | Admin should land on dashboard page ( centre of the page will be empty , menu bar is present)|
    | invalid credentials      | Error message please check Admin name/password                                               |
    | password                 | Error message please check Admin name/password                                               |
    | username                 | Error message please check Admin name/password                                               |

    @keyboardLogin
 Scenario: verify login button action through keyboard
   When Admin enter valid credentials  and clicks login button through keyboard
   Then Admin should land on dashboard page

  @mouseLogin
 Scenario: verify login button action through mouse
   When Admin enter valid credentials  and clicks login button through mouse
   Then Admin should land on dashboard page

