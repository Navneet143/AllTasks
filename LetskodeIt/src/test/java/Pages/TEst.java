package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TEst {

	WebDriver driver;

//	@BeforeClass
//	public void openBrowser() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://courses.letskodeit.com/practice");
//		// driver.manage().window().maximize();
//	}
	
	@Test
	public void test() throws Exception {
		System.out.println(System.getProperty("Browser"));
	}

//	@AfterTest
//	public void closeBrowser() throws Exception {
//		Thread.sleep(2000);
//		driver.close();
//	}

}