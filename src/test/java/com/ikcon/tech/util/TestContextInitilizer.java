package com.ikcon.tech.util;

import com.ikcon.tech.pageobjectlocator.PageObjectManager;


/**
 * 
 * @author VaishnavPuthiyanampa
 * @this class initializes the WebDriverManager class, which will internally
 *  returns a single web driver instance that is used across different classes
 *  for an operation to perform.
 *
 */
public class TestContextInitilizer {
    
    public WebDriverManager webDriverManager;
    public String landingPageProductName;
    public PageObjectManager pageObjectManager;
    public GenericUtil genericUtils;
    
    public TestContextInitilizer() {
	//initalizing web driver manager class
	webDriverManager = new WebDriverManager();
	//passing the web driver object to POM class
	this.pageObjectManager = new PageObjectManager(webDriverManager.InitializeSeliniumWebDriver());
	System.out.println("Driver Initialized");
	genericUtils = new GenericUtil(webDriverManager.InitializeSeliniumWebDriver()); 
	
    }

}
