package com.uitesting.stepdefintions;

import static org.testng.Assert.assertTrue;

import com.uitesting.factory.DriverFactory;
import com.uitesting.pages.AddFunds;
import com.uitesting.pages.BookingsPage;
import com.uitesting.pages.DashboardPHPTravelsPage;
import com.uitesting.pages.FrontEndLoginPage;
import com.uitesting.pages.HomePage;
import com.uitesting.pages.HotelPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AgentTestSteps {

	private HomePage home = new HomePage(DriverFactory.getDriver());
	private FrontEndLoginPage login = home.clickOnAgentFrontEnd();
	private DashboardPHPTravelsPage agent;
	private BookingsPage bookings;
	private AddFunds funds;
	private HotelPage hotel;
	private String url;
	private String selected;
	private String title;

	@When("user click on Login")
	public void user_click_on_Login() {
		url = login.clickOnLogin();
		agent =login.getAgentDashboard();
	}

	@When("user click on Home {string}")
	public void user_click_on_Home(String string) {
		agent = login.getAgentDashboard();
		url= agent.clickOnElement(string);
	}

	@Then("user navigate to the Home page with url should be {string}")
	public void user_navigate_to_the_Home_page_with_url_should_be(String string) {
		assertTrue(url.contains(string));
	}

	@When("user click on Hotel {string}")
	public void user_click_on_Hotel(String string) {
		agent = login.getAgentDashboard();
		url= agent.clickOnElement(string);
	}

	@Then("user navigate to the Hotel page with url should be {string}")
	public void user_navigate_to_the_Hotel_page_with_url_should_be(String string) {
		assertTrue(url.contains(string));
	}

	@When("user click on Flights {string}")
	public void user_click_on_Flights(String string) {
		agent = login.getAgentDashboard();
		url= agent.clickOnElement(string);
	}

	@Then("user navigate to the Flights page with url should be {string}")
	public void user_navigate_to_the_Flights_page_with_url_should_be(String string) {
		assertTrue(url.contains(string));
	}

	@When("user click on Tours {string}")
	public void user_click_on_Tours(String string) {
		agent = login.getAgentDashboard();
		url= agent.clickOnElement(string);
	}

	@Then("user navigate to the Tours page with url should be {string}")
	public void user_navigate_to_the_Tours_page_with_url_should_be(String string) {
		assertTrue(url.contains(string));
		}

	@When("user click on Visa {string}")
	public void user_click_on_Visa(String string) {
		agent = login.getAgentDashboard();
		url= agent.clickOnElement(string);
	}

	@Then("user navigate to the Visa page with url should be {string}")
	public void user_navigate_to_the_Visa_page_with_url_should_be(String string) {
		assertTrue(url.contains(string));
	}

	@When("user click on Blog {string}")
	public void user_click_on_Blog(String string) {
		agent = login.getAgentDashboard();
		url= agent.clickOnElement(string);
	}

	@Then("user navigate to the Blog page with url should be {string}")
	public void user_navigate_to_the_Blog_page_with_url_should_be(String string) {
		assertTrue(url.contains(string));
	}

	@When("user click on Offers {string}")
	public void user_click_on_Offers(String string) {
		agent = login.getAgentDashboard();
		url= agent.clickOnElement(string);
	}

	@Then("user navigate to the Offers page with url should be {string}")
	public void user_navigate_to_the_Offers_page_with_url_should_be(String string) {
		assertTrue(url.contains(string));
	}


	@When("user click on USD and select INR {string}")
	public void user_click_on_USD_and_select_INR(String string) {
		agent = login.getAgentDashboard();
		hotel= agent.getHotel();
		selected=hotel.selectCurrency(string);
	}

	@Then("user can see currency dispalyed is change to {string}")
	public void user_can_see_currency_dispalyed_is_change_to(String string) {
		assertTrue(selected.contains(string));
	}

	
    @When("user click on Accounts and select Dashboard {string}")
	public void user_click_on_Accounts_and_select_Dashboard(String string) {
    	agent = login.getAgentDashboard();
		hotel= agent.getHotel();
		url = hotel.selectAccount(string);
	}
	@Then("user navigate to the dashboard page with url should be {string}")
	public void user_navigate_to_the_dashboard_page_with_url_should_be(String string) {
		assertTrue(url.contains(string));
	}

	@When("user enter and select the city name {string}")
	public void user_enter_and_select_the_city_name(String string) throws InterruptedException {
		agent = login.getAgentDashboard();
		hotel= agent.getHotel();
		title=hotel.selectCity(string);
	}

	@Then("navigate to the page with title of should contain city name {string}")
	public void navigate_to_the_page_with_title_of_should_contain_city_name(String string) {
		System.out.println("Assert Hotel   " +title);
		assertTrue(title.contains(string));
	}

	

}
