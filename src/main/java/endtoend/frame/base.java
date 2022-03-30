package endtoend.frame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;



public class base {

	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver browserInitialise() throws IOException {
		
	    prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\lenovo\\eclipse-workspacePathan\\frame\\src\\main\\java\\resourse\\data.properties");
	    prop.load(fis);
	    String  browsername=prop.getProperty("browser");
	    //mvn test -Dbrowser=chrome
	    
	 //   String  browsername=System.getProperty("browser"); //for maven to know which in browser we want to execute..this we go and check in maven cmd that any browser is define
	    
	 // String driverpath =System.getProperty("user.dir"); //it will give the project path
	    
	    if(browsername.contains("chrome")) {
	    	
	    	System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		 /*  ChromeOptions option=new ChromeOptions();
		  if(browsername.contains("headless")) {
				  option.addArguments("headless");
		  }*/
	    	driver =  new ChromeDriver();   
	    }
	    else if(browsername.equals("firefox")){
	    	
	    
	        
	    }
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	public String screenshot(String testcasename,WebDriver driver) throws IOException {
		
		//here we get the name of the failed test through listeners 
		File shot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\reports\\"+ testcasename+".png";
		FileUtils.copyFile(shot,new File(destination));
		 return destination;
		
	}
	
}
