@tag
Feature: Manage Program with search function
  
 Background: Admin on LMS Portal for delete program
    Given  Admin logged into LMS portal for Program module delete function
  @tag1
  Scenario: Verify Admin is able to search results found for program name  
    Given Admin is on Program module page for search  
    When  Admin enter the program name in search field of program module page
    Then  Admin should able to see Program name, description, and status for searched program name
   
   @tag2
  Scenario: Verify Admin is able to search results found for program description  
    Given Admin is on Program module page for search  
    When  Admin enter the program description in search field of program module page
    Then  Admin should able to see Program name, description, and status for searched program name
     
    @tag3
  Scenario: Verify Admin is able to search results not found 
    Given Admin is on Program module page for search  
    When  Admin enter the Invalid program name in search field of program module page
    Then  Admin should receive zero results
    
    @tag4
  Scenario: Verify Admin is able to search with partial program name
    Given Admin is on Program module page for search  
    When  Admin enter the search field by partial name of program
    Then  Admin should able to see Program name, description, and status for searched program name
      