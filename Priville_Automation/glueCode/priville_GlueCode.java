package glueCode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Priville_PageObjects;
import testBase.TestBase;
import testBase.pageBase;
import utility.Utils;

public class priville_GlueCode {

	public static int Resultcount1;
	public static int Resultcount2;
	public static int ActualcountafterAddingfilter;
	public static String Discount;
	
	
	@When("User opens the Browser")
	public void user_opens_the_Browser() {

		// User Is opening the by passing browser as property from config.proprties file the value of browser is Chrome
		
		pageBase.OpenBrowser("Browser"); 
	
	}

	@When("User Enter Priville Application URL and navigate to Map page")
	public void user_Enter_Priville_Application_URL_and_navigate_to_Map_page() throws InterruptedException {
		
		//We have mentions some static wait by using thred.sleep
		Thread.sleep(3000);
		String url=Utils.getFileProperty("Application_Priville_URL");
		
		//with below line we are recording the current system time
        long startTime = System.currentTimeMillis(); // Start time
		pageBase.driver.get(url);
		
		// with below line will check the current time agin after hitting the Application URL
		long endTime = System.currentTimeMillis(); // End time
        long loadTime = endTime - startTime;
        
        //with below line we are checking the how much time it took to load
        System.out.println("Page Load Time: " + loadTime + " milliseconds");
	}

	@Then("Verify user is on Map Page")
	public void verify_user_is_on_Map_Page() throws Exception {

	  //  with the below line we can check the visibility of Map on the page
	   TestBase.waitForElement(Priville_PageObjects.MapBoxlogo, 10);
	   boolean Logo = TestBase.isElementVisible(Priville_PageObjects.MapBoxlogo, "MapLogo");
	   
	   Assert.assertTrue(Logo);
	
	}

	@Then("Verify pool and beach button is by default selected")
	public void verify_pool_and_beach_button_is_by_default_selected() throws Exception {
        
		//with the below lines we can validate the button validation
		String ExpectedOption = "Pool & beach";
		TestBase.waitForElement(Priville_PageObjects.EnabledOption, 10);
        String ActualString = TestBase.getElementText(Priville_PageObjects.EnabledOption, "Button");
    	Assert.assertEquals(ExpectedOption, ActualString);

	}

	@Then("Verify user able to see the filtered result on map page")
	public void verify_user_able_to_see_the_filtered_result_on_map_page() throws Exception {
	   
		// Validating the filtered result data
		TestBase.waitForElement(Priville_PageObjects.Serchcount, 10);
        List<WebElement> list = TestBase.getListofElements(Priville_PageObjects.Serchcount);
        Thread.sleep(5000);
        Resultcount1 = list.size();
        System.out.println("The Count of search result"+Resultcount1);
	
	}

	@Then("User click on Filters button on map page")
	public void user_click_on_Filters_button_on_map_page() throws Exception {
	    
		//validating the button functinality
		Thread.sleep(5000);
		TestBase.waitForElement(Priville_PageObjects.Filterbutton, 10);
        TestBase.clickonElement(Priville_PageObjects.Filterbutton, "Filter button");
        
	}

	@Then("Verify user able to see Filter your Serch window")
	public void verify_user_able_to_see_Filter_your_Serch_window() throws Exception {
	    
		//validation on user is on right window and doing assertion
		String ExpectedOption = "Filter your search";
		TestBase.waitForElement(Priville_PageObjects.Filteryoursearchtext, 10);
        String ActualString = TestBase.getElementText(Priville_PageObjects.Filteryoursearchtext, "FilterSerchtexton window");
    	Assert.assertEquals(ExpectedOption, ActualString);
		
	}

	@Then("Verify map page result and the count avialable on Filter your search should be same")
	public void verify_map_page_result_and_the_count_avialable_on_Filter_your_search_should_be_same() throws Exception {
   
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

	@Then("user select any Location")
	public void user_select_any_Location() throws Exception {
	    
		//validaing user can able to select location
		
		TestBase.waitForElement(Priville_PageObjects.SelectWithoption("Dubai"), 20);
        TestBase.clickonElement(Priville_PageObjects.SelectWithoption("Dubai"), "Filter button");
        
	}

	@Then("Verify the count on show venue button is variable")
	public void verify_the_count_on_show_venue_button_is_variable() throws Exception {
	    
		//validating data integrity after doing some operation
		TestBase.waitForElement(Priville_PageObjects.ShowVenubutton, 10);
        String ActualCounString = TestBase.getElementText(Priville_PageObjects.ShowVenubutton, "show venue button");
	    
        System.out.println("The count on Filter your search window is = "+ActualCounString);
        
        String[] strarr = ActualCounString.split(" ");
        String countstr = strarr[1];
         ActualcountafterAddingfilter = Integer.parseInt(countstr);
        assertNotEquals("Values do not match!", ActualcountafterAddingfilter, Resultcount1);   

        
	}

	@Then("user click on show venue button")
	public void user_click_on_show_venue_button() throws Exception {
	   
		// validating the button functinality
		TestBase.waitForElement(Priville_PageObjects.ShowVenubutton, 10);
        TestBase.clickonElement(Priville_PageObjects.ShowVenubutton, "show venue button");
		
	}

	@Then("Verify the Filter your search count and Map page result count should be same")
	public void verify_the_Filter_your_search_count_and_Map_page_result_count_should_be_same() throws Exception {
	    
		//validating data integrity after doing some operation
		TestBase.waitForElement(Priville_PageObjects.Serchcount, 10);
        List<WebElement> list = TestBase.getListofElements(Priville_PageObjects.Serchcount);
        
        Resultcount2 = list.size();
        System.out.println("The Count of seearch result"+Resultcount2);
        assertEquals("Values do match!", Resultcount2, ActualcountafterAddingfilter);   

	}

	@Given("User click on Clear filters button on filter your search page")
	public void user_click_on_Clear_filters_button_on_filter_your_search_page() throws Exception {
        
		// validating the button is working properly functionality 
		TestBase.waitForElement(Priville_PageObjects.Clearfiltersbutton, 10);
        TestBase.clickonElement(Priville_PageObjects.Clearfiltersbutton, "Clear filters button");
	
	}

	@Then("User click on Dining button")
	public void user_click_on_Dining_button() throws Exception {
	   
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

	@Then("User check the discount percentage for a particular hotel")
	public void user_check_the_discount_percentage_for_a_particular_hotel() throws Exception {
	    
		
		TestBase.waitForElement(Priville_PageObjects.Discountper, 10);
		String discountonmappage = TestBase.getElementText(Priville_PageObjects.Discountper, "Discount bar on hotel image");
		System.out.println(discountonmappage);
		
	}

	@Then("Verify user able to select one hotel from serch result")
	public void verify_user_able_to_select_one_hotel_from_serch_result() throws Exception {
	   
		TestBase.waitForElement(Priville_PageObjects.anyHotel, 10);
        TestBase.clickonElement(Priville_PageObjects.anyHotel, "any hotel from search result");
		
	}

	@Then("Verify user can able to see all the images of selected hotel on hotel window")
	public void verify_user_can_able_to_see_all_the_images_of_selected_hotel_on_hotel_window() throws Exception {
	   
		TestBase.waitForElement(Priville_PageObjects.Imgeonhotelwindow, 10);
		TestBase.mouseOver(Priville_PageObjects.Imgeonhotelwindow);
		for(int i=0;i<3;i++) {
			
			TestBase.waitForElement(Priville_PageObjects.forwardarrow, 10);
	        TestBase.clickonElement(Priville_PageObjects.forwardarrow, "any hotel from search result");
			
		}
	}

	@Then("verify the discount percentage on map page and hotel window should be same")
	public void verify_the_discount_percentage_on_map_page_and_hotel_window_should_be_same() throws Exception {
	    
		TestBase.waitForElement(Priville_PageObjects.discountonhotelwindow, 10);
		String discountonhotelwindow = TestBase.getElementText(Priville_PageObjects.discountonhotelwindow, "Discount bar on hotel image");
		System.out.println(discountonhotelwindow);
        assertEquals("Values do match!", discountonhotelwindow, Discount);   

	}

	@Then("Verify the opening hours on hotel window")
	public void verify_the_opening_hours_on_hotel_window() throws Exception {
	    
		String ExpectedOpeningHours = "6:30 - 22:30";
		TestBase.waitForElement(Priville_PageObjects.Openinghours, 10);
		String ActualOpeningTimingonHotelWindow = TestBase.getElementText(Priville_PageObjects.Openinghours, "Opening hours time");
        assertEquals("Values do match!", ActualOpeningTimingonHotelWindow, ExpectedOpeningHours);
	}

	@Then("Verify the quotes message of hotel")
	public void verify_the_quotes_message_of_hotel() throws Exception {
	   
		String ExpectedQuotes = "This all-day-dining restaurant serves pizza fresh from the oven, spicy delights cooked live from the Tandoor, deli-style salads, plus pudding counters with free-flowing chocolate and home-made ice-cream.";
		TestBase.waitForElement(Priville_PageObjects.Quetosonhotelwindow, 10);
		String Actualquotes = TestBase.getElementText(Priville_PageObjects.Quetosonhotelwindow, "Quetes on hotel window");
        assertEquals("Values do match!", Actualquotes, ExpectedQuotes);
	
	}

	@Then("Verify the discount is available for which type of user")
	public void verify_the_discount_is_available_for_which_type_of_user() throws Exception {
	    
		
		TestBase.waitForElement(Priville_PageObjects.discounAvialbleUsers, 10);
		String DiscountapplicableUsers = TestBase.getElementText(Priville_PageObjects.discounAvialbleUsers, "Discount available user");
		
		System.out.println(DiscountapplicableUsers);
	}
	
	@Then("User enter the firstname on Explore Privilee venue window")
	public void user_enter_the_firstname_on_Explore_Privilee_venue_window() throws Exception {
	    
		TestBase.waitForElement(Priville_PageObjects.FirstNametextbox, 10);
        TestBase.typeinTextBox(Priville_PageObjects.FirstNametextbox, "Dinesh", "First name field");
        
	}

	@Then("User enter the email on Explore Privilee venue window")
	public void user_enter_the_email_on_Explore_Privilee_venue_window() throws Exception {
	   
		TestBase.waitForElement(Priville_PageObjects.Emailtextbox, 10);
        TestBase.typeinTextBox(Priville_PageObjects.Emailtextbox, "dinesh.lavate@simformsolutions.com", "Email textbox");
        
	}

	@Then("User select the country code {string} from country dropdown")
	public void user_select_the_country_code_from_country_dropdown(String string) throws Exception {
	   
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

	@Then("User enter the Phone Number on Explore Privilee venue window")
	public void user_enter_the_Phone_Number_on_Explore_Privilee_venue_window() throws Exception {
	    
		TestBase.waitForElement(Priville_PageObjects.MobileNumbertextbox, 10);
        TestBase.typeinTextBox(Priville_PageObjects.MobileNumbertextbox, "9370181893", "Mobile number field");
        
	}

	@Then("User click on View button")
	public void user_click_on_View_button() throws Exception {
		
		TestBase.waitForElement(Priville_PageObjects.Viewbutton, 10);
        TestBase.clickonElement(Priville_PageObjects.Viewbutton, "View button");
	}
}
