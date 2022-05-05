package com.uitesting.stepdefintions;

import static org.testng.Assert.assertTrue;

import com.uitesting.factory.DriverFactory;
import com.uitesting.pages.AddFunds;
import com.uitesting.pages.BookingsPage;
import com.uitesting.pages.DashboardPHPTravelsPage;
import com.uitesting.pages.FrontEndLoginPage;
import com.uitesting.pages.HomePage;
import com.uitesting.pages.PayPalPage;
import com.uitesting.pages.CustomerProfilePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerTestSteps {
	
	private HomePage home = new HomePage(DriverFactory.getDriver());
	private FrontEndLoginPage login = home.clickOnCustomerFrontEnd();
	private DashboardPHPTravelsPage customer;
	private BookingsPage bookings;
	private AddFunds funds;
	private PayPalPage paypal;
	private CustomerProfilePage profile;
	private String url;
	private String title;
	
	@Given("user is on login page with Login - PHPTRAVELS {string}")
	public void user_is_on_login_page_with_Login_PHPTRAVELS(String string) {
		url = login.getWindow(string);
		login.clickOngotIt();

		
	}

	@Then("the login page url should be {string}")
	public void the_login_page_url_should_be(String string) {
		assertTrue(url.contains(string));
	}

	@When("user enters inavlid {string}")
	public void user_enters_inavlid(String string) {
		login.enterEmail(string);
	}

	@When("user enters invalid password {string}")
	public void user_enters_invalid_password(String string) {
		login.enterPassword("string");
	}
	@When("user click on Login button")
	public void user_click_on_Login_button() {
		url=login.clickOnLogin();
		customer=login.getCustomerDashboard();
	}

	@Then("user get the url of login failed should be {string}")
	public void user_get_the_url_of_login_failed_should_be(String string) {
		url = customer.getUrl();
		assertTrue(url.contains(string));
	}

	@When("user enters valid email {string}")
	public void user_enters_valid_email(String string) {
		login.enterEmail(string);
	}

	@When("user enters valid password {string}")
	public void user_enters_valid_password(String string) {
		login.enterPassword(string);
	}
    @Then("user navigate to the dashboard")
	public void user_navigate_to_the_dashboard() {
    	 //login.clickOnLogin();
    	 customer=login.getCustomerDashboard();
	}
  

	/*@When("user click on Login button")
	public void user_click_on_Login_button() {
		login.clickOnLogin();
	}*/

	@Then("user dashboard url should be {string}")
	public void user_dashboard_url_of_should_be(String string) {
		url=customer.getUrl();
		assertTrue(url.contains(string));
	}

	@When("user click on MyBookings")
	public void user_click_on_MyBookings() {
		customer = login.getCustomerDashboard();
		bookings=customer.clickOnMyBookings();
		url = customer.getUrl();
	}

	@Then("user navigate to the bookings page with url should be {string}")
	public void user_navigate_to_the_bookings_page_with_url_should_be(String string) {
		assertTrue(url.contains(string));
	}

	@When("user click on Add Funds")
	public void user_click_on_Add_Funds() {
		customer = login.getCustomerDashboard();
		funds=customer.clickOnAddFunds();
		url = funds.getUrl();
	}

	@Then("user navigate to the funds page with url should be {string}")
	public void user_navigate_to_the_funds_page_with_url_should_be(String string) {
		assertTrue(url.contains(string));
	}

	@When("user click on My Profile")
	public void user_click_on_My_Profile() {
		customer = login.getCustomerDashboard();
		profile=customer.clickOnMyProfile();
		url = customer.getUrl();
	}

	@Then("user navigate to the profile page with url should be {string}")
	public void user_navigate_to_the_profile_page_with_url_should_be(String string) {
		assertTrue(url.contains(string));
	}

	@When("user click on Logout button")
	public void user_click_on_Logout_button() {
		customer = login.getCustomerDashboard();
		customer.clickOnLogout();
		url = customer.getUrl();
	}

	@Then("user navigate to the login page with url should be {string}")
	public void user_navigate_to_the_login_page_with_url_should_be(String string) {
		assertTrue(url.contains(string));
	}


	@When("user click on a View Voucher {string}")
	public void user_click_on_a_View_Voucher(String string) {
		bookings=customer.clickOnMyBookings();
		bookings.clickOnViewVoucher();
        title=bookings.getCurrentWindowTitle(string);
		
	}

	@Then("user navigate to the invoice page with title should be {string}")
	public void user_navigate_to_the_invoice_page_with_title_should_be(String string) {
		assertTrue(string.contains(title));
	}

	@When("user select payment method and click on PayNow")
	public void user_select_payment_method_and_click_on_PayNow() {
		funds.clickOnGetWayPayPal();
		paypal=funds.clickOnPayNow();
		url = paypal.getUrl();
	}

	@Then("user navigate to the paypalpage with url should be {string}")
	public void user_navigate_to_the_paypalpage_with_url_should_be(String string) {
		assertTrue(url.contains(string));
	}

	@When("user click on Back to Invoice")
	public void user_click_on_Back_to_Invoice() {
		paypal.clickOnBackToInvoice();
		paypal.clickOnBackToInvoiceYes();
		url = funds.getUrl();
	}

	@Then("user navigate to the add funds page with url should be {string}")
	public void user_navigate_to_the_add_funds_page_with_url_should_be(String string) {
		assertTrue(url.contains(string));
	}

	@When("user get data from address filed and enter data to address field {string}")
	public void user_get_data_from_address_filed_and_enter_data_to_address_field(String string) {
		profile.setAddress(string);
	}

	@When("user click on update profle")
	public void user_click_on_update_profle() throws InterruptedException {
		profile.clickOnUpdateProfile();
	}

	@Then("user get a message {string}")
	public void user_get_a_message(String string) {
		String msg = profile.getMessage();
		assertTrue(msg.equalsIgnoreCase(string));
	}

}
