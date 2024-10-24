Feature: Class Page Validation
 Background: Admin Is on the Dashboard page after login
 Given Admin is on the dashboard page after login
 When Admin clicks the Class Navigation bar in the Header
 
  Scenario: Validating the Title in the Manage class page 
    Then Admin should see the "LMS-Learning Management System" Title
    
    Scenario: Validating the Header in the Manage class page
    Then Admin should see the "Manage Class" Header
    
    Scenario: Admin should see the "Manage Class" Header
    Then Admin should see the "Manage Class" Header
    
    Scenario: Validating the data table headers in the class page
    Then Admin should see the datatable heading like Batchname,class topic,class descrption,status,class Date,staff name,Edit/Delete
    
    Scenario: Validating the text and pagination icon in the classpage
    Then Admin should see the " showing x to y of  z entries" and enabled pagination controls under the data table
    
    Scenario: Validate the sort icon of all the field in datatable
    Then Admin should see the Sort icon of all the field in the datatable.
    
    Scenario: Validating the Delete button under the Manage class 
    Then Admin should see the Delete button under the Manage class page header
    
    Scenario: Validate the total no of classes in manage class page
    Then Admin should see Total no of classes in below of the data table
    