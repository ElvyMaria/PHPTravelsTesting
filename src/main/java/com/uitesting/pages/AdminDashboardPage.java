package com.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Iterator; 
import java.util.Set;

import com.uitesting.util.PageUtil;
public class AdminDashboardPage {

	private By bookings = By.xpath("//body/nav[1]/div[1]/div[1]/ul[1]/li[2]/a[1]");
    private By website = By.xpath("//a[contains(text(),'Website')]");
	private WebDriver driver;

	public AdminDashboardPage(WebDriver driver) {
		this.driver = driver;

	}

	public String getUrl() {
		PageUtil page = new PageUtil(driver);
		String url = page.getCurrentUrl();
		//String url = driver.getCurrentUrl();
		return url;
	}

	public String getWindow(String string) throws InterruptedException {
		Thread.sleep(2000);
		PageUtil pageUtil = new PageUtil(driver);
		String url = pageUtil.winHandle(string);
		return url;
	}
	
	public String switchtonewwindow() throws InterruptedException
	{
		String title = null;
		String parent=driver.getWindowHandle();

	Set<String>s=driver.getWindowHandles();

	// Now iterate using Iterator
	Iterator<String> I1= s.iterator();

	while(I1.hasNext())
	{
	String child_window=I1.next();
	if(!parent.equals(child_window))
	{
	driver.switchTo().window(child_window);
    Thread.sleep(2000);
	title=driver.switchTo().window(child_window).getTitle();
	
	}
	}
	return title;
	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void clickOnWebsite() {
		WebElement ele = driver.findElement(website);
		PageUtil page = new PageUtil(driver);
		page.clickOnElement(ele);

	}

	public AdminBookingsPage clickOnBookings() throws InterruptedException {
		WebElement ele = driver.findElement(bookings);
		PageUtil page = new PageUtil(driver);
		page.clickOnElement(ele);
		Thread.sleep(1000);
		return getAdminBookingsPage();
	}

	public AdminBookingsPage getAdminBookingsPage() {
		AdminBookingsPage allBookings = new AdminBookingsPage(driver);
		return allBookings;
	}
}
