package org.Locators;

import org.openqa.selenium.By;

 public  class ListingDseLocators {
    public By bed = By.xpath("//*[@id='bedSection']");
    public By bedOptions=By.xpath("//*[@class='dropdown-menu bedrooms']");
    public By bedH1=By.xpath("//*[@bedscount='2']//h1");
    public By a_mun_comH1=By.xpath("//*[@class='dseHeadingBox']/h1");
    public By error = By.xpath("//*[@class='otherPageSearch']");
}
