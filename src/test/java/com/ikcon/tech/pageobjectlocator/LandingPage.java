package com.ikcon.tech.pageobjectlocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    
    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("h4.product-name");
    private  WebDriver webDriver;
    private By topDealsLink = By.linkText("Top Deals");
    private By addToCartButton = By.cssSelector(".product-action button");
    private By incrementItemButton = By.cssSelector("a.increment");
    
    public LandingPage(WebDriver webDriver) {
	this.webDriver = webDriver;
    }
    
    public String getTitleofLandingPage() {
	return webDriver.getTitle();
    }
    
    public void SearchItem(String shortName)
    {
	webDriver.findElement(search).sendKeys(shortName);
    }
    
    public String getProductName() {
	return webDriver.findElement(productName).getText();
    }
    
    public String extractProductName() {
	return getProductName().split("-")[0].trim();
    }
    
    public void openTopDealsPageInChildWindow() {
	if(!webDriver.getCurrentUrl().contentEquals("https://rahulshettyacademy.com/seleniumPractise/#/offers")) 
	{
	webDriver.findElement(topDealsLink).click();
        }
    }
    
    public void incrementItemQuantity(int quantity) {
	int i = quantity-1;
	while(i>0) 
	{
	    webDriver.findElement(incrementItemButton).click();
	    i--;
	}
    }
    
    public void AddItemsToCart() {
	webDriver.findElement(addToCartButton).click();
    }

}
