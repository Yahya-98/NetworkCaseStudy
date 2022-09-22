package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage {
    WebDriver driver;
    WebDriverWait wt;

     static String productOldPrice,productSize,productCheepPrice;

    By salePrice = By.xpath("//span[@class='cartItem__price -sale']");

    By saleOldPrice = By.xpath("//span[@class='cartItem__price -old -labelPrice']");

    By saleSize = By.xpath("//span[@class='cartItem__attrValue']");

    By continuebtn = By.xpath("//button[@class='continueButton n-button large block text-center -primary']");

    public BasketPage(WebDriver driver,WebDriverWait wt){
        this.driver = driver;
        this.wt = wt;
    }
    public boolean checkProductCapabilities(){
        return productOldPrice.equals(wt.until(ExpectedConditions.elementToBeClickable(saleOldPrice)).getText())
                && productCheepPrice.equals(driver.findElement(salePrice).getText())
                && productSize.equals(driver.findElement(saleSize).getText());

    }

    public boolean checkProductDiscount(){
        //Check product price bigger then product discounted price

        //price split TL for convert to double
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
