package com.uitesting.util;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtil {

	private WebDriver driver;

	public PageUtil(WebDriver driver) {
		this.driver = driver;
	}

	public String winHandle(String Title) {

		String expTitle = Title;

		ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());

		for (int i = 1; i < w.size(); i++) {

			// switch to open tab
			driver.switchTo().window(w.get(i)).getTitle();

			// System.out.println("New tab title: " + driver.getTitle());
			String cTitle = driver.switchTo().window(w.get(i)).getTitle();
			System.out.println(cTitle);
			if (cTitle.equalsIgnoreCase(expTitle)) {
				driver.switchTo().window(w.get(i));

			}

			else if (!cTitle.equalsIgnoreCase(expTitle))
				driver.switchTo().window(w.get(0));

		}
		return expTitle;

	}

	public String winHandleUrl(String Title) {

		String expTitle = Title;
		String url = null;
		ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
		// System.out.println(w.size());
		for (int i = 1; i < w.size(); i++) {

			// switch to open tab
			driver.switchTo().window(w.get(i)).getTitle();

			System.out.println("New tab title: " + driver.getTitle());
			String cTitle = driver.switchTo().window(w.get(i)).getTitle();
			System.out.println(cTitle);
			if (cTitle.equalsIgnoreCase(expTitle)) {
				driver.switchTo().window(w.get(i));
				url = driver.switchTo().window(w.get(i)).getCurrentUrl();
				System.out.println("pageutil " + url);
				return url;
			}

			else if (!cTitle.equalsIgnoreCase(expTitle))
				driver.switchTo().window(w.get(0));

		}
		return url;

	}

	public void explicitlyWait(By element) {
		// explicit wait - to wait for the compose button to be click-able
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public void scrollPageDown(WebDriver driver) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		
	}
	public void scrollDown(WebDriver driver){
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		
	}
	public void clickOnElement(WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
	}
	public String getCurrentUrl() {
		String url = null;
	   url=driver.getCurrentUrl();
	   return url;
	   
	}
	
}