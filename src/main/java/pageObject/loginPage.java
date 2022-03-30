package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	public WebDriver driver;
	public loginPage( WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div input[id='user_email']")
	private WebElement emailid;
	
	@FindBy(xpath="//div//input[@id='user_password']")
	private WebElement password;
	
	@FindBy(xpath="//div//input[@name='commit']")
	private WebElement submitButton;
	
	@FindBy(xpath="//div//a[text()='Forgot Password?']")
	private WebElement fogotbutton;
	
	public WebElement mailid() {
		return emailid;
	}
	
	public WebElement password() {
		return password;
	}
	public WebElement subbutton() {
		return submitButton;
	}
	public WebElement forgotpass() {
		return fogotbutton;
		 // return new passwordforgot(driver);
	}
	
	
}
