package stepDefinations;

import ProjectManagers.TextContextObject;
import io.cucumber.java.en.*;

public class LogInTestSD {

	TextContextObject textcontextobject;
	
	public LogInTestSD(TextContextObject textcontextobject) 
	{
		this.textcontextobject = textcontextobject;
	}

	@Given("Open the OrangeHRM Portal")
	public void open_the_orange_hrm_portal() throws InterruptedException {
		
		textcontextobject.objmanager.getObjectReuseableMethods().LaunchOrangeHRMUrl();
		Thread.sleep(4000);
		
	}

	@When("Try to Log in with {string} and {string}")
	public void try_to_log_in_with_and(String username, String password) {
		
		
	}

	@When("Click on LogIn Btn")
	public void click_on_log_in_btn() {
		
	}

	@Then("Verify {string} able to login and Dashboard")
	public void verify_able_to_login_and_dashboard(String string) {
		
		
	}

}
