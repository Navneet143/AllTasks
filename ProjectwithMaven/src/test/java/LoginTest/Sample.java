package LoginTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
	WebDriver driver;

	public int changeTime(String time) {
		int val1 = 0, val0 = 0;
		try {
			String[] str2 = time.split(":");
			val1 = Integer.parseInt(str2[1]);
			val0 = Integer.parseInt(str2[0]);
		} catch (NumberFormatException e) {
			// e.printStackTrace();
			System.out.println("Not In Number Format");
		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace();
			System.out.println("Array ran out of bound");
		}
		return val0 * 60 + val1;
	}

	@Rule
	public TestName testname = new TestName();

	@Before
	public void RunBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Selenium\\chromedriver.exe");
		this.driver = new ChromeDriver();
	}

	@After
	public void AttheEnd() {
		System.out.println(testname.getMethodName() + " Test has Ended");
		driver.close();
	}

	@Test
	public void YouTube1() {
		String url = "https://www.youtube.com";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String searchValue = "Excuses by AP Dhillon";
		WebElement srch = driver.findElement(By.xpath("//input[contains(@id,\"search\")]"));
		srch.sendKeys(searchValue);
		srch.submit();
		driver.findElement(By.xpath("//yt-formatted-string[contains(@aria-label,\"by Intense\")]/../.")).click();
		try {
			driver.findElement(By.xpath("//button[contains(@class,\"ad-skip\")]")).click();
		} catch (NoSuchElementException e) {
			//e.printStackTrace();
			System.out.println("No Add occur");
		}
		WebElement  fiTime =driver.findElement(By.xpath("//span[@class=\"ytp-time-duration\"]"));
		String finaltime = fiTime.getText();
		System.out.println(finaltime);
		int ftime =0;
		ftime=changeTime(finaltime);
		//System.out.println(ftime);
		int ctime = 00;
		// Actions a = new Actions(driver);
		WebElement music_player = driver.findElement(By.xpath("//div[@id=\"movie_player\"]"));
		// Action mouseOverPlayer = a.moveToElement(music_player).build();
		while (ctime != ftime && ftime - ctime >= 5) {
			// System.out.println("...........Wait.......");
			try {
				Thread.sleep(4830);// 4850 for click
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// mouseOverPlayer.perform();
			finally{music_player.click();
			WebElement curTime = driver.findElement(By.xpath("//span[@class=\"ytp-time-current\"]"));
			String currentTime = "00:00";
			currentTime = curTime.getText();
			// System.out.println("The String is " + currentTime);
			ctime = changeTime(currentTime);
			if (ctime % 5 == 0) {
				System.out.println(currentTime + "/" + finaltime);
			}
			music_player.click();
		}
		}
		System.out.println("...........................Video is over....................");
	}
}
