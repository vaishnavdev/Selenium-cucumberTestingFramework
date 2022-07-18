package com.ikcon.tech.pageobjectlocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopDealsPage {
    
    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("tr td:nth-child(1)");
    
    private WebDriver webDriver;
    
    public TopDealsPage(WebDriver webDriver) {
	this.webDriver = webDriver;
    }
    
    public void SearchItem(String shortName)
    {
	webDriver.findElement(search).sendKeys(shortName);
    }
    
    public String getProductName() {
	return webDriver.findElement(productName).getText();
    }
    

}
