package com.uitesting.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features"
,glue = "com.uitesting.stepdefintions"
,strict = true
,monochrome = true
,plugin = {"pretty"} 
,tags= {"@test"}

)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	

}
