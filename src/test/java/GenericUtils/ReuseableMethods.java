package GenericUtils;

import org.openqa.selenium.WebDriver;

public class ReuseableMethods {

	WebDriver driver;
	public ReuseableMethods(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void LaunchOrangeHRMUrl()
	{
		String url = BaseClass.GetPropertyFromFile("searchurl");
		driver.get(url);
	}
	
	
	
	
	
}
