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

public class SmartBearStepDefinitionsWithParameterization {

    SmartBearPage smartBearPage = new SmartBearPage();

    @Given("User logs into SmartBear Tester account and on Order page")
    public void userLogsIntoSmartBearTesterAccountAndOnOrderPage() {

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        smartBearPage.usernameInput.sendKeys(configurationReader.getProperty("smartBearUsername"));

        smartBearPage.passwordInput.sendKeys(configurationReader.getProperty("smartBearPassword"));

        smartBearPage.loginButton.click();

        smartBearPage.orderLink.click();

    }


    //User fills out the form as followed:

    @When("User should select FamilyAlbum from product dropdown")
    public void user_should_select_family_album_from_product_dropdown() {

        Select select = new Select(smartBearPage.productDropdown);

        select.selectByIndex(1);
    }

    @When("User enters {string} quantity")
    public void user_enters_quantity(String quantity) {

        smartBearPage.quantity.sendKeys(Keys.BACK_SPACE + quantity);
    }

    @When("User enters {string} to costumer name")
    public void user_enters_to_costumer_name(String name) {

        smartBearPage.customerName.sendKeys(name);
    }

    @When("User enters {string} to street")
    public void user_enters_to_street(String street) {

        smartBearPage.street.sendKeys(street);

    }
    @When("User enters {string} to city")
    public void user_enters_to_city(String city) {

        smartBearPage.city.sendKeys(city);
    }

    @When("User enters {string} to state")
    public void user_enters_to_state(String state) {

        smartBearPage.state.sendKeys(state);
    }

    @When("User should enter {string}")
    public void user_should_enter(String zip) {

        smartBearPage.zip.sendKeys(zip);
    }

    @When("User selects Visa as card")
    public void user_selects_visa_as_card() {

        smartBearPage.visaType.click();
    }

    @When("User enters {string} card number")
    public void user_enters_card_number(String cardNumber) {

        smartBearPage.cardNumber.sendKeys(cardNumber);
    }

    @And("User enters {string} expiration date")
    public void userEntersExpirationDate(String expireDate) {

        smartBearPage.expireDate.sendKeys(expireDate);
    }

    @When("User clicks process Button")
    public void user_clicks_process_button() {

        smartBearPage.processButton.click();
    }

    @Then("User verifies {string} is in the list")
    public void user_verifies_is_in_the_list(String name) {

        smartBearPage.viewAllOrders.click();

       Assert.assertTrue(smartBearPage.johnWick.isDisplayed());

       String actualName = smartBearPage.johnWick.getText();

       Assert.assertEquals(actualName, name);

        System.out.println("Verifications passed!");
    }


}
