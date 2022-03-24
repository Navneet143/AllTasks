package YoutubeTimestamp;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class youtubeTimestamp {
	public static int changeTime(String time) {
		int val0 = 0, val1 = 0;
		//System.out.println(time);
		try {

			String str2[] = time.split(":");
			val0 = Integer.parseInt(str2[0]);
			val1 = Integer.parseInt(str2[1]);
			/*for (String value : str2)
				System.out.print(value + " ");*/
			// System.out.println("\n" + val0 + " " + val1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		int tm = val0 * 60 + val1;
		return tm;
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:\\\\Software\\\\Selenium\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
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
			e.printStackTrace();
		}
		String finalTime = driver.findElement(By.xpath("//span[@class=\"ytp-time-duration\"]")).getText();
		int ftime = changeTime(finalTime);
		//System.out.println(ftime);
		int ctime = 0;
		Actions a = new Actions(driver);
		WebElement music_player = driver.findElement(By.xpath("//div[@id=\"movie_player\"]"));
		while (ctime != ftime) {
			System.out.println("...........Wait.......");
			try {
				Thread.sleep(4850);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// a.moveToElement(music_player).build().perform();
			music_player.click();
			// ebDriverWait wait = new WebDriverWait(driver, 10);
			// WebElement curTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"ytp-time-current\"]")));
			WebElement curTime = driver.findElement(By.xpath("//span[@class=\"ytp-time-current\"]"));
			if (curTime.isDisplayed()) {
				String currentTime = curTime.getText();
				//System.out.println("The String is " + currentTime);
				ctime = changeTime(currentTime);
				if (ctime % 5 == 0) {
					System.out.println("Current Time:-" + currentTime);
					System.out.println("Final Time:-" + finalTime);
				}
				music_player.click();
			} else
				System.out.println("Element Not Found");
		}
	}
}
