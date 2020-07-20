package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearPage {

    public SmartBearPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='ctl00$MainContent$username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(linkText = "Order")
    public WebElement orderLink;

    @FindBy(xpath = "//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")
    public WebElement productDropdown;


    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$txtName']")
    public WebElement customerName;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox2']")
    public WebElement street;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox3']")
    public WebElement city;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox4']")
    public WebElement state;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox5']")
    public WebElement zip;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaType;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox6']")
    public WebElement cardNumber;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")
    public  WebElement expireDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(xpath = "//strong")
    public WebElement successMessage;

    @FindBy(xpath = "//a[.='View all orders']")
    public WebElement viewAllOrders;

    @FindBy(xpath = "//table[@class='SampleTable']/tbody/tr[2]/td[2]")
    public WebElement johnWick;


}
