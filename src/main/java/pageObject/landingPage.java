package pageObject;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage {

	public WebDriver driver;
	public landingPage( WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(text(),'NO THANKS')]")
	private WebElement popup;
	
	@FindBy(css="a[href*='sign_in']")
	private WebElement login;
	
	@FindBy(xpath="//section//div//div//h2[contains(text(),'Featured Courses')]")
	private WebElement title;
	
	//nav//ul[@class='nav navbar-nav navbar-right']
	@FindBy(xpath="//nav//ul[@class='nav navbar-nav navbar-right']")
	private WebElement headers;
	
	
	
	public WebElement popo() {
		return popup;
	}
	public WebElement login() {
		return login;
		//return new loginPage(driver);
	}
	public WebElement tittles() {
		return title;
	}
	public WebElement heads() {
		return headers;
	}
}
