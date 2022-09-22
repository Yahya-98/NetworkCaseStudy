package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StorePage {
    WebDriver driver;
    WebDriverWait wt;

    By seeMoreBtn = By.xpath("//button[@class='button -secondary -sm relative']");

    By selectOldPrice = By.xpath("//span[@class='product__price -label -old -size']");

    By selectSize = By.xpath("//label[@class='radio-box__label ']");

    By goToBasket = By.xpath("//*[@id=\"header__desktopBasket\"]/div/div[3]/a");

    By productDiscountedPrice = By.xpath("//span[@class='product__price -actual']");


    public StorePage(WebDriver driver, WebDriverWait wt){
        this.driver = driver;
        this.wt = wt;
    }

    public String scrollPage(){
        wt.until(ExpectedConditions.elementToBeClickable(seeMoreBtn));
        driver.findElement(seeMoreBtn).sendKeys(Keys.CONTROL,Keys.PAGE_DOWN);
        driver.findElement(seeMoreBtn).click();

        wt.until(ExpectedConditions.urlContains("page=2"));
        return driver.getCurrentUrl();
    }

    public void selectDenim(){

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(selectOldPrice);
        BasketPage.productOldPrice =  element.getText();
        actions.moveToElement(element).perform();
        BasketPage.productCheepPrice = driver.findElement(productDiscountedPrice).getText();
        element = driver.findElement(selectSize);
        actions.moveToElement(element).perform();
        BasketPage.productSize = element.getText();
        element.click();
    }

    public void goToBasketPage(){
        wt.until(ExpectedConditions.elementToBeClickable(goToBasket)).click();

    }

}
