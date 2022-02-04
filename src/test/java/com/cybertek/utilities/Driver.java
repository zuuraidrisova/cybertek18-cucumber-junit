package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

        //make constructor private

    private Driver(){

    }


    private static WebDriver driver;


    public static WebDriver getDriver(){

        if(driver == null){

            String browser = configurationReader.getProperty("browser");

            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "chrome-remote":
                    try {
//                        same thing as ChromeOptions
//                        To request Selenium Grid to run tests on Chrome
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);

                        desiredCapabilities.setPlatform(Platform.LINUX);

//                        ChromeOptions chromeOptions = new ChromeOptions();
                        URL url = new URL("http://18.206.13.27:4444/wd/hub");

                        driver = new RemoteWebDriver(url, desiredCapabilities);

                    } catch (MalformedURLException e) {

                        e.printStackTrace();

                    }
                    break;
                /*
                case "chrome-remote":
                    try {
                        ChromeOptions chromeOptions = new ChromeOptions();
                        URL url = new URL("http://54.161.64.201:4444/wd/hub");
                        driver = new RemoteWebDriver(url, chromeOptions);


                    } catch (MalformedURLException e) {

                        e.printStackTrace();
                    }
                    break;

                 */

                default:
                    throw new RuntimeException("Wrong Browser : : "+browser);


            }
        }

        return driver;
    }

    public static void closeDriver(){

        if(driver != null){//if there is any browser assigned

            driver.quit();//then close it

            driver = null;//and assign it to its initial default value

        }

    }





}
