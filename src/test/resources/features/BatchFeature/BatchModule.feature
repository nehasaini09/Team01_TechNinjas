Feature: Batch Page Navigation and Validation

  Background: 
       Given Admin is logged into the LMS portal and on the dashboard page
    #And Admin navigates to the 'Batch' page from the navigation bar clicking "Batch icon"

  Scenario Outline: Validate Batch Page elements
    When Admin clicks on the Batch menu from the header
 
   Then  Admin should see the "<Element>" in the Batch Page

    Examples:
      | Element                                          |
      | LMS - Learning Management System                 |
      #| Manage Batch                                     |
      #| disabled Delete Icon under the header            |
      #| enabled pagination controls under the data table |
      #| edit icon in each data row                       |
      #| delete icon in each data row                     |
      #| checkbox in each data row                        |
      #| datatable headers: Batch name, Batch Description, Batch Status, No Of classes, Program Name, Edit/Delete |
      #| checkbox in the datatable header row             |
      #| sort icon next to all datatable headers          |
#		
#	  Scenario Outline: Add New Batch
    #When Admin clicks on "Add New Batch" under the Batch menu bar
    #Then Admin should see the Batch Details pop-up window should include the fields "<field>"
  #
    #Examples:
      #| field                               |
      #| Batch Name                          |
      #| Number of classes                   |
      #| Description as text box             |
      #| Program Name as drop down           |
      #| Status as radio button              |
      #|Save Button												  |
      #|Cancel Button												|
      #| close                               |
      #
      #
  #Scenario: Validate batch name field and dropdown
  #
     #When Admin selects program name present in the dropdown
     #Then Admin should see the selected program name in the batch name prefix box
   #
     #Scenario Outline: Validate batch name input restrictions
    #When Admin enters <input> in the batch name suffix box
    #Then Admin should get an <expected_message>
#
    #Examples:
      #|input | expected_message                               |
      #|A      |This field accept only numbers and max 5 count.|                                
      #|12     |    (no message)                               |
      #|12345  |        (no message)                           |
      #|123456 |This field accept only numbers and max 5 count.|
      #|abcdef |This field accept only numbers and max 5 count.|
     
   #  Scenario: Validation of Edit icon
   #  Given Admin is on the Batch page
   # When Admin clicks the edit icon for any batch 
   # Then Admin should see the Batch details pop-up window with program name and Batch name field disabled
    
   # Scenario Outline: Validation of Delete icon
  #  When Admin clicks the Delete icon for any batch 
  #  Then Admin should see the confirm alert box with yes and no button
   
  #  When Admin clicks the "<action>" button on the confirm alert box
  #  Then Admin should <outcome_message>

#    Examples:
  #    | action |        outcome_message                                    |
 #     | yes    |  see a successful message and the batch should be deleted |
  #    | no     |   see the alert box closed and the batch is not deleted |
   #   | close  |  see the alert box closed                           |
    

  Scenario: Validate single row delete with checkbox
    When Admin  clicks the delete icon by selecting the checkbox for a specific batch 
    Then The respective row in the table should be deleted

  Scenario: Validate multiple row delete with checkboxes
    When Admin clicks the delete icon under the Manage Batch header by selecting the checkboxes for multiple batches
    Then The respective rows in the table should be deleted
    
  
    