package com.cybertek.step_definitions;

import com.cybertek.pages.EtsyPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsyStepDefinitions2 {

    /*
  TC#51: Etsy Title Verification
User is on https://www.etsy.com
User sees title is as expected.

Expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

Note: Follow POM
   */

    @Given("User is on the etsy home page")
    public void user_is_on_the_etsy_home_page() {

        Driver.getDriver().get("https://www.etsy.com");
    }

    @Then("User should see title is as expected")
    public void user_should_see_title_is_as_expected() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    
    /*
    TC#53: Etsy Search Functionality Title Verification (with parameterization)
User is on https://www.etsy.com
User types Wooden Spoon in the search box
User clicks search button
User sees Wooden Spoon is in the title

Note: Follow POM
     */
    

    EtsyPage etsyPage = new EtsyPage();

    @When("User searches {string} in the search box")
    public void userSearchesInTheSearchBox(String searchValue) {

        etsyPage.searchBox.sendKeys(searchValue);
    }

    @And("User clicks to search button")
    public void userClicksToSearchButton() {

        etsyPage.searchBoxButton.click();
    }

    @Then("User should see {string}in the etsy title")
    public void userShouldSeeInTheEtsyTitle(String expectedInTitle) {

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }
    
    
}
