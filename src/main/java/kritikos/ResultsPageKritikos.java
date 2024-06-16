package kritikos;

import main.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsPageKritikos {

    private WebDriver driver;
    private By result = By.cssSelector(".ProductListItem_title__e6MEz");
    private By resultPrice = By.cssSelector(".ProductListItem_finalPrice__sEMjs");
    private By searchBar = By.id("main-search");

    public ResultsPageKritikos(WebDriver driver) {
        this.driver = driver;
    }

    public Product getFirstResultProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(result));
        String price = driver.findElement(resultPrice).getText();
        price = price.replaceAll("[^0-9,.]", "");
        price = price.replace(',','.');
        return new Product(driver.findElement(result).getText(), Double.parseDouble(price));
    }

    /*public String getFirstResultText(){
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
    }*/

}
