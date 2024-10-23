@LogoutPage
Feature: Validation on Logout button

 Scenario: Verify logout function
   Given Admin is in dashboard page after logging in
   When Admin clicks on the logout in the menu bar
   Then Admin should be redirected to login page

 Scenario: Verify back button function
   Given Admin is logged out of the application and Admin is in login page
   When Admin clicks  browser back button
   Then Admin should receive error message


