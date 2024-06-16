package myMarket;

import main.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsPageMyMarket {

    private WebDriver driver;
    private By result = By.cssSelector("header h3 a");
    private By resultPrice = By.cssSelector(".price");
    private By searchBar = By.id("main-search");

    public ResultsPageMyMarket(WebDriver driver) {
        this.driver = driver;
    }

    public Product getFirstResultProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(result));
        String price = driver.findElement(resultPrice).getText();
        price = price.replaceAll("[^0-9,]", "");
        price = price.replace(',','.');
        return new Product(driver.findElement(result).getText(), Double.parseDouble(price));
    }

    /*public String getFirstResultText(Product product){
        return product.getProductName();
    }

    public double getFirstResultPrice(Product product){
        return product.getProductPrice();
    }*/

}
