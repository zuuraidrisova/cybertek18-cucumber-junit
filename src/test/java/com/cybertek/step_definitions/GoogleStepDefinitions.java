package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;


import java.util.List;

public class GoogleStepDefinitions {

    @Given("User is on the google search page")
    public void user_is_on_the_google_search_page() {

        Driver.getDriver().get("https://www.google.com");

    }

    @Then("User should see title is Google")
    public void user_should_see_title_is_google() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Google";

        Assert.assertTrue(expectedTitle.equals(actualTitle));

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Google Title Verification passed!");
    }

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("User searches apple")
    public void userSearchesApple() {

        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);

    }

    @Then("User should see apple in the title")
    public void userShouldSeeAppleInTheTitle() {

        String expectedInTitle = "apple";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    @When("User searches {string}")
    public void userSearches(String searchValue) {

       googleSearchPage.searchBox.sendKeys(searchValue + Keys.ENTER);

    }

    @Then("User should see {string} in the title")
    public void userShouldSeeInTheTitle(String searchValue) {

        String expectedInTitle = searchValue + " - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.equals(expectedInTitle));
    }

    @Then("User should see About link")
    public void userShouldSeeAboutLink() {

        Assert.assertTrue(googleSearchPage.aboutLink.isDisplayed());

    }


    @And("User clicks to About link")
    public void userClicksToAboutLink() {

        googleSearchPage.aboutLink.click();

    }

    @Then("User should see title Google - About Google, Our Culture & Company News")
    public void userShouldSeeTitleGoogleAboutGoogleOurCultureCompanyNews() {

        String expectedTitle = "Google - About Google, Our Culture & Company News";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    // Verify that on the google search page footer contains 6 links

    @Then("User should see six links in the footer")
    public void user_should_see_six_links_in_the_footer(List<String> listOfLinks) {

        int expectedSize = listOfLinks.size();
        int actualSize = googleSearchPage.footerLinks.size();

        Assert.assertEquals(actualSize, expectedSize);
    }

}
