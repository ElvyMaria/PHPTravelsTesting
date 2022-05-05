package com.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePage {

	
	private WebDriver driver;

	private By customerFrontEnd = By.xpath("//a[contains(text(),'Customer - Front-End')]");
	private By agentFrontEnd = By.xpath("//a[contains(text(),'Agent - Front-End')]");
	private By adminBackEnd = By.xpath("//a[contains(text(),'Admin - Back-End')]");
	private By supplierBackEnd = By.xpath("//a[contains(text(),'Supplier - Back-End')]");
   
    public HomePage(WebDriver driver) {
		this.driver = driver;
		
	}
    
    public FrontEndLoginPage clickOnCustomerFrontEnd() {

		driver.findElement(customerFrontEnd).click();
		FrontEndLoginPage customerFrontEnd = new FrontEndLoginPage(driver);
		
		return customerFrontEnd;

	}
    public AdminLoginPage getCustomerFrontEnd() {

		AdminLoginPage customerFrontEnd = new AdminLoginPage(driver);
		System.out.println("Driver");
		return customerFrontEnd;
	}
    public FrontEndLoginPage clickOnAgentFrontEnd() {

    	FrontEndLoginPage FrontEnd = new FrontEndLoginPage(driver);
		System.out.println("Driver");
		return FrontEnd;
	}
    
    public FrontEndLoginPage getAgentFrontEnd() {

    	FrontEndLoginPage agentFrontEnd = new FrontEndLoginPage(driver);
		return agentFrontEnd;
	}
    
    public AdminLoginPage clickOnAdminBackEnd() {

		driver.findElement(adminBackEnd).click();
		AdminLoginPage adminBackEnd = new AdminLoginPage(driver);
		return adminBackEnd;

	}
    public AdminLoginPage getAdminBackEnd() {

    	AdminLoginPage adminBackEnd = new AdminLoginPage(driver);
		return adminBackEnd;
	}
    
    public SupplierLoginPage clickOnSupplierBackEnd() {

  		driver.findElement(supplierBackEnd).click();
  		SupplierLoginPage supplierBackEnd = new SupplierLoginPage(driver);
  		return supplierBackEnd;

  	}
      public SupplierLoginPage getSupplierBackEnd() {

      	SupplierLoginPage supplierBackEnd = new SupplierLoginPage(driver);
  		return supplierBackEnd;
  	}
    
    
}
