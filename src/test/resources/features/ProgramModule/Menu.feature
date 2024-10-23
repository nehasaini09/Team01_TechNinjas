Feature: Menu Bar

  #These all steps are from login Module
Background: Admin is logged in to LMS Portal
Given Admin is in login Page
When Admin enter valid credentials  and clicks login button through keyboard
Then Admin should land on dashboard page

  #This step is common in class module Given Admin is on dashboard page after Login
Scenario: Verify any broken links on program page  
    Given Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should not have any broken links for Program module
     
Scenario: Verify heading in menu bar  
    Given Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the heading "LMS - Learning Management System"
    
Scenario: Verify other modules name displayed in menu bar
    Given Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the module names as in order "Program Batch Class "
    
Scenario: Verify Logout displayed in menu bar
    Given Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see Logout in menu bar
    
Scenario: Verify sub menu displayed in program menu bar
    Given Admin is on program page
    When Admin clicks "Program" on the navigation bar
    Then Admin should see sub menu in menu bar as "Add New Program"
    
    
    
    
    
    
    
    