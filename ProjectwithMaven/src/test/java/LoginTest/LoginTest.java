package LoginTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	@Rule public TestName testName = new TestName();
	WebDriver driver;
	WebElement username,password,login;
	@Before
	public void openBrowser() {
		//System.setProperty("webdriver.chrome.driver", "E:\\Software\\Selenium\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.browserstack.com/users/sign_in");
		this.username=driver.findElement(By.xpath("//input[@id=\"user_email_login\"]"));
		this.password=driver.findElement(By.id("user_password"));
		this.login=driver.findElement(By.name("commit"));
	}
	@After
	public void End() {
		System.out.println("The "+ testName.getMethodName()+" Test has ended" );
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		driver.close();
	}
	
	@Test
	public void Logintest1() {
		username.sendKeys("xyz@alfaceti.com");
		password.sendKeys("welcome@back");
		login.click();
	
	}
	@Test
	public void Logintest2() {
		username.sendKeys("paxeve6043@alfaceti.com");
		password.sendKeys("welcome@back");
		login.click();
	}

}
