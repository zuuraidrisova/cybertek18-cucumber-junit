package com.cybertek.step_definitions;

import com.cybertek.pages.SmartBearPage;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.configurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class SmartBearStepDefinitions {


    SmartBearPage smartBearPage = new SmartBearPage();

    @Given("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page() {

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        smartBearPage.usernameInput.sendKeys(configurationReader.getProperty("smartBearUsername"));

        smartBearPage.passwordInput.sendKeys(configurationReader.getProperty("smartBearPassword"));

        smartBearPage.loginButton.click();

        smartBearPage.orderLink.click();
    }

     //User fills out the form as followed:

    @When("User selects FamilyAlbum from product dropdown")
    public void user_selects_family_album_from_product_dropdown() {

        Select select = new Select(smartBearPage.productDropdown);

        select.selectByIndex(1);
    }

    @And("User enters {string} to quantity")
    public void userEntersToQuantity(String four) {

        smartBearPage.quantity.sendKeys(Keys.BACK_SPACE + four);
    }

    @When("User enters John Wick to costumer name")
    public void user_enters_john_wick_to_costumer_name() {

        smartBearPage.customerName.sendKeys("John Wick");

    }

    @When("User enters Kinzie Ave to street")
    public void user_enters_kinzie_ave_to_street() {

        smartBearPage.street.sendKeys("Kinzie Ave");
    }

    @When("User enters Chicago to city")
    public void user_enters_chicago_to_city() {

        smartBearPage.city.sendKeys("Chicago");
    }

    @When("User enters IL to state")
    public void user_enters_il_to_state() {

        smartBearPage.state.sendKeys("IL");

    }

    @And("User enters {string}")
    public void userEnters(String zip) {

        smartBearPage.zip.sendKeys(zip);
    }

    @When("User selects Visa as card type")
    public void user_selects_visa_as_card_type() {

        smartBearPage.visaType.click();

    }

    @And("User enters {string} to card number")
    public void userEntersToCardNumber(String cardNumber) {

        smartBearPage.cardNumber.sendKeys(cardNumber);
    }

    @And("User enters {string} to expiration date")
    public void userEntersToExpirationDate(String expireDate) {

        smartBearPage.expireDate.sendKeys(expireDate);
    }

    @When("User clicks process button")
    public void user_clicks_process_button() {

        smartBearPage.processButton.click();

    }

    @Then("User verifies John Wick is in the list")
    public void user_verifies_john_wick_is_in_the_list() {

        Assert.assertTrue(smartBearPage.successMessage.isDisplayed());

        smartBearPage.viewAllOrders.click();

        String actualText = smartBearPage.johnWick.getText();
        String expectedText = "John Wick";

        Assert.assertEquals(actualText, expectedText);

        System.out.println("Verifications Passed!");


    }


}
