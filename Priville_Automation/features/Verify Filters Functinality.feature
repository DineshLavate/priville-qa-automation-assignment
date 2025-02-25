Feature: Verify the filter functionality


Scenario: Verify the filter functionality for pool & beach
    When User opens the Browser
    And User Enter Priville Application URL and navigate to Map page
    Then Verify user is on Map Page
    Then Verify pool and beach button is by default selected
    And Verify user able to see the filtered result on map page
    Then User click on Filters button on map page
    Then Verify user able to see Filter your Serch window
    And Verify map page result and the count avialable on Filter your search should be same
    And user select any Location
    Then Verify the count on show venue button is variable
    And user click on show venue button
    Then Verify the Filter your search count and Map page result count should be same
    Then User click on Filters button on map page
    And User click on Clear filters button on filter your search page
    And Verify map page result and the count avialable on Filter your search should be same
    
    
Scenario:  Verify the filter functinality for Dinning with multiple filter selection
    When User opens the Browser
    And User Enter Priville Application URL and navigate to Map page
    Then Verify user is on Map Page
    Then Verify pool and beach button is by default selected
    Then User click on Dining button
    Then User click on Filters button on map page
    And user select any Location
    And User select "35% off" as discount
    And user click on show venue button
    And Verify user able to see the filtered result on map page
    And User check the discount percentage for a particular hotel 
    Then Verify user able to select one hotel from serch result 
    Then User enter the firstname on Explore Privilee venue window
    And User enter the email on Explore Privilee venue window
    Then User select the country code "+91" from country dropdown
    And User enter the Phone Number on Explore Privilee venue window
    And User click on View button
    And Verify user can able to see all the images of selected hotel on hotel window
    Then verify the discount percentage on map page and hotel window should be same
    And Verify the opening hours on hotel window
    And Verify the quotes message of hotel
    And Verify the discount is available for which type of user
    

    
    
    
    