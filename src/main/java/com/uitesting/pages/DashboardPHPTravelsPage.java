package com.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPHPTravelsPage {
	
	 private WebDriver driver;
	
	 private By myBookings = By.xpath("//body/div[1]/div[1]/div[3]/ul[1]/li[2]/a[1]");
	 private By addFunds = By.xpath("//body/div[1]/div[1]/div[3]/ul[1]/li[3]/a[1]");
	 private By myProfile = By.xpath("//body/div[1]/div[1]/div[3]/ul[1]/li[4]/a[1]");
	 private By logout = By.xpath("//body/div[1]/div[1]/div[3]/ul[1]/li[5]/a[1]");
	 
	 
	 
	public DashboardPHPTravelsPage(WebDriver driver) {
			this.driver = driver;
			
	}
	//My Bookings
	public BookingsPage clickOnMyBookings() {
		driver.findElement(myBookings).click();
		BookingsPage bookings = new BookingsPage(driver);
		return bookings;
		
	}
	public String getUrl() {
		String url=driver.getCurrentUrl();
		return url;
	}
	
	
	//AddFunds
	public AddFunds clickOnAddFunds() {
		driver.findElement(addFunds).click();
	    AddFunds funds = new AddFunds(driver);
		return funds;
	}
	
	 //My profile
	public CustomerProfilePage clickOnMyProfile() {
		driver.findElement(myProfile).click();
		CustomerProfilePage profile = new CustomerProfilePage(driver);
			return profile;
	}
	
	public void clickOnLogout() {
		driver.findElement(logout).click();
	}
   
 
	public String clickOnElement(String value) {
		
		String expValue=value;
	
		 String url=null;
	     switch (expValue) {
	     
	         case "Home":
	        	   driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
	               url=driver.getCurrentUrl();
	        	   break;
	         
	         case "Hotel":
	               driver.findElement(By.xpath("//a[contains(text(),'Hotels')]")).click();
	        	   url=driver.getCurrentUrl();
	             break;
	         
	         case "Flights":
	        	  driver.findElement(By.xpath("//a[contains(text(),'flights')]")).click();
	        	  url=driver.getCurrentUrl();
	             break;
	         case "Tours":
	               driver.findElement(By.xpath("//a[contains(text(),'Tours')]")).click();
	        	   url=driver.getCurrentUrl();
	             break;
	         case "Visa":
	        	   driver.findElement(By.xpath("//a[contains(text(),'visa')]")).click();
	        	   url=driver.getCurrentUrl();
	             break;
	         case "Blog":
	        	   driver.findElement(By.xpath("//a[contains(text(),'Blog')]")).click();
	        	   url=driver.getCurrentUrl();
	             break;
	         case "Offers":
	        	   driver.findElement(By.xpath("//a[contains(text(),'Offers')]")).click();
	        	   url=driver.getCurrentUrl();
	             break;
	         default:
	             throw new IllegalArgumentException("Invalid Link " + expValue);
	     }
	     return url;
		
		
		
	}
	
	public HotelPage getHotel() {
		HotelPage hotel= new HotelPage(driver);
		return hotel;
	}
	
}
 
	

	