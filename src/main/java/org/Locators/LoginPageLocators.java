package org.Locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
   public By header= By.id("knowledgeCityBtn");
   public By userName=By.xpath("//*[@id='leadname']");
   public By userEmail=By.xpath("//*[@id='leademail']");
   public By phone=By.xpath("//*[@id='leadmobile']");
   public By submitButton=By.xpath("//*[@class='btn btn-secondary btn-block leadGenrateButton']");
   public By thankYou = By.xpath("//div[@class='thankyouBox']/p");

}
