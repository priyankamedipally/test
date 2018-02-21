package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataInputs.ConfigReader;
import utilities.UtilityFunctions;

public class BaseClass {
	public static WebDriver driver;
	public  static ConfigReader configReader = new ConfigReader();
	public  static UtilityFunctions utilityFunctions = new UtilityFunctions();
	protected static ExtentReports extentvar;
	protected static ExtentTest testvar;
	
	//public  static BrowserFunctions browserFunctions = new BrowserFunctions();

	@BeforeTest
	public static void init() {

		startBrowser(configReader.getConfigData("browser"));
		
		
		getURL(configReader.getConfigData("url"));
		
		
	}

	public static void startBrowser(String browserName) {
		try {
			switch (browserName) {
			case "chrome": {
				System.setProperty("webdriver.chrome.driver", configReader.getConfigData("chromeDriverPath"));
				
				driver = new ChromeDriver();
				
			
				break;
				
			}
			}

		} catch (Exception e) {
e.getMessage();
e.printStackTrace();
		}
	}

	public static void getURL(String URL) {
		try {
			driver.get(URL);
			
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	@AfterTest
	public static void tearDown() {
		try {
			extentvar.endTest(testvar);
			
			driver.close();
			
			extentvar.flush();
			
		//driver.get("C://report//Report.html");
		
		}
		catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

}
