package spiceJet_Pages;

import org.openqa.selenium.By;

public class PassengerDetails extends ChromeBrowser {

	public void contact_details(String fname, String lname,String phoneno,String email, String city) {
		// select title
		driver.findElement(By.xpath("//*[@data-testid=\"title-contact-detail-card\"]")).click();
		driver.findElement(By.xpath("//*[text()=\"Mr\"]")).click();

		// contact details
		// name
		driver.findElement(By.xpath("//*[@data-testid=\"first-inputbox-contact-details\"]")).sendKeys(fname);
		// last name
		driver.findElement(By.xpath("//*[@data-testid=\"last-inputbox-contact-details\"]")).sendKeys(lname);
		// contact
		driver.findElement(By.xpath("//*[@data-testid=\"contact-number-input-box\"]")).sendKeys(phoneno);
		// email
		driver.findElement(By.xpath("//*[@data-testid=\"emailAddress-inputbox-contact-details\"]")).sendKeys(email);
		// town and city
		driver.findElement(By.xpath("//*[@data-testid=\"city-inputbox-contact-details\"]")).sendKeys(city);
	}

	public void passenger_details(String p_fname, String p_lname,String p_phoneno) {
		// Passenger details
		// name
		driver.findElement(By.xpath("//*[@data-testid=\"traveller-0-first-traveller-info-input-box\"]"))
				.sendKeys(p_fname);
		// last
		driver.findElement(By.xpath("//*[@data-testid=\"traveller-0-last-traveller-info-input-box\"]"))
				.sendKeys(p_lname);
		// number
		driver.findElement(By.xpath("//*[@data-testid=\"sc-member-mobile-number-input-box\"]")).sendKeys(p_phoneno);
	}

	public void continueButton2() {
		driver.findElement(By.xpath("//*[@data-testid=\"traveller-info-continue-cta\"]")).click();
	}
}
