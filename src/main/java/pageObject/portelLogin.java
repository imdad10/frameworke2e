package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class portelLogin {

	
	public WebDriver driver;
	public portelLogin( WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(text(),'NO THANKS')]")
	private WebElement popups;
	
	@FindBy(xpath="(//div//nav/ul/li[@class='active']/a) [1]")
	private WebElement homebtn;
	
	@FindBy(css="div.page-wrapper header.main-header:nth-child(2) div.header-top div.auto-container div.clearfix div.top-right.clearfix div.login-btn:nth-child(3) > a.theme-btn.register-btn")
	private WebElement loginbutton;
	
	@FindBy(xpath="//div/input[@id='email']")
	private WebElement emailfield;
	
	@FindBy(xpath="//div/input[@id='password']")
	private WebElement passfield;
	
	@FindBy(xpath="//div/input[@name='commit']")
	private WebElement confirmbutton;
	
	//div/input[@id='search-courses']
	@FindBy(xpath="//div/input[@id='search-courses']")
	private WebElement searchbutton;
	
	
	public WebElement popos() {
		return popups;
	}
	
			
	public WebElement homebutton() {
		return homebtn;
	}		
	
	public WebElement loginbot() {
		return loginbutton;
	}
	
	public WebElement mailfield() {
		return emailfield;
		
	}
	public WebElement getpassfield() {
		return passfield;
		
	}
	public WebElement getconfirm() {
		return confirmbutton;
		
	}
	public WebElement getsearch() {
		return searchbutton;
		
	}
	
	
}
