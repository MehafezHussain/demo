package com.Elements.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.inetbanking.testCases.BaseClass;

public class TC_003 extends BaseClass {

	
	@Test
	public void validate_Widgets() throws Throwable {
		
		TC_001 tc=new TC_001();
		tc.firstTest("Widgets");
		WebDriverWait wait=new WebDriverWait(driver,50);
		
		// Validate Accordian
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Accordian']")));
		scroll("//*[text()='Accordian']");
		driver.findElement(By.xpath("//*[text()='Accordian']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("(//*[@class='card-body']/p)[1]")).getText());
		scroll("//*[@id='section2Heading']");
		driver.findElement(By.xpath("//*[@id='section2Heading']")).click();
		System.out.println(driver.findElement(By.xpath("(//*[@class='card-body']/p)[2]")).getText());
		System.out.println(driver.findElement(By.xpath("(//*[@class='card-body']/p)[3]")).getText());
		scroll("//*[@id='section3Heading']");
		driver.findElement(By.xpath("//*[@id='section3Heading']")).click();
		System.out.println(driver.findElement(By.xpath("(//*[@class='card-body']/p)[4]")).getText());

		//validate Auto complete
/*		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Auto Complete']")));
		scroll("//*[text()='Auto Complete']");
		driver.findElement(By.xpath("//*[text()='Auto Complete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='auto-complete__value-container auto-complete__value-container--is-multi css-1hwfws3']")).click();
		System.out.println("clicked");
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@class='auto-complete__control css-yk16xz-control']")).sendKeys("yellow");
		driver.findElement(By.xpath("//*[@class='auto-complete__control css-yk16xz-control']")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//*[@class='auto-complete__value-container auto-complete__value-container--is-multi css-1hwfws3']")).sendKeys("red",Keys.ENTER);
		driver.findElement(By.xpath("//*[@class='auto-complete__value-container css-1hwfws3']")).sendKeys("Blue",Keys.ENTER);
	 
	*/	// to select date
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Date Picker']")));
		scroll("//*[text()='Date Picker']");
		driver.findElement(By.xpath("//*[text()='Date Picker']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='datePickerMonthYearInput']")).click();
		Select s =new Select(driver.findElement(By.xpath("//*[@class='react-datepicker__month-select']")));
		s.selectByVisibleText("September");
		Select s1 =new Select(driver.findElement(By.xpath("//*[@class='react-datepicker__year-select']")));
		s1.selectByVisibleText("2022");
		driver.findElement(By.xpath("//*[text()='15']")).click();
		System.out.println("Date has entered");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dateAndTimePickerInput']")).click();
		Thread.sleep(3000);
	
		// to drag the slider
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Slider']")));
		scroll("//*[text()='Slider']");
		driver.findElement(By.xpath("//*[text()='Slider']")).click();
		Thread.sleep(2000);
		WebElement e=driver.findElement(By.xpath("//*[@class='range-slider range-slider--primary']"));
		Actions a =new Actions(driver);
		a.dragAndDropBy(e, 0, 50).perform();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//*[@id='sliderValue']")).getText());
		System.out.println("Slider has dragged");
		
		// to validate progress bar
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Progress Bar']")));
		scroll("//*[text()='Progress Bar']");
		driver.findElement(By.xpath("//*[text()='Progress Bar']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Start']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Stop']")).click();
		System.out.println("The bar dragged upto "+driver.findElement(By.xpath("//*[@role='progressbar']")).getText());
		
		// to validate tabs
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Tabs']")));
		scroll("//*[text()='Tabs']");
		driver.findElement(By.xpath("//*[text()='Tabs']")).click();
		Thread.sleep(2000);
		for(int i=1;i<=3;i++) {
			driver.findElement(By.xpath("(//*[@role='tablist']/a)["+i+"]")).click();
			Thread.sleep(1000);
			System.out.println(driver.findElement(By.tagName("p")).getText());
			System.out.println("-----------");
		}
		
	 // to validate tooltips
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Tool Tips']")));
		scroll("//*[text()='Tool Tips']");
		driver.findElement(By.xpath("//*[text()='Tool Tips']")).click();
		Thread.sleep(2000);
		WebElement el=driver.findElement(By.xpath("//*[@id='toolTipButton']"));
		
		a.moveToElement(el).build().perform();
		System.out.println(driver.findElement(By.xpath("//*[@class='tooltip-inner']")).getText());
		Thread.sleep(2000);
		WebElement e2=driver.findElement(By.xpath("//*[@id='toolTipTextField']"));
		a.moveToElement(e2).build().perform();
		System.out.println(driver.findElement(By.xpath("//*[@class='tooltip-inner']")).getText());
		Thread.sleep(2000);
		WebElement e3=driver.findElement(By.xpath("(//*[@id='texToolTopContainer']/a)[1]"));
		a.moveToElement(e3).build().perform();
		System.out.println(driver.findElement(By.xpath("//*[@class='tooltip-inner']")).getText());
		Thread.sleep(2000);
		scroll("(//*[@id='texToolTopContainer']/a)[2]");
		WebElement e4=driver.findElement(By.xpath("(//*[@id='texToolTopContainer']/a)[2]"));
		a.moveToElement(e4).build().perform();
		System.out.println(driver.findElement(By.xpath("//*[@class='tooltip-inner']")).getText());
		Thread.sleep(2000);
		
		// to validate Select menu
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Select Menu']")));
		scroll("//*[text()='Select Menu']");
		driver.findElement(By.xpath("//*[text()='Select Menu']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Select Option']")).click();
		driver.findElement(By.xpath("//*[text()='Group 1, option 1']")).click();
		Thread.sleep(2000);
		System.out.println("option selected");
		driver.findElement(By.xpath("//*[text()='Select Title']")).click();
		driver.findElement(By.xpath("//*[text()='Mr.']")).click();
		Thread.sleep(2000);
		Select s2=new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
		s2.selectByVisibleText("Blue");
		Thread.sleep(2000);
		scroll("(//*[@class=' css-1hwfws3'])[3]");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class=' css-1hwfws3'])[3]")).click();
		driver.findElement(By.xpath("//*[text()='Black']")).click();
		Thread.sleep(2000);
		scroll("//*[@name='cars']");
		Select s3=new Select(driver.findElement(By.xpath("//*[@name='cars']")));
		s3.selectByVisibleText("Saab");
		s3.selectByVisibleText("Opel");
		Thread.sleep(2000);
		System.out.println("Multiple selected");
		
		
		
		
		
	}
}
