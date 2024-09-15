package Playwright_Automation;



import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class StartChromBrowser {
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
		driver.navigate("https://www.daraz.com.bd/");
		Thread.sleep(5000);
	}
	@Test(priority = 1)
	public void getTitle() throws InterruptedException {
		String title = driver.title();
		System.out.println(title);
		Thread.sleep(2000);
	}
	@Test(priority = 2)
	public void getUrl() throws InterruptedException {
		String url = driver.url();
		System.out.println("Url :"+url);
		Thread.sleep(2000);
	}
	@Test(priority = 3)
	public void scroll() throws InterruptedException {
		ElementHandle card_title = driver.querySelector("//span[@class='hp-mod-card-title']");
		card_title.scrollIntoViewIfNeeded();
		Thread.sleep(5000);
		ElementHandle hover_locator = driver.querySelector("//i[contains(@class,'J_LazadaIcon lazada-icon lazada-ic-Categories &#xe6fd;')]");
		hover_locator.hover();
		Thread.sleep(5000);
		ElementHandle click_cate = driver.querySelector("//div[contains(text(),'Categories')]");
		click_cate.click();
		Thread.sleep(5000);
	}
	@Test(priority = 4)
	public void scrolDown() throws InterruptedException {
		String scriptButtom= "window.scrollTo(0,document.body.scrollHeight)";
		driver.evaluate(scriptButtom);
		Thread.sleep(5000);
		
		String scriptTop= "window.scrollTo(0,0)";
		driver.evaluate(scriptTop);
		Thread.sleep(5000);
	}
	@Test(priority = 5)
	public void login() throws InterruptedException {
		ElementHandle log = driver.querySelector("//a[normalize-space()='Login']");
		log.click();
		Thread.sleep(5000);
		ElementHandle daraz = driver.querySelector("//img[@alt='Online Shopping Daraz Logo']");
		daraz.click();
		Thread.sleep(5000);
	}
	@AfterSuite
	public void close() {
		driver.close();
		browser.close();
		playwright.close();	
	}

}
