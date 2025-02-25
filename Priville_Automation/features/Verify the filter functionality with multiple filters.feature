#Feature Analysis: Dining Filter with Multiple Selections
#Feature Being Tested: Ensures Dining filter applies correctly with additional filters (e.g., 35% off discount).
#Validates that filtered results match expected counts. Confirms discount details and venue-specific information are accurate.
#Expected Outcome: Dining filter applies correctly and updates results.
#Discount percentage remains consistent across the map page and hotel window. User form submission (name, email, phone) works as expected. Venue details (images, hours, quotes, discount eligibility) display correctly.
 
#Setup & Teardown:
#Setup: Launch browser, navigate to Privilee, ensure Map Page loads properly.
#Teardown: Clear filters, verify form submission, close browser.
 
#Importance of This Test: Ensures correct filter behavior and accurate venue details.
#Prevents mismatched discount info and incorrect search results.
#Improves app reliability by verifying data consistency across pages.

Feature: Verify the filter functionality


Scenario:  Verify the filter functionality for Dining with multiple filter selections
    When the user opens the browser
    And the user navigates to the Privilee application and opens the Map page
    Then the user should be on the Map page
    And the "Pool & Beach" filter button should be selected by default  
    When the user clicks on the "Dining" button on map page
    When the user clicks on the "Filters" button on the Map page  
    When the user selects any location
    And User select "35% off" as discount
    When the user clicks on the "Show Venue" button  
    And the user should see filtered results on the Map page
    And the user verifies the discount percentage for a particular hotel  
    When the user selects a hotel from the search results  
    Then the user will navigate to Explore Privilee venues window
    And enters the first name in the "Explore Privilee Venue" window  
    And enters the email in the "Explore Privilee Venue" window  
    And selects the country code "+91" from the dropdown  
    And enters the phone number in the "Explore Privilee Venue" window 
    And clicks on the "View" button  
    Then the user should be able to see all images of the selected hotel on the hotel window  
    And the discount percentage on the Map page and the hotel window should match  
    And the user verifies the opening hours on the hotel window  
    And checks the hotel's quote message  
    And verifies the discount eligibility based on the user type
    Then verify the discount available for the selected venue via API and validate the discount percentage     
    Then user close the hotel model window