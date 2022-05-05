package com.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.uitesting.util.PageUtil;



public class FrontEndLoginPage {

	private WebDriver driver;
	private By gotIt= By.id("cookie_stop");
	private By email = By.name("email");
	private By password = By.name("password");
	//private By password = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/div[1]/input[1]");
	
	private By login = By.xpath("//span[contains(text(),'Login')]");

	public FrontEndLoginPage(WebDriver driver) {
		this.driver = driver;
	}
    
	public void clickOngotIt() {
    	driver.findElement(gotIt).click();
    }
	
	public void enterEmail(String value) {
		driver.findElement(email).sendKeys(value);
	}

	public void enterPassword(String value) {
		driver.findElement(password).sendKeys(value);
	}
    
	public String clickLoginBtn() {
		
		driver.findElement(login).click();
		String url = driver.getCurrentUrl();
		return url;
		
	}
	public String clickOnLogin() {

		//System.out.println("new");
		driver.findElement(login).click();
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public String getWindow(String value) {
		PageUtil pageUtil= new PageUtil(driver);
	    String title=pageUtil.winHandle(value);
	    System.out.println("current window"+title);
	    String url = driver.getCurrentUrl();
	   return url;
	}
	
	public DashboardPHPTravelsPage getCustomerDashboard() {

		DashboardPHPTravelsPage customerDashboard = new DashboardPHPTravelsPage(driver);
		System.out.println("Driver");
		return customerDashboard;
	}
	
	public DashboardPHPTravelsPage getAgentDashboard() {

		DashboardPHPTravelsPage agent = new DashboardPHPTravelsPage(driver);
		return agent;
	}
	
	
  
  
}
