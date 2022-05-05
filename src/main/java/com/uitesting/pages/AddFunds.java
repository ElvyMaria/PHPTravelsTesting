package com.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddFunds {

	// AddFundsPage
	private By gatewayPaypal = By.id("gateway_paypal");
	private By payNow = By.xpath("//body/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/button[1]");

	private WebDriver driver;

	public AddFunds(WebDriver driver) {
		this.driver = driver;

	}

	public void clickOnGetWayPayPal() {
		driver.findElement(gatewayPaypal).click();
	}

	public PayPalPage clickOnPayNow() {
		driver.findElement(payNow).click();
		PayPalPage paypal = new PayPalPage(driver);
	
		return paypal;
	}
	
	public String getUrl() {
		String url =driver.getCurrentUrl();
		return url;
	}

}
