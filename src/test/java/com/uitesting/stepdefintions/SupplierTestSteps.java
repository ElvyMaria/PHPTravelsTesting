package com.uitesting.stepdefintions;

import static org.testng.Assert.assertEquals;
import com.uitesting.factory.DriverFactory;
import com.uitesting.pages.HomePage;
import com.uitesting.pages.SupplierDashboardPage;
import com.uitesting.pages.SupplierLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SupplierTestSteps {

	private HomePage home = new HomePage(DriverFactory.getDriver());
	private SupplierLoginPage login= home.clickOnSupplierBackEnd();
	private SupplierDashboardPage supplier;
	private String title;
	private String url;
	private boolean msg1;
	private boolean msg2;
	
	@Given("supplier is on the login page with title Supplier Login {string}")
	public void supplier_is_on_the_login_page_with_title_Supplier_Login(String string) {
		
		title= login.getTitle(string);
		login.waitforloginpage();

	}

	@Then("check supplier login page title should be {string}")
	public void check_supplier_login_page_title_should_be(String string) {
		assertEquals(title,string);
	}

	@When("supplier click on the Login")
	public void supplier_click_on_the_Login() {
		 login = home.getSupplierBackEnd();
		 login.clickOnLogin();
	}

	@Then("supplier gets the first error message should be {string}")
	public void supplier_gets_the_first_error_message_should_be(String string) {
		  msg1= login.checkPageContainstxt(string);
	       assertEquals(msg1,true);
	}

	@Then("supplier gets the second error message should be {string}")
	public void supplier_gets_the_second_error_message_should_be(String string) {
		 msg2= login.checkPageContainstxt(string);
    	 assertEquals(msg2,true);
	}

	@When("supplier enter an invalid password {string}")
	public void supplier_enter_an_invalid_password(String string) {
		login = home.getSupplierBackEnd();
        //login.getTitle();
    	 login.enterPassword(string);
	}

	@Then("supplier gets the email error message should be {string}")
	public void supplier_gets_the_email_error_message_should_be(String string) {
		 msg1= login.checkPageContainstxt(string);
	     assertEquals(msg1,true);
	}

	@When("supplier enters the invalid email id {string}")
	public void supplier_enters_the_invalid_email_id(String string) {
		login = home.getSupplierBackEnd();
        login.enterEmail(string);
	}

	@Then("supplier gets the  error message should be {string}")
	public void supplier_gets_the_error_message_should_be(String string) {
		 msg1= login.checkPageContainstxt(string);
	     assertEquals(msg1,true);
	}

	@When("a supplier enters the valid email id {string}")
	public void a_supplier_enters_the_valid_email_id(String string) {
		login = home.getSupplierBackEnd();
	    login.enterEmail(string);
	}

	@When("supplier enter a valid password {string}")
	public void supplier_enter_a_valid_password(String string) {
		login.enterPassword(string);
	}

	@Then("supplier should redirect to the supplier dashboard")
	public void supplier_should_redirect_to_the_supplier_dashboard() {
		   login = home.getSupplierBackEnd();
		   login.clickOnValidLogin();
		
    }

	@Then("supplier dashboard url should be {string}")
	public void supplier_dashboard_url_should_be(String string) throws InterruptedException {
		   supplier=login.getSupplierDashboardPage();
		   url=supplier.getUrl();
	       assertEquals(url,string);
	}


	@Then("supplier dashboard  should contain Revenue Breakdown {string}")
	public void supplier_dashboard_should_contain_Revenue_Breakdown(String string) {
		 supplier= login.getSupplierDashboardPage();
		    msg1= supplier.checkPageContainstxt(string);
		   assertEquals(msg1,true);
	}


	@Then("supplier dashboard  should contain Sales overview & summary {string}")
	public void supplier_dashboard_should_contain_Sales_overview_summary(String string) {
		    supplier= login.getSupplierDashboardPage();
		    msg1= supplier.checkPageContainstxt(string);
		   assertEquals(msg1,true);
	}
	@When("supplier click on Tours, view tours links")
	public void supplier_click_on_Tours_view_tours_links() {
		   supplier= login.getSupplierDashboardPage();
		   supplier.clickOnTours();
	}
	@When("supplier click on Manage Tours {string}")
	public void supplier_click_on_Manage_Tours(String string) {
		 title=supplier.clickOnElement(string);
	}

	@Then("supplier should redirect to the  Manage Tours page with title {string}")
	public void supplier_should_redirect_to_the_Manage_Tours_page_with_title(String string) {
		 assertEquals(title,string);
	}

	@When("supplier click on Extras {string}")
	public void supplier_click_on_Extras(String string) {
		//login.waitforloginpage();
		  supplier= login.getSupplierDashboardPage();
		  
		  title=supplier.clickOnElement("Extras");
	}

	@Then("supplier should redirect to the Extras page with title {string}")
	public void supplier_should_redirect_to_the_Extras_page_with_title(String string) {
		 assertEquals(title,string);
	}

	@When("supplier click on Bookings")
	public void supplier_click_on_Bookings() {
		  supplier= login.getSupplierDashboardPage();
		   url=supplier.clickOnBookings();
	}

	@Then("supplier should redirect to the Bookings page with url {string}")
	public void supplier_should_redirect_to_the_Bookings_page_with_url(String string) {
		  assertEquals(url,string);
	}
	

}
   