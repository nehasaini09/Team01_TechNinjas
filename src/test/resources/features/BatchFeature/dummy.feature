  
  Feature:dummy
  
    Background: 
       Given Admin is logged into the LMS portal and on the dashboard pageScenario: Validate single row delete with checkbox
   
       
     Scenario: Validate batch name prefix 
    Given Admin is on the Batch Details Pop Up Window
    When  Admin should see selected program name in the batch name prefix box by selecting program name from dropdown 
    And   Admin enters alphabets in batch name prefix box
    Then Admin should get an error message below the text box of the respective field

  Scenario: Validate input data only for mandatory fields
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters the data only to the mandatory fields and clicks save button
    Then Admin should get a successful message

  Scenario: Validate input data missing for mandatory fields
    Given Admin is on the Batch Details Pop Up Window
    When Admin leaves blank one of the mandatory fields
    Then Admin should get an error message on the respective mandatory field


  Scenario: Validate cancel button in Batch details pop up
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters valid data into all the mandatory fields and clicks cancel button
    Then Admin can see the batch details popup closes without creating any batch

  Scenario: Validate close icon on the batch details pop up
    Given Admin is on the Batch Details Pop Up Window
    When Admin clicks on the close icon
    Then the batch details pop up closes

     Scenario Outline: Validation of Delete icon
    When Admin clicks the Delete icon for any batch 
    Then Admin should see the confirm alert box with yes and no button
   
    When Admin clicks the "<action>" button on the confirm alert box
    Then Admin should <outcome_message>

    Examples:
      | action |        outcome_message                                    |
      | yes    |  see a successful message and the batch should be deleted |
      | no     |   see the alert box closed and the batch is not deleted |
      | close  |  see the alert box closed                           |