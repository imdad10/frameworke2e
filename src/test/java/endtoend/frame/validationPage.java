package endtoend.frame;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import pageObject.landingPage;


public class validationPage extends base {
 
	public WebDriver driver;
	 private static Logger log=LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialise() throws IOException {
		driver=browserInitialise();
		log.info("validation page displayed");
		driver.get(prop.getProperty("url"));
		log.info("navi gated to validation page");
	}
	
	@Test
	public void validationbar() throws IOException {
		
		landingPage lp=new landingPage(driver);
		lp.popo().click();
		String title=lp.tittles().getText();
		System.out.println(title);
		Assert.assertEquals(title, "FEATURED 123COURSES");
		//lp.heads().isDisplayed();
		Assert.assertTrue(lp.heads().isDisplayed());
		log.info("test case pass");
		
		}
	@AfterMethod
	 public void closing() {
		 driver.close();
	 }
	
	      
}

