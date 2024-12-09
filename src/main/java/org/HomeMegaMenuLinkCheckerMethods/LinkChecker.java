package org.HomeMegaMenuLinkCheckerMethods;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class   LinkChecker {
    protected static int NCount = 0;
  protected static int Salecount = 0;
   protected static int Rentcount = 0;

    static int Linkchecker(WebDriver driver, String xpath, String id) {

        int invalidLink = 0;
        String Bxpath = String.format("//li[contains(@data-id,'%s')]//div[@class='sliderNavigation']/div//a", id);
        List<WebElement> items = driver.findElements(By.xpath(Bxpath));
        for (int i = 0; i < items.size(); i++) {
            String Mxpath = String.format(xpath, i);
            List<WebElement> elements = driver.findElements(By.xpath(Mxpath));
            for (WebElement e : elements) {
                String url = e.getAttribute("href");
                try {
                    int resps = getResponseCode(url);
                    if (resps > 400) {
                        System.out.println("link is borken" +" "+ url + resps);
                        invalidLink++;
                    }else {
                        System.out.println(resps);
                    }

                } catch (Exception ess) {
                    ess.printStackTrace();
                }

            }

        }

        return invalidLink;
    }


    static int getResponseCode(String urlString) {

        try {
            URL url = new URL(urlString);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("HEAD");
            huc.connect();
            return huc.getResponseCode();
        } catch (Exception e) {
            System.out.println("unable to get status code");
            return -1;
        }

    }

    public static void areapicker(WebDriver driver, String xpath) {
//		driver.findElement(By.id("knowledgeCityBtn")).click();
        WebElement areaList = driver.findElement(By.xpath(xpath));
        List<WebElement> links = areaList.findElements(By.tagName("a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));

        for (WebElement link : links) {

            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            wait.until(ExpectedConditions.elementToBeClickable(link));
            link.sendKeys(clickOnLinkTab);
            driver.findElement(By.id("knowledgeCityBtn")).click();

        }
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();

        while (it.hasNext()) {

            String windowHandle = it.next();
            driver.switchTo().window(windowHandle);
            System.out.println("Title of the page: " + driver.getTitle());
            NCount = NCount + Linkchecker(driver,
                    "//li[@data-id='newHomes']//div[@class='sliderNavigation']//div[%d]//a", "newHomes");

            Salecount = Salecount + Linkchecker(driver,
                    "//li[@data-id='rentItem']//div[@class='sliderNavigation']//div[%d]//a", "rentItem");

            Rentcount = Rentcount + Linkchecker(driver,
                    "//li[@data-id='projectsItem']//div[@class='sliderNavigation']//div[%d]//a", "projectsItem");

        }

    }
}
