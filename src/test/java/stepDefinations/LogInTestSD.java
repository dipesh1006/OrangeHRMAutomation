package stepDefinations;

import GenericUtils.ReuseableMethods;
import POMClasses.LoginPageOrangeHRM;
import ProjectManagers.TextContextObject;
import io.cucumber.java.en.*;

public class LogInTestSD {

	TextContextObject textcontextobject;
	LoginPageOrangeHRM loginpage;
	ReuseableMethods reuseable;
	
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
		
		loginpage = textcontextobject.objmanager.getObjectLoginPageOrangeHRM();
		loginpage.fill_userName_password_details(username, password);
		
	}

	@When("Click on LogIn Btn")
	public void click_on_log_in_btn() throws Exception {
		
		
		loginpage.log_In();
	}

	@Then("Verify able to login and Dashboard")
	public void verify_able_to_login_and_dashboard() {
		
		loginpage.VerifyUserableToLoginOrNot();
	}

}
