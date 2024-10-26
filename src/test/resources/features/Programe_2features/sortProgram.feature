
@tag
Feature: Manage Program with Sort Function
  

  @tag1
  Scenario: Verify sorting of Program name in Ascending order
  	Given Admin is on Program module page for sorting
    When  Admin clicks on Arrow next to program Name of Program module page
    Then  Admin See the Program Name is sorted Ascending order in Program module page
       @tag2
  Scenario: Verify sorting of Program name in Descending order
  	Given Admin is on Program module page for sorting
    When  Admin clicks on Arrow next to program description of Program module page
    Then  Admin See the Program description is sorted Descending order in Program module page
    

  @tag3
  Scenario:Verify sorting of Program status in Ascending order/Descending order
   Given Admin is on Program module page for sorting
    When  Admin clicks on Arrow next to program status of Program module page
    Then  Admin See the Program status is sorted Descending order in Program module page 