package Playwright_Automation;


import java.nio.file.Paths;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FindLocator {
	Playwright playwright;
	BrowserType browserType;
	Browser browser;
	BrowserContext browserContext;
	Page driver;
	
	@BeforeSuite
	public void start() {
		playwright = Playwright.create();
		browserType = playwright.chromium();
		browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
		browserContext = browser.newContext(new Browser.NewContextOptions());
		driver = browser.newPage();
		
		System.out.println("Version : "+browser.version());
	}
	@Test(priority = 0)
	public void openUrl() throws InterruptedException {
		driver.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		Thread.sleep(5000);
	}
	@Test(priority = 1)
	public void getTitle() {
		String title = driver.title();
		System.out.println("Title :"+title);
	}
	@Test(priority = 2)
	public void locator() throws InterruptedException {
		ElementHandle name = driver.querySelector("//input[@id='name']");
		name.fill("Moin Khan");
		Thread.sleep(5000);
		
		ElementHandle email = driver.querySelector("//input[@id='email']");
		email.fill("moinkhan4363@gmail.com");
		Thread.sleep(5000);
		
		ElementHandle male = driver.querySelector("//input[@id='gender']");
		male.click();
		Thread.sleep(5000);
		
		ElementHandle mobile = driver.querySelector("//input[@id='mobile']");
		mobile.fill("01717511288");
		
		ElementHandle dob = driver.querySelector("//input[@id='dob']");
		dob.fill("2020-09-10");
		Thread.sleep(5000);
		
		ElementHandle sub = driver.querySelector("//input[@id='subjects']");
		sub.fill("Bangla");
		Thread.sleep(5000);
		
		ElementHandle hob = driver.querySelector("//div[7]//div[1]//div[1]//div[2]//input[1]");
		hob.click();
		Thread.sleep(5000);
		
		ElementHandle file = driver.querySelector("//input[@id='picture']");
		file.setInputFiles(Paths.get("C:\\Users\\benny\\OneDrive\\Desktop\\Recommendation Letter.pdf"));
		Thread.sleep(5000);
		
		ElementHandle add = driver.querySelector("//textarea[@id='picture']");
		add.fill("Dhaka, Bangladesh");
		Thread.sleep(5000);
		
		ElementHandle state = driver.querySelector("//select[@id='state']");
		state.selectOption("NCR");
		Thread.sleep(5000);
		
		ElementHandle city = driver.querySelector("//select[@id='city']");
		city.selectOption("Meerut");
		Thread.sleep(5000);
		
		ElementHandle reg = driver.querySelector("//input[@value='Login']");
		reg.click();
		Thread.sleep(5000);
		
		ElementHandle login = driver.querySelector("//a[normalize-space()='Login']");
		login.click();
		Thread.sleep(5000);
		
		ElementHandle login_email = driver.querySelector("//input[@id='email']");
		login_email.fill("moinkhan4363@gmail.com");
		Thread.sleep(5000);
		
		ElementHandle password = driver.querySelector("//input[@id='password']");
		password.fill("01717511288");
		Thread.sleep(5000);
		
		ElementHandle click_login = driver.querySelector("//input[@value='Login']");
		click_login.click();
		Thread.sleep(5000);
	}
	@AfterSuite
	public void close() {
		driver.close();
		browser.close();
		playwright.close();	
	}


}
