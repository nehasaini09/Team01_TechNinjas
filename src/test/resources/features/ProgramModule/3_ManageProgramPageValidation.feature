Feature: Manage Program Page validation

  #These all steps are from login Module
Background: Admin is logged in to LMS Portal
Given Admin is in login Page
When Admin enter valid credentials  and clicks login button through keyboard
Then Admin should land on dashboard page

  #This step is common in class module Given Admin is on dashboard page after Login
  #1
Scenario: Verify heading in manage program
    #Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see the heading  "Manage Program" for each program
    
   #2 
Scenario: Verify view details of programs
    #Given Admin is on dashboard page after Login
   When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should able to see Program name, description, and status for each program
  
  #3  
Scenario: Verify the Multiple Delete button state 
    #Given Admin is on dashboard page after Login
   When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see a Delete button in left top is disabled
 
  #4  
Scenario: Verify the Search button  
    #Given Admin is on dashboard page after Login
   When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see Search bar with text as "Search..."
 
 #5   
#Scenario: Verify column header name of data table  
    #Given Admin is on dashboard page after Login
  # When  Admin clicks "Program" on the navigation bar in program module
    #Then Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit/Delete
 
 #6   
Scenario: Verify checkbox default state beside Program Name column header
   # Given Admin is on dashboard page after Login
   When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see checkbox default state as unchecked beside Program Name column header
 #7    
Scenario: Verify checkboxes default state beside each Program names in the data table
   # Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see check box default state as unchecked on the left side in all rows against program name 
 
 #8   
Scenario: Verify Sort icon in manage program
    #Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete 
 #9    
Scenario: Verify edit and delete icon in manage program
    #Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see the Edit and Delete buttons on each row of the data table 
 #10    
Scenario: Verify pagination icons below data table in manage program
   # Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table.
#11     
Scenario: Verify footer message in manage program
    #Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see the footer as "In total there are z programs".
    


    
    
    