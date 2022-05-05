package com.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uitesting.util.PageUtil;



public class AdminLoginPage {

	private WebDriver driver;
	
	private By email = By.name("email");
	private By password = By.name("password");
	private By login = By.xpath("//span[contains(text(),'Login')]");
	private By loginbtn= By.xpath("//button[@class='btn btn-primary btn-block ladda-button fadeIn animated mdc-ripple-upgraded'  and @type='submit']");

	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
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
        driver.findElement(login).click();
		String url = driver.getCurrentUrl();
		return url;
	}
	public boolean checkPageContainstxt(String value) {
		boolean txt=true;
	if(driver.getPageSource().contains(value)) {
    	txt= true;
    	}
	return txt;
	}
	 public AdminDashboardPage clickOnValidLogin() throws InterruptedException {
		 
		    WebElement ele= driver.findElement(loginbtn);
		    PageUtil page= new PageUtil(driver);
			page.clickOnElement(ele);
		    Thread.sleep(1000);
		    AdminDashboardPage admin = new AdminDashboardPage(driver);
	 		return admin;
	 		
	 	}
	public String getWindow(String string) {
		
		PageUtil pageUtil= new PageUtil(driver);
	    String title=pageUtil.winHandleUrl(string);
	    System.out.println("current window"+title);
	    //String url = driver.getCurrentUrl();
	    return title;
	}
	
	public AdminDashboardPage getAdminDashboard() {

		AdminDashboardPage admin = new AdminDashboardPage(driver);
		//System.out.println("Driver");
		return admin;
	}
	
	public AdminDashboardPage getAgentDashboard() {

		AdminDashboardPage admin = new AdminDashboardPage(driver);
		return admin;
	}
}
