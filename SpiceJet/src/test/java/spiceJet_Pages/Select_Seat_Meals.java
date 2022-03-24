package spiceJet_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sun.tools.javac.comp.Check;

public class Select_Seat_Meals extends ChromeBrowser{
	
	public void selectSeat(String Seat_no) {
		String seat=String.format("(//*[text()=\"%s\"]//..)[@style=\"cursor: pointer;\"]", Seat_no);
		WebElement check_seat=driver.findElement(By.xpath(seat));
		if(check_seat.isEnabled())
			check_seat.click();
		else
			System.out.println("Seat is not avialable");
	}
	
	public void selectMeal(String meal) throws InterruptedException {
		
		//select meal
		driver.findElement(By.xpath("(//*[text()=\"Select Meals\"]//..)[1]")).click();
		String meal_path=String.format("//*[contains(text(),\"%s\")]", meal.toLowerCase());
		driver.findElement(By.xpath(meal_path)).click();
		//done
		driver.findElement(By.xpath("(//*[text()=\"Done\"]//..)[1]")).click();
		Thread.sleep(4000);
	}
	
	public void continueButtonAgain() {
		//continue
		driver.findElement(By.xpath("(//*[text()=\"Continue\"]//..)[1]")).click();
	}
}