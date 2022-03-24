package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest {

public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver", "E:\\Software\\Selenium\\chromedriver.exe");
	//WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	//driver.manage().window().maximize();
	driver.get("https://www.browserstack.com/users/sign_in");
	WebElement username=driver.findElement(By.xpath("//input[@id=\"user_email_login\"]"));
	WebElement password=driver.findElement(By.id("user_password"));
	WebElement login=driver.findElement(By.name("commit"));
	username.sendKeys("abc@gmail.com");
	password.sendKeys("p@ssword");
	login.click();
	Thread.sleep(2000);
	driver.close();
	
	
}
	
}