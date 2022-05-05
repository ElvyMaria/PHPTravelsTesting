package com.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.uitesting.util.PageUtil;

public class SupplierLoginPage {
	private String title;
	
	private By submit = By.xpath("//body/div[@id='layoutAuthentication']/div[@id='layoutAuthentication_content']/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/button[1]");
	private By email = By.name("email");
	private By password = By.name("password");
	//private By loginbtn = By.xpath("//body/div[@id='layoutAuthentication']/div[@id='layoutAuthentication_content']/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/button[1]");
	private By loginbtn = By.xpath("//span[contains(text(),'Login')]");
	private By loginpageelement=By.xpath("//strong[contains(text(),'Login')]");
	private WebDriver driver;
	
	public SupplierLoginPage(WebDriver driver) {
		this.driver= driver;
		
	}
	
	public String getTitle(String string) {
		PageUtil page = new PageUtil(driver);
		title=page.winHandle(string);
		return title;
	}
	
	public void waitforloginpage() {
		PageUtil page = new PageUtil(driver);
		page.explicitlyWait(loginpageelement);
	}
	public void clickOnLogin() {
		
		driver.findElement(submit).click();
	}
	
	public boolean checkPageContainstxt(String value) {
		boolean txt=true;
	if(driver.getPageSource().contains(value)) {
    	txt= true;
    	}
	return txt;
	}
	
	public void enterEmail(String value) {
		driver.findElement(email).sendKeys(value);
	}
	public void enterPassword(String value) {
		driver.findElement(password).sendKeys(value);
	}
	
	
   public SupplierDashboardPage clickOnValidLogin() {
	 
	  // driver.findElement(loginbtn).click();
	   WebElement ele= driver.findElement(loginbtn);
	    PageUtil page= new PageUtil(driver);
		page.clickOnElement(ele);
	    SupplierDashboardPage supplier = new SupplierDashboardPage(driver);
 		return supplier;
 	}

   public String getUrl() {
		
	  
	   String currentURL  = driver.getCurrentUrl();
	   System.out.println(currentURL);
	 return currentURL;
   }
	public SupplierDashboardPage getSupplierDashboardPage() {

		SupplierDashboardPage supplier = new SupplierDashboardPage(driver);
  		return supplier;
  	}
	
}	
	
	
	
