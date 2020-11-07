package com.cybertek.step_definitions;

import com.cybertek.pages.WikipediaPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WikipediaStepDefinitions {

    WikipediaPage wikipediaPage = new WikipediaPage();

    /*
    TC#25: Wikipedia Search Functionality Title Verification
1. User is on Wikipedia home page
2. User types Steve Jobs in the wiki search box
3. User clicks wiki search button
4. User sees Steve Jobs is in the wiki title
Note: Follow POM
     */

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {

        Driver.getDriver().get("https://www.wikipedia.org/");

    }

    @When("User types Steve Jobs in the wiki search box")
    public void user_types_steve_jobs_in_the_wiki_search_box() {

        wikipediaPage.searchInput.sendKeys("Steve Jobs");
    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {

        wikipediaPage.searchButton.click();
    }
    @Then("User sees Steve Jobs is in the wiki title")
    public void user_sees_steve_jobs_is_in_the_wiki_title() {

        String expectedInTitle = "Steve Jobs";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    /*
    TC#26: Wikipedia Search Functionality Header Verification
1. User is on Wikipedia home page
2. User types Steve Jobs in the wiki search box
3. User clicks wiki search button
4. User sees Steve Jobs is in the main header
Note: Follow POM
     */

    @Then("User sees Steve Jobs is in the main header")
    public void userSeesSteveJobsIsInTheMainHeader() {

       Assert.assertTrue(wikipediaPage.mainHeader.isDisplayed());

       String expectedHeader = "Steve Jobs";
       String actualHeader = wikipediaPage.mainHeader.getText();

       Assert.assertEquals(actualHeader, expectedHeader);
    }

    /*
    TC#27: Wikipedia Search Functionality Image Header Verification
1. User is on Wikipedia home page
2. User types Steve Jobs in the wiki search box
3. User clicks wiki search button
4. User sees Steve Jobs is in the image header
Note: Follow POM
     */

    @Then("User sees Steve Jobs is in the image header")
    public void userSeesSteveJobsIsInTheImageHeader() {

        Assert.assertTrue(wikipediaPage.imageHeader.isDisplayed());

        String expectedImageHeader = "Steve Jobs";
        String actualImageHeader = wikipediaPage.imageHeader.getText();

        Assert.assertEquals(actualImageHeader, expectedImageHeader);
    }

}
