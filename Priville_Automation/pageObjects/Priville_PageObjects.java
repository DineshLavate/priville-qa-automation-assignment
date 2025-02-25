package pageObjects;

import org.openqa.selenium.By;

public class Priville_PageObjects {

	
	// These are the locators of Map page
    public static final By MapBoxlogo = By.xpath("//canvas[@class='mapboxgl-canvas']");
    public static final By EnabledOption = By.xpath("//button[@class='sc-d2d8fc08-2 eXrhOI']");
    public static final By Serchcount = By.xpath("//div[@class='sc-445d4fd4-3 dqhgCe']/a");
    public static final By Filterbutton = By.xpath("//button[@class='sc-445d4fd4-5 BZOKq']");
    public static final By Diningbutton = By.xpath("//button[contains(text(),'Dining')]");
    public static final By Discountper = By.xpath("(//span[contains(text(),'20% - 35% off')])[2]");
    public static final By anyHotel = By.xpath("//div[@class='sc-445d4fd4-3 dqhgCe']/a[2]");
    public static final By searchbox = By.xpath("//input[@placeholder='Search for venue']");
    public static final By FirstsearchResult = By.xpath("(//span[@class='sc-a1efdac9-6 bsFHU'])[1]");
    public static final By FamilyActivitiesbutton = By.xpath("//button[contains(text(),'Family activities')]");
    public static final By Noresultfoundele = By.xpath("//div[@class='sc-a1efdac9-8 SWKWR']");
    public static final By Waterparksbutton = By.xpath("//button[contains(text(),'Waterparks')]");

    
    
    // These are the locators on Filter your search page
    public static final By Filteryoursearchtext = By.xpath("//h2[contains(text(),'Filter your search')]");
    public static final By ShowVenubutton = By.xpath("//button[@class='sc-5180758e-9 jygJwH']");
    public static final By Clearfiltersbutton = By.xpath("//button[contains(text(),'Clear filters')]");
    
    
    // These are the locators on Hotel/venue window
    public static final By forwardarrow = By.xpath("(//button[@class='sc-e2b9ce20-3 bGBsEL arrow'])[2]");
    public static final By discountonhotelwindow = By.xpath("//div[@class='sc-62f80698-3 cwCCVo paneltitle']");
    public static final By Openinghours = By.xpath("//span[@class='sc-80f121f-7 cwssDb']");
    public static final By Quetosonhotelwindow = By.xpath("//div[@class='sc-80f121f-9 cUZXHm']//p");
    public static final By discounAvialbleUsers = By.xpath("//div[@class='sc-62f80698-2 lkavkw']//span");
    public static final By Imgeonhotelwindow = By.xpath("(//div[@class='sc-2c74a223-6 dYggO modal-base-content']//img)[1]");
    public static final By Hotelmodelwindow = By.xpath("//div[@class='sc-2c74a223-4 kPAArY modal-base-dialog']");
    public static final By venuenameelement = By.xpath("//div[@class='sc-80f121f-1 cytZeL']/h2");
    public static final By modalwindowclosebutton = By.xpath("(//button[@title='Close modal window'])[2]");

    
    // These are the locators on Login window
    public static final By FirstNametextbox = By.xpath("//input[@name='first_name']");
    public static final By Emailtextbox = By.xpath("//input[@name='email']");
    public static final By MobileNumbertextbox = By.xpath("//input[@name='mobile']");
    public static final By Viewbutton = By.xpath("//button[contains(text(),'View')]");
    public static final By countrydropdown = By.xpath("//div[@class='sc-c744ec56-1 hUdmSq']");
    public static final By allcountryfromdropdowna = By.xpath("//ul[@class='sc-a1efdac9-1 kHWhtf']/li//span[@class='sc-a1efdac9-6 bsFHU']");
    public static final By Exporeprivileeetext = By.xpath("//h3[contains(text(),'Explore Privilee venues')]");


    



    
    
    
    public static By SelectWithoption(String text) {
    	
  	  final By textXpath = By.xpath("//button/span[contains(text(),'"+text+"')]");
  	  return textXpath;
  	
       }
    
    
  
    

}
