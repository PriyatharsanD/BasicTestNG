package com.testng.extendReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportGeneration {
	ExtentSparkReporter spark;
	ExtentReports report;
	@BeforeSuite
	public void beforeSuite()
	{
		spark = new ExtentSparkReporter("./advancedReport/udemyReport.html");
		spark.config().setDocumentTitle("UdemyTest");
		spark.config().setReportName("Udemy Test Report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","WINDOW");
		report.setSystemInfo("System Name","TYP-PRIYA");
		report.setSystemInfo("Browser","Chrome");
	}
	@Test
	public void homePageTest()
	{
		ExtentTest test = report.createTest("Home Page");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		test.log(Status.PASS,"Browser is Launched");
		driver.get("https://www.udemy.com/");
		test.log(Status.INFO,"Home page is opened");
		test.log(Status.PASS,"Test is Passed");
		report.flush();
		driver.close();
	}
	
	@Test()
	public void searchCourseTest() throws InterruptedException
	{
		ExtentTest test = report.createTest("Search Course");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		test.log(Status.PASS,"Browser is Launched");
		driver.get("https://www.udemy.com/");
		test.log(Status.INFO,"Home page is opened");
		Thread.sleep(2000);
		WebElement searchField=driver.findElement(By.id("search-form-autocomplete--25724"));
		searchField.sendKeys("Java");
		test.log(Status.INFO,"Course is entered");
		searchField.submit();
		test.log(Status.INFO,"Submit is clicked");
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("Search results | Udemy"))
			test.log(Status.PASS,"Courses are dispayed");
		else
			test.log(Status.FAIL,"Courses are not dispayed");
		report.flush();
	}
	

}
