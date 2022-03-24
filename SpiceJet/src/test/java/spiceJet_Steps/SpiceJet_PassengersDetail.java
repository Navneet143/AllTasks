package spiceJet_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import spiceJet_Pages.PassengerDetails;

public class SpiceJet_PassengersDetail extends PassengerDetails{


	PassengerDetails PD = new PassengerDetails();
	
	@Given("user is on spiceJet passengers page")
	public void user_is_on_spice_jet_passengers_page() {
		System.out.println("This is Passenger Page");
	}

	@When("user fill contact details {string},{string},{string},{string}and {string}")
	public void user_fill_contact_details_and(String fname,String lname,String phoneno,String email,String city) {

		PD.contact_details(fname,lname,phoneno,email,city);
	}
	@And("user fill passenger information {string},{string} and {string}")
	public void user_fill_passenger_information_and(String p_fname ,String p_lname,String p_phoneno) {
		PD.passenger_details(p_fname,p_lname ,p_phoneno);
	}

	@When("click on continue button")
	public void click_on_continue_button() {

		//Continue
		PD.continueButton2();

	}

	@Then("user navigate to next page")
	public void user_navigate_to_next_page() {

		System.out.println("Test 3 is Successfull..");
	}
}
