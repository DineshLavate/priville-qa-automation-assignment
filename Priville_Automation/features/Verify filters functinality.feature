#Feature Analysis: Filter Functionality for Pool & Beach
#Feature Being Tested: Ensures "Pool & Beach" filter is selected by default.
#Validates accurate filtering, dynamic venue count updates, and filter reset functionality.
#Expected Outcome: Default filter selection is applied correctly. Search results match the filter window count. Venue count updates dynamically when filters change.
#Clearing filters resets results to default.
#Setup & Teardown:
#Setup: Launch browser, navigate to Privilee, verify initial filters.
#Teardown: Confirm filter reset, validate results, close session.
 
#Why This Test is Important: Ensures filter accuracy & consistency. Prevents misleading venue counts.
#Verifies smooth user navigation & experience.
#Supports robust test automation & data integrity.



Feature: Verify the filter functionality


Scenario: Verify the filter functionality for Pool & Beach
    When the user opens the browser
    And the user navigates to the Privilee application and opens the Map page
    Then the user should be on the Map page
    And the "Pool & Beach" filter button should be selected by default  
    And the user should see filtered results on the Map page
    When the user clicks on the "Filters" button on the Map page  
    Then the "Filter Your Search" window should be displayed  
    And the results on the Map page should match the count displayed in "Filter Your Search" on "show venue" button  
    When the user selects any location
    Then the count on the "Show Venue" button should update dynamically
    When the user clicks on the "Show Venue" button  
    Then the count in "Filter Your Search" should match the number of results on the Map page  
    When the user clicks on the "Filters" button on the Map page  
    And the user clicks on the "Clear Filters" button in "Filter Your Search"  
    And the results on the Map page should match the count displayed in "Filter Your Search" on "show venue" button  
    
    

    

    
    
    
    