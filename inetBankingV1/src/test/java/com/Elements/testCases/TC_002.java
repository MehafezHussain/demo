package com.Elements.testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.inetbanking.testCases.BaseClass;

public class TC_002 extends BaseClass {

	
	@Test
	public void validate_windows() throws Throwable {
		
		TC_001 tc=new TC_001();
		tc.firstTest("Alerts, Frame & Windows");
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Browser Windows']")));
		scroll("//*[text()='Browser Windows']");
		driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='New Tab']")).click();
		Thread.sleep(5000);
		Set<String> window=driver.getWindowHandles();
		Iterator<String> ids=window.iterator();
		String parent=ids.next();
		String child=ids.next();
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='New Window']")));
		
		// to validate Alerts
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Alerts']")));
		scroll("//*[text()='Alerts']");
		driver.findElement(By.xpath("//*[text()='Alerts']")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Click me'])[1]")));

		driver.findElement(By.xpath("(//*[text()='Click me'])[1]")).click();
		Alert a=driver.switchTo().alert();
		a.accept();
		driver.findElement(By.xpath("(//*[text()='Click me'])[2]")).click();
		Thread.sleep(8000);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("(//*[text()='Click me'])[3]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("(//*[text()='Click me'])[4]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("Hello");
		driver.switchTo().alert().accept();
		System.out.println("Accepted");
		
		// to validate frames
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Frames']")));
		scroll("//*[text()='Frames']");
		driver.findElement(By.xpath("//*[text()='Frames']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(1);
		System.out.println("switched");
		String value=driver.findElement(By.xpath("(//*[@id='sampleHeading'])[1]")).getText();
		System.out.println(value);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		System.out.println("Switched2");
		String val=driver.findElement(By.xpath("(//*[@id='sampleHeading'])[1]")).getText();
		System.out.println(val);
		driver.switchTo().defaultContent();
		
		// to validate nested frames
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Nested Frames']")));
		scroll("//*[text()='Nested Frames']");
		driver.findElement(By.xpath("//*[text()='Nested Frames']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("frame1").switchTo().frame(0);
		String text=driver.findElement(By.tagName("p")).getText();
		System.out.println(text);
		driver.switchTo().parentFrame();
		System.out.println(driver.getPageSource());
		driver.switchTo().defaultContent();
		
		// to validate modal dialogues
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Modal Dialogs']")));
		scroll("//*[text()='Modal Dialogs']");
		driver.findElement(By.xpath("//*[text()='Modal Dialogs']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Small modal']")).click();
		System.out.println("Small Modal text :"+driver.findElement(By.xpath("//*[@class='modal-body']")).getText());
		driver.findElement(By.xpath("//*[@id='closeSmallModal']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Large modal']")).click();
		System.out.println("Large Modal text :"+driver.findElement(By.tagName("p")).getText());
		driver.findElement(By.xpath("//*[@id='closeLargeModal']")).click();

		
		
	}
	
	
	
	
}
