Feature: Sort Class details
 Background: Admin Is on the Dashboard page after login
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    
    @Verifydescendingordersortfunction
Scenario: Verify sort function in data table for descending order
When Admin click on Batch id column header to sort
Then Admin should see data table sorted in descending order

@Verifysascendingordersortfunction
Scenario: Verify sort function in data table for ascending order
When Admin double click on Batch id column header to sort
Then Admin should see data table sorted in ascending  order
    
