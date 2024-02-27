package object;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Propertymanagementpage {
	WebDriver driver;
	//Constructor Created to pass the driver instances in this class
	public Propertymanagementpage(WebDriver driver) {
		this.driver= driver;

	}
	//All elements locators defined for Property Management Page
	By Watchdemo =By.className("button-default");
	By Basecamp=By.xpath("//a[text()='Base Camp']");
	By product =By.className("header-nav-item");
	By Residential =By.linkText("ResidentPortal");

	// Click on watchDemo button and verify the Page Title in this action method
	public void demowatchclick() throws InterruptedException {
		WebElement watchdemo=driver.findElement(Watchdemo);
		watchdemo.click();
		Thread.sleep(3000);
		String Actualtitle= "https://go.entrata.com/watch-demo.html";
		String Expectedtitle=driver.getCurrentUrl();
		System.out.println("TestCase1 expected Result"+Expectedtitle);
		Assert.assertEquals(Actualtitle,Expectedtitle);	
	}

	// Click on clickBaseCamp button and display new URL and verify the  new Page  Page title
	public void clickBaseCamp() throws InterruptedException {
		//driver.navigate().back();
		Thread.sleep(30);
		System.out.println("After back :" +driver.getCurrentUrl());
		String mainwindow = driver.getWindowHandle();
		driver.findElement(Basecamp).click();
		Thread.sleep(30);
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		System.out.println(i1.hasNext());
		System.out.println(mainwindow);
		while (i1.hasNext()) {
			String Parentwindow = i1.next();
			String Childwindow = i1.next();
			System.out.println("Parent window:"+Parentwindow);
			System.out.println("Child window:"+Childwindow);
			if (!Parentwindow.equalsIgnoreCase(Childwindow)) {
				driver.switchTo().window(Childwindow);
				String actualresult=driver.getTitle();
				String expectedresult="Base Camp 2024 | Entrata";
				System.out.println("TestCase3 expected Title Result"+ actualresult + ":"+ expectedresult);
			}

		}
	}
	//Navigate ResidentPortal option on HomePage and verify page title of new page
	public void Product() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(3000);
		Actions action=new Actions(driver); 
		action.moveToElement(driver.findElement(product)).perform();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(Residential)).click().perform();
		Thread.sleep(3000);
		String expectedTitle="ResidentPortal by Entrata | Property Manager Tools";
		String actualTitle=driver.getTitle();
		System.out.println("Page new Title ="   +actualTitle);
		Assert.assertEquals(actualTitle,expectedTitle);

	}

}

