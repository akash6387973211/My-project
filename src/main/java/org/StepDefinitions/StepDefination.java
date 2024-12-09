package org.StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.ApiReader.Mun_commData;
import org.HomeMegaMenuLinkCheckerMethods.LinkChecker;
import org.HomeMegaMenuLinkCheckerMethods.StaticLinkChecker;
import org.Locators.ListingDetailPageLocators;
import org.Locators.ListingDseLocators;
import org.Locators.NhDetailPageLocator;
import org.Locators.LoginPageLocators;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.reports.ExtentReportUtils;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.HomeMegaMenuLinkCheckerMethods.NHDetailFooterLinks.linkChecker;

public class StepDefination extends LinkChecker {
    WebDriver driver;
    LoginPageLocators Lp = new LoginPageLocators();
    NhDetailPageLocator Dpl = new NhDetailPageLocator();
    ListingDetailPageLocators Ldpl = new ListingDetailPageLocators();
    ListingDseLocators dse = new ListingDseLocators();
    private List<String> mclink = new ArrayList<>();


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
        ExtentReportUtils.startTestcase("Set chrome WebDriver");
        this.driver = Hooks.getDriver();
        ExtentReportUtils.logInfo("Chrome WebDriver initialized");
    }

    @When("user clicks on top cities megamenu it should not return {int}")
    public void userClicksOnTopCitiesMegaMenuItShouldNotReturn(int arg0) {
        ExtentReportUtils.startTestcase("userClicksOnTopCitiesMegaMenuItShouldNotReturn");
        driver.findElement(Lp.header).click();
        areapicker(driver, "//ul[@class='gblTopCities']");
        System.out.println("Broken New Homes link count" + NCount);
        System.out.println("Broken Sale link count" + Salecount);
        System.out.println("Broken Rent link count" + Rentcount);
        ExtentReportUtils.logInfo("link checked successfully");
    }


    @Given("Launch dse URL at {string}")
    public void launchDseURLAt(String url) {
        ExtentReportUtils.startTestcase("Launch Beta URL at" + url);
        driver.get(url);
        ExtentReportUtils.logInfo("Launched URL: " + url);
        ExtentReportUtils.setPassTestStep(url, "Url launched successfully");
    }

    @When("user enter name {string} and email {string} and contact no {string}")
    public void userEnterNameAndEmailAndContactNo(String name, String email, String contact) {
        ExtentReportUtils.startTestcase("user enter name and email and contact no");
        Hooks.Wait(driver, Lp.userName);
        driver.findElement(Lp.userName).sendKeys(name);
        driver.findElement(Lp.userEmail).sendKeys(email);
        driver.findElement(Lp.phone).sendKeys(contact);
        driver.findElement(Lp.submitButton).click();
        ExtentReportUtils.logInfo("Entered name: " + name + ", email: " + email + ", contact: " + contact);
    }

    @Then("click on submit button and verify thank you msg")
    public void clickOnSubmitButtonAndVerifythankyoumsg() {
        ExtentReportUtils.startTestcase("Submit form and verify message");
        Hooks.Wait(driver, Lp.thankYou);
        WebElement text = driver.findElement(Lp.thankYou);
        ExtentReportUtils.logInfo("Thank you message: " + text.getText());
        Assert.assertTrue(true, text.getText());
        ExtentReportUtils.setPassTestStep("Submit Form", "Form submitted successfully and thank you message displayed.");

    }


    @Given("Launch detail URL at {string}")
    public void launchDetailURLAt(String url) {
        driver.get(url);
    }

    @When("user clicks on image")
    public void userClicksOnImage() {
        driver.findElement(Dpl.image).click();
    }

    @When("user enter name {string} on gallery lead form and email {string} and contact no {string}")
    public void userEnterNameOnGalleryLeadFormAndEmailAndContactNo(String name, String email, String contactNo) {
        ExtentReportUtils.startTestcase("Enter user details");
        Hooks.Wait(driver, Dpl.userName);
        driver.findElement(Dpl.userName).sendKeys(name);
        driver.findElement(Dpl.userEmail).sendKeys(email);
        driver.findElement(Dpl.userContact).sendKeys(contactNo);
        driver.findElement(Dpl.buttonClick).click();
        ExtentReportUtils.logInfo("Entered name: " + name + ", email: " + email + ", contact: " + contactNo);
    }


    @When("user enter name {string} and email {string} and contact no {string} on Listing detail lead form")
    public void userEnterNameAndEmailAndContactNoOnListingDetailLeadForm(String name, String email, String contactNo) {
        ExtentReportUtils.startTestcase("Enter user details");
        Hooks.Wait(driver, Ldpl.userName);
        driver.findElement(Ldpl.userName).sendKeys(name);
        driver.findElement(Ldpl.userEmail).sendKeys(email);
        driver.findElement(Ldpl.userContact).sendKeys(contactNo);
        driver.findElement(Ldpl.buttonClick).click();
        ExtentReportUtils.logInfo("Entered name: " + name + ", email: " + email + ", contact: " + contactNo);
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
        ExtentReportUtils.startTestcase("Click on bed filter");
        WebElement ele = driver.findElement(dse.bed);
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
//        ArrayList<List> options = driver.findElement(By.xpath("//*[@class='dropdown-menu bedrooms']//input"));
        String optionXPath = String.format("//*[@class='dropdown-menu bedrooms']//input[@value='%s']", bed);
        WebElement option = driver.findElement(By.xpath(optionXPath));
        option.click();
        ExtentReportUtils.logInfo("Clicked on bed filter: " + bed);

    }

    @Then("verify results at {string}")
    public void verifyResultsAt(String bed) {
        ExtentReportUtils.startTestcase("verify clicked filter" + bed);
        Hooks.Wait(driver, dse.bedH1);
        String H1 = driver.findElement(dse.bedH1).getText();
        Assert.assertTrue(H1.contains(bed), "Filter verification failed.");
        ExtentReportUtils.logInfo("Bed filter verified successfully" + H1);
    }


    @And("Check all these URLs and navigate to")
    public void checkAllTheseURLsAndNavigateTo(DataTable urls) {

        List<String> urlsList = urls.asList();

        for (String link : urlsList) {
            driver.get(link);
            linkChecker(this.driver);
        }
    }


    @Given("fetch community sale data from api")
    public void fetchCommunitySaleDataFromApi() {
        try {
            JSONArray dataArray = new JSONArray(Mun_commData.Mun_CommDataGetter("sale", "Community"));
            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject item = dataArray.getJSONObject(i);
                String comingUrl = item.getString("newUrl");
                String NewUrl = "https://www.squareyards.ca" + comingUrl;
                mclink.add(NewUrl);
                System.out.println(NewUrl);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Then("I process the community sale data and verify h1 of every page")
    public void iProcessTheCommunitySaleDataAndVerifyH1ofEveryPage() {
        ExtentReportUtils.startTestcase("verifyResults");
        for (String urls : mclink) {
            driver.get(urls);
            int respCode = StaticLinkChecker.StaticLink(urls);
            if (respCode != 200) {
                ExtentReportUtils.logInfo(urls);
            } else {
                String pageH1 = driver.findElement(dse.a_mun_comH1).getText().trim().toLowerCase();
                String[] pathSegments = urls.split("/");
                String lastSegment = pathSegments[pathSegments.length - 1];
                String secondLastSegment = pathSegments[pathSegments.length - 2];
                String CommunityInitialText = "Houses for Sale in" + " " + lastSegment + secondLastSegment + "ON";
                String normalizedInitialText = CommunityInitialText.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
                try {
                    String normalizedPageH1 = pageH1.replaceAll("[^A-Za-z0-9]", "");
                    if (normalizedPageH1.equals(normalizedInitialText)) {
                        ExtentReportUtils.setPassTestStep(pageH1, "H1 is correct");
                    } else {
                        ExtentReportUtils.logInfo(normalizedPageH1 + " " + urls);
                        System.out.println("Difference found in h1 and url is " + urls);
                        ExtentReportUtils.setFailTestStep(pageH1, "H1 is Wrong");
                    }
                } catch (NoSuchElementException e) {
                    ExtentReportUtils.logInfo(urls);
                    ExtentReportUtils.setFailTestStep("H1 element not found", "H1 is missing");
                    Assert.fail("H1 element not found on the page.");
                }
            }
        }
    }

    @Given("fetch community lease data from api")
    public void fetchCommunityLeaseDataFromApi() {
        try {
            JSONArray dataArray = new JSONArray(Mun_commData.Mun_CommDataGetter("lease", "Community"));
            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject item = dataArray.getJSONObject(i);
                String comingUrl = item.getString("newUrl");
                String NewUrl = "https://www.squareyards.ca" + comingUrl;
                mclink.add(NewUrl);
                System.out.println(NewUrl);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Then("I process the community lease data and verify h1 of every page")
    public void iProcessTheCommunityLeaseDataAndVerifyH1fEveryPage() {
        ExtentReportUtils.startTestcase("verifyResults");
        for (String urls : mclink) {
            driver.get(urls);
            int respCode = StaticLinkChecker.StaticLink(urls);
            if (respCode != 200) {
                ExtentReportUtils.logInfo(urls);
            } else {
                String pageH1 = driver.findElement(dse.a_mun_comH1).getText().trim().toLowerCase();
                String[] pathSegments = urls.split("/");
                String lastSegment = pathSegments[pathSegments.length - 1];
                String secondLastSegment = pathSegments[pathSegments.length - 2];
                String CommunityInitialText = "Houses for Rent in" + " " + lastSegment + secondLastSegment + "ON";

                String normalizedInitialText = CommunityInitialText.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
                try {
                    String normalizedPageH1 = pageH1.replaceAll("[^A-Za-z0-9]", "");
                    if (normalizedPageH1.equals(normalizedInitialText)) {
                        ExtentReportUtils.setPassTestStep(pageH1, "H1 is correct");
                    } else {
                        ExtentReportUtils.logInfo(normalizedPageH1 + " " + urls);
                        System.out.println("Difference found in h1 and url is " + urls);
                        ExtentReportUtils.setFailTestStep(pageH1, "H1 is Wrong");
                    }
                } catch (NoSuchElementException e) {
                    ExtentReportUtils.logInfo(urls);
                    ExtentReportUtils.setFailTestStep("H1 element not found", "H1 is missing");
                    Assert.fail("H1 element not found on the page.");
                }
            }
        }
    }

    @Given("fetch municipality sale data from api")
    public void fetchMunicipalitySaleDataFromApi() {
        try {
            JSONArray dataArray = new JSONArray(Mun_commData.Mun_CommDataGetter("sale", "Municipality"));
            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject item = dataArray.getJSONObject(i);
                String comingUrl = item.getString("newUrl");
                String NewUrl = "https://www.squareyards.ca" + comingUrl;
                mclink.add(NewUrl);
                System.out.println(NewUrl);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Then("I process the municipality sale data and verify h1 of every page")
    public void iProcessTheMunicipalitySaleDataAndVerifyH1fEveryPage() {
        ExtentReportUtils.startTestcase("verifyResults");
        for (String urls : mclink) {
            driver.get(urls);
            int respCode = StaticLinkChecker.StaticLink(urls);
            if (respCode != 200) {
                ExtentReportUtils.logInfo(urls);
            } else {
                String pageH1 = driver.findElement(dse.a_mun_comH1).getText().trim().toLowerCase();
                String mun_comm = urls.substring(urls.lastIndexOf("/") + 1);
                String municipalityInitialText = mun_comm + " " + "ON Real Estate Listings & Houses for sale";
                String normalizedInitialText = municipalityInitialText.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
                try {
                    String normalizedPageH1 = pageH1.replaceAll("[^A-Za-z0-9]", "");
                    if (normalizedPageH1.equals(normalizedInitialText)) {
                        ExtentReportUtils.setPassTestStep(pageH1, "H1 is correct");
                    } else {
                        ExtentReportUtils.logInfo(normalizedPageH1 + " " + urls);
                        System.out.println("Difference found in h1 and url is " + urls);
                        ExtentReportUtils.setFailTestStep(pageH1, "H1 is Wrong");
                    }
                } catch (NoSuchElementException e) {
                    ExtentReportUtils.logInfo(urls);
                    ExtentReportUtils.setFailTestStep("H1 element not found", "H1 is missing");
                    Assert.fail("H1 element not found on the page.");
                }
            }
        }
    }

    @Given("fetch municipality lease data from api")
    public void fetchMunicipalityLeaseDataFromApi() {
        try {
            JSONArray dataArray = new JSONArray(Mun_commData.Mun_CommDataGetter("lease", "Municipality"));
            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject item = dataArray.getJSONObject(i);
                String comingUrl = item.getString("newUrl");
                String NewUrl = "https://www.squareyards.ca" + comingUrl;
                mclink.add(NewUrl);
                System.out.println(NewUrl);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Then("I process the municipality lease data and verify h1 of every page")
    public void iProcessTheMunicipalityLeaseDataAndVerifyH1fEveryPage() {
        ExtentReportUtils.startTestcase("verifyResults");
        for (String urls : mclink) {
            driver.get(urls);
            int respCode = StaticLinkChecker.StaticLink(urls);
            if (respCode != 200) {
                ExtentReportUtils.logInfo(urls);
            } else {
                String pageH1 = driver.findElement(dse.a_mun_comH1).getText().trim().toLowerCase();
                String mun_comm = urls.substring(urls.lastIndexOf("/") + 1);
                String municipalityInitialText = "Houses For Rent in" + mun_comm + "ON";
                String normalizedInitialText = municipalityInitialText.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
                try {
                    String normalizedPageH1 = pageH1.replaceAll("[^A-Za-z0-9]", "");
                    if (normalizedPageH1.equals(normalizedInitialText)) {
                        ExtentReportUtils.setPassTestStep(pageH1, "H1 is correct");
                    } else {
                        ExtentReportUtils.logInfo(normalizedPageH1 + " " + urls);
                        System.out.println("Difference found in municipality lease h1 and url is " + urls);
                        ExtentReportUtils.setFailTestStep(pageH1, "H1 is Wrong");
                    }
                } catch (NoSuchElementException e) {
                    ExtentReportUtils.logInfo(urls);
                    ExtentReportUtils.setFailTestStep("H1 element not found", "H1 is missing");
                    Assert.fail("H1 element not found on the page.");
                }
            }
        }
    }



}
