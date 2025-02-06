package com.testng.ListenerAndRetryAnalyzer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class AmazonTest extends BaseClass{
	@Test(retryAnalyzer = Retry.class)
	public void homePageTest()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("dsfjndkvn"));
		driver.close();
	}

}
