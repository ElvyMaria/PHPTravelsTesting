package com.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.uitesting.util.PageUtil;

public class BookingsPage {
	private WebDriver driver;
	
	private By dashbord = By.xpath("//body/div[1]/div[1]/div[3]/ul[1]/li[1]/a[1]");
	 public BookingsPage(WebDriver driver) {
			this.driver = driver;
			
	}
    
	 
	public void clickOnViewVoucher() {
		//int n= driver.findElements(By.xpath("//tbody/tr")).size();
		PageUtil pageUtil= new PageUtil(driver);
		try {
			pageUtil.scrollPageDown(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/a[1]")).click();	
		
	}
	
	public String getCurrentWindowTitle(String value) {
		PageUtil pageUtil= new PageUtil(driver);
	    String title=pageUtil.winHandle(value);
	    //System.out.println("current window"+title);
	     //String url = driver.getCurrentUrl();
		return title;
	}
	public String getCurrentWindowUrl(String value) {
		PageUtil pageUtil= new PageUtil(driver);
	    String url=pageUtil.winHandleUrl(value);
	    System.out.println("current window"+url);
	  
		return url;
	}
	
	public void clickOnDashboard() {
		driver.findElement(dashbord).click();
	}
}
