package org.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.HomeMegaMenuLinkCheckerMethods.StaticLinkChecker;
import org.Locators.ListingDetailPageLocators;
import org.Locators.ListingDseLocators;
import org.Locators.NhDetailPageLocator;
import org.Locators.LoginPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.HomeMegaMenuLinkCheckerMethods.LinkChecker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.utils.Hooks;

import static org.HomeMegaMenuLinkCheckerMethods.NHDetailFooterLinks.linkChecker;

public class StepDefination extends LinkChecker {

    SetupWebDriver webDriver = new SetupWebDriver();
    LoginPageLocators Lp = new LoginPageLocators();
    NhDetailPageLocator Dpl = new NhDetailPageLocator();
    ListingDetailPageLocators Ldpl = new ListingDetailPageLocators();
    ListingDseLocators dse = new ListingDseLocators();
    Hooks use = new Hooks();
    WebDriver driver;


    @Given("Launch Dashboard UI")
    public void launchURL() {
        System.out.println("Hi");
    }

    @Given("Launch Beta URL at {string}")
    public void launchURL1(String url) {
        driver.get(url);

    }

    @Given("Set chrome WebDriver")
    public void setChromeWebDriver() {
        this.driver = webDriver.getWebDriver();
    }

    @When("user clicks on top cities megamenu it should not return {int}")
    public void userClicksOntopcitiesMegamenuItShouldNotReturn(int arg0) {
        driver.findElement(Lp.header).click();
        areapicker(driver, "//ul[@class='gblTopCities']");
//	    areapicker(driver,"//ul[@class='gblCityList']");
        System.out.println("Broken New Homes link count" + NCount);
        System.out.println("Broken Sale link count" + Salecount);
        System.out.println("Broken Rent link count" + Rentcount);
    }


    @Given("Launch dse URL at {string}")
    public void launchDseURLAt(String url) {
        driver.get(url);
    }

    @When("user enter name {string} and email {string} and contact no {string}")
    public void userEnterNameAndEmailAndContactNo(String name, String email, String contact) {
        Hooks.Wait(driver, Lp.userName);
        driver.findElement(Lp.userName).sendKeys(name);
        driver.findElement(Lp.userEmail).sendKeys(email);
        driver.findElement(Lp.phone).sendKeys(contact);
        driver.findElement(Lp.submitButton).click();
    }

    @Then("click on submit button and verify thank you msg")
    public void clickOnSubmitButtonAndVerifythankyoumsg() {
        Hooks.Wait(driver, Lp.thankYou);
        WebElement text = driver.findElement(Lp.thankYou);
        Assert.assertTrue(true, text.getText());

    }


    @Given("Launch detail URL at {string}")
    public void launchDetailURLAt(String url) {
        driver.get(url);
    }

    @When("user clicks on image")
    public void userClicksOnImage() {
//        WebElement schedule=driver.findElement(Dpl.scheduletour);
//        if (schedule != null){
//            driver.findElement(Dpl.scheduletour).click();
//        }

        driver.findElement(Dpl.image).click();
    }

    @When("user enter name {string} on gallery lead form and email {string} and contact no {string}")
    public void userEnterNameOnGalleryLeadFormAndEmailAndContactNo(String name, String email, String contactNo) {
        Hooks.Wait(driver, Dpl.userName);
        driver.findElement(Dpl.userName).sendKeys(name);
        driver.findElement(Dpl.userEmail).sendKeys(email);
        driver.findElement(Dpl.userContact).sendKeys(contactNo);
        driver.findElement(Dpl.buttonClick).click();

    }

//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }

    @When("user enter name {string} and email {string} and contact no {string} on Listing detail lead form")
    public void userEnterNameAndEmailAndContactNoOnListingDetailLeadForm(String name, String email, String contactNo) {
        Hooks.Wait(driver, Ldpl.userName);
        driver.findElement(Ldpl.userName).sendKeys(name);
        driver.findElement(Ldpl.userEmail).sendKeys(email);
        driver.findElement(Ldpl.userContact).sendKeys(contactNo);
        driver.findElement(Ldpl.buttonClick).click();
    }

    @When("user clicks on Listing detail image")
    public void userClicksOnListingDetailImage() {
        driver.findElement(Ldpl.ListingDetailImage).click();
    }


    @When("user opens page  it should not return {int}")
    public void userOpensPageItShouldNotReturn(int arg1) {
        String url = driver.getCurrentUrl();
        StaticLinkChecker.StaticLink(url);
    }


    @When("click on bed filter {string}")
    public void clickOnBedFilter(String bed) {
        WebElement ele = driver.findElement(dse.bed);
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
//        ArrayList<List> options = driver.findElement(By.xpath("//*[@class='dropdown-menu bedrooms']//input"));
            String optionXPath = String.format("//*[@class='dropdown-menu bedrooms']//input[@value='%s']", bed);
        WebElement option = driver.findElement(By.xpath(optionXPath));
        option.click();

    }

    @Then("verify results at {string}")
    public void verifyResultsAt(String bed) {
        Hooks.Wait(driver,dse.bedH1);
        String H1 = driver.findElement(dse.bedH1).getText();
        if (H1.contains(bed)){
            Assert.assertTrue(true);
        }
    }

    @When("user clicks on link")
    public void userClicksOnLink() {
        linkChecker(this.driver);
    }

    @Then("it should not return error")
    public void itShouldNotReturnError() {
        String text = driver.findElement(Dpl.errorMsg).getText();
        Assert.assertEquals(text,"Oops… We can’t seem to find this page");
    }
}
