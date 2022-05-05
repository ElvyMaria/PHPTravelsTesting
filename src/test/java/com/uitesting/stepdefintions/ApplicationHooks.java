package com.uitesting.stepdefintions;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.uitesting.factory.DriverFactory;
import com.uitesting.util.ConfigReader;



import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	
	

	Properties prop;

	@Before
	public void setup() {
		
		
			configReader = new ConfigReader();
			prop = configReader.init_prop();
			String browserName = prop.getProperty("browser");
			driverFactory = new DriverFactory();
			driver = driverFactory.init_driver(browserName);
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			
			driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
		
			driver.get(prop.getProperty("url"));
		
	}
	
   @After
	public void addScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
		  String name = scenario.getName().replaceAll(" ", "_");
		
		  File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		  String PATH = System.getProperty("user.dir");
			String directoryName = PATH.concat("\\target\\screenshot\\");
			
			File directory = new File(directoryName);
		    if (! directory.exists()){
		    	 directory.mkdir();
		    }
		    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			String destination = directoryName + name + dateName + ".png";

			File finalDestination = new File(destination);

			// FileHandler.copy(source, finalDestination);//or FileUtils.copyFile import
			// org.apache.commons.io.FileUtils;
			FileUtils.copyFile(source, finalDestination);
			//return destination;
		
		}
		driver.quit();
	}
  
   

}
