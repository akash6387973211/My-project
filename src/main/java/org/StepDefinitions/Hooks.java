package org.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.reports.ExtentReportUtils;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    public static void Wait(WebDriver driver, By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    @Before
    public static void beforeScenario(Scenario scenario) {

//          System.setProperty("Webdriver.chrome.driver","C:\\Users\\User.Admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            String scenarioName = scenario.getName();
            ExtentReportUtils.initializeExtentReport("Web Automation Test");  // Initialize once for all tests
            // Initialize ExtentReport with scenario name
            ExtentReportUtils.startTestcase(scenarioName);  // Start the test case for Extent Report

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.out.println("WebDriver is null.");
        } else {
            System.out.println("Returning WebDriver instance.");
        }
        return driver;
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportUtils.setFailTestStep(scenario.getName(), "Test case failed.");  // Log failure if scenario failed
        } else {
            ExtentReportUtils.setPassTestStep(scenario.getName(), "Test case passed.");  // Log success if scenario passed
        }
        ExtentReportUtils.flush();  // Flush only once at the end of all tests

        driver.quit();

    }

}
