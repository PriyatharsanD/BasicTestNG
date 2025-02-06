package com.testng.batchExecution;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.time.Duration;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenAmazonTest {
	@Test
	public void test()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.close();
	}
	@Test
	public void readFile() throws IOException
	{
		File file = new File("./files/Resume-Priyatharsan D.pdf");
		PDDocument pdf = PDDocument.load(file);
		PDFTextStripper stripper = new PDFTextStripper();
		String text = stripper.getText(pdf);
		//System.out.println(text);
		
		
		BufferedReader reader = new BufferedReader(new StringReader(text));
		String lines = reader.readLine();
		while(lines!=null)
		{
			System.out.println(lines);
			lines=reader.readLine();
		}
		
		PrintWriter writer = new PrintWriter(new File("./files/resume.txt"));
		writer.write(text);
		writer.flush();
	}

}
