package spiceJet_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import spiceJet_Pages.Payment;

public class SpiceJet_Payment extends Payment{
	
	Payment pay = new Payment();
	
	@Given("user is on payment page")
	public void user_is_on_payment_page() {
	    System.out.println("Payment Page");
	}

	@When("user fetch data from payment page")
	public void user_fetch_data_from_payment_page() {
		pay.fetchData();
	}

	@And("verify the prices and cities name are same or not")
	public void verify_the_prices_and_cities_name_are_same_or_not() {
	  pay.verifyData();
	}

	@And("verify prices without adding convenience fee")
	public void verify_prices_without_adding_convenience_fee() {
		pay.convenienceFee();
	}

	@Then("user print message all test cases are correctlly done")
	public void user_print_message_all_test_cases_are_correctlly_done() {
	   System.out.println("Test 5 is Successfull..");
	}
}
