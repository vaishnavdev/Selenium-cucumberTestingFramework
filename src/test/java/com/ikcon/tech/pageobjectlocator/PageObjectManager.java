package com.ikcon.tech.pageobjectlocator;

import org.openqa.selenium.WebDriver;

/**
 * 
 * @author VaishnavPuthiyanampa
 * @this class creates the object for all the Pageobject locator classes
 *
 */
public class PageObjectManager {
    
    private WebDriver driver;
    public LandingPage landingPage;
    public TopDealsPage topDealsPage;
    public CheckoutPage checkoutPage;
    
    /*this constructor collects the  WebDriver instance passed from TestContextInitalizer 
    *class and passes it to different POM locator classes. These locator classes will 
    *use the diver object to connect with actual web pages and perform operations on Html 
    *elements.
    */
    public PageObjectManager(WebDriver driver) {
	this.driver = driver;
    }
    
    /*
     * LandingPage object locator class initailization / object creation
     */
    public LandingPage getLandingPageObject() {
	 landingPage = new LandingPage(driver);
	 return landingPage;
    }
    
    /*
     * TopDealsPage object locator class initailization / object creation
     */
    public TopDealsPage getTopDealsPageObject() {
	topDealsPage = new TopDealsPage(driver);
	return topDealsPage;
    }
    
    /*
     * CheckoutPage object locator class initailization / object creation
     */
    public CheckoutPage getCheckoutPageObject() {
	checkoutPage = new CheckoutPage(driver);
	return checkoutPage;
    }

}
