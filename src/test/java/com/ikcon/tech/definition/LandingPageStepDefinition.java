package com.ikcon.tech.definition;
import org.testng.Assert;

import com.ikcon.tech.pageobjectlocator.LandingPage;
import com.ikcon.tech.util.TestContextInitilizer;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * 
 * @author VaishnavPuthiyanampa
 * uses the methods of POM locator classes and defines the operation that are
 * to be performed.
 */
public class LandingPageStepDefinition {
    
    private TestContextInitilizer testContextInitializer;
    private LandingPage landingPage;
    
    //gets through DI
    //single responsibility principle and set classes as loosely coupled using DI
    //implement Factory Design pattern
    public LandingPageStepDefinition(TestContextInitilizer testContextInitializer) 
    {
	this.testContextInitializer = testContextInitializer;
	this.landingPage = testContextInitializer.pageObjectManager.getLandingPageObject(); 
    }
    
    @Given("^User is on GreenKart Landing page$")
    public void user_is_on_greenkart_landing_page() throws Throwable {
	Assert.assertTrue(landingPage.getTitleofLandingPage().contains("GreenKart"));
    }

    @When("^User searched with a ShortName (.+) and extracted the actual name of the product$")
    public void user_searched_with_a_shortname_something_and_extracted_the_actual_name_of_the_product(String shortName) throws Throwable {
	landingPage.SearchItem(shortName);
        Thread.sleep(2000);
        testContextInitializer.landingPageProductName = landingPage.extractProductName(); 
        System.out.println(testContextInitializer.landingPageProductName+" from Home page");
    }
    
    @And("^Added \"([^\"]*)\" items of selected product to cart$")
    public void added_items_of_product_to_cart(String quantity) throws Throwable { 
        landingPage.incrementItemQuantity(Integer.parseInt(quantity));
        landingPage.AddItemsToCart();
    }  
}

