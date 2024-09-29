package POMClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtils.ReuseableMethods;

public class AdminPageOrangeHRM {
	
	private WebDriver driver;
	public ReuseableMethods reuseable;
	private String user;
	public AdminPageOrangeHRM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		reuseable = new ReuseableMethods(driver);
	}
	
	
	@FindBy(xpath="// div[@class='orangehrm-header-container']  / button")
	WebElement AddBtn;
	
	@FindBy(xpath="//div[@class='oxd-form-actions'] / button[@type='submit']")
	WebElement savebtn;
	
	@FindBy(xpath="(//div[@class='oxd-select-wrapper'] / div[contains(@class,'oxd-select-text oxd-select-text')] ) [position()=1]")
	WebElement userrolelabel;
	
	@FindBy(xpath="(//div[@class='oxd-select-wrapper'] / div[contains(@class,'oxd-select-text oxd-select-text')] ) [position()=2]")
	WebElement status;
	
	@FindBy(xpath="//div[contains(@class,'oxd-select-dropdown') and @role='listbox']")
	WebElement userdropdown;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-wrapper'] /div/ input")
	WebElement empname;
	
	@FindBy(xpath="(//div[contains(@class,'oxd-input-group')] / div[2] / input [contains(@class,'oxd-input oxd-input--active')]) [position()=1]")
	WebElement adminusername;
	
	@FindBy(xpath="//div[@class='oxd-form-row user-password-row'] / div / div[1] / div / div[2] / input[@type='password']")
	WebElement Adminpassword;

	@FindBy(xpath="//div[@class='oxd-form-row user-password-row'] / div / div[2] / div / div[2] / input[@type='password']")
	WebElement Confirmpassword;

	
	
	public void select_UserRole(String role)
	{
		if(role.equalsIgnoreCase("Admin"))
		{
			userrolelabel.click();
			reuseable.WaitUntilElementVisible(userdropdown);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
			System.out.println("User Role: Admin");
			
			
		}
		else if(role.equalsIgnoreCase("ESS"))
		{
			userrolelabel.click();
			reuseable.WaitUntilElementVisible(userdropdown);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
			System.out.println("User Role: ESS");
			
		}
	}
	
	public void click_AddButton()
	{
		AddBtn.click();
		reuseable.WaitUntilElementVisible(savebtn);
	}
	
	public void select_AdminStatus()
	{
		status.click();
		reuseable.WaitUntilElementVisible(userdropdown);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		System.out.println("User is Enable");
	}
	
	
	public void select_EmployeeName(String name) throws Exception
	{
		empname.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(name).pause(4000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		System.out.println("Select Employee name");

	}
	
	public void fill_UserName_Password(String username,String password)
	{
		adminusername.sendKeys(username);
		

		Adminpassword.sendKeys(password);
		Confirmpassword.sendKeys(password);
	}
	
	
	public void save_NewAdmin() throws Exception
	{
		System.out.println("Normal Click");
		savebtn.click();
		Thread.sleep(4000);
	}
	
	
}
