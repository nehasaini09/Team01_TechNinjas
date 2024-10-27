Feature: Class Page Validation and Add new class

  Background: Admin Is on the Dashboard page after login
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header

  Scenario Outline: Validating the headers in the class page
    Then Admin should see the headers heading like "<headers>"

    Examples: 
      | headers                          |
      | LMS - Learning Management System |
      | Manage Class                     |
      | Batch Name                       |
      | Class Topic                      |
      | Class Description                |
      | Status                           |
      | Class Date                       |
      | Staff Name                       |

  Scenario: Validating the text and pagination icon in the classpage
    Then Admin should see the showing entries and enabled pagination controls under the data table

  Scenario: Validate the sort icon of all the field in datatable
    Then Admin should see the Sort icon of all the field in the datatable.

  Scenario: Validating the Delete button under the Manage class
    Then Admin should see the Delete button under the Manage class page header

  Scenario: Validate the total no of classes in manage class page
    Then Admin should see Total no of classes in below of the data table

  #Add new class popup window
  Scenario: Validate Class Details Popup window
    When clicks add new class under the class menu bar
    Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window

  Scenario: Validate input fields and their text boxes in Class details form
    When clicks add new class under the class menu bar
    Then Admin should see few input fields and their respective text boxes in the class details window

  Scenario Outline: Check if class is created when only mandatory fields are entered with valid data
    Given clicks add new class under the class menu bar
    When Admin enters mandatory fields "<BatchName>" "<ClassTopic>" "<ClassDescription>" "<month>" "<date1>" "<date2>" "<StaffName>" "<Status>" "<SuccessMsg>" in the form and clicks on save button
    Then Admin gets message Class added Successfully

    Examples: 
      | BatchName |  | ClassTopic |  | ClassDescription |  | month    |  | date1 |  | date2 |  | StaffName |               | Status |          | SuccessMsg |              |
      | SMPO10    |  | Java       |  | Core Java        |  | November |  |    15 |  |    20 |  | Sarnaya   |               | Active |          | Successful |              |
      | SMPO2     |  | @@         |  | %^U^**&          |  |          |  |       |  |       |  |           | Geetha Thakur |        | Inactive |            | Unsuccessful |

  Scenario Outline: Check no classes value added when selecting class dates
    Given clicks add new class under the class menu bar
    When Admin selects class "<month>" "<date1>" "<date2>" in date picker
    Then Admin should see no of class value is added automatically
     Examples: 
    |month||date1||date2|
    |December||26||31|

  Scenario Outline: Check if class is created when only optional fields are entered with valid data
    Given clicks add new class under the class menu bar
    When Admin skips to add value in mandatory field and enter only the optional field "<comments>" "<notes>" "<recording>"
    Then Admin should see error message below the test field and the field will be highlighed in red color "<batchNameReqText>" "<classTopicReqText>" "<classDateReqText>" "<staffNameReqText>" "<noOfClassesReqText>"

    Examples: 
      | comments |  | notes      |  | recording |  | batchNameReqText        | classTopicReqText        | classDateReqText        | staffNameReqText        | noOfClassesReqText          |
      | Good     |  | java notes |  | goto link |  | Batch Name is required. | Class Topic is required. | Class Date is required. | Staff Name is required. | No. of Classes is required. |

  Scenario Outline: Empty form submission
    Given clicks add new class under the class menu bar
    When Admin clicks on save button without entering data
    Then Admin should see error message below the test field and the field will be highlighed in red color "<batchNameReqText>" "<classTopicReqText>" "<classDateReqText>" "<staffNameReqText>" "<noOfClassesReqText>"

    Examples: 
      | batchNameReqText        | classTopicReqText        | classDateReqText        | staffNameReqText        | noOfClassesReqText          |
      | Batch Name is required. | Class Topic is required. | Class Date is required. | Staff Name is required. | No. of Classes is required. |

  Scenario: Validate Cancel/Close(X) icon on class Details form
    Given clicks add new class under the class menu bar
    When Admin clicks Cancel Icon on class Details form
    Then Class Details popup window should be closed without saving

  # Edit class details
  Scenario: Validate row level edit icon
    When Admin clicks on the edit icon
    Then A new pop up with class details appears

  Scenario: Check disabled  batch name
    When Admin clicks on the edit icon
    Then Admin should see batch name field is disabled

  Scenario: Check disabled class topic
    When Admin clicks on the edit icon
    Then Admin should see class topic field is disabled

  Scenario Outline: Check if the fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Update the fields with valid data "<Class>" and click save
    Then Admin gets message "Successful" and see the updated values in data table

    Examples: 
      | Class |
      | Java  |

  Scenario Outline: Check if the optional fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Update the optional fields with valid values "<comments>" "<notes>" "<recording>" and click save
    Then Admin gets message "Successful" and see the updated values in data table

    Examples: 
      | comments |  | notes      |  | recording |
      | Good     |  | java notes |  | goto link |

  Scenario: Validate Cancel button on Edit popup
    Given Admin is on the Edit Class Popup window
    When Admin clicks Cancel button on edit popup
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class

  # Delete/multiple deletion
  Scenario: Admin checks Succes delete operation with single class delete
    When Admin clicks on the delete icon on class module page
    Then Admin able to delete by clicking yes to confirmation pop up

  Scenario: Admin checks delete operation unsucces with single program delete
    When Admin clicks on the delete icon on class module page
    Then Admin able to delete by clicking No to confirmation pop up

  Scenario: Admin validate delete by deleting multiple programs
    When Admin clicks on the multiple checkboxes on class module page
    And Admin clicks  on the left delete button on class module page
    Then Admin able to delete multiple class by clicking yes to confirm
    
    # Search box validation
    Scenario Outline: Search class by Batch Name
When Admin enter the "<field>" "<value>" in search textbox
Then Admin should see Class details are searched by given fields
Examples: 
|field||value|
|Batch Name||Micro service-01|
|Class Topic||Java|
|Staff Name||Getha Takur|
