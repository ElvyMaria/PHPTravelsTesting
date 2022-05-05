package com.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.uitesting.util.PageUtil;

public class PayPalPage {
	
	
	private WebDriver driver;
	
	 //PayPal
	
	 private By backToInvoice = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]");
	 private By backToInvoiceYes = By.xpath("//a[contains(text(),'Yes')]");
	 
	 public PayPalPage(WebDriver driver) {
		   
			this.driver = driver;
			
	}
		//Pay pal page
		public void clickOnBackToInvoice() {
		
			driver.findElement(backToInvoice).click();
		} 
		public void clickOnBackToInvoiceYes() {
			driver.findElement(backToInvoiceYes).click();
	    }

		public String getUrl() {
			PageUtil page = new PageUtil(driver);
		    page.explicitlyWait(backToInvoice);
			
            String url=driver.getCurrentUrl();
            return url;
		}

}
