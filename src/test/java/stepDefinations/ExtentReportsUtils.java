package stepDefinations;

import java.net.SocketException;

import ProjectManagers.TextContextObject;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;

public class ExtentReportsUtils {

	TextContextObject textcontext;
	public ExtentReportsUtils(TextContextObject textcontext)
	{
		this.textcontext = textcontext;
	}
	
	@After
	public void close_browser()
	{
		textcontext.driver.close();

	}
	
	@AfterAll
	public static void tearDown()
	{
		
	}
	
}
