package pages;

import org.openqa.selenium.WebDriver;
import browserFunctions_Details.BrowserFunctions;
import objectRepo.ObjRepo_Login;
import testBase.BaseClass;

//public class LoginPage extends ObjRepo_Login {

public class LoginPage extends BaseClass{
	
	
	boolean flag = false;
	
	WebDriver driver;
	public ObjRepo_Login objRepo_Login;
	
	
	
	public LoginPage(WebDriver driver) {
		objRepo_Login = new ObjRepo_Login(driver);
		this.driver = driver;
	}
	
  public boolean portalLogin(String emailid, String password) throws InterruptedException {
	//  driver.findElement(By.id("session_key-login")).sendKeys("test");
	//  driver.findElement(By.xpath("//*[@id='session_password-login']")).sendKeys("test");
	  
	  boolean  flag1 =  BrowserFunctions.editText(objRepo_Login.txt_edit_emailId, "EmailIdField", emailid);
	  boolean  flag2=  BrowserFunctions.editText(objRepo_Login.txt_edit_password, "PasswordField", password);
	  boolean flag3 =  BrowserFunctions.web_Click(objRepo_Login.submitButton_login, "LoginButtonField");
	  
		Thread.sleep(5000);
		
		/*if(flag1==true && flag2==true)
			
		return flag2;
		
		return flag1;
		*/
		
		if(flag1==true && flag2==true) 
			
			return flag3;
		
			return flag2;
		 
		
		
	}
	
	

}
