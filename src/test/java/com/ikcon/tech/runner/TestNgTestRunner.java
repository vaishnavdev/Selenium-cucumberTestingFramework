package com.ikcon.tech.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/ikcon/tech/features",
                 glue = "com/ikcon/tech/definition",
                 monochrome = true,
                 tags = "@SearchProduct or @PlaceOrder")
public class TestNgTestRunner extends AbstractTestNGCucumberTests {
    
    
    //runs the scenarios in multiple browsers paralelly
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
	return super.scenarios();
    }
}