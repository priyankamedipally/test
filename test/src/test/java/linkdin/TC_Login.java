package linkdin;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import testBase.BaseClass;
import utilities.UtilityFunctions;

public class TC_Login extends BaseClass {
	
	boolean flag = false;
	//String timeStamp = new SimpleDateFormat("MMddyyyy_HHmmss").format(Calendar.getInstance().getTime());
	
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
		//testvar.log(LogStatus.PASS, " Login is successful");
			
		UtilityFunctions.CaptureScreenshot(driver, "login success");
		
		}
		else {
			System.out.println("FAIL");
			
			testvar.log(LogStatus.FAIL, " Login failed");
			UtilityFunctions.CaptureScreenshot(driver, "login failed");
			
			//testvar.log(LogStatus.FAIL,"Snapshot below" +testvar.addScreenCapture("test/Screenshots"));
			testvar.log(LogStatus.FAIL,"Snapshot below" +testvar.addScreenCapture("C:\\Users\\PRIYANKA\\git\\test\\test\\Screenshots"));
			
			
		}
	}

}




















































