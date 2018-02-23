package pages;

import org.openqa.selenium.WebDriver;
import browserFunctions_Details.BrowserFunctions;
import objectRepo.ObjRepo_Login;
import testBase.BaseClass;

//public class LoginPage extends ObjRepo_Login {

public class LoginPage extends BaseClass {

	boolean flag = false;
	int i = 0;

	WebDriver driver;
	public ObjRepo_Login objRepo_Login;

	public LoginPage(WebDriver driver) {
		objRepo_Login = new ObjRepo_Login(driver);
		this.driver = driver;
	}

	public boolean portalLogin(String emailid, String password) throws InterruptedException {
		// driver.findElement(By.id("session_key-login")).sendKeys("test");
		// driver.findElement(By.xpath("//*[@id='session_password-login']")).sendKeys("test");

		flag = BrowserFunctions.editText(objRepo_Login.txt_edit_emailId, "EmailIdField", emailid);

		if (!flag)
			i = i + 1;

		flag = BrowserFunctions.editText(objRepo_Login.txt_edit_password, "PasswordField", password);

		if (!flag)
			i = i + 1;

		flag = BrowserFunctions.web_Click(objRepo_Login.submitButton_login, "LoginButtonField");
		if (!flag)
			i = i + 1;

		Thread.sleep(5000);

		if(i==0)
			return true;
		else
			return false;

	}

}
