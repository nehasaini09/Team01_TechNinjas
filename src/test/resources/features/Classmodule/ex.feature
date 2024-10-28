Feature: logugut page
Background: Admin Is on the Dashboard page after login
    Given Admin is on the dashboard page after login
     When Admin clicks the Class Navigation bar in the Header
     
  Scenario Outline: Check if class is created when only mandatory fields are entered with valid data
    Given clicks add new class under the class menu bar
    When Admin enters mandatory fields "<BatchName>" "<ClassTopic>" "<ClassDescription>" "<month>" "<date1>" "<date2>" "<StaffName>" "<Status>" "<SuccessMsg>" in the form and clicks on save button
    Then Admin gets message Class added Successfully

    Examples: 
      | BatchName |  | ClassTopic |  | ClassDescription |  | month    |  | date1 |  | date2 |  | StaffName |   | Status ||SuccessMsg |             
      | SMPO10    |  | Java       |  | Core Java        |  | November |  |    15 |  |    20 |  | Sarnaya   |   | Active || Successful |            
      | SMPO2     |  | @@         |  | %^U^**&          |  | December |  |   26  |  |   31    |  | Geetha Thakur|| Inactive || Unsuccessful |
    