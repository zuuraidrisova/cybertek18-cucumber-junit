package com.cybertek.step_definitions;

import com.cybertek.pages.WikipediaPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WikiStepDefinitions {

    WikipediaPage wikipediaPage = new WikipediaPage();

    /*
   TC#25: Wikipedia Search Functionality Title Verification
1. User is on Wikipedia home page
2. User types Steve Jobs in the wiki search box
3. User clicks wiki search button
4. User sees Steve Jobs is in the wiki title
Note: Follow POM
    */

    @Given("User is on the Wikipedia home page")
    public void user_is_on_the_wikipedia_home_page() {

        Driver.getDriver().get("https://www.wikipedia.org");

        Driver.getDriver().manage().window().maximize();
    }

    @When("User searches {string} in the wiki search page")
    public void user_searches_in_the_wiki_search_page(String string) {

        wikipediaPage.searchInput.sendKeys(string);
        wikipediaPage.searchButton.click();
    }
    @Then("User should see {string} in the wiki title")
    public void user_should_see_in_the_wiki_title(String string) {

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(string));
    }

     /*
    TC#26: Wikipedia Search Functionality Header Verification
1. User is on Wikipedia home page
2. User types Steve Jobs in the wiki search box
3. User clicks wiki search button
4. User sees Steve Jobs is in the main header
Note: Follow POM
     */


    @Then("User should see {string} in the main header")
    public void userShouldSeeInTheMainHeader(String expectedHeaderText) throws InterruptedException{

        String actualHeaderText = wikipediaPage.mainHeader.getText();

        Thread.sleep(2000);

        Assert.assertTrue(actualHeaderText.equals(expectedHeaderText));
    }
    /*
    TC#27: Wikipedia Search Functionality Image Header Verification
1. User is on Wikipedia home page
2. User types Steve Jobs in the wiki search box
3. User clicks wiki search button
4. User sees Steve Jobs is in the image header
Note: Follow POM
     */

    @Then("User should see {string} in the image header")
    public void userShouldSeeInTheImageHeader(String expectedImageHeader) {

        String actualImageHeader = wikipediaPage.imageHeader.getText();


        Assert.assertTrue(actualImageHeader.equals(expectedImageHeader));
    }

}
