package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.relevantcodes.extentreports.ExtentReports;

import dataInputs.ConfigReader;

public class UtilityFunctions {
	
	public static ExtentReports Instance() {
		
		ExtentReports extent;
		String timeStamp = new SimpleDateFormat("MMddyyyy_HHmmss").format(Calendar.getInstance().getTime());
		//String extReportPath = "reports\\Report.html";
		String extReportPath = ConfigReader.getConfigData("ExtentRepoPath");
		
		extent = new ExtentReports(extReportPath);
		//extent = new ExtentReports(extReportPath,false);
		return extent;
		
	}
	
	public static void CaptureScreenshot(WebDriver driver,String screenshotName) throws Exception {
		try {
			TakesScreenshot ts =((TakesScreenshot)driver);
			
			File source=ts.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(source,new File("./screenshots/"+screenshotName+".png"));
			 
			 System.out.println("Screenshot taken");
		} 
		catch (WebDriverException e) {
			
			System.out.println("Exception while taking screenshot"+e.getMessage());
		} 
		
		
		
		
		
	}
	


}
