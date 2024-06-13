package ab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsPageAb {

    private WebDriver driver;
    private By result = By.cssSelector(".product-item .ireisQ");
    private By resultPriceInt = By.cssSelector(".sc-y4jrw3-19 .sc-bw95zp-9");
    private By resultPriceDec = By.cssSelector(".sc-y4jrw3-19 .sc-bw95zp-10");
    private By searchBar = By.id("main-search");

    public ResultsPageAb(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstResultText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(result));
        return driver.findElement(result).getText();
    }

    public double getFirstResultPrice(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultPriceInt));
        String price = driver.findElement(resultPriceInt).getText() + "," + driver.findElement(resultPriceDec).getText();
        price = price.replaceAll("[^0-9,]", "");
        price = price.replace(',','.');
        return Double.parseDouble(price);
    }
}
