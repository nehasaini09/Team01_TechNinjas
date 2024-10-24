
@tag
Feature: Manage Program With Delete Function
  

  @tag1
  Scenario: Verify delete feature on program module   
    Given Admin is on Program module page  
    When Admin clicks on delete button for a program module page
    Then Admin will get confirm deletion popup for program module page
    
  @tag2
  Scenario: Verify Admin is able to click "Yes" in delete pop up
    Given Admin is on Confirm pop up for delete on program module page
    When Admin clicks on "Yes" button for delete on program module page
    Then Admin can see 'Successful Program Deleted' message in program module page

   @tag3
  Scenario: Verify Admin is able to click "No" in delete pop up 
    Given Admin is on Confirm pop up for delete program module page
    When Admin clicks on "No" button for delete on program module page
    Then Admin can Validate the program was not deleted
    
    @tag4
  Scenario: Verify Admin is able to select multiple delete programs
    Given Admin is on Program module page
    When  Admin selects more than one program by clicking on the checkboxes on program module page
    Then Programs get selected for delete on Program module page 
    
    
    @tag5
  Scenario: Verify Admin is able to delete Multiple programs
    Given Admin is on Program module page
    When  Admin clicks on the delete button on the left top of the program page
    Then  Programs get selected for deleting on program page
    
    
    @tag6
  Scenario: Verify Admin is able to click 'Yes' to delete multiple programs
    Given Admin is on Confirm delete in Program module page
    When  Admin clicks on "yes" button for deleting in program module page
    Then  Admin can see "Successful  program deleted" message in program module page
    
    
    @tag7
  Scenario: Verify Admin is able to click 'No' to delete multiple programs
    Given Admin is on Confirm delete in Program module page
    When  Admin clicks on "no" button for deleting in program module page
    Then  Admin can see Programs are still selected and not deleted in program module page
    
    
     @tag8
  Scenario: Verify Admin is able to close the window with "X" program page
    Given Admin is on Confirm delete in Program module page
    When  Admin Click on "X" button
    Then  Admin can see Confirm Deletion form disappear
    
    @tag9
  Scenario: Admin verify the number of programs reduced after delete in program page
    Given Admin is on manage Program module page
    Then  Admin should be able to validate the number of programs reduced
