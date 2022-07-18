package com.ikcon.tech.pageobjectlocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    
   //private By search = By.xpath("//input[@type='search']");
    //private By productName = By.cssSelector("h4.product-name");
    private  WebDriver driver;
    
    private By cartBagLink = By.cssSelector("img[alt='Cart']");
    private By proceedToCheckoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    private By promoButton = By.cssSelector(".promoBtn");
    private By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
    private By checkoutPageProductName = By.cssSelector("p.product-name");
    
    public CheckoutPage(WebDriver webDriver) {
	this.driver = webDriver;
    }
    
    public void checkoutItems() {
	driver.findElement(cartBagLink).click();
	driver.findElement(proceedToCheckoutButton).click();
    }
    
    public boolean verifyPromoButton() {
	return driver.findElement(promoButton).isDisplayed();
    }
    
    public boolean verifyPlaceOrderButton() {
	return driver.findElement(placeOrderButton).isDisplayed();
    }
    
    public String getCheckoutPageProductName() {
	return driver.findElement(checkoutPageProductName).getText();
    }
    
    public String extractChekoutPageProductName() {
	return getCheckoutPageProductName().split("-")[0].trim();
    }
}
