package glueCode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.gson.JsonObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pageObjects.Priville_PageObjects;
import testBase.TestBase;
import testBase.PageBase;
import utility.Utils;

public class Privilee_GlueCode {

	public static int Resultcount1;
	public static int Resultcount2;
	public static int ActualcountafterAddingfilter;
	public static String Discount;
	public static String discountonhotelwindow;
	
	@When("the user opens the browser")
	public void the_user_opens_the_browser() {
		
		// User Is opening the by passing browser as property from config.proprties file the value of browser is Chrome
		
		PageBase.OpenBrowser("Browser"); 
	
	}

	@When("the user navigates to the Privilee application and opens the Map page")
	public void the_user_navigates_to_the_Privilee_application_and_opens_the_Map_page() throws InterruptedException {
		
		//We have mentions some static wait by using thred.sleep
		Thread.sleep(3000);
		String url=Utils.getFileProperty("Application_Priville_URL");
		
		//with below line we are recording the current system time
        long startTime = System.currentTimeMillis(); // Start time
		PageBase.driver.get(url);
		
		// with below line will check the current time agin after hitting the Application URL
		long endTime = System.currentTimeMillis(); // End time
        long loadTime = endTime - startTime;
        
        //with below line we are checking the how much time it took to load
        System.out.println("Page Load Time: " + loadTime + " milliseconds");
	}

	@Then("the user should be on the Map page")
	public void the_user_should_be_on_the_Map_page() throws Exception {

	  //  with the below line we can check the visibility of Map on the page
	   TestBase.waitForElement(Priville_PageObjects.MapBoxlogo, 10);
	   boolean Logo = TestBase.isElementVisible(Priville_PageObjects.MapBoxlogo, "MapLogo");
	   
	   Assert.assertTrue(Logo);
	
	}

	@Then("the {string} filter button should be selected by default")
	public void the_filter_button_should_be_selected_by_default(String string) throws Exception {
        
		//with the below lines we can validate the button validation
		String ExpectedOption = "Pool & beach";
		TestBase.waitForElement(Priville_PageObjects.EnabledOption, 10);
        String ActualString = TestBase.getElementText(Priville_PageObjects.EnabledOption, "Button");
    	Assert.assertEquals(ExpectedOption, ActualString);

	}

	@Then("the user should see filtered results on the Map page")
	public void the_user_should_see_filtered_results_on_the_Map_page() throws Exception {
	   
		// Validating the filtered result data
		TestBase.waitForElement(Priville_PageObjects.Serchcount, 10);
        List<WebElement> list = TestBase.getListofElements(Priville_PageObjects.Serchcount);
        Thread.sleep(5000);
        Resultcount1 = list.size();
        System.out.println("The Count of search result"+Resultcount1);
	
	}

	@When("the user clicks on the {string} button on the Map page")
	public void the_user_clicks_on_the_button_on_the_Map_page(String string) throws Exception {
	    
		//validating the button functinality
		Thread.sleep(5000);
		TestBase.waitForElement(Priville_PageObjects.Filterbutton, 10);
        TestBase.clickonElement(Priville_PageObjects.Filterbutton, "Filter button");
        
	}

	@Then("the {string} window should be displayed")
	public void the_window_should_be_displayed(String string) throws Exception {
	    
		//validation on user is on right window and doing assertion
		String ExpectedOption = "Filter your search";
		TestBase.waitForElement(Priville_PageObjects.Filteryoursearchtext, 10);
        String ActualString = TestBase.getElementText(Priville_PageObjects.Filteryoursearchtext, "FilterSerchtexton window");
    	Assert.assertEquals(ExpectedOption, ActualString);
		
	}

	@Then("the results on the Map page should match the count displayed in {string} on {string} button")
	public void the_results_on_the_Map_page_should_match_the_count_displayed_in_on_button(String string, String string2) throws Exception {
   
		//validating the data integrity between two pages doing assertion on them
		
		TestBase.waitForElement(Priville_PageObjects.ShowVenubutton, 10);
        String ActualCounString = TestBase.getElementText(Priville_PageObjects.ShowVenubutton, "show venue button");
	    
        System.out.println("The count on Filter your search window is = "+ActualCounString);
        
        String[] strarr = ActualCounString.split(" ");
        String countstr = strarr[1];
        int Actualcount = Integer.parseInt(countstr);
        System.out.println("THe count is = "+Resultcount1);
        assertEquals("Values do match!", Actualcount, Resultcount1);   
        
	}

	@When("the user selects any location")
	public void the_user_selects_any_location() throws Exception {
	    
		//validaing user can able to select location
		
		TestBase.waitForElement(Priville_PageObjects.SelectWithoption("Dubai"), 20);
        TestBase.clickonElement(Priville_PageObjects.SelectWithoption("Dubai"), "Filter button");
        
	}

	@Then("the count on the {string} button should update dynamically")
	public void the_count_on_the_button_should_update_dynamically(String string) throws Exception {
	    
		//validating data integrity after doing some operation
		TestBase.waitForElement(Priville_PageObjects.ShowVenubutton, 10);
        String ActualCounString = TestBase.getElementText(Priville_PageObjects.ShowVenubutton, "show venue button");
	    
        System.out.println("The count on Filter your search window is = "+ActualCounString);
        
        String[] strarr = ActualCounString.split(" ");
        String countstr = strarr[1];
         ActualcountafterAddingfilter = Integer.parseInt(countstr);
        assertNotEquals("Values do not match!", ActualcountafterAddingfilter, Resultcount1);   

        
	}

	@When("the user clicks on the {string} button")
	public void the_user_clicks_on_the_button(String string) throws Exception {
	   
		// validating the button functinality
		TestBase.waitForElement(Priville_PageObjects.ShowVenubutton, 10);
        TestBase.clickonElement(Priville_PageObjects.ShowVenubutton, "show venue button");
		
	}

	@Then("the count in {string} should match the number of results on the Map page")
	public void the_count_in_should_match_the_number_of_results_on_the_Map_page(String string) throws Exception {
	    
		//validating data integrity after doing some operation
		TestBase.waitForElement(Priville_PageObjects.Serchcount, 10);
        List<WebElement> list = TestBase.getListofElements(Priville_PageObjects.Serchcount);
        
        Resultcount2 = list.size();
        System.out.println("The Count of seearch result"+Resultcount2);
        assertEquals("Values do match!", Resultcount2, ActualcountafterAddingfilter);   

	}

	@When("the user clicks on the {string} button in {string}")
	public void the_user_clicks_on_the_button_in(String string, String string2) throws Exception {
        
		// validating the button is working properly functionality 
		TestBase.waitForElement(Priville_PageObjects.Clearfiltersbutton, 10);
        TestBase.clickonElement(Priville_PageObjects.Clearfiltersbutton, "Clear filters button");
	
	}

	@When("the user clicks on the {string} button on map page")
	public void the_user_clicks_on_the_button_on_map_page(String string) throws Exception {
	   
		// validating the button is working properly functionality 
		TestBase.waitForElement(Priville_PageObjects.Diningbutton, 10);
        TestBase.clickonElement(Priville_PageObjects.Diningbutton, "Dining button");
		
	}

	@Then("User select {string} as discount")
	public void user_select_as_discount(String string) throws Exception {
	    
		// applying more filters
		 Discount = string;
		TestBase.waitForElement(Priville_PageObjects.SelectWithoption(string), 20);
        TestBase.clickonElement(Priville_PageObjects.SelectWithoption(string), "Filter button");
                
	}

	@When("the user verifies the discount percentage for a particular hotel")
	public void the_user_verifies_the_discount_percentage_for_a_particular_hotel() throws Exception {
	    
		//wait for element for 10 sec
		TestBase.waitForElement(Priville_PageObjects.Discountper, 10);
		String discountonmappage = TestBase.getElementText(Priville_PageObjects.Discountper, "Discount bar on hotel image");
		System.out.println(discountonmappage);
		
	}

	@When("the user selects a hotel from the search results")
	public void the_user_selects_a_hotel_from_the_search_results() throws Exception {
	   
		// Click on the element
		TestBase.waitForElement(Priville_PageObjects.anyHotel, 10);
        TestBase.clickonElement(Priville_PageObjects.anyHotel, "any hotel from search result");
		
	}

	@Then("the user should be able to see all images of the selected hotel on the hotel window")
	public void the_user_should_be_able_to_see_all_images_of_the_selected_hotel_on_the_hotel_window() throws Exception {
	   
		TestBase.waitForElement(Priville_PageObjects.Imgeonhotelwindow, 10);
		// Mouse Over on the element
		TestBase.mouseOver(Priville_PageObjects.Imgeonhotelwindow);
		for(int i=0;i<3;i++) {
			
			TestBase.waitForElement(Priville_PageObjects.forwardarrow, 10);
	        TestBase.clickonElement(Priville_PageObjects.forwardarrow, "any hotel from search result");
			
		}
	}

	@Then("the discount percentage on the Map page and the hotel window should match")
	public void the_discount_percentage_on_the_Map_page_and_the_hotel_window_should_match() throws Exception {
	    
		// get text from element and store in variable
		TestBase.waitForElement(Priville_PageObjects.discountonhotelwindow, 10);
	    discountonhotelwindow = TestBase.getElementText(Priville_PageObjects.discountonhotelwindow, "Discount bar on hotel image");
		System.out.println(discountonhotelwindow);
        assertEquals("Values do match!", discountonhotelwindow, Discount);   

	}

	@Then("the user verifies the opening hours on the hotel window")
	public void the_user_verifies_the_opening_hours_on_the_hotel_window() throws Exception {
	    
		// validate the expected and actual Strings
		String ExpectedOpeningHours = "6:30 - 22:30";
		TestBase.waitForElement(Priville_PageObjects.Openinghours, 10);
		String ActualOpeningTimingonHotelWindow = TestBase.getElementText(Priville_PageObjects.Openinghours, "Opening hours time");
        assertEquals("Values do match!", ActualOpeningTimingonHotelWindow, ExpectedOpeningHours);
	}

	@Then("checks the hotel's quote message")
	public void checks_the_hotel_s_quote_message() throws Exception {
	   
		// Validating the Actual and expected values
		String ExpectedQuotes = "This all-day-dining restaurant serves pizza fresh from the oven, spicy delights cooked live from the Tandoor, deli-style salads, plus pudding counters with free-flowing chocolate and home-made ice-cream.";
		TestBase.waitForElement(Priville_PageObjects.Quetosonhotelwindow, 10);
		String Actualquotes = TestBase.getElementText(Priville_PageObjects.Quetosonhotelwindow, "Quetes on hotel window");
        assertEquals("Values do match!", Actualquotes, ExpectedQuotes);
	
	}

	@Then("verifies the discount eligibility based on the user type")
	public void verifies_the_discount_eligibility_based_on_the_user_type() throws Exception {
	    
		
		// wait for element
		TestBase.waitForElement(Priville_PageObjects.discounAvialbleUsers, 10);
		String DiscountapplicableUsers = TestBase.getElementText(Priville_PageObjects.discounAvialbleUsers, "Discount available user");
		
		System.out.println(DiscountapplicableUsers);
	}
	
	
	@Then("enters the first name in the {string} window")
	public void enters_the_first_name_in_the_window(String string) throws Exception {
	    
		// type a text in text box
		TestBase.waitForElement(Priville_PageObjects.FirstNametextbox, 10);
        TestBase.typeinTextBox(Priville_PageObjects.FirstNametextbox, "Dinesh", "First name field");
        
	}

	@Then("enters the email in the {string} window")
	public void enters_the_email_in_the_window(String string) throws Exception {
		
		// type a text in text box
		TestBase.waitForElement(Priville_PageObjects.Emailtextbox, 10);
        TestBase.typeinTextBox(Priville_PageObjects.Emailtextbox, "dinesh.lavate@simformsolutions.com", "Email textbox");
        
	}

	@Then("selects the country code {string} from the dropdown")
	public void selects_the_country_code_from_the_dropdown(String string) throws Exception {
	   
		// select the country from dropdown
		TestBase.waitForElement(Priville_PageObjects.countrydropdown, 10);
        TestBase.clickonElement(Priville_PageObjects.countrydropdown, "country Dropdwon");
        
        TestBase.waitForElement(Priville_PageObjects.allcountryfromdropdowna, 10);
        List<WebElement> list = TestBase.getListofElements(Priville_PageObjects.allcountryfromdropdowna);
        System.out.println(list.size());
        
        for(int i=0;i<list.size();i++) {
        	
        	String text = list.get(i).getText();
        	if(text.equalsIgnoreCase(string)) {
        	    final By object1 = By.xpath("//span[contains(text(),'+91')]");
        		TestBase.JsclickonElement(object1,"India country");
                break;
        	}
        }
	}

	@Then("enters the phone number in the {string} window")
	public void enters_the_phone_number_in_the_window(String string) throws Exception {
	    
		TestBase.waitForElement(Priville_PageObjects.MobileNumbertextbox, 10);
        TestBase.typeinTextBox(Priville_PageObjects.MobileNumbertextbox, "9370181893", "Mobile number field");
        
	}

	@Then("clicks on the {string} button")
	public void clicks_on_the_button(String string) throws Exception {
		
		// wait for element
		TestBase.waitForElement(Priville_PageObjects.Viewbutton, 10);
        TestBase.clickonElement(Priville_PageObjects.Viewbutton, "View button");
	}
	
	@Then("the user will navigate to Explore Privilee venues window")
	public void the_user_will_navigate_to_Explore_Privilee_venues_window() throws Exception {
	    
		// check the visibility of element on the page
		TestBase.waitForElement(Priville_PageObjects.Exporeprivileeetext, 10);
        boolean istextavailable = TestBase.isElementVisible(Priville_PageObjects.Exporeprivileeetext, "Expore Privilee text");
		
        if(istextavailable==true) {
        	System.out.println("user successfully naviage to Explore Privilee venues window");
        }else {
        	System.out.println("user is not naviage to Explore Privilee venues window");

        }
	}
	
	@Then("user close the hotel model window")
	public void user_close_the_hotel_model_window() throws Exception {
	    
		// click on element
		TestBase.waitForElement(Priville_PageObjects.modalwindowclosebutton, 10);
        TestBase.clickonElement(Priville_PageObjects.modalwindowclosebutton, "close button on modal window");
	}
	
	@Then("verify the discount available for the selected venue via API and validate the discount percentage")
	public void verify_the_discount_available_for_the_selected_venue_via_API_and_validate_the_discount_percentage() {
	    
		// check the API reponce data and validate with UI
		String discountfromAPI = null;
		Response response = RestAssured.given().baseUri("https://staging-website.privilee.ae/api/map") // Replace with
				// actual API
                        .when().get("/restaurant") // Replace with actual endpoint
                        .then().extract().response(); // Extract response
		 
        JsonPath extracter = response.jsonPath();

        List<String> venueNames = extracter.getList("items.id");
        
        
        for(int i=0;i<venueNames.size();i++) {
        	
        	String venu = venueNames.get(i);
        	if(venu.equalsIgnoreCase("WjIa4SoAAEMDR0vk")) {
        		
        		 discountfromAPI= extracter.get("items["+i+"].thingsToDo[0].title").toString();
        	
        		System.out.println(discountfromAPI);
        	}
        	
        }
         int countfromAPI = extracter.getInt("items.size()");
         System.out.println("Count got from API"+countfromAPI);
         
         assertEquals("Values do match!", discountonhotelwindow, discountfromAPI);   

	}
}
