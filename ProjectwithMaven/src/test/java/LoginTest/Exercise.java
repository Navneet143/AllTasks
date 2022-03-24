package LoginTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.jupiter.api.Test;
import junit.framework.Assert;

public class Exercise {
	public WebDriver driver = null;

	public int changeTime(String time) {
		String[] str2 = time.split(":");
		int val1 = Integer.parseInt(str2[1]);
		int val0 = Integer.parseInt(str2[0]);
		return val0 * 60 + val1;
	}

	@BeforeEach
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@RepeatedTest(value = 5)
	public void repeatedTestDemo() throws Exception {
		try {
			String url = "https://www.youtube.com";
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String searchValue = "Excuses by AP Dhillon";
			WebElement srch = driver.findElement(By.xpath("//input[contains(@id,\"search\")]"));
			srch.sendKeys(searchValue);
			// srch.sendKeys(Keys.ENTER);
			srch.submit();
			// WebElement btn =
			// driver.findElement(By.xpath("//button[@id=\"search-icon-legacy\"]"));
			// btn.click();
			driver.findElement(By.xpath("//yt-formatted-string[contains(@aria-label,\"by Intense\")]/../.")).click();
			driver.findElement(By.xpath("//button[contains(@class,\"ad-skip\")]")).click();
			WebElement finalTime = driver
					.findElement(By.xpath("//*[@id=\"movie_player\"]/div[29]/div[2]/div[1]/div[1]/span[2]/span[3]"));
			int ftime = changeTime(finalTime.getText());
			System.out.println(ftime);
			int ctime = 0;
			Actions a = new Actions(driver);
			System.out.println("Wait.......");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement display = driver.findElement(By.xpath("//div[@id=\"movie_player\"]"));
			a.moveToElement(display).perform();
			WebElement curTime = driver.findElement(By.xpath("//span[@class=\"ytp-time-current\"]"));
			String currentTime = curTime.getText();
			System.out.println("The String is " + currentTime);
			ctime = changeTime(currentTime);
			if (ctime % 5 == 0) {
				System.out.println("Current Time:-" + ctime);
				System.out.println("Final Time:-" + ftime);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterEach
	public void tearDown() throws Exception {
		driver.quit(); // for illustration
	}

}