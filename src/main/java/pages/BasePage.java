package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;
    By cookiesAccep = By.id("onetrust-accept-btn-handler");
    By search = By.id("search");

    By searchres = By.xpath("//span[@class='resultInfo__title']");
    private static Logger log  = Logger.getLogger(BasePage.class.getName());
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getMainPage(){
        driver.get("https://www.network.com.tr/");
        driver.findElement(cookiesAccep).click();
        log.info("Current Url = " + driver.getCurrentUrl());
        return driver;
    }

    public String searchInput(){
        driver.findElement(search).sendKeys("jean");
        driver.findElement(search).sendKeys(Keys.ENTER);

        return driver.findElement(searchres).getText();
    }
}
