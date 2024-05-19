package org.StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class StepDefination {

    SetupWebDriver webDriver = new SetupWebDriver();
    WebDriver driver ;

    @Given("Launch Dashboard UI")
    public void launchURL(){
        System.out.println("Hi");
    }
    @Given("Launch Beta URL at {string}")
    public void launchURL1(String url){
        driver.get(url);
    }

    @Given("Set chrome WebDriver")
    public void setChromeWebDriver() {
        this.driver = webDriver.getWebDriver();
    }
}
