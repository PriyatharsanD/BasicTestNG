package com.testng.ListenerAndRetryAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpl implements ITestListener,ISuiteListener{
	public void onStart(ISuite suite) {
		System.out.println(suite.getName());
	  }

	public void onTestFailure(ITestResult result)
	{
		String methodName=result.getMethod().getMethodName();
		WebDriver driver = BaseClass.driver;
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		File dest = new File("./screenshots/"+methodName+".png");
		try 
		{
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test is success");
	}
	public void onFinish(ISuite suite)
	{
		System.out.println("Finish");
		System.out.println(suite.getParallel());
	}
}
