package GenericUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	
	public void WaitUntilElementVisible(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		System.out.println("We are in Wait for Element Visibility");
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void WaitUntilElementInvisible(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		System.out.println("We are in Loader");
		wait.until(ExpectedConditions.invisibilityOf(e));
	}
	
	public void WaitUntilUrlGet(String url)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		System.out.println("We are in URL");
		wait.until(ExpectedConditions.urlContains(url));
	}
	
	
	
}
