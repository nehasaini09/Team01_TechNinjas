Feature: Sort Class details
Background: Admin is on the Manage Class page after login
Given Admin is on the Manage class page

Scenario: Sort Class by Batch name
When Admin clicks on the Batchname sort icon
Then Admin should see Class details are sorted by Batch Name

Scenario: Sort Class by Class topic
When Admin clicks on the Class topic sort icon
Then Admin should see Class details are sorted by Class topic

Scenario: Sort Class by Class description
When Admin clicks on the Class description sort icon
Then Admin should see Class details are sorted by Class description

Scenario: Sort Class by Status
When Admin clicks on the Status sort icon
Then Admin should see Class details are sorted by Status

Scenario: Sort Class by Class date
When Admin clicks on the Class date sort icon
Then Admin should see Class details are sorted by Class date

Scenario: Sort Class by Staff name
When Admin clicks on the Staff name sort icon
Then Admin should see Class details are sorted by Staff name
