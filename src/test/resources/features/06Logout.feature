@LogoutPage
Feature: Validation on Logout button

Background: 
Given Admin launch the browser and Admin is in login Page

@logout1
 Scenario: Verify logout function
    When Admin enter valid credentials and clicks login button
   And Admin clicks on the logout in the menu bar
   Then Admin should be redirected to login page

@logout2
 Scenario: Verify back button function
 When Admin enter valid credentials and clicks login button
  And  Admin clicks  browser back button
   Then Admin should receive error message