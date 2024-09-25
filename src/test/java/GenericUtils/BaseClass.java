package GenericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;
	public static Properties prop;
	
	public BaseClass()
	{
		this.prop = new Properties();
		
        try {
            prop.load(new FileInputStream("./src/test/resources/test_property.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	public WebDriver getDriver()
	{
		if(driver==null)
		{
			
	       String browsername =  prop.getProperty("browser");
	       
			switch (browsername) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			}
	       
	       driver.manage().window().maximize();
			
		}
		return driver;
	}
	
	public static String GetPropertyFromFile(String key)
	{
		String property = null;
		try {
			property = prop.getProperty("searchurl");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally
		{
			return property;
		}
		
	}
	
	
}
