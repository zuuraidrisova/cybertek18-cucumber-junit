package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    @Before(order = 2)
    public void setUpScenario(){

        //System.out.println("----> Before annotation: Setting up browser");
    }

    @Before(value = "@db", order = 1)
    public void setUpDataBaseConnection(){

        //System.out.println("----> Before annotation: DB CONNECTION CREATED <----");
    }

    @After(order = 1)
    public void tearDownScenario(Scenario scenario){

//        //System.out.println("----> After annotation: Closing browser");
//        System.out.println("scenario.getName() = " + scenario.getName());
//        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
//        System.out.println("scenario.isFailed() = " + scenario.isFailed());

        //# to take a screen shot using Selenium
        // getScreenshotAs(): to be able to use this method we have to cast our Driver
        // to (TakesScreenshot)

        if(scenario.isFailed()) {//if only scenario is failed then take a screenshot

            byte[] screenShots = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            // and attach it to our report
            scenario.attach(screenShots, "image/png", scenario.getName());

        }

    }

    @After(value = "@db", order = 4)
    public void tearDownDataBaseConnection(){

       // System.out.println("----> After annotation: DB CONNECTION CLOSED <----");
    }


    @BeforeStep
    public void setUpStep(){

        //System.out.println("====> BEFORESTEP: TAKING SCREENSHOT <====");
    }

    @AfterStep
    public void tearDownStep(){

       // System.out.println("====> AFTERSTEP: TAKING SCREENSHOT <====");
    }

}
