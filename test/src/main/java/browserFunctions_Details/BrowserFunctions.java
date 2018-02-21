/**
 * 
 */
package browserFunctions_Details;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;


import testBase.BaseClass;

/**
 * @author PRIYANKA
 *
 */
public class BrowserFunctions extends BaseClass {
	static WebDriver driver;
	
	
	
	public static boolean editText(WebElement element, String fieldName, String strngValue)
	{
		boolean isElementExist = false;
		try {
			element.clear();
			element.sendKeys(strngValue);
			isElementExist = true;//give extent report as FieldName Exist
			 testvar.log(LogStatus.PASS, fieldName+" Exists");
		}
		catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
			isElementExist = false;
			testvar.log(LogStatus.FAIL,  fieldName+" doesn't Exist");
			//UtilityFunction.CaptureScreenshot(driver, "BrowserStarted");
		}
		return isElementExist; 
		
		}
	
	public static boolean web_Click(WebElement element, String fieldName)
	{
		boolean isElementExist = false;
		try {
			element.click();
			isElementExist = true;
			testvar.log(LogStatus.PASS, fieldName+" Exists");
		}
		catch(Exception e) {
			e.getMessage();
			isElementExist = false;
			testvar.log(LogStatus.FAIL,  fieldName+" doesn't Exist");
		}
		return isElementExist;
		
		}
}
