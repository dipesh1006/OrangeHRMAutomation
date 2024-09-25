package ProjectManagers;

import org.openqa.selenium.WebDriver;

import GenericUtils.ReuseableMethods;
import POMClasses.LoginPageOrangeHRM;



public class ObjectManager {

	
	WebDriver driver;
	
	public ObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public ReuseableMethods getObjectReuseableMethods()
	{
		return new ReuseableMethods(driver);
	}

	public LoginPageOrangeHRM getObjectLoginPageOrangeHRM()
	{
		return new LoginPageOrangeHRM(driver);
	}
	
}
