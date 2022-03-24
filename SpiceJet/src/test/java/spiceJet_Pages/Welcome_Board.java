package spiceJet_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Welcome_Board extends ChromeBrowser {

	public void fromLocation(String city1) {

		driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]//input")).sendKeys(city1);
	}

	public void toLocation(String city2) {

		String city="//div[text()=\"";
		city=city+city2+"\"]";
		//System.out.println(city);
		driver.findElement(By.xpath(city)).click();

	}

	public void departureDate(String Fulldate) {
		String[] str1=Fulldate.split("-",2);
		String date,month;
		date=str1[0];
		month=str1[1];
		//System.out.println(date+" "+month+" "+year);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String path;
		path=String.format("//div[contains(@data-testid,\"%s\")]//div[contains(@data-testid,\"day-%s\")]",month,date );
		//System.out.println(path);
		driver.findElement(By.xpath(path)).click();

	}

	public void searchButton() {

		driver.findElement(By.xpath("//*[@data-testid=\"home-page-flight-cta\"]")).click();
		WebElement No_Result=driver.findElement(By.xpath("//*[text()=\"Sorry, there are no flights available\"]"));
		if(No_Result.isDisplayed())
			System.out.println("No Flight Found");
	}

}
