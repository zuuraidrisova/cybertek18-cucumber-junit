package com.cybertek.step_definitions;

import com.cybertek.pages.EtsyPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsyStepDefinitions {

    /*
    TC#51: Etsy Title Verification
User is on https://www.etsy.com
User sees title is as expected.

Expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

Note: Follow POM
     */
    @Given("User is on etsy page")
    public void user_is_on_etsy_page() {

        Driver.getDriver().get("https://www.etsy.com");
    }

    @Then("User sees title is as expected.")
    public void user_sees_title_is_as_expected() {

        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }
        /*
    TC#52: Etsy Search Functionality Title Verification (without parameterization)
User is on https://www.etsy.com
User types Wooden Spoon in the search box
User clicks search button
User sees Wooden Spoon is in the title

Note: Follow POM
     */
        EtsyPage etsyPage = new EtsyPage();

    @When("User types Wooden Spoon in the search box")
    public void userTypesWoodenSpoonInTheSearchBox() {

        etsyPage.searchBox.sendKeys("Wooden Spoon");

    }

    @And("User clicks search button")
    public void userClicksSearchButton() {

        etsyPage.searchBoxButton.click();
    }

    @Then("User sees Wooden Spoon is in the title")
    public void userSeesWoodenSpoonIsInTheTitle() {

        String expectedInTitle = "Wooden spoon";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /*
    TC#53: Etsy Search Functionality Title Verification (with parameterization)
User is on https://www.etsy.com
User types Wooden Spoon in the search box
User clicks search button
User sees Wooden Spoon is in the title

Note: Follow POM
     */

    @When("User types {string} in the search box")
    public void userTypesInTheSearchBox(String searchValue) {

        etsyPage.searchBox.sendKeys(searchValue);

    }

    @Then("User sees {string} is in the title")
    public void userSeesIsInTheTitle(String searchValue) {

        String expectedInTitle = searchValue;
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

}
