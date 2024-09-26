package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GenericUtils.ReuseableMethods;
import ProjectManagers.TextContextObject;

public class LoginPageOrangeHRM {

	private WebDriver driver;
	public ReuseableMethods reuseable;
	private String user;
	public LoginPageOrangeHRM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement usernamefield;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordfield;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//h6[contains(@class,'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module')]")
	WebElement dashboard;
	
	@FindBy(xpath="//div[@class='orangehrm-login-error'] / div[1] / div[1] / p")
	WebElement errormsg;
	
	
	public void fill_userName_password_details(String usename,String password)
	{
		user = usename;
		usernamefield.sendKeys(usename);
		passwordfield.sendKeys(password);
		
	}
	
	public void log_In() throws Exception
	{
		loginbtn.click();
		reuseable = new ReuseableMethods(driver);
		if(user.equalsIgnoreCase("Admin"))
		{
			
			reuseable.WaitUntilUrlGet("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
			reuseable.WaitUntilElementVisible(dashboard);
			
		}
		else
		{
			reuseable.WaitUntilElementVisible(errormsg);
			
		}
		 
	}
	
	public void VerifyUserableToLoginOrNot()
	{
		if(user.equalsIgnoreCase("Admin"))
		{
	
			Assert.assertEquals(dashboard.getText(), "Dashboard");
		}
		else
		{
			Assert.assertEquals(errormsg.getText(), "Invalid credentials");
		}
	}
	
}
