package testBase;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ExceptionHandling;
import utility.Logs;


public class TestBase extends PageBase {
	
	public static String TestCaseName;
	
	public static void waitForElement(By locator, long ltime) throws Exception {
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(ltime));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			Logs.info("Element is visible");
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Element not available");
		}
	}
	
	public static void typeinTextBox(By locator , String data,String elementName) throws Exception {
		try {
			if(driver.findElement(locator).isDisplayed()) {
				driver.findElement(locator).clear();
				driver.findElement(locator).sendKeys(data);
				Logs.info("Text Entered into "+elementName);
			}else {
				Logs.info("Unable to enter text into "+elementName);
			}
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to Identify text field ");
		}
	}
	
	public static void clickonElement(By locator, String elementName) throws Exception {
		boolean bflag=false;
		try {
			if(driver.findElement(locator).isDisplayed()) {
				driver.findElement(locator).click();
				bflag=true;
				Logs.info("Clicked on "+elementName);
			}
			else {
				Logs.info("Unable to click on  "+elementName);
			}
			
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to click on element "+elementName);
		}
	}
	
	public static void JsclickonElement(By locator, String elementName) throws Exception {
		boolean bflag=false;
		try {
			if(driver.findElement(locator).isDisplayed()) {
				bflag=true;
				JavascriptExecutor executor=(JavascriptExecutor) driver;
				executor.executeAsyncScript("arguments[0].click();", driver.findElement(locator));
				Logs.info("Click on  "+elementName);
			}
			else {
				Logs.info("Unable to click on  "+elementName);
			}
			
		}catch(Exception e) {
//			ExceptionHandling.HandleExecption(e, "Unable to click on element "+elementName);
		}
	}
	
	public static String getElementText(By locator, String elementName) throws Exception {
		String sText="";
		try {
			if(driver.findElement(locator).isDisplayed()) {
				sText=driver.findElement(locator).getText();
				Logs.info("Text got from "+elementName);
			}else
			{
				Logs.info("Unable to get Text from "+elementName);
			}
			
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to get text from element"+elementName);
		}
		return sText;
	}
	
	public static void ScrollToElementByPixel(int pixelSize) throws Exception {
		try {
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) (TestBase.driver);
			javascriptExecutor.executeScript("window.scrollBy(0, " + pixelSize + ")", "");
			Logs.info("Element is Scrolled");
		} catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "unable to scroll");
		}
	}
	
	
	public static void RefreshPage() {
		driver.navigate().refresh();
	}
	
	public static boolean isElementVisible(By object,String elementName) throws Exception {
		boolean bFlag = false;
		try {
			if(driver.findElements(object).size() > 0) {
				bFlag= true;
				Logs.info("able to Right click to"+elementName);
			}
		} catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "Unable to check if the " + elementName +" element is visible or not");
		}
		return bFlag;
	}
	public static List<WebElement> getElements(By Obj) throws Throwable {
		List<WebElement> webele = null;
		try {
			Thread.sleep(1000);
			webele = driver.findElements(Obj);
			Logs.info("elements are stored in array");
		} catch (Exception e) {
			ExceptionHandling.HandleExecption(e, e.toString());
		}
		return webele;
	}
	
	public static List<WebElement> getListofElements(By object) throws Exception {
		try {
			List<WebElement> listofele = driver.findElements(object);
			return listofele;

			
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "Fail to locate Elements");

		}
		return null;
		
		}
	
	
	public static boolean isDisplayed(By profileName) throws Exception {
		boolean flag = false;
		
		try {
			flag = driver.findElement(profileName).isDisplayed();
			Logs.info("elements is displayed");
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "incorrect profile name");

		}
		return false;	
	}
	
	public static void dropdownSelectElement(By objLocator, String sVisibletext) throws Throwable {
		try {
			Select s = new Select(driver.findElement(objLocator));
			s.selectByVisibleText(sVisibletext);
			Logs.info("elements is selected from dropdown");
		} catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "Option not selected");
		}
	}
	
	
	public static void mouseOver(By ele) throws Exception {
		try {
			Actions action = new Actions(PageBase.driver);
			action.moveToElement(driver.findElement(ele)).build().perform();
			Logs.info("elements is moved");
		}catch (Exception e) {
			ExceptionHandling.HandleExecption(e, "Failed to click on ");
		}
	}
	
	
	public static String getTextFromPropertis(By object) throws Exception {
		String text = null;
		try {
			text = (String) ((JavascriptExecutor) PageBase.driver).executeScript("return arguments[0].value;", PageBase.driver.findElement(object));	
			Logs.info("text is getting from properties");
		}catch(Exception e) {
			ExceptionHandling.HandleExecption(e, "unable to get text from properties");
		}
		
		return text;
		
	}
	
	
	
}
