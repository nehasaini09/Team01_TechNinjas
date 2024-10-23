@LoginPageDetails
Feature: Login Page Verification

  Background:
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL

  Scenario: Verify Admin is able to land on login page
    Then Admin should land on the login page

  Scenario: Verify for broken link
    Then HTTP response >= 400. Then the link is broken

  Scenario: Verify the text spelling in the page
    Then Admin should see correct spellings in all fields

  Scenario: Verify the company logo
    Then Admin should see logo on the left  side

  Scenario:Verify application name
    Then Admin should see  LMS - Learning Management System

  Scenario: Verify company name
    Then Admin should see company name below the app name

  Scenario: Validate sign in content
    Then Admin should see "Please login to LMS application"

  Scenario: Verify text field is present
    Then Admin should see two text field

  Scenario: Verify text on the first text field
    Then Admin should "User" in the first text field

  Scenario: Verify asterisk next to Admin text
    Then Admin should see field mandatory asterisk symbol next to Admin text

  Scenario: Verify text on the second text field
    Then Admin should "Password" in the second text field

  Scenario: Verify asterisk next to password text
    Then Admin should see * symbol next to password text

  Scenario: Verify the alignment input field for the login
    Then Admin should see input field on the centre of the page

    Scenario: verify Login button is present
      Then Admin should see login button

  Scenario: Verify the alignment of the login button
    Then Admin should see login button on the centre of the page

  Scenario:Verify input descriptive test in Admin field
    Then Admin should see Admin in gray color

 Scenario: Verify input descriptive test in password field
   Then Admin should see password in gray color











