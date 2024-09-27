package stepDefinations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericUtils.ReuseableMethods;
import POMClasses.LoginPageOrangeHRM;
import ProjectManagers.TextContextObject;
import io.cucumber.java.en.*;

public class RetestPasswordSD {

	TextContextObject textcontextobject;
	LoginPageOrangeHRM loginpage;
	ReuseableMethods reuseable;
	
	public RetestPasswordSD(TextContextObject textcontextobject) 
	{
		this.textcontextobject = textcontextobject;
	}

	
	
	@When("Click on Forget Password for user {string}")
	public void click_on_forget_password(String username) throws Exception {
	    
		loginpage = textcontextobject.objmanager.getObjectLoginPageOrangeHRM();
		loginpage.click_Forget_Password();
		loginpage.fill_forget_username_Click_Resetbtn(username);
	}

	@Then("Verify {string} and {string} in a dialogbox")
	public void verify_and_in_a_dialogbox(String message1, String message2) throws Exception {

		loginpage.verify_RestPassword_dialougeBox_ErrorMessage(message1,message2);
	}

}
