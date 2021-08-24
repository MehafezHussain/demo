package com.Elements.testCases;

import java.io.IOException;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.inetbanking.testCases.BaseClass;

public class TC_004 extends BaseClass {

	
	@Test
	public void validate_Interactions() throws Throwable, InterruptedException {
		TC_001 tc=new TC_001();
		tc.firstTest("Interactions");
		WebDriverWait wait=new WebDriverWait(driver,50);
		
		// to validate Selectable
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Selectable']")));
		scroll("//*[text()='Selectable']");
		driver.findElement(By.xpath("//*[text()='Selectable']")).click();
		Thread.sleep(4000);
		for(int i=1;i<=4;i++) {
			scroll("(//*[@id='verticalListContainer']/li)[\"+i+\"]");
			driver.findElement(By.xpath("(//*[@id='verticalListContainer']/li)["+i+"]")).click();
			boolean flag=driver.findElement(By.xpath("(//*[@id='verticalListContainer']/li)["+i+"]")).isEnabled();
			System.out.println(flag);
			Thread.sleep(1000);
		}
		scroll("//*[text()='Grid']");
		driver.findElement(By.xpath("//*[text()='Grid']")).click();
		Thread.sleep(2000);
		System.out.println("Grid selected");
		for(int i=1;i<=9;i++) {
			driver.findElement(By.xpath("(//*[@id='gridContainer']/div/li)["+i+"]")).click();
			boolean flag=driver.findElement(By.xpath("(//*[@id='gridContainer']/div/li)["+i+"]")).isEnabled();
			System.out.println(flag);
			Thread.sleep(1000);
		}
		
		// to validate Resizable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Resizable']")));
		scroll("//*[text()='Resizable']");
		driver.findElement(By.xpath("//*[text()='Resizable']")).click();
		Thread.sleep(2000);
		WebElement resize=driver.findElement(By.xpath("(//*[@class='react-resizable-handle react-resizable-handle-se'])[1]"));
		Actions a=new Actions(driver);
		a.dragAndDropBy(resize, 400, 250).perform();
		Thread.sleep(2000);
		scroll("(//*[@class='react-resizable-handle react-resizable-handle-se'])[2]");
		WebElement resize2=driver.findElement(By.xpath("(//*[@class='react-resizable-handle react-resizable-handle-se'])[2]"));
		a.dragAndDropBy(resize2, 400, 250).perform();
		System.out.println("Resize performed");
		Thread.sleep(2000);
		
		// to validate Droppable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Droppable']")));
		scroll("//*[text()='Droppable']");
		driver.findElement(By.xpath("//*[text()='Droppable']")).click();
		Thread.sleep(2000);
		WebElement first=driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement second=driver.findElement(By.xpath("//*[@id='droppable']"));
		a.dragAndDrop(first, second).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Accept']")).click();
		Thread.sleep(2000);
		WebElement notaccepted=driver.findElement(By.xpath("//*[text()='Not  Acceptable']"));
		WebElement accepted=driver.findElement(By.xpath("//*[text()='Acceptable']"));
		WebElement dropped=driver.findElement(By.xpath("//*[text()='Dropped!']"));
		a.dragAndDrop(notaccepted, dropped).perform();
		a.dragAndDrop(accepted, dropped).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Prevent Propogation']")).click();
		WebElement dragme=driver.findElement(By.xpath("//*[@id='dragBox']"));
		WebElement outer=driver.findElement(By.xpath("//*[@id='notGreedyDropBox']"));
		WebElement inner=driver.findElement(By.xpath("//*[@id='notGreedyInnerDropBox']"));
		a.dragAndDrop(dragme, outer).perform();
		Thread.sleep(2000);
		a.dragAndDrop(dragme, inner).perform();
		driver.findElement(By.xpath("//*[@id='droppableExample-tab-revertable']")).click();
		WebElement revert=driver.findElement(By.xpath("//*[@id='revertable']"));
		WebElement notrevert=driver.findElement(By.xpath("//*[@id='notRevertable']"));
		WebElement dropped2=driver.findElement(By.xpath("(//*[text()='Drop here'])[2]"));
		a.dragAndDrop(revert, dropped2).perform();
		Thread.sleep(2000);
		a.dragAndDrop(notrevert, dropped2).perform();
		Thread.sleep(2000);
		System.out.println("All drags are dropped");
	
	}
}
