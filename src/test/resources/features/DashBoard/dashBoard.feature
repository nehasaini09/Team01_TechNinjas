@DashBoard
Feature: Dashboard Page
  Background:
    Given Admin launch the browser and Admin is in login Page

    @Dashboard1
  Scenario: Verify after login Admin lands on dashboard page
      When  Admin enter valid credentials and clicks login button
    Then Admin should see the "expectedResult"

@DashboardPageloadtime
  Scenario: Verify the response time
    When  Admin logins to validate the navigation time
    Then Maximum navigation time in milliseconds, defaults to 30 seconds

  Scenario: Verify broken link
    When  Admin enter valid credentials and clicks login button
    Then HTTP response >= 400. Then the link is broken

  Scenario: Verify LMS title
    When  Admin enter valid credentials and clicks login button
    Then Admin should see LMS -Learning management system as title

  Scenario: Verify LMS title alignment
    When  Admin enter valid credentials and clicks login button
    Then LMS title should be on the top left corner of page

  Scenario: Validate navigation bar text
    When  Admin enter valid credentials and clicks login button
    Then Admin should see correct spelling in navigation bar text

  Scenario: Validate LMS title has correct spelling and space
    When  Admin enter valid credentials and clicks login button
    Then Admin should see correct spelling and space in LMS title

  Scenario: Validate alignment for navigation bar
    When  Admin enter valid credentials and clicks login button
    Then   Admin should see the navigation bar text on the top right side

  Scenario: Validate navigation bar order  program,batch,class,logout
    When  Admin enter valid credentials and clicks login button
    Then  Admin should see program in order


































