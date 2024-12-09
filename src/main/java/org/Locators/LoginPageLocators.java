package org.Locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
   public By header= By.id("knowledgeCityBtn");
   public By userName=By.xpath("//*[@aria-label='name']");
   public By userEmail=By.xpath("//*[@aria-label='email']");
   public By phone=By.xpath("//*[@aria-label='phone number']");
   public By submitButton=By.xpath("//*[@id='requestForCallFrom']//*[@class='btn btn-secondary btn-block leadGenrateButton callBackBtn']");
   public By thankYou = By.xpath("//div[@class='thankyouBox']/p");

}
