#Feature being tested: This feature validates the functionality of the Family Activities filter.
#Expected outcome: The data displayed on the UI should be filtered based on the selected filter option, and the response from the API should match the UI data within the expected time.
#Setup or teardown procedures for automation: The PageBase class contains methods for browser initialization, and Cucumber hooks are used to handle browser teardown.
#Importance of this test: Ensuring the filter functionality works correctly is crucial, as stakeholders rely on it to search for venues based on their preferences.

Feature: Filter Functionality for Family Activities

Scenario: Verify user can filter data based on Family Activities
    When the user opens the browser
    And the user navigates to the Privilee application and opens the Map page
    Then the user should be on the Map page
    And the user clicks on the "Family Activities" filter button
    And the user counts the number of filtered results
    Then verify the result count via API and validate the time taken to load the search results
    
    
    