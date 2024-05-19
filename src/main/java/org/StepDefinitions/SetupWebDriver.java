package org.StepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupWebDriver {

    WebDriver webDriver ;

    private void setWebDriver(){
       /* //Setting system properties of ChromeDriver
         System.setProperty("webdriver.chrome.driver","C:\\Users\\sandeep.pandey\\Downloads\\Browsers\\chrome-win64\\chrome-win64\\chrome.exe");
        //Creating an object of ChromeDriver
          webDriver = new ChromeDriver();*/
        webDriver  = new ChromeDriver();

    }
     protected WebDriver getWebDriver(){
        setWebDriver();
        return webDriver ;
    }
}
