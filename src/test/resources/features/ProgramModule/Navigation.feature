Feature: Navigation

  #These all steps are from login Module
Background: Admin is logged in to LMS Portal
Given Admin is in login Page
When Admin enter valid credentials  and clicks login button through keyboard
Then Admin should land on dashboard page

  #This step is common in class module Given Admin is on dashboard page after Login
Scenario: Verify that Admin is able to navigate to Program module
    When Admin clicks "Program" on the navigation bar
    Then Admin should be navigated to Program module
    
    