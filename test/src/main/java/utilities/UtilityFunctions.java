package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.relevantcodes.extentreports.ExtentReports;

import dataInputs.ConfigReader;
import testBase.BaseClass;

public class UtilityFunctions extends BaseClass {
	
	static String timeStamp = new SimpleDateFormat("MMddyyyy_HHmmss").format(Calendar.getInstance().getTime());
	public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
	public static final DateTimeFormatter dtfm = DateTimeFormatter.ofPattern("HH_mm_ss");
	public static final DateTimeFormatter dtmonth = DateTimeFormatter.ofPattern("MMM");
	public static LocalDateTime now;
	
	public static String resultfilepath() {
		now = LocalDateTime.now();
		String Path = "."+ ConfigReader.getConfigData("ExtentRepoPath")+now.getYear()+"\\"+dtmonth.format(now) + "\\Day_"+dtf.format(now)+"\\Result_" +dtfm.format(now)+".html";
		return Path;
				}
	
	public static ExtentReports Instance() {
		
		ExtentReports extent;
		
		String extReportPath = resultfilepath();
		//String extReportPath = ConfigReader.getConfigData("ExtentRepoPath" +timeStamp);
		
		extent = new ExtentReports(extReportPath );
		//extent = new ExtentReports(extReportPath,false);
		return extent;
		
	}
	
	public static void CaptureScreenshot(WebDriver driver,String screenshotName) throws Exception {
		try {
			TakesScreenshot ts =((TakesScreenshot)driver);
			
			
			File source=ts.getScreenshotAs(OutputType.FILE);
			
			
			FileUtils.copyFile(source,new File("./Screenshots/"+screenshotName+".png"));
			 
			 System.out.println("Screenshot taken");
		} 
		catch (WebDriverException e) {
			
			System.out.println("Exception while taking screenshot"+e.getMessage());
		} 
		
		
		
		
		
	}
	


}
