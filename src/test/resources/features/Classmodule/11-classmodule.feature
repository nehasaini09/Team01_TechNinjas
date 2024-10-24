Feature: Navigation Validation from Manage Class to other Pages
Background: Admin is on dashboard page after Login and clicks Class on the navigation bar
Given Admin is on Manage Class page

Scenario: Class link on navigation bar
When Admin clicks on Class link on Manage Class page
Then Admin is re-directed to class page

Scenario: Class link to other module on navigation bar
When Admin clicks on any module link on Manage Class page
Then Admin is re-directed to which module link they clicked.

Scenario: Logout link on navigation bar
When Admin clicks on Logout link on Manage class page
Then Admin is re-directed to Login page