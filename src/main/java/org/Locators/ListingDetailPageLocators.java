package org.Locators;

import org.openqa.selenium.By;

public class ListingDetailPageLocators {
    public By userName = By.xpath("//*[@id='requestForCallFrom']//*[@name='name']");
    public By userEmail = By.xpath("//*[@id='requestForCallFrom']//*[@name='email']");
    public By userContact = By.xpath("//*[@id='requestForCallFrom']//*[@name='mobileNo']");
    public By buttonClick = By.xpath(
            "//*[@id='requestForCallFrom']//button[@class='btn btn-secondary btn-block leadGenrateButton callBackBtn']");
    public By scheduleTour = By.xpath("//*[@class='propertyDetailPopupBox']//*[@class='icon-cancal close']");
    public By ListingDetailImage=By.xpath("//*[@class='totalPhoto mapImage soldblur ']");
}
