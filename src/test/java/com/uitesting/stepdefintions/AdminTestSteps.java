package com.uitesting.stepdefintions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.uitesting.factory.DriverFactory;
import com.uitesting.pages.AdminBookingsPage;
import com.uitesting.pages.AdminDashboardPage;
import com.uitesting.pages.AdminLoginPage;
import com.uitesting.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminTestSteps {
	
	private HomePage home= new HomePage(DriverFactory.getDriver());
	private AdminLoginPage login = home.clickOnAdminBackEnd();
	private AdminDashboardPage admin;
	private AdminBookingsPage bookings;
	private String title;
	private String url;private 
	boolean msg1;
	private boolean msg2;
	private int count;
	private int currentCount;
	
	@Given("admin is on the login page title Administator Login {string}")
	public void admin_is_on_the_login_page_title_Administator_Login(String string) {
		url=login.getWindow(string);//check
	}

	@Then("check admin login page url should be {string}")
	public void check_admin_login_page_url_should_be(String string) {
		assertEquals(url,string);
	}

	@When("admin click on Login")
	public void admin_click_on_Login() {
		  login.clickOnLogin();
	}

	@Then("admin gets the first error message should be {string}")
	public void admin_gets_the_first_error_message_should_be(String string) {
		 msg1= login.checkPageContainstxt(string);
	       assertEquals(msg1,true);
	}

	@Then("admin gets the second error message should be {string}")
	public void admin_gets_the_second_error_message_should_be(String string) {
		msg2= login.checkPageContainstxt(string);
   	    assertEquals(msg2,true);;
	}
    @When("admin enter an invalid password {string}")
	public void admin_enter_an_invalid_password(String string) {
		
    	login = home.getAdminBackEnd();
		login.enterPassword(string);
	}

	@Then("admin gets the email error message should be {string}")
	public void admin_gets_the_email_error_message_should_be(String string) {
		login = home.getAdminBackEnd();
		msg1=login.checkPageContainstxt(string);
		assertEquals(msg1,true);
	}

	@When("admin enters the invalid email id {string}")
	public void admin_enters_the_invalid_email_id(String string) {
		login = home.getAdminBackEnd();
		 login.enterEmail(string);
	}
    @Then("admin gets the  error message should be {string}")
	public void admin_gets_the_error_message_should_be(String string) {
		 msg1= login.checkPageContainstxt(string);
	     assertEquals(msg1,true);
	}

	@When("admin enters the valid email id {string}")
	public void admin_enters_the_valid_email_id(String string) {
		login = home.getAdminBackEnd();
		 //login.getWindow(); check
		 login.enterEmail(string);
	}

	@When("admin enter a valid password {string}")
	public void admin_enter_a_valid_password(String string) {
		login = home.getAdminBackEnd();
		login.enterPassword(string);
	}

	@Then("admin should redirect to the admin dashboard")
	public void admin_should_redirect_to_the_admin_dashboard() {
		 admin=login.getAdminDashboard();
		 url=admin.getUrl();
		  
	}

	@Then("admin dashboard url should be {string}")
	public void admin_dashboard_url_should_be(String string) {
		
		assertEquals(url,string);
	}

	@When("admin click on Website")
	public void admin_click_on_Website() {
		 admin=login.getAdminDashboard();
		 admin.clickOnWebsite();
	}

	//@Then("admin should redirect to the PHPTRAVELS page {string}")
	@Then("admin should redirect to the PHPTRAVELS page")
	public void admin_should_redirect_to_the_PHPTRAVELS_page() throws InterruptedException {
		//title=admin.getWindow(string); //check
		title=	admin.switchtonewwindow();
		 
	}

	@Then("the page title PHPTRAVELS page should be {string}")
	public void the_page_title_PHPTRAVELS_page_should_be(String string) {
		assertEquals(title,string);
	}
   
    @When("admin click on Bookings")
	public void admin_click_on_Bookings() throws InterruptedException {
		 bookings=admin.clickOnBookings();
	}

	@Then("admin should redirect to the All bookings view page")
	public void admin_should_redirect_to_the_All_bookings_view_page() {
		 title=bookings.getTitle();
	}
	@Then("the All bookings page title should be {string}")
	public void the_All_bookings_page_title_should_be(String string) {
		assertEquals(title,string);
	}
	@When("the admin change the booking from pending to confirmed")
	public void the_admin_change_the_booking_from_pending_to_confirmed() {
        count=bookings.countOnDashboard();
		bookings.selectBookingStatus();
	}

	@Then("the count on booking status pending is less by one compare with previous count")
	public void the_count_on_booking_status_pending_is_less_by_one_compare_with_previous_count() {
		
		  bookings.clickOnDahboard();
		  currentCount=bookings.countOnDashboard();
		  assertTrue(count>currentCount);
	}

	@Then("check  the booking status with confirmed and the payment status with paid for successful payment")
	public void check_the_booking_status_with_confirmed_and_the_payment_status_with_paid_for_successful_payment() {
		msg1=bookings.paymentSuccess();
    	assertEquals(msg1,true);
	}
	
   @When("admin click on delete button with booking status {string}")
	public void admin_click_on_delete_button_with_booking_status(String string) {
	   bookings.deleteCancelled(string);
	}

	@Then("an alert is open")
	public void an_alert_is_open() {
	    msg1=bookings.alert();
	    assertEquals(msg1,true);
	}



}
