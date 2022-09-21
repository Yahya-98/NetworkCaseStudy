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

        Assert.assertEquals("jean",bp.searchInput());

    }

    @Test
    public void step3ScrollPage(){

    }
}
