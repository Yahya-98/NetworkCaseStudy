package pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wt;
    String productOldPrice,productSize,productCheepPrice;
    By cookiesAccep = By.id("onetrust-accept-btn-handler");
    By search = By.id("search");
    By searchres = By.xpath("//span[@class='resultInfo__title']");

    By seeMoreBtn = By.xpath("//button[@class='button -secondary -sm relative']");

    By selectoldprice = By.xpath("//span[@class='product__price -label -old -size']");

    By selectSize = By.xpath("//label[@class='radio-box__label ']");

    By goToBasket = By.xpath("//*[@id=\"header__desktopBasket\"]/div/div[3]/a");

    By salePrice = By.xpath("//span[@class='cartItem__price -sale']");

    By saleOldPrice = By.xpath("//span[@class='cartItem__price -old -labelPrice']");

    By saleSize = By.xpath("//span[@class='cartItem__attrValue']");

    By continuebtn = By.xpath("//button[@class='continueButton n-button large block text-center -primary']");



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
        driver.findElement(search).sendKeys("denim");
        driver.findElement(search).sendKeys(Keys.ENTER);
        return driver.findElement(searchres).getText();
    }

    public String scrollPage(){
        driver.findElement(seeMoreBtn).sendKeys(Keys.CONTROL,Keys.PAGE_DOWN);
        driver.findElement(seeMoreBtn).click();
        wt = new WebDriverWait(driver,10);
        wt.until(ExpectedConditions.urlContains("page=2"));
        return driver.getCurrentUrl();
    }

    public void selectDenim(){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(selectoldprice);
        productOldPrice =  element.getText();
        actions.moveToElement(element).perform();
        productCheepPrice = driver.findElement(By.xpath("//span[@class='product__price -actual']")).getText();
        element = driver.findElement(selectSize);
        actions.moveToElement(element).perform();
        productSize = element.getText();
        element.click();
    }

    public void goToBasketPage(){
        wt.until(ExpectedConditions.elementToBeClickable(goToBasket)).click();

    }

    public boolean checkProductCapabilities(){
        log.info("Chech the price and size same the baskeetpage and storepage");
        if (productOldPrice.equals(wt.until(ExpectedConditions.elementToBeClickable(saleOldPrice)).getText())
                && productCheepPrice.equals(driver.findElement(salePrice).getText())
                && productSize.equals(driver.findElement(saleSize).getText())){
            return true;
        }else {return false;}

    }

    public boolean checkProductDiscount(){
        log.info("Check product price bigger then product discounted price");
        // price split TL for convert to double
        String[] s = productOldPrice.split(" TL");
        String [] s1 = productCheepPrice.split(" TL");
        //price convert to double and check discount
        return Double.parseDouble(((s[0].replace(".",""))).replace(",",""))
                > Double.parseDouble(((s1[0].replace(".",""))).replace(",",""));
    }

    public void clickContinue(){
        driver.findElement(continuebtn).click();
    }



}
