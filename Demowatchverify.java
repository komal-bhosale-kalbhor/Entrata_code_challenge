package Testscenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import object.Propertymanagementpage;
import object.Watchdemopage;

public class Demowatchverify {

	WebDriver driver;
	Propertymanagementpage page;
	Watchdemopage page1;

	@BeforeTest
	// We are opening Entrata.com application in Chrome browser
	public void beforeTest()  {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(co);

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.entrata.com/");
		driver.manage().window().maximize();
	}
	@Test(priority=0)	
	//Test DemoWatch link functionality by click on DemoWatch link button
	public void clickDemowatch() throws InterruptedException {
		Propertymanagementpage page =new Propertymanagementpage(driver);
		page.demowatchclick();


	}
	@Test(priority=1)	
	//Test All fields of registration fields for watch demo functionality
	public void fieldFill() {

		Watchdemopage page1 =new Watchdemopage(driver);
		page1.fillField();;
	}
	@Test(priority=3)
	//Verify BaseCamp navigation Page
	public void baseCampClick() throws InterruptedException {
		Propertymanagementpage page =new Propertymanagementpage(driver);
		page.clickBaseCamp();

	}
	@Test(priority=2)
	//Test ResidentPortal option navigation
	public void productClick() throws InterruptedException {

		page =new Propertymanagementpage(driver);
		page.Product();
	}

	@AfterTest
	//CLose the Browser
	public void tearDown() {
		driver.quit();
	}
}
