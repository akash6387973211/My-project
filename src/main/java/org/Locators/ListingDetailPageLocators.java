package org.Locators;

import org.openqa.selenium.By;

public class ListingDetailPageLocators {
    public By userName = By.xpath("//*[@id='requestForCallFrom']//*[@id='leadname']");
    public By userEmail = By.xpath("//*[@id='requestForCallFrom']//*[@id='leademail']");
    public By userContact = By.xpath("//*[@id='requestForCallFrom']//*[@id='leadmobile']");
    public By buttonClick = By.xpath(
            "//*[@id='requestForCallFrom']//button[@class='btn btn-secondary btn-block leadGenrateButton']");
    public By scheduleTour = By.xpath("//*[@class='propertyDetailPopupBox']//*[@class='icon-cancal close']");
    public By ListingDetailImage=By.xpath("//*[@class='totalPhoto mapImage soldblur ']");
}
