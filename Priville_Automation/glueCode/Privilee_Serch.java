package glueCode;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Then;
import pageObjects.Priville_PageObjects;
import testBase.TestBase;

public class Privilee_Serch {

	public static String Venue;
	
	@Then("User Enter the {string} as venue on search bar")
	public void user_Enter_the_as_venue_on_search_bar(String venue) throws Exception {
	   
		Venue=venue;
		
		TestBase.waitForElement(Priville_PageObjects.serchbox, 10);
        TestBase.typeinTextBox(Priville_PageObjects.serchbox, Venue, "serch box field");
        
	}

	@Then("User select the venue")
	public void user_select_the_venue() throws Exception {
	    
		TestBase.waitForElement(Priville_PageObjects.FirstsearchResult, 10);
        TestBase.clickonElement(Priville_PageObjects.FirstsearchResult, "First result Dropdwon");
        
	}

	@Then("Verify User is on hotel window")
	public void verify_User_is_on_hotel_window() throws Exception {

		TestBase.waitForElement(Priville_PageObjects.Hotelmodelwindow, 10);
        boolean isonmodelwindow =TestBase.isElementVisible(Priville_PageObjects.Hotelmodelwindow, "model window");
	    
        if(isonmodelwindow==true) {
        	System.out.println("User is on Hotel model window");
        }
	}
	
	@Then("Verify the dropdown will show the serch result on top and others are downside")
	public void verify_the_dropdown_will_show_the_serch_result_on_top_and_others_are_downside() throws Exception {
	   
		TestBase.waitForElement(Priville_PageObjects.FirstsearchResult, 10);
		String FirstVenue = TestBase.getElementText(Priville_PageObjects.FirstsearchResult, "First search result");
        
        assertEquals("Values do match!", FirstVenue, Venue);


	}
	@Then("Validate user is on right venue")
	public void validate_user_is_on_right_venue() throws Exception {
	    
		TestBase.waitForElement(Priville_PageObjects.venuenameelement, 10);
		String VenueNameonModelwindow = TestBase.getElementText(Priville_PageObjects.venuenameelement, "Venue name on model window");
        
        assertEquals("Values do match!", VenueNameonModelwindow, Venue);

	}
	
	@Then("User click on Family Activities button")
	public void user_click_on_Family_Activities_button() throws Exception {
	    
		// validating the button is working properly functionality 
		TestBase.waitForElement(Priville_PageObjects.FamilyActivitiesbutton, 10);
		TestBase.clickonElement(Priville_PageObjects.FamilyActivitiesbutton, "Family activities button");
	}

	
}
