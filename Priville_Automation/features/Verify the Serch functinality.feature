Feature: Verify the Search functionality

Scenario: Verify the filter functionality for pool & beach
    When User opens the Browser
    And User Enter Priville Application URL and navigate to Map page
    Then Verify user is on Map Page
    And User Enter the "PLAYA Dubai" as venue on search bar
    Then Verify the dropdown will show the serch result on top and others are downside
    Then User select the venue
    Then User enter the firstname on Explore Privilee venue window
    And User enter the email on Explore Privilee venue window
    Then User select the country code "+91" from country dropdown
    And User enter the Phone Number on Explore Privilee venue window
    And User click on View button
    Then Validate user is on right venue
    
    