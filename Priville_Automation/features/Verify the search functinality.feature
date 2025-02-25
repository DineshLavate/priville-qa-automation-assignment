#Feature Analysis: Search Functionality for Pool & Beach
#Feature Being Tested: Verifies search bar functionality with "PLAYA Dubai". Ensures correct dropdown behavior and venue selection. Validates user navigation to the correct venue page.
#Expected Outcome: Search results show "PLAYA Dubai" at the top. Correct venue details displayed after user selection and input.
#Setup & Teardown:
#Setup: Open browser, navigate to Privilee, search "PLAYA Dubai".
#Teardown: Validate venue and user submission. 
#Why This Test is Important: Ensures accurate search and correct venue navigation.



Feature: Verify the Search functionality

Scenario: Verify the Serch functionality of serch box
    When the user opens the browser
    And the user navigates to the Privilee application and opens the Map page
    Then the user should be on the Map page
    And User Enter the "PLAYA Dubai" as venue on search bar
    Then Verify the dropdown will show the serch result on top and others are downside
    Then User select the venue
    Then the user will navigate to Explore Privilee venues window
    And enters the first name in the "Explore Privilee Venue" window  
    And enters the email in the "Explore Privilee Venue" window  
    And selects the country code "+91" from the dropdown  
    And enters the phone number in the "Explore Privilee Venue" window 
    And clicks on the "View" button
    Then verify that the user is on the correct venue
    
    