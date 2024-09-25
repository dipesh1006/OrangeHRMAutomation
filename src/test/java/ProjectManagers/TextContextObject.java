package ProjectManagers;

import org.openqa.selenium.WebDriver;

import GenericUtils.BaseClass;


public class TextContextObject {

	public WebDriver driver;
	public ObjectManager objmanager;
	BaseClass base;
	
	public TextContextObject()
	{
		base = new BaseClass();
    	this.driver = base.getDriver();
    	objmanager = new ObjectManager(base.getDriver());
	}
	
	
}
