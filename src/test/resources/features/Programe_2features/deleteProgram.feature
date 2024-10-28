 @tag
Feature: Manage Program With Delete Function

  Background: Admin on LMS Portal for delete program
    Given  Admin logged into LMS portal for Program module delete function

  Scenario: Admin checks Succes delete operation with single program delete
    Given Admin on the program module page after login
    When Admin clicks on the delete icon on program module page
    Then Admin able to delete by clicking yes to confirmation pop up
    
    
    Scenario: Admin checks delete operation unsucces with single program delete
    Given Admin on the program module page after login
    When Admin clicks on the delete icon on program module page
    Then Admin able to delete by clicking No to confirmation pop up
     
       
  Scenario: Admin validate delete by deleting multiple programs
    Given Admin on the program module page after login
    When Admin clicks on the multiple checkboxes on program module page
    And Admin clicks  on the left delete button on program module page
    Then Admin able to delete multiple program by clicking yes to confirm
