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

    public static void linkChecker(WebDriver driver) {
        List<WebElement> count = driver.findElements(By.xpath("//*[@class='searchRelatedList']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ndpl.scheduletour));
        WebElement scheduleTour = driver.findElement(ndpl.scheduletour);
        scheduleTour.click();
        for (int i = 1; i <= count.size(); i++) {
            String xpath1 = String.format("//*[@id='searchRelatedSlider']//*[@class='searchRelatedList'][%d]", i);
            WebElement urlList = driver.findElement(By.xpath(xpath1));
            List<WebElement> links = urlList.findElements(By.tagName("a"));
            String xpathRd = String.format("//*[@id='searchRelatedSlider']//*[@class='searchRelatedList'][%d]//a[@class='readFullSearchResult']", i);

            try{
                List<WebElement> nextButton = driver.findElements(By.xpath("//*[@class='bx-next bxButton']"));
                WebElement fourthButton = nextButton.get(3);
                if (fourthButton != null && i >= 3) {
                    fourthButton.click();
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            try {
                WebElement readMore = driver.findElement(By.xpath(xpathRd));
                if (readMore != null) {
//                    System.out.println(readMore+"readMore");
                    readMore.click();
                }
            } catch (Exception e) {
                System.out.println("No readFullSearchResult link found or not clickable for element: ");
            }



            for (WebElement link : links) {
                if (link.getAttribute("class").contains("readFullSearchResult")) {
                    break; // Skip readMore links
                }
                String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
                wait.until(ExpectedConditions.elementToBeClickable(link));
                link.sendKeys(clickOnLinkTab);
                Set<String> windowHandles = driver.getWindowHandles();
                Iterator<String> windowIterator  = windowHandles.iterator();
                String parent = windowIterator.next();
                String child_window = windowIterator.next();
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                StaticLink(driver.getCurrentUrl());
                driver.close();
                driver.switchTo().window(parent);
            }
            try {
                WebElement readLess = driver.findElement(By.xpath("//*[@class='searchRelatedList active']//*[@class='readFullSearchResult']"));
                if (readLess != null) {
                    readLess.click();
                }
            } catch (Exception e) {
//                System.out.println(e.getMessage());
            }




        }
    }


}
