package com.ikcon.tech.definition;

import org.openqa.selenium.WebDriver;

import com.ikcon.tech.util.TestContextInitilizer;

import io.cucumber.java.After;

public class Hooks {
    
    private WebDriver driver;
    private TestContextInitilizer contextInitializer;
    
    public Hooks(TestContextInitilizer contextInitializer) {
	this.contextInitializer = contextInitializer;
    }
    
    //An operation is performed after executing an entire single scenario.
    @After
    public void afterSearchProductScenario() {
	//opening of browser, closing, closing db instances etc
	this.driver = contextInitializer.webDriverManager.InitializeSeliniumWebDriver();
	System.out.println("Driver destroyed and browser closed");
	driver.quit();
    }

}
