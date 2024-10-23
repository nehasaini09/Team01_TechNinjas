@InvalidLoginPage
Feature: Invalid Login Page Verification

  Background:
    Given Admin launch the browser

  Scenario: Verify Admin is able to land on home page with invalid URL
    When Admin gives the invalid LMS portal URL
    Then Admin should receive 404 page not found error