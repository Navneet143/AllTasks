package spiceJet_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import spiceJet_Pages.Select_Flight;

public class SpiceJet_SelectFlight extends Select_Flight{

	
	Select_Flight SF = new Select_Flight();
	
	@Given("user is on spiceJet flight search page")
	public void user_is_on_spice_jet_flight_search_page() {
		System.out.println("Flight Search Page");
	}

	@When("user select any flight")
	public void user_select_any_flight() {
		System.out.println("Select Any Flight");
	}

	@And("user select {string} and fetch flight number and price")
	public void user_select_and_fetch_flight_number_and_price(String flight_type) {

		// select spice max button and fetch data
		SF.selectFlight(flight_type);

	}

	@And("user click on continue button")
	public void user_click_on_continue_button() {
		// Continue
		SF.continueButton();
	}

	@Then("user navigate to passengers page")
	public void user_navigate_to_next_page() {
		System.out.println("Test 2 is Successfull..");
	}
}
