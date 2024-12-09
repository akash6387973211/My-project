package org.Locators;

import org.openqa.selenium.By;

public class NhDetailPageLocator {
    public By userName = By.xpath("//*[@class='formBody galleryLeadpopupbox']//*[@name='name']");
    public By userEmail = By.xpath("//*[@class='formBody galleryLeadpopupbox']//*[@name='email']");
    public By userContact = By.xpath("//*[@class='formBody galleryLeadpopupbox']//*[@name='mobileNo']");
    public By buttonClick = By.xpath(
            "//*[@class='formBody galleryLeadpopupbox']//button[@class='btn btn-secondary btn-block leadGenrateButton']");
    public By scheduletour = By.xpath("//em[@class='icon-cancal close']");
    public By image=By.xpath("//*[@class='fixedActionBox']");
    public By errorMsg=By.xpath("//*[@class='bigHeading']");
    public By footerUrlList = By.xpath("//*[@id='searchRelatedSlider']");
}
