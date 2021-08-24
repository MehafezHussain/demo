package com.Elements.testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.inetbanking.testCases.BaseClass;

public class TC_001 extends BaseClass

{
	//
	@Test
	public void firstTest(String Elements) throws IOException, InterruptedException 
	{
		try {	
		//Logger.info("URL is opened");
		String module =Elements;
		JavascriptExecutor je=(JavascriptExecutor)driver;
		WebDriverWait wait= new WebDriverWait(driver,60);
		
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+module+"']")));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		element.click();
		
		System.out.println(module +" is clicked");
		Thread.sleep(5000);
		}catch(Exception e) {}
	}
	
	
	@Test
	public void textbox() throws Throwable
	{
		WebDriverWait wait= new WebDriverWait(driver,60);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Elements']")));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		element.click();
		System.out.println("Elements clicked");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Text Box']")));
		driver.findElement(By.xpath("//*[text()='Text Box']")).click();
		System.out.println("Text box is clicked");
		logger.info("Text box is clicked");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@placeholder='Full Name']")).sendKeys("Hussain Shaik");
		driver.findElement(By.xpath("//*[@placeholder='name@example.com']")).sendKeys("shaik@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder='Current Address']")).sendKeys("Saleem Nagar");
		driver.findElement(By.xpath("//*[@id='permanentAddress']")).sendKeys("Nandyal");
		WebElement el=driver.findElement(By.xpath("//*[@id='submit']"));
		je.executeScript("arguments[0].scrollIntoView(true);",el);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='submit']")).click();
		System.out.println("Submit button is clicked");
		logger.info("Submit button is clicked");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='output']/div")));
		String output=driver.findElement(By.xpath("//*[@id='output']/div")).getText();
		System.out.println(output);
		scroll("//*[text()='Check Box']");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Check Box']")));
		System.out.println("Started");
		driver.findElement(By.xpath("//*[text()='Check Box']")).click();
		System.out.println("Check box is clicked");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@title='Expand all']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Desktop']")));
		driver.findElement(By.xpath("//*[text()='Desktop']")).click();
		driver.findElement(By.xpath("//*[text()='Documents']")).click();
		scroll("//*[text()='Office']");
		driver.findElement(By.xpath("//*[text()='Downloads']")).click();
		System.out.println("All Check boxes are clicked");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='result']")));
		scroll("//*[@id='result']");
		String result=driver.findElement(By.xpath("//*[@id='result']")).getText();
		System.out.println(result);
	/*	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Radio Button']")));
		scroll("//*[text()='Radio Button']");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Radio Button']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='yesRadio']")));
		driver.findElement(By.xpath("//*[@id='yesRadio']")).click();
		Thread.sleep(3000);
		String radio=driver.findElement(By.xpath("//*[@class='mt-3']")).getText();
		System.out.println(radio);
		*/ wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Web Tables']")));
		scroll("//*[text()='Web Tables']");
		driver.findElement(By.xpath("//*[text()='Web Tables']")).click();
		String table=driver.findElement(By.xpath("//*[@class='rt-table']")).getText();
		System.out.println(table);
		driver.findElement(By.xpath("//*[@placeholder='Type to search']")).sendKeys("Fruits");
		driver.findElement(By.xpath("//*[text()='Add']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='First Name']")));
		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("pine");
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Apple");
		driver.findElement(By.xpath("//*[@placeholder='name@example.com']")).sendKeys("pineapple@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder='Age']")).sendKeys("26");
		driver.findElement(By.xpath("//*[@placeholder='Salary']")).sendKeys("30000");
		driver.findElement(By.xpath("//*[@placeholder='Department']")).sendKeys("ECE");
		scroll("//*[text()='Submit']");
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Buttons']")));
		scroll("//*[text()='Buttons']");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Buttons']")).click();
		Thread.sleep(2000);
		Actions a=new Actions(driver);
		scroll("//*[text()='Double Click Me']");
		Thread.sleep(2000);
		a.doubleClick(driver.findElement(By.xpath("//*[text()='Double Click Me']"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Click Me']")).click();
		Thread.sleep(3000);
		//a.contextClick(driver.findElement(By.xpath("Right Click Me"))).perform();
		scroll("//*[text()='Links']");
		driver.findElement(By.xpath("//*[text()='Links']")).click();
		driver.findElement(By.xpath("//*[text()='Home']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='dynamicLink']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Created']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='linkResponse']")).getText());
		driver.findElement(By.xpath("//*[text()='No Content']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='linkResponse']")).getText());
		driver.findElement(By.xpath("//*[text()='Moved']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='linkResponse']")).getText());
		driver.findElement(By.xpath("//*[text()='Bad Request']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='linkResponse']")).getText());
		driver.findElement(By.xpath("//*[text()='Unauthorized']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='linkResponse']")).getText());
		driver.findElement(By.xpath("//*[text()='Forbidden']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='linkResponse']")).getText());
		driver.findElement(By.xpath("//*[text()='Not Found']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='linkResponse']")).getText());
		
		// to validate broken links
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Broken Links - Images']")));
	scroll("//*[text()='Broken Links - Images']");
	driver.findElement(By.xpath("//*[text()='Broken Links - Images']")).click();
	Thread.sleep(3000);
		List<WebElement> list=driver.findElements(By.tagName("a"));
		list.addAll(driver.findElements(By.tagName("href")));
		System.out.println("Total list :"+list.size());
		List<WebElement> newlist=new ArrayList<WebElement>();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getAttribute("href"));
			if(list.get(i).getAttribute("href")!=null) {
				newlist.add(list.get(i));
			}
		}
		System.out.println("size of active links "+newlist.size());
		
		for(int j=0;j<newlist.size();j++) {
			HttpURLConnection conn=(HttpURLConnection) new URL(newlist.get(j).getAttribute("href")).openConnection();
			conn.connect();
			String response=conn.getResponseMessage();
			conn.disconnect();
			System.out.println(newlist.get(j).getAttribute("href")+"---->"+response);
		}
		
		
		//to upload and download files
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Upload and Download']")));
		scroll("//*[text()='Upload and Download']");
		driver.findElement(By.xpath("//*[text()='Upload and Download']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='uploadFile']")).sendKeys("C:\\Users\\HUSSAIN\\Desktop\\Textfile.txt");
		Thread.sleep(5000);
		System.out.println("File uploaded");
		driver.findElement(By.xpath("//*[text()='Download']")).click();
		System.out.println("File downloaded");
		Thread.sleep(3000);
		
		// to validate dynamic properties
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Dynamic Properties']")));
		scroll("//*[text()='Dynamic Properties']");
		driver.findElement(By.xpath("//*[text()='Dynamic Properties']")).click();
		Thread.sleep(8000);
		
		WebElement colour=driver.findElement(By.xpath("//*[text()='Color Change']"));
		String btncolour=colour.getCssValue("color");
		
		System.out.println(btncolour);
	
		
	}
		
	
		
	
}
