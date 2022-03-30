package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/featuresfiles",            //path of feature files
		glue="stepDefination") 
public class testRunner extends AbstractTestNGCucumberTests {

}
