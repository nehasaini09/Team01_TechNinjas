Feature: logugut page
Background: Admin Is on the Dashboard page after login
    Given Admin is on the dashboard page after login
     When Admin clicks the Class Navigation bar in the Header
     
  #Scenario: Weenkend dates are disabled
# Given clicks add new class under the class menu bar
#When Admin clicks on weekend date
#Then Admin should see it is disabled

  Scenario Outline: Search class by Batch Name
When Admin enter the "<field>" "<value>" in search textbox
Then Admin should see Class details are searched by given fields
Examples: 
|field||value|
|Batch Name||Micro service-01|
|Class Topic||Java|
|Staff Name||Getha Takur|