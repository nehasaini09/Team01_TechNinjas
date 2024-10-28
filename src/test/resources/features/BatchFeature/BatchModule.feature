Feature: Batch Page Navigation and Validation

  Background: 
       Given Admin is logged into the LMS portal and on the dashboard page
   # And Admin navigates to the 'Batch' page from the navigation bar clicking "Batch icon"

  Scenario Outline: Validate Batch Page elements
    When Admin clicks on the Batch menu from the header
 
   Then  Admin should see the "<Element>" in the Batch Page

    Examples:
      | Element                                          |
      | LMS - Learning Management System                 |
      | Manage Batch                                     |
      | disabled Delete Icon under the header            |
      | enabled pagination controls under the data table |
      | edit icon in each data row                       |
      | delete icon in each data row                     |
      | checkbox in each data row                        |
      | datatable headers: Batch name, Batch Description, Batch Status, No Of classes, Program Name, Edit/Delete |
      | checkbox in the datatable header row             |
      | sort icon next to all datatable headers          |
		
	  Scenario Outline: Add New Batch icon  and popup label validation 
    When Admin clicks on "Add New Batch" under the Batch menu bar
    Then Admin should see the Batch Details pop-up window should include the fields "<label>"
  
    Examples:
      | label                              |
      | Batch Name                          |
      | Number of classes                   |
      | Description as text box             |
      | Program Name as drop down           |
      | Status as radio button              |
      |Save Button												  |
      |Cancel Button												|
      | close                               |
      
  Scenario: Validate batch name field and dropdown
  
     When Admin selects program name present in the dropdown
     Then Admin should see the selected program name in the batch name prefix box
  
 Scenario: Validate error messages when leaving mandatory fields blank
    When Admin leaves one mandatory field blank and clicks the save button
    Then Admin should see a error message "Error message should be displayed under the description field"
    And Admin should see a error message "Error message should be displayed under the number of classes field"

  Scenario: Save a new batch with valid mandatory fields
    When Admin enters valid data in all mandatory fields and clicks the save button
    Then Admin should see a successful message "Batch created successfully"

  Scenario: Cancel batch creation with valid data entered in mandatory fields
    When Admin enters valid data in all mandatory fields and clicks the cancel button
    Then Admin should see the Batch Details pop-up closes without creating any batch
   
    Scenario Outline: Validate batch name input restrictions
    When Admin enters <input> in the batch name suffix box
    Then Admin should get an <expected_message>

    Examples:
      |input | expected_message                               |
      |A      |This field accept only numbers and max 5 count.|                                
      |123456 |This field accept only numbers and max 5 count.|
   
     
  
    Scenario: Validate Edit icon feature
    When Admin should see the Batch details pop-up window by clicking the edit icon for any batch
    Then Admin should see the Program name field  and batchname prefix field disabled for editing
    When Admin updates the description and No. of classes fields with and clicks the save button
    Then Admin should get  message batch updated
    When Admin enters data clicks the cancel button
    Then Admin should see the Batch Details pop-up closes without editing the batch
    
    
    When Admin enters valid data in all mandatory fields and clicks the save button
    Then Admin should get a successful message for editing the batch

  Scenario: Validate cancel button in Batch Details pop-up
    Given Admin is on the Batch Details pop-up window
   

  Scenario: Validate single row delete 
    When Admin  clicks the delete icon by selecting the checkbox for a specific batch
    Then The respective row in the table should be deleted
    
    
     Scenario: Validation of No in Delete
    When Admin clicks on the delete icon on  batch page
    Then Admin should not be able to delete  the batch by clicking No to to go back the batch page

  Scenario: Validate multiple row delete with checkboxes
    When Admin clicks the delete icon under the Manage Batch header by selecting the checkboxes for multiple batches
    Then The respective rows in the table should be deleted
    
  Scenario Outline: Validate pagination links
    When Admin clicks the <pageLink> link on the data table
    Then Admin should see the <pageLink> results on the data table

  Examples:
      | pageLink   | results                  |
      | Next       | Next enabled link        |
      | Last       | last page link with Next disabled |
      | Previous   | previous page            |
      | First      | very first page          |
    
   Scenario: Search Text Box Validation  
   When Admin enters the java in the search text box
  Then Admin should see the filtered batches in the data table
  