@tag
Feature: Manage Program with Sort Function

  Background: Admin on LMS Portal for Sort program
    Given Admin logged into LMS portal for Program module sort function
    Then Admin is on Program Module for sorting

  @tag1
  Scenario: Verify sorting of Program name in Ascending order
    When Admin clicks on Arrow next to program Name of Program module page for sort
    Then Admin See the Program Name is sorted Ascending order in Program module page for sort

  @tag2
  Scenario: Verify sorting of Program name in Descending order
    When Admin clicks on Arrow next to program Name of Program module page for sort descend
    Then Admin See the Program Name is sorted Descending order in Program module page 

  @tag3
  Scenario: Verify sorting of Program description in Ascending order
    When Admin clicks on Arrow next to program description of Program module page for sort 
    Then Admin See the Program description is sorted Ascending order in Program module page 

  @tag4
  Scenario: Verify sorting of Program description in Descending order
    When Admin clicks on Arrow next to program description of Program module page for sort descend
    Then Admin See the Program description is sorted Descending order in Program module page

  @tag5
  Scenario: Verify sorting of Program status in Ascending order
    When Admin clicks on Arrow next to program status of Program module page for sort
    Then Admin See the Program status is sorted Ascending order in Program module page

  @tag6
  Scenario: Verify sorting of Program status in Descending order
    When Admin clicks on Arrow next to program status of Program module page for sor descend
    Then Admin See the Program status is sorted Descending order in Program module page
