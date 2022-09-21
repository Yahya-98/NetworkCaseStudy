import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.BasePage;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BaseTest {
    private static Logger log  = Logger.getLogger(BaseTest.class.getName());
    static Driver driver;
     static BasePage bp;
    @BeforeClass
    public static void asd(){
        log.info("Test Start");
        driver = new Driver();
        bp = new BasePage(driver.getDriver());
    }

    @Test
    public void step1GetNetwork(){

        Assert.assertEquals("https://www.network.com.tr/" ,bp.getMainPage().getCurrentUrl());

    }

    @Test
    public void step2SearchJean(){

        Assert.assertEquals("denim",bp.searchInput());

    }

    @Test
    public void step3ScrollPage(){

        Assert.assertEquals("https://www.network.com.tr/search?searchKey=denim&page=2",bp.scrollPage());
    }

    @Test
    public void step4SelectProduct(){
        bp.selectDenim();
    }

    @Test
    public void step5goToBasket(){
        bp.goToBasketPage();
    }

    @Test
    public void step6checkPrductCapabilities(){
        Assert.assertEquals(true,bp.checkProductCapabilities());
    }

    @Test
    public void step7checkProductDiscountPrice(){
        Assert.assertEquals(true,bp.checkProductDiscount());
    }

    @Test
    public void step8ContinuetoLogin(){
        bp.clickContinue();
    }
}
