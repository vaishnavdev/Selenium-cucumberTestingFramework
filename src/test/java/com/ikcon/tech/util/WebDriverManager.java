package com.ikcon.tech.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
    
    public WebDriver driver;
    
    /**
     * This method @returns a WebDriver object that is used across different
     *  classes to execute test scenarios
     */
    public WebDriver InitializeSeliniumWebDriver() {
    Properties props = new Properties();
    try {
	//get the properties from global properties file
	InputStream fileInputStream = new FileInputStream("C:\\ECLIPSE_WORKSPACE\\selenium_Testing\\SeliniumTestProject\\src\\test\\resources\\globalconfiguration.properties");
      //FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\com\\ikcon\\tech\\resources\\globalconfiguration.properties");
	props.load(fileInputStream);
    } catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
    }
    
    // getting browser value from properties file
    String browserFromProperties = props.getProperty("browser");
    
    // getting browser/driver from terminal
    /*
     * "-Dbrowser" is the env property name that we give from command line terminal,
     * so get the property with same name "browser"
     */
    String browserFromTerminal = System.getProperty("browser");
    
    /*
     * If driver/browser value from command line is null,
     * then pick the driver/browser driver value from properties file
     */
    String browser = browserFromTerminal != null? browserFromTerminal: browserFromProperties;
    
	if(driver == null) {
	    if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", props.getProperty("chromedriverpath"));
		driver = new ChromeDriver();
	    }
	    if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver",props.getProperty("chromedriverpath"));
		driver = new FirefoxDriver();
	    }
	    driver.get(props.getProperty("Url"));
	}
	/*
	 * set driver timeout to execute different driver methods which 
	 * takes time in between to execute
	*/
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	return driver;
    }

}