package com.cybertek.step_definitions;

import com.cybertek.pages.WikipediaPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WikiStepDefinitions {

    WikipediaPage wikipediaPage = new WikipediaPage();

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


    @Then("User should see {string} in the main header")
    public void userShouldSeeInTheMainHeader(String expectedHeaderText) throws InterruptedException{

        String actualHeaderText = wikipediaPage.mainHeader.getText();

        Thread.sleep(2000);

        Assert.assertTrue(actualHeaderText.equals(expectedHeaderText));
    }

    @Then("User should see {string} in the image header")
    public void userShouldSeeInTheImageHeader(String expectedImageHeader) {

        String actualImageHeader = wikipediaPage.imageHeader.getText();


        Assert.assertTrue(actualImageHeader.equals(expectedImageHeader));
    }
}
