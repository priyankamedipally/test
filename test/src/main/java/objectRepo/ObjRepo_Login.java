package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class ObjRepo_Login extends BaseClass {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@id='session_key-login']") 
	public static WebElement txt_edit_emailId;
	
	@FindBy(how = How.XPATH, using = "//*[@id='session_password-login']") 
	public static WebElement txt_edit_password;
	
	@FindBy(how = How.XPATH, using = "//*[@id='btn-primary']123") 
	public static WebElement submitButton_login;
	
	
	
	public ObjRepo_Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;		
	}



	/*public ObjRepo_Login() {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} */

}
