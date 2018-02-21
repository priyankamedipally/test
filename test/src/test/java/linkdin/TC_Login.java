package linkdin;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import testBase.BaseClass;
import utilities.UtilityFunctions;

public class TC_Login extends BaseClass {
	
	boolean flag = false;

	
	@Test
	public void login() throws Exception {
		 
		extentvar = UtilityFunctions.Instance();
		testvar=extentvar.startTest("LinkedIn Login");
		
		
		LoginPage loginPage = new LoginPage(driver);
		
		testvar.log(LogStatus.INFO, "browser started");
		testvar.log(LogStatus.INFO, "Application is up and running");
		
		System.out.println("IM in TC");
		
		flag = loginPage.portalLogin(configReader.getConfigData("emailid"), configReader.getConfigData("password"));
		if(flag) {
			System.out.println("PASS");
		testvar.log(LogStatus.PASS, " Login is successful");
		
		}
		else {
			System.out.println("FAIL");
			
			testvar.log(LogStatus.FAIL, " Login failed");
			//UtilityFunctions.CaptureScreenshot(driver, "login failed");
			
			testvar.log(LogStatus.FAIL,"Snapshot below" +testvar.addScreenCapture("test/screenshots"));
			
			
			
		}
	}

}




















































