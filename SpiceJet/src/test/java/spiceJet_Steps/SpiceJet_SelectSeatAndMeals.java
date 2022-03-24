package spiceJet_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import spiceJet_Pages.Select_Seat_Meals;

public class SpiceJet_SelectSeatAndMeals extends Select_Seat_Meals{
	
	Select_Seat_Meals SM = new Select_Seat_Meals();

	@Given("user already fill passenger details and user is on Add-on page")
	public void user_already_fill_passenger_details_and_user_is_on_add_on_page() {
	   System.out.println("Passenger Page");
	}

	@When("user first select seat {string}")
	public void user_first_select_seat(String Seat_no) {
	   SM.selectSeat(Seat_no);
	}
	
	@And("user select meals {string} and click on done button")
	public void user_select_meals_and_click_on_done_button(String meal) throws InterruptedException {
		SM.selectMeal(meal);
	}

	@Then("user nevigate to Add-on page")
	public void user_nevigate_to_add_on_page_and_click_on_continue_button() {
	  System.out.println("All done..");
	}
	
	@And("click on continue button again")
	public void user_nevigate_to_add_on_page() {
		SM.continueButtonAgain();
	}
	
	@Then("user nevigate to payment page")
	public void user_nevigate_to_next_button() {
	   System.out.println("Test 4 is Successfull..");
	}
}
