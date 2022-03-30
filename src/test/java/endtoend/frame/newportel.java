package endtoend.frame;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pageObject.portelLogin;

public class newportel extends base {

	
	
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void linkIntialise() throws IOException {
		driver = browserInitialise();
		log.info("driver initialised");
		
		driver.get(prop.getProperty("url"));
		log.info("navigate to url");
	}
	@Test
	public void validationbar() throws IOException, InterruptedException {
		
		portelLogin prtlog=new portelLogin(driver);
		
	
		prtlog.popos().click();
		prtlog.homebutton().click();
		prtlog.loginbot().click();
		Thread.sleep(2000);
		prtlog.mailfield().sendKeys("hbb");
		prtlog.getpassfield().sendKeys("dijd");
		prtlog.getconfirm().click();
		Thread.sleep(2000);
		
		
		
		//Assert.assertTrue(prtlog.getsearch().isDisplayed());
		log.info("test case pass");
		
		}
	@AfterMethod
	 public void closing() {
		 driver.close();
	 }
}
