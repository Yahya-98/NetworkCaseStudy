package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    WebDriver driver;
    WebDriverWait wt;
    By cookiesAccept = By.id("onetrust-accept-btn-handler");
    By search = By.id("search");
    By searchResult = By.xpath("//span[@class='resultInfo__title']");
    By shoppingBag = By.xpath("//div[@class='header__basket js-basket header__basketLink']");
    By shoppingBagDeleteBtn = By.xpath("//div[@class='header__basketProductBtn header__basketModal -remove']");
    By deleteCartBtn = By.xpath("//button[@class='btn -black o-removeCartModal__button']");
    By bagEmptyMessage = By.xpath("//span[@class='header__emptyBasketText']");

    public BasePage(WebDriver driver, WebDriverWait wt){
        this.driver = driver;
        this.wt = wt;
    }

    public WebDriver getMainPage(){
        driver.get("https://www.network.com.tr/");
        driver.findElement(cookiesAccept).click();
        return driver;
    }

    public String searchInput(){
        driver.findElement(search).sendKeys("denim");
        driver.findElement(search).sendKeys(Keys.ENTER);
        return driver.findElement(searchResult).getText();
    }
    public void clickToShoppingBag(){
        driver.findElement(shoppingBag).click();
    }

    public void removeProduct(){
        wt.until(ExpectedConditions.elementToBeClickable(shoppingBagDeleteBtn));
        driver.findElement(shoppingBagDeleteBtn).click();
        driver.switchTo().activeElement().findElement(deleteCartBtn).click();
    }

    public boolean checkShoppingBagEmpty(){
        wt.until(ExpectedConditions.elementToBeClickable(shoppingBag));
        driver.findElement(shoppingBag).click();
        return driver.findElement(bagEmptyMessage).getText().equals("Sepetiniz Henüz Boş");
    }



}
