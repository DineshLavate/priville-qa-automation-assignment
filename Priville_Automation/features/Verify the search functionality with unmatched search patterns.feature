#Feature Analysis: Filter Functionality for Family Activities
#Feature Being Tested: Verifies the behavior of the search functionality with unmatched search patterns. Ensures correct display of "No Results Found" when invalid or non-existent venues are searched.
#Expected Outcome: "No Results Found" is displayed when searching "Dhow & Lagoon Kitchen" or "@$D89".
#Setup & Teardown:
#Setup: Open browser, navigate to Privilee, open the Map page, and apply the "Family Activities" filter.
#Teardown: Validate "No Results Found" display for both search attempts.
#Why This Test is Important: Ensures the system handles unmatched search queries properly. Improves user experience by providing clear feedback when no results are found.


Feature: Verify the Filter functionality based on Search Criteria


Scenario: Verify the serch functinality with unmatched serch pattern
    When the user opens the browser
    And the user navigates to the Privilee application and opens the Map page
    Then the user should be on the Map page
    And the user clicks on the "Family Activities" filter button on Map page
    And User Enter the "Dhow & Lagoon Kitchen" as venue on search bar
    Then the user should see "No Results Found" displayed below the search box
    And User Enter the "@$D89" as venue on search bar
    Then the user should see "No Results Found" displayed below the search box
    
    
    
    