Feature: Manage Program - Edit Program

  
Background: Admin is on program module after reaching dashboard


 #1
Scenario: Verify Edit option
    Given Admin is on Program module
    When Admin clicks on Edit option for particular program
    Then Admin lands on Program details form
    
 #2
Scenario: Verify title of the pop up window
    Given Admin is on Program module
    When Admin clicks on Edit option for particular program
    Then Admin should see window title as "Program Details"
 #3
   Scenario: Verify mandatory fields with red "*" mark 
    Given Admin is on Program module
    When Admin clicks on Edit option for particular program
    Then Admin should see red "*" mark beside mandatory field "Name" 
  #4
   Scenario: Verify edit Program Name 
    Given Admin is on Program module
    When Admin edits the program name and click on save button
    Then Updated program name is seen by the Admin 
  #5
  Scenario: Verify edit Description
    Given Admin is on Program module
    When Admin edits the description text and click on save button
    Then Admin can see the description is updated
  #6 
  Scenario: Verify edit Status
    Given Admin is on Program module
    When Admin can change the status of the program and click on save button
    Then Status updated can be viewed by the Admin
  #7
  Scenario: Verify Admin is able to click Save
    Given Admin is on Program module
    When Admin click on save button
    Then Admin can see the updated program details
 #8
 Scenario: Verify Admin is able to click Cancel
    Given Admin is on Program module
    When Admin click on cancel button
    Then Admin can see the Program details form disappears
  #9
  Scenario: Verify edited Program details
    Given Admin is on Program module
    When Admin searches with newly updated "Program Name"
    Then Admin verifies that the details are correctly updated.
  #10
  Scenario:  Verify close the window with "X" 
    Given Admin is on Program module
    When Admin Click on "X" button
    Then Admin can see program details form disappear
  
  