package com.testng.distributedParallelExecution;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenRedbusTest {
	
	@Parameters("browser")
	@Test
	public void open(String browser)
	{
		System.out.println(browser);
		WebDriver driver;
		if(browser.equals("chrome"))
			driver = new ChromeDriver();
		else
			driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		driver.close();
	}
}