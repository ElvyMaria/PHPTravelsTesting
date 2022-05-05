package com.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uitesting.util.PageUtil;

public class CustomerProfilePage {
	private WebDriver driver;
	String txt;



	private By address = By.name("address1");
    private By updateProfile = By.xpath("//button[@type='submit' ]");
	// private By updateProfile =
	// By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/button[1]");
	private By msg = By
			.xpath("//body[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]");

	public CustomerProfilePage(WebDriver driver) {
		this.driver = driver;

	}

	public String getAddress() {
		String addresstxt = driver.findElement(address).getText();
		return addresstxt;
	}

	public void setAddress(String value) {
		driver.findElement(address).clear();
		driver.findElement(address).sendKeys(value);

	}

	public void clickOnUpdateProfile() throws InterruptedException {

		WebElement ele = driver.findElement(updateProfile);
		PageUtil page = new PageUtil(driver);
		page.clickOnElement(ele);

	}

	public String getMessage() {

		try {
			Thread.sleep(1000);
			if (driver.getPageSource().contains("Profile updated successfully")) {
				// return true;
				txt = driver.findElement(msg).getText();
			}
			System.out.println("profile update  " + txt);
			return txt;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("profile update  " + txt);
		return txt;
	}

}
