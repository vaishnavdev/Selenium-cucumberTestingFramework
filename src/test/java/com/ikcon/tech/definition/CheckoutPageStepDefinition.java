package com.ikcon.tech.definition;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import com.ikcon.tech.pageobjectlocator.CheckoutPage;
import com.ikcon.tech.util.TestContextInitilizer;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

/**
 * 
 * @author VaishnavPuthiyanampa
 * uses the methods of POM locator classes and defines the operation which 
 * is going to be performed.
 */
public class CheckoutPageStepDefinition {
    
    private TestContextInitilizer contextInitializer;
    private CheckoutPage checkoutPage;
    
    
    public CheckoutPageStepDefinition(TestContextInitilizer contextInitializer) {
	this.contextInitializer = contextInitializer;
	this.checkoutPage = contextInitializer.pageObjectManager.getCheckoutPageObject();
    }

    @Then("^User proceeds to checkout page and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_page_and_validate_the_items_in_checkout_page(String shortname) throws Throwable {
       checkoutPage.checkoutItems();
      // Thread.sleep(2000);
       String productName = checkoutPage.extractChekoutPageProductName();
       System.out.println(productName+" from checkout page");
       assertEquals(productName, contextInitializer.landingPageProductName);
    }

    @And("^Check the user has ability to enter promocode and place the order$")
    public void check_the_user_has_ability_to_enter_promocode_and_place_the_order() throws Throwable {
       Assert.assertTrue(checkoutPage.verifyPromoButton());
       Assert.assertTrue(checkoutPage.verifyPlaceOrderButton());	
       
    }

}
