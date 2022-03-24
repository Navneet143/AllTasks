package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.PracticePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PraticePageTest {

	PracticePage p1 = new PracticePage();
	WebDriver driver;
	
	@BeforeClass
	public void openChrome() throws Exception {
		String browser= System.getProperty("Browser");
		if(browser==null)
			browser="chrome";
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();		
			driver = new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.get("https://courses.letskodeit.com/practice");
	}

	@Test(enabled = true)
	public void CheckRadioButton() throws Throwable {
		try {
		Assert.assertEquals(p1.checkRadio(driver), 1);
		}catch (AssertionError e) {
			Assert.fail();
			e.getStackTrace();
		}
		}

	@Test
	public void checkOptions() throws Throwable {
		
		try {
			Assert.assertEquals(p1.checkOptions(driver), "Honda");
			}catch (AssertionError e) {
				Assert.fail();
				e.getStackTrace();
			}
	}
	
	@Test
	public void checkMulitpleSelect() throws Throwable {
		try {
			Assert.assertTrue(p1.checkMultipleSelect(driver));
			}catch (AssertionError e) {
				Assert.fail();
				e.getStackTrace();
			}
	}
	
	@Test
	public void checkCheckbox() throws Throwable {
		
		try {
			Assert.assertTrue(p1.checkCheckbox(driver));
			}catch (AssertionError e) {
				Assert.fail();
				e.getStackTrace();
			}
	}
	
	@Test
	public void checkWindow() throws Throwable{
		try {
			Assert.assertTrue(p1.checkWindow(driver));
			}catch (AssertionError e) {
				Assert.fail();
				e.getStackTrace();
			}
	}
	
	@Test
	public void checkTab() throws Throwable {
		try {
			Assert.assertTrue(p1.checkTab(driver));
			}catch (AssertionError e) {
				Assert.fail();
				e.getStackTrace();
			}
	}
	
	@Test
	public void checkAlert() throws Throwable {
		try {
			Assert.assertTrue(p1.checkAlert(driver));
			}catch (AssertionError e) {
				Assert.fail();
				e.getStackTrace();
			}
	}
	
	@Test
	public void checkEnable() throws Throwable {
		try {
			Assert.assertTrue(p1.checkEnableButton(driver));
			}catch (AssertionError e) {
				Assert.fail();
				e.getStackTrace();
			}
	}
	
	@Test
	public void checkHideFunction() throws Throwable {
		try {
			Assert.assertTrue(p1.checkHide(driver));
			}catch (AssertionError e) {
				Assert.fail();
				e.getStackTrace();
			}
	}
	
	public void checkmouseover() throws Throwable {
		try {
			Assert.assertTrue(p1.checkmouseover(driver));
			}catch (AssertionError e) {
				Assert.fail();
				e.getStackTrace();
			}
	}
	
	@Test
	public void checkIframe() throws Exception {
		try {
			Assert.assertTrue(p1.checkIframe(driver));
			}catch (AssertionError e) {
				Assert.fail();
				e.getStackTrace();
			}
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
