package com.testng.ListenerAndRetryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int count=1;
	public boolean retry(ITestResult result) {
		if(count<=5)
		{
			count++;
			return true;
		}
		else
			return false;
	}

}
