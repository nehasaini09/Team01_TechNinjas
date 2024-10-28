Feature: Add New Program Feature

 #no need of background
Background: Admin is logged in to LMS Portal
Given Admin is in login Page
When Admin enter valid credentials  and clicks login button through keyboard
Then Admin should land on dashboard page
When  Admin clicks "Program" on the navigation bar in program module
 

  
  #1
Scenario: Verify add New Program
   # Given  Admin is on Program module
    When Admin clicks on "New Program" under the "Program" menu bar
    Then Admin should see pop up window for program details
    
  #2
  Scenario: Verify title of the pop up window
    #Given  Admin is on Program module
    When Admin clicks on "New Program" under the "Program" menu bar
    Then Admin should see window title as "Program Details" for popup
    
  #3
   Scenario: Verify mandatory fields with red "*" mark 
    #Given  Admin is on Program module
    When Admin clicks on "New Program" under the "Program" menu bar
    Then Admin should see red "*" mark beside mandatory field "Name" in popup
    
  #4
  
  Scenario: Verify empty form submission
    #Given  Admin is on Program details form
    Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin clicks save button without entering mandatory fiels in add new program form
    Then Admin gets message '<field> is required' in popup
  
  #5
  Scenario: Verify cancel button
    #Given  Admin is on Program details form
    Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin clicks Cancel button in new program form
    Then Admin can see Program Details form disappears
     
  #6
  Scenario: Verify enter program name
    Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin enters the Name in the text box
    Then Admin can see the program name entered
  #7
   Scenario: Verify enter description
    #Given  Admin is on Program details form
    When  Admin enters the Description in text box
    Then Admin can see the text entered in description box
  #8
  Scenario: Verify select Status
   Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin selects the status of the program by clicking on the radio button "(Active/InActive)"
    Then Admin can see 'Active/Inactive' status selected
  #9
   Scenario: Verify Admin is able to save the program details
    Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin enter valid details for mandatory fields and Click on save button
    Then Admin gets message 'Created Program Successfully'
  #10
  Scenario: Verify cancel program details
   Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin Click on cancel button
    Then Admin can see program details form disappear after click on cancel
  #11
   Scenario: Verify added Program is created
   Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin searches with newly created "Program Name"
    Then Records of the newly created  "Program Name" is displayed and match the data entered
  #12
  Scenario: Verify close window with "X" 
    Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin Click on "X" button
    Then Admin can see program details form disappear
  
  
    
  