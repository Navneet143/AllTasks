package spiceJet_Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.Before;

public class ChromeBrowser {
	static public WebDriver driver;
	public void launch_ChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.spicejet.com/");
	}
	
}
