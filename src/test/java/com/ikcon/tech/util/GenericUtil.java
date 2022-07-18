package com.ikcon.tech.util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtil {
    
    private WebDriver driver;
    
    public GenericUtil(WebDriver driver) {
	this.driver = driver;
    }
    
    public void switchToChildWindow() {
	Set<String> windowsOpened = driver.getWindowHandles();
	Iterator<String> i1 = windowsOpened.iterator();
	@SuppressWarnings("unused")
	String parentWindow = i1.next();
	String childWindow = i1.next();
	//switch to child window
	driver.switchTo().window(childWindow); 
    }

}
