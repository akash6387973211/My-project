package org.HomeMegaMenuLinkCheckerMethods;

import org.Locators.NhDetailPageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.HomeMegaMenuLinkCheckerMethods.StaticLinkChecker.StaticLink;

public class NHDetailFooterLinks {
    static NhDetailPageLocator ndpl = new NhDetailPageLocator();
   static int Count = 0;
    WebElement readMore =null;
public static void linkChecker( WebDriver driver){
    List<WebElement> count = driver.findElements(By.xpath("//*[@class='searchRelatedList']"));

    System.out.println(count.size());
//    WebElement areaList = driver.findElement(By.xpath("//*[@id='searchRelatedSlider']//*[@class='searchRelatedList'][1]"));
//    List<WebElement> links = areaList.findElements(By.tagName("a"));
//    System.out.println(links);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15000));
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ndpl.scheduletour));
    WebElement scheduleTour= driver.findElement(ndpl.scheduletour);
    scheduleTour.click();
   for(int i =1;i<= count.size();i++){
       String xpath1= String.format("//*[@id='searchRelatedSlider']//*[@class='searchRelatedList'][%d]",i);
       WebElement urlList = driver.findElement(By.xpath(xpath1));
       System.out.println(urlList+"oooooooooooo");

       List<WebElement> links = urlList.findElements(By.tagName("a"));
       System.out.println(links+"ppppppppppppppppp");
//       String xpathRd = String.format("//*[@class='searchRelatedList'][%d]//a[@class='readFullSearchResult']", i);
//       System.out.println(i);
//       WebElement readMore = driver.findElement(By.xpath(xpathRd));



//       try {
////           readMore = driver.findElement(By.xpath(xpathRd));
//           readMore = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathRd)));
//           if (readMore != null) {
//               wait.until(ExpectedConditions.elementToBeClickable(readMore));
//               readMore.click();
//               System.out.println("Clicked on readMore link for element: " + i);
//           }
//       } catch (Exception e) {
//           System.out.println("No readFullSearchResult link found or not clickable for element: " + i + ". Exception: " + e.getMessage());
//       }
           for (WebElement link : links) {
               String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
               wait.until(ExpectedConditions.elementToBeClickable(link));
               link.sendKeys(clickOnLinkTab);
               //need changes
           }

    }

    Set<String> windowHandles = driver.getWindowHandles();
    Iterator<String> it = windowHandles.iterator();

    while (it.hasNext()) {
        String windowHandle = it.next();
        driver.switchTo().window(windowHandle);
        System.out.println("Title of the page: " + driver.getTitle());
        StaticLink(driver.getCurrentUrl());
    }

}
}
