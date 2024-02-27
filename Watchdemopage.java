package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Watchdemopage {
	WebDriver driver;
	//Constructor Created to pass the driver instances in this class
	public Watchdemopage(WebDriver driver) {
		this.driver= driver;
	}
	//All elements locators defined for Watch Demo Page
	By Watchdemo =By.className("button-default");
	By Firstname =By.id("FirstName");
	By Lastname=  By.id("LastName");
	By Email= By.id("Email");
	By Companyname=By.id("Company");
	By Phone=By.id("Phone");
	By Unitcount=By.name("Unit_Count__c");
	By Jobtitle=By.name("Title");

	//Verify all text fields on DemoWatch page
	public void fillField() {
		WebElement firstname=driver.findElement(Firstname);
		firstname.sendKeys("Komal");
		WebElement lastname=driver.findElement(Lastname);
		lastname.sendKeys("Kalbhor");
		WebElement email=driver.findElement(Email);
		email.sendKeys("Komalkalbhor@gmail.com");
		WebElement companyname=driver.findElement(Companyname);
		companyname.sendKeys("AAA Wholesale Cash & Carry");

		//  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement phone=driver.findElement(Phone);

		phone.sendKeys("525-452-1212");

		WebElement unitcount=driver.findElement(Unitcount);
		unitcount.sendKeys("1-10");
		WebElement jobtitle=driver.findElement(Jobtitle);
		jobtitle.sendKeys("Tester");
	}
}
