package endtoend.frame;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.landingPage;
import pageObject.loginPage;
import pageObject.passwordforgot;

public class homePage extends base {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeMethod
	public void initialise() throws IOException {
		driver = browserInitialise();
		log.info("driver initialised");
		driver.get(prop.getProperty("url"));
		log.info("navigate to url");
	}

	@Test(dataProvider = "data")
	public void browse(String email, String pass) throws IOException, InterruptedException {

		landingPage lp = new landingPage(driver);
		lp.popo().click();
		lp.login().click();

		// WebDriverWait wait=new WebDriverWait(driver, 5);

		// WebElement
		// ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div
		// input[id='user_email']")));
		// ele.sendKeys(email);
		loginPage logpg = new loginPage(driver);
		logpg.mailid().sendKeys(email);
		logpg.password().sendKeys(pass);
		logpg.subbutton().click();
		logpg.forgotpass().click();
		// Thread.sleep(3000);

		passwordforgot pf = new passwordforgot(driver);
		pf.userEmail().sendKeys("pathanimdad111");
		// Thread.sleep(2000);
		pf.instructbutton().click();

		System.out.println(" sdhdh");

	}

	@DataProvider
	public Object[][] data() {

		Object[][] obj = new Object[2][2];

		obj[0][0] = "pass";
		obj[0][1] = "hey";

		obj[1][0] = "hgjhg";
		obj[1][1] = "jack";

		return obj;
	}

	@AfterMethod
	public void closing() {
		driver.close();
	}

}
