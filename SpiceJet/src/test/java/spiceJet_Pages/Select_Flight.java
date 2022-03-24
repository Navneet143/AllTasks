package spiceJet_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Select_Flight extends ChromeBrowser {
	
	public String fNumber;
	public String fPrice;
	public String f_type;
	
	public void selectFlight(String flight_type) {
		this.f_type=flight_type;
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		String flight="";
		if(flight_type.equalsIgnoreCase("spicemax"))
		flight = String.format("(//*[@data-testid=\"%s-flight-select-radio-button-3\"])[1]", flight_type.toLowerCase());
		if(flight_type.equalsIgnoreCase("spicesaver"))
			flight = String.format("(//*[@data-testid=\"%s-flight-select-radio-button-1\"])[1]", flight_type.toLowerCase());
			
		if(flight_type.equalsIgnoreCase("spiceflex"))
			flight = String.format("(//*[@data-testid=\"%s-flight-select-radio-button-2\"])[1]", flight_type.toLowerCase());
		System.out.println(flight);
		driver.findElement(By.xpath(flight)).click();
		fNumber = driver.findElement(By.xpath("//div[text()=\"SG 191\"]")).getText();
		System.out.println(fNumber);
	    fPrice = driver.findElement(By.xpath("(//*[text()=\"5,619\"])[1]")).getText();
		System.out.println("Rupees"+"="+ fPrice);
	}
	
	public void continueButton() {
		WebElement next = driver.findElement(By.xpath("//div[@data-testid=\"continue-search-page-cta\"][3]"));
		Actions act = new Actions(driver);
		act.click(next).build().perform();
		if(f_type.equalsIgnoreCase("Spicesaver")) {
			act.click(next).build().perform();
			act.click(next).build().perform();
		}
		
	}
}
