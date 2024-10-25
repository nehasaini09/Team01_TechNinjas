Feature: Batch Page Navigation and Validation

  Background: 
       Given Admin is logged into the LMS portal and on the dashboard page
   # And Admin navigates to the 'Batch' page from the navigation bar clicking "Batch icon"

  Scenario Outline: Validate Batch Page elements
    When Admin clicks on the Batch menu from the header
    Then Admin should see the "<Element>" in the Batch Page

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
			| pagination frame                                 |
			| Footer                                            |
  