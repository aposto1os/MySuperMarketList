package ab;

import main.Product;
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

    public ResultsPageAb(WebDriver driver) {
        this.driver = driver;
    }

    public Product getFirstResultProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(result));
        String price = driver.findElement(resultPriceInt).getText() + "," + driver.findElement(resultPriceDec).getText();
        price = price.replaceAll("[^0-9,]", "");
        price = price.replace(',','.');
        return new Product(driver.findElement(result).getText(), Double.parseDouble(price));
    }
}
