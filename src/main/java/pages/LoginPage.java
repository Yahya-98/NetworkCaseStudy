package pages;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class LoginPage{
    WebDriver driver;
    WebDriverWait wt;
    String email,password;
    Path resourceDirectory = Paths.get("src","main","resources");
    String absolutePath = resourceDirectory.toFile().getAbsolutePath();
    String CSV_PATH = absolutePath + "/RegistrationData.csv";
    String [] csvCell;
    By loginEmail = By.xpath("//input[@class='input js-trim']");

    By loginPassword = By.xpath("//input[@class='input']");
    By submitBtn  = By.xpath("//button[@type='submit']");

    By logoBtn = By.xpath("//a[@class='header__logo']");
    public LoginPage(WebDriver driver, WebDriverWait wt){
        this.driver = driver;
        this.wt = wt;
    }
    public void readCsv()  {
        CSVReader csvReader;
        try {
            csvReader = new CSVReader(new FileReader(CSV_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (true){
            try {
                if ((csvCell = csvReader.readNext()) == null) break;
            } catch (IOException | CsvValidationException e) {
                throw new RuntimeException(e);
            }
            email = csvCell[0];
            password = csvCell[1];
        }
    }

    public boolean Login() {
        readCsv();

        wt.until(ExpectedConditions.elementToBeClickable(loginEmail));
        driver.findElement(loginEmail).click();
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).click();
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(submitBtn).click();
        return driver.getCurrentUrl().equals("https://www.network.com.tr/checkout#delivery");
    }

    public void goToBasePage(){

        driver.findElement(logoBtn).click();
    }




}
