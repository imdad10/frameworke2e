package stepDefination;

import java.io.IOException;

import org.testng.Assert;

import endtoend.frame.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.portelLogin;


public class stepDeftn extends base {

	portelLogin prtlog;
	@Given("Initialise the browser with chrome")
	public void initialise_the_browser_with_chrome() throws IOException {
	   
		driver =browserInitialise();
	}
	@Given("Navigate to {string} site")
	public void navigate_to_site(String string) {
	   
		driver.get(string);
	}
	
	@Given("Click on login link in home page to land on secure sign in page")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() {
	    prtlog=new portelLogin(driver);
	    prtlog.popos().click();
	    prtlog.homebutton().click();
		prtlog.loginbot().click();
		
	}
	
	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		prtlog.mailfield().sendKeys(username);
		prtlog.getpassfield().sendKeys(password);
		prtlog.getconfirm().click();
    }
	@Then("Verify that user is succesfully logged in")
	public void verify_that_user_is_succesfully_logged_in() {
	   
		Assert.assertTrue(prtlog.getsearch().isDisplayed());
	}
	 @And("^close the browser$")
	    public void close_the_browser() throws Throwable {
	       driver.close();
	    }
}
