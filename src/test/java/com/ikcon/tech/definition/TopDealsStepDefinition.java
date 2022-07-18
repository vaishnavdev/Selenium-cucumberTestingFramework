package com.ikcon.tech.definition;
import org.testng.Assert;
import com.ikcon.tech.pageobjectlocator.LandingPage;
import com.ikcon.tech.pageobjectlocator.TopDealsPage;
import com.ikcon.tech.util.TestContextInitilizer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

/**
 * @author VaishnavPuthiyanampa
 * uses the methods of POM locator classes and defines the operation which 
 * is going to be performed.
 */
public class TopDealsStepDefinition {
   
    private String offersPageProductName;
    private TestContextInitilizer testContextInitializer;
    
    public TopDealsStepDefinition(TestContextInitilizer testContextInitializer) 
    {
	this.testContextInitializer = testContextInitializer;
    }
    
    @Then("^User searched with same Shortname (.+) in offers page$")
    public void user_searched_with_same_shortname_something_in_offers_page(String shortName) throws Throwable 
    {
	        switchToOffersPageWithSeprateWindow();
		//get search element and send shortname
		//testContextInitializer.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	        TopDealsPage topDealsPage = testContextInitializer.pageObjectManager.getTopDealsPageObject();
	        topDealsPage.SearchItem(shortName);
		 Thread.sleep(2000);
		// offersPageproductName = testContextInitializer.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		 offersPageProductName = topDealsPage.getProductName();
		 System.out.println(offersPageProductName+" from Landing Page");
    }
    
    @And("^validate product name in offers page matches with Landing page product name$")
    public void validate_product_name_in_offers_page_matches_with_landing_page_product_name() throws Throwable 
    {
      Assert.assertEquals(testContextInitializer.landingPageProductName, offersPageProductName);
    }
    
    private void switchToOffersPageWithSeprateWindow() 
    {
	        //LandingPage landingPage = new LandingPage(testContextInitializer.driver);
	        LandingPage landingPage = testContextInitializer.pageObjectManager.getLandingPageObject();
	        landingPage.openTopDealsPageInChildWindow();
	        testContextInitializer.genericUtils.switchToChildWindow();
    }

}

