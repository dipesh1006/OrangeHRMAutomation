package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.*;

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
		reuseable = new ReuseableMethods(driver);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement usernamefield;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordfield;
	
	@FindBy(xpath="// div[@class='oxd-form-actions orangehrm-login-action'] / button[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//h6[contains(@class,'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module')]")
	WebElement dashboard;
	
	@FindBy(xpath="//div[@class='orangehrm-login-error'] / div[1] / div[1] / p")
	WebElement errormsg;
	
	@FindBy(xpath="//div[@class='orangehrm-login-form'] / form / div[4] / p")
	WebElement forget;
	
	@FindBy(xpath="//div[@class='oxd-form-row'] / div[1] / div[2] /input[@name='username']")
	WebElement resetusername;
	
	@FindBy(xpath="//div[@class='orangehrm-forgot-password-button-container'] / button [@type='submit']")
	WebElement resetbtn;
	
	@FindBy(xpath="//div[@class='orangehrm-card-container'] / h6")
	WebElement errormsgtitile;
	
	@FindBy(xpath="//div[@class='orangehrm-card-container'] / p[1]")
	WebElement errormsgparagraph;
	
	@FindBy(xpath="//li[@class='oxd-main-menu-item-wrapper'] / a / span")
	List<WebElement> menuList;
	
	@FindBy(xpath="//li / a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab'] / i")
	WebElement logoutmenutriangle;
	
	
	public void fill_userName_password_details(String usename,String password)
	{
		user = usename;
		reuseable.WaitUntilElementVisible(usernamefield);
		usernamefield.sendKeys(usename);
		passwordfield.sendKeys(password);
		
	}
	
	public void log_In()
	{
		loginbtn.click();
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
	
	public void click_Forget_Password()
	{
		forget.click();
		reuseable.WaitUntilElementVisible(resetbtn);
	}
	
	public void fill_forget_username_Click_Resetbtn(String username)
	{
		resetusername.sendKeys(username);
		resetbtn.click();
	}
	
	public String verify_RestPassword_dialougeBox_ErrorMessage() 
	{
		reuseable.WaitUntilElementVisible(errormsgtitile);
		return errormsgtitile.getText();
		
	}
	
	
	public void Search_Panel_From_ListOfPanel(String panelname)
	{
		for(int i=0;i<menuList.size();i++)
		{
			if(menuList.get(i).getText().equalsIgnoreCase(panelname))
			{
				menuList.get(i).click();
				break;
			}
		}
		reuseable.WaitUntilElementVisible(dashboard);
	}
	
	public void LogOut_User()
	{
		logoutmenutriangle.click();
		reuseable.WaitUntilElementVisible(logout);
		logout.click();
		reuseable.WaitUntilElementVisible(loginbtn);
	}
	
	public void fill_userName_password_details_Login(String usename,String password) throws Exception
	{
		user = usename;
		reuseable.WaitUntilElementVisible(usernamefield);
		usernamefield.sendKeys(usename);
		passwordfield.sendKeys(password);
		loginbtn.click();
		Thread.sleep(5000);
		
		
	}
	
	public String verify_Dashboard_Is_Visiable()
	{
		return dashboard.getText();
	}
	
	
	
}
