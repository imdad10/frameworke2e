package endtoend.frame;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resourse.extentReports;

public class listeners extends base implements ITestListener{
	
	ExtentReports extent=extentReports.reportsExtent();
	ExtentTest test;
	
	//in case of running test in parallel mode ThreadLocal class makes the test Thread safe prevent overriden of test
	ThreadLocal<ExtentTest> extentest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		
	  test=extent.createTest(result.getMethod().getMethodName());
	  extentest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		extentest.get().log(Status.PASS, "test case is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		//we need to inherit base class to access the methods of base class
		//here by using Result we get the method and method name of the failed test case and we pass the instance to screenshot method
		
		
		extentest.get().fail(result.getThrowable()); //we need to pass the fail log in this method so we use getThrowable mathod to get the failed logs
		
		WebDriver driver=null;
		String Testmethodname=result.getMethod().getMethodName();
		
		//to access the fields of failed test case we use this method
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
		} 
		
		try {
			extentest.get().addScreenCaptureFromPath(screenshot(Testmethodname,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}

	
	
}
