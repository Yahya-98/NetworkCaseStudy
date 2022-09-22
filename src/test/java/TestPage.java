import DriverSetup.DriverSetup;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.BasketPage;
import pages.LoginPage;
import pages.StorePage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPage {
    private static Logger log  = Logger.getLogger(TestPage.class.getName());
    static DriverSetup driverSetup = new DriverSetup();
    static WebDriver driver;
    static WebDriverWait wait;
    static BasePage basePage;
    static LoginPage loginPage;
    static BasketPage basketPage;
    static StorePage storePage;
    @BeforeClass
    public static void asd() {
        log.info("Test Start");
        driver = driverSetup.getDriver();
        wait = new WebDriverWait(driver,10);
        basePage = new BasePage(driver,wait);
        storePage = new StorePage(driver,wait);
        basketPage = new BasketPage(driver,wait);
        loginPage = new LoginPage(driver,wait);

    }

    @Test
    public void step01GetNetwork(){
        log.info("Going to network age");
        Assert.assertEquals("https://www.network.com.tr/" , basePage.getMainPage().getCurrentUrl());

    }

    @Test
    public void step02SearchJean(){
        log.info("Search denim product");
        Assert.assertEquals("denim", basePage.searchInput());

    }

    @Test
    public void step03ScrollPage(){
        log.info("Scroll page and click see more button and check page loaded");
        Assert.assertEquals("https://www.network.com.tr/search?searchKey=denim&page=2", storePage.scrollPage());
    }

    @Test
    public void step04SelectProduct(){
        log.info("Select first discounted product");
        storePage.selectDenim();
    }

    @Test
    public void step05goToBasket(){
        log.info("Go to basket page");
        storePage.goToBasketPage();
    }

    @Test
    public void step06checkPrductCapabilities(){
        log.info("Check product capabilities is true");
        Assert.assertTrue(basketPage.checkProductCapabilities());
    }

    @Test
    public void step07checkProductDiscountPrice(){
        log.info("Check old price bigger then discounted price");
        Assert.assertTrue(basketPage.checkProductDiscount());
    }

    @Test
    public void step08ContinuetoLogin(){
        log.info("Click the continue button");
        basketPage.clickContinue();
    }

    @Test
    public void step09Login() {
        log.info("Login with registration data and Check success login");
        Assert.assertTrue(loginPage.Login());
    }

    @Test
    public void step10goToBasePage(){
        log.info("Click the base page button");
        loginPage.goToBasePage();
    }

    @Test
    public void step11goToShoppingBag(){
        log.info("Click the shopping bag button ");
        basePage.clickToShoppingBag();
    }

    @Test
    public void step12DeleteShoppingBagProduct(){
        log.info("Click to remove button");
        basePage.removeProduct();

    }

    @Test
    public void step13checkBagisEmpty(){
        log.info("Check the shopping bag is empty");
        Assert.assertTrue(basePage.checkShoppingBagEmpty());
    }
}

