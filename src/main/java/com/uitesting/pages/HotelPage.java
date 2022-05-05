package com.uitesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.uitesting.util.PageUtil;

public class HotelPage {
	private WebDriver driver;
	private By cityContainer = By.xpath("//span[@id='select2-hotels_city-container']");
	private By cityInput = By.xpath("//body/span[1]/span[1]/span[1]/input[1]");

	// private By search =
	// By.xpath("//html[1]/body[1]/section[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/button[1]");
	// private By search = By.xpath("//button[@id='submit']");

	private By search = By.xpath("//body/section[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]");
	private By currency = By.xpath("//button[contains(text(),'USD')]");
	private By account = By.xpath("//button[contains(text(),'Account')]");
	private String url;

	public HotelPage(WebDriver driver) {
		this.driver = driver;

	}

	public String selectCurrency(String value) {

		String expValue = value;
		driver.findElement(currency).click();
		int n = driver
				.findElements(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li"))
				.size();
		for (int i = 1; i < n; i++) {
			String actualValue = driver
					.findElement(By.xpath(
							"//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[" + i + "]"))
					.getText();
			// System.out.println("currency" + txt);
			if (expValue.equalsIgnoreCase(actualValue)) {
				driver.findElement(By
						.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[" + i + "]"))
						.click();
				break;

			}
		}

		return expValue;
	}

	
	public String selectCity(String value) throws InterruptedException {
		String title = value;
		driver.findElement(cityContainer).click();
		if (driver.findElement(cityInput).isEnabled()) {
			driver.findElement(cityInput).sendKeys(value);

			Actions action = new Actions(driver);
			WebElement city = driver.findElement(By.xpath("//body/span[1]/span[1]/span[2]/ul[1]/li[4]"));

			action.moveToElement(city);
			// action.click();
			action.moveToElement(city).click().build().perform();

			WebElement element = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
			PageUtil page = new PageUtil(driver);
			page.clickOnElement(element);

			// driver.findElement(search).click();
			title = driver.getTitle();
			// System.out.println("Hotel" +title);
			return title;
		}
		return title;
	}

	public String selectAccount(String value) {
		String expValue = value;
		driver.findElement(account).click();
		int n = driver
				.findElements(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/ul[1]/li"))
				.size();

		for (int i = 1; i < n; i++) {
			String actualValue = driver
					.findElement(By.xpath(
							"//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[" + i + "]/a"))
					.getText();
			if (expValue.equalsIgnoreCase(actualValue)) {
				driver.findElement(By.xpath(
						"//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[" + i + "]/a"))
						.click();

				break;

			}
		}
		url = driver.getCurrentUrl();
		System.out.println("select Account" + url);
		return url;

	}

	public boolean clickOnSearch() {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(search).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;

	}
}
