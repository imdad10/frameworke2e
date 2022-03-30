package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class passwordforgot {
	public WebDriver driver;
	public passwordforgot( WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//form//div//input[@id='user_email']")
	private WebElement emailtext;
	
	@FindBy(xpath="//div//input[@type='submit']")
	private WebElement instructionClick;
	
	public WebElement userEmail() {
		return emailtext;
	}
	
	public WebElement instructbutton() {
		return instructionClick;
	}
	
}
