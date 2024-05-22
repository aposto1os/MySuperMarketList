package myMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsPage {

    private WebDriver driver;
    private By result = By.cssSelector("header h3 a");
    private By resultPrice = By.cssSelector(".price");
    private By searchBar = By.id("main-search");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstResultText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(result));
        return driver.findElement(result).getText();
    }

    public double getFirstResultPrice(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultPrice));
        String price = driver.findElement(resultPrice).getText();
        price = price.replaceAll("[^0-9,]", "");
        price = price.replace(',','.');
        return Double.parseDouble(price);
    }

}
