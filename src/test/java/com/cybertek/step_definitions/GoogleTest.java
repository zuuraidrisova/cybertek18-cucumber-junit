package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class GoogleTest {


    @Test
    public void setup() throws InterruptedException{

        Driver.getDriver().get("https://www.google.com");

        Driver.getDriver().manage().window().maximize();

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertTrue(Driver.getDriver().getTitle().equals("Google"));

        Thread.sleep(1000);

        Driver.closeDriver();
    }
}
