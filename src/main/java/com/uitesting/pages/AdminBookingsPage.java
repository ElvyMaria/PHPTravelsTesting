package com.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uitesting.util.PageUtil;

public class AdminBookingsPage {
	//private By booking_status = By.id("booking_status");
	private By pending = By.xpath("/html[1]/body[1]/div[2]/div[2]/main[1]/div[1]/div[1]/div[2]/a[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
	//private By pending1 = By.xpath("/html[1]/body[1]/div[2]/div[2]/main[1]/div[1]/div[2]/div[2]/a[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
	private By pending1 = By.xpath("//div[contains(text(),'Pending Bookings')]/../div[1]");
	private WebDriver driver;
	private int count;
	private By dashboard =By.xpath("//div[contains(text(),'Dashboard')]");
	private By waitDashboard= By.xpath("//h1[contains(text(),'Dashboard')]");
	public AdminBookingsPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getTitle() {
		String title=driver.getTitle();
		return title;
	}

	public void checkSuccessfullPayments() {
		int n = driver.findElements(By.xpath("//tbody/tr")).size();
		System.out.println(n);
	}
	
	public int countOnDashboard() {
		String s=driver.findElement(pending1).getText();
	count=Integer.parseInt(s);
				
		System.out.println("dashboard "+count);
		return count;
	}
	public void selectBookingStatus(){
		//PageUtil page = new PageUtil(driver);
		//page.scrollDown(driver);
		int n= driver.findElements(By.xpath("//tbody/tr")).size();
		
		for(int i=1;i<=n;i++) {
		
		Select select = new Select(driver. findElement(By. xpath("//tbody/tr["+i+"]/td[11]/select")));
		WebElement option = select. getFirstSelectedOption();
		String defaultItem = option. getText();
	    if(defaultItem.equalsIgnoreCase("PENDING")) {
			
			select.selectByVisibleText("Confirmed");
			
			break;
		}
		
		}
		
		
	}
	public boolean paymentSuccess(){
		int n= driver.findElements(By.xpath("//tbody/tr")).size();
		
		//int c =0;
		for(int i=1;i<n;i++) {
		//String pending=	driver.findElement(By.xpath("//tbody/tr["+i+"]/td[11]/select")).getText();
		Select bookingStatus = new Select(driver. findElement(By. xpath("//tbody/tr["+i+"]/td[11]/select")));
		WebElement option = bookingStatus. getFirstSelectedOption();
		String booking = option. getText();
		
		Select paymentStatus = new Select(driver. findElement(By. xpath("//tbody/tr["+i+"]/td[12]/select")));
		WebElement option1 = paymentStatus. getFirstSelectedOption();
		String payment = option1. getText();
		//System.out.println(defaultItem);
		if(booking.equalsIgnoreCase("CONFIRMED") && (payment.equalsIgnoreCase("PAID")))
			return true;
		 System.out.println("Payment Successfull" +i);
	    }
		return false;
	}
	
	public void deleteCancelled(String string) {
		int n= driver.findElements(By.xpath("//tbody/tr")).size();
		
		for(int i=1;i<n;i++) {
		
		Select select = new Select(driver. findElement(By. xpath("//tbody/tr["+i+"]/td[11]/select")));
		WebElement option = select. getFirstSelectedOption();
		String defaultItem = option. getText();
	    if(defaultItem.equalsIgnoreCase(string)) {
			driver. findElement(By. xpath("//tbody/tr["+i+"]/td[15]/button")).click();
	    }
		}
	}
	
	public boolean alert() {
		driver.switchTo().alert().dismiss();
		return true;
		
	}
	
	public void clickOnDahboard() {
		driver.findElement(dashboard).click();
		PageUtil page = new PageUtil(driver);
		page.explicitlyWait(waitDashboard);
	}
	
	
	
}
