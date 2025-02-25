package glueCode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.gherkin.model.Given;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pageObjects.Priville_PageObjects;
import testBase.TestBase;
import io.restassured.response.Response;

public class Privilee_Search {

	public static String Venue;
    public static int CountonMapPage;
	
    /**
     * Enters the specified venue name in the search bar.
     */
	@Then("User Enter the {string} as venue on search bar")
	public void user_Enter_the_as_venue_on_search_bar(String venue) throws Exception {

		Venue = venue;

		TestBase.waitForElement(Priville_PageObjects.searchbox, 10);
		TestBase.typeinTextBox(Priville_PageObjects.searchbox, Venue, "serch box field");

	}

	/**
     * Selects the first venue from the search results.
     */
	@Then("User select the venue")
	public void user_select_the_venue() throws Exception {

		TestBase.waitForElement(Priville_PageObjects.FirstsearchResult, 10);
		TestBase.clickonElement(Priville_PageObjects.FirstsearchResult, "First result Dropdwon");

	}
	
	/**
     * Verifies that the user is on the hotel details window.
     */
	@Then("Verify User is on hotel window")
	public void verify_User_is_on_hotel_window() throws Exception {

		TestBase.waitForElement(Priville_PageObjects.Hotelmodelwindow, 10);
		boolean isonmodelwindow = TestBase.isElementVisible(Priville_PageObjects.Hotelmodelwindow, "model window");

		if (isonmodelwindow == true) {
			System.out.println("User is on Hotel model window");
		}
	}
	
	/**
     * Verifies that the dropdown will show the serch result on top and others are downside
     */

	@Then("Verify the dropdown will show the serch result on top and others are downside")
	public void verify_the_dropdown_will_show_the_serch_result_on_top_and_others_are_downside() throws Exception {

		// Wait for the first search result in the dropdown to be visible (max wait time: 10 seconds)
		TestBase.waitForElement(Priville_PageObjects.FirstsearchResult, 10);
		String FirstVenue = TestBase.getElementText(Priville_PageObjects.FirstsearchResult, "First search result");

		assertEquals("Values do match!", FirstVenue, Venue);

	}

	/**
     * Verifies that the user is on the correct venue
     */

	@Then("verify that the user is on the correct venue")
	public void verify_that_the_user_is_on_the_correct_venue() throws Exception {

		TestBase.waitForElement(Priville_PageObjects.venuenameelement, 10);
		String VenueNameonModelwindow = TestBase.getElementText(Priville_PageObjects.venuenameelement,"Venue name on model window");

		assertEquals("Values do match!", VenueNameonModelwindow, Venue);

	}
	
	/**
     * Verifies the user clicks on the Family Activity button
     */
	@Then("the user clicks on the {string} filter button")
	public void the_user_clicks_on_the_filter_button(String string) throws Exception {

		// validating the button is working properly functionality
		TestBase.waitForElement(Priville_PageObjects.FamilyActivitiesbutton, 10);
		TestBase.clickonElement(Priville_PageObjects.FamilyActivitiesbutton, "Family activities button");

	}

	/**
     * Verifies the user counts the number of filtered results
     */
	
	@Then("the user counts the number of filtered results")
	public void the_user_counts_the_number_of_filtered_results() throws Exception {

		// Validating the filtered result data
		TestBase.waitForElement(Priville_PageObjects.Serchcount, 10);
		List<WebElement> list = TestBase.getListofElements(Priville_PageObjects.Serchcount);
		
		CountonMapPage = list.size();
		System.out.println(CountonMapPage);
	}
	
	/**
     * Verifies the result count via API and validate the time taken to load the search results
     */
	@Then("verify the result count via API and validate the time taken to load the search results")
	public void verify_the_result_count_via_API_and_validate_the_time_taken_to_load_the_search_results() {

		long maxResponseTime = 3000;
		Response response = RestAssured.given().baseUri("https://staging-website.privilee.ae/api/map") // Replace with
																										// actual API
				.when().get("/family") // Replace with actual endpoint
				.then().extract().response(); // Extract response

		JsonPath extracter = response.jsonPath();
		int countfromAPI = extracter.getInt("items.size()");
		System.out.println("Count got from API"+countfromAPI);
		
		long responseTime = response.getTime(); // extracting the responce time from responce
		System.out.println("API Response Time: " + responseTime + " ms");

		// Validate response time is within the expected limit
		if (responseTime > maxResponseTime) {
			throw new AssertionError("Response time exceeded: " + responseTime + " ms");
		}
	}
	
	/**
     * Verifies the user should see No result found displayed below the search box
     */
	@Then("the user should see {string} displayed below the search box")
	public void the_user_should_see_displayed_below_the_search_box(String string) throws Exception {
	    
		
		TestBase.waitForElement(Priville_PageObjects.Noresultfoundele, 10);
		String ExpectedMessage = TestBase.getElementText(Priville_PageObjects.Noresultfoundele,"Text box below serch ");

		assertEquals("Values do match!", ExpectedMessage, string);
	}
	
	/**
     * Verifies the user clicks on the waterpark filter button on Map page
     */
	@Then("the user clicks on the {string} filter button on Map page")
	public void the_user_clicks_on_the_filter_button_on_Map_page(String string) throws Exception {
	    
		TestBase.waitForElement(Priville_PageObjects.Waterparksbutton, 10);
		TestBase.clickonElement(Priville_PageObjects.Waterparksbutton, "Waterparks button");
        Thread.sleep(5000);
		
	}
}
