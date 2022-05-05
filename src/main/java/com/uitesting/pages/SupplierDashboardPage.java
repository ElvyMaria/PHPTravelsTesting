package com.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SupplierDashboardPage {

	private String url;
	private String title;
    private By tours =By.xpath("//i[contains(text(),'luggage')]");
	private By toursmodule = By.xpath("//div[@id= 'toursmodule']");
	private By bookings = By.xpath(
			"//a[@href='https://www.phptravels.net/api/supplier/bookings' and @class='loadeffect nav-link collapsed mdc-ripple-upgraded']");

	private WebDriver driver;

	public SupplierDashboardPage(WebDriver driver) {
		this.driver = driver;

	}

	public String getUrl() throws InterruptedException {

		Thread.sleep(1000);
		url = driver.getCurrentUrl();
		return url;

	}

	public boolean checkPageContainstxt(String value) {
		boolean txt = true;
		if (driver.getPageSource().contains(value)) {
			txt = true;
		}
		return txt;
	}

	public void clickOnTours() {
		driver.findElement(tours).click();
		if (driver.findElement(toursmodule).isDisplayed()) {
			driver.findElement(toursmodule).click();

		}
	}

	public String clickOnElement(String value) {

		String expValue = value;

	
		switch (expValue) {
		
		case "Manage Tours" :
			driver.findElement(By.linkText("Manage Tours")).click();
			title = driver.getTitle();
			break;
		case "Add Room":
			driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/api/supplier/tours']")).click();
			title = driver.getTitle();
			break;

		case "Extras":
			driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/api/supplier/tours/extras']")).click();
			title = driver.getTitle();
			break;
		default:
			throw new IllegalArgumentException("Invalid Link " + expValue);
		}
		return title;
	}
		
	
     public String clickOnBookings() {
		driver.findElement(bookings).click();
		String title = driver.getTitle();
		return title;
	}
}
